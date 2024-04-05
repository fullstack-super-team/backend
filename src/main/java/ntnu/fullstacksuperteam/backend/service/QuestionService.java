package ntnu.fullstacksuperteam.backend.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ntnu.fullstacksuperteam.backend.dto.*;
import ntnu.fullstacksuperteam.backend.model.*;
import ntnu.fullstacksuperteam.backend.repository.QuestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private final Logger logger = LoggerFactory.getLogger(QuestionService.class);

    public List<Question> getQuestionsByQuizId(long quizId) {
        logger.info("Getting questions by quiz id: " + quizId);
        List<Question> questions = questionRepository.findByQuizId(quizId);
        return questions;
    }

    public Question createQuestion(long quizId, CreateQuestionDTO createQuestionDTO) {
        Quiz quiz = entityManager.getReference(Quiz.class, quizId);
        if (createQuestionDTO instanceof CreateTextQuestionDTO) {
            return createTextQuestion(quiz, (CreateTextQuestionDTO) createQuestionDTO);
        } else if (createQuestionDTO instanceof CreateSlideQuestionDTO) {
            return createSlideQuestion(quiz, (CreateSlideQuestionDTO) createQuestionDTO);
        } else if (createQuestionDTO instanceof CreateTrueOrFalseQuestionDTO) {
            return createTrueOrFalseQuestion(quiz, (CreateTrueOrFalseQuestionDTO) createQuestionDTO);
        } else {
            throw new IllegalArgumentException("Unknown question type");
        }
    }

    public SubmittedAnswerDTO<?> submitAnswer(long questionId, SubmitAnswerDTO submitAnswerDTO) {
        Question question = questionRepository.findById(questionId).orElseThrow();

        if (question instanceof TextQuestion textQuestion) {
            String answer = submitAnswerDTO.getAnswer();
            String correctAnswer = textQuestion.getAnswers().stream()
                    .filter(TextAnswer::isIsCorrect)
                    .map(TextAnswer::getText)
                    .findFirst()
                    .orElse("No correct answer found");

            if (answer.equals(correctAnswer)) {
                return new SubmittedAnswerDTO<>(answer, correctAnswer, textQuestion.getPoints());
            }

            return new SubmittedAnswerDTO<>(answer, correctAnswer, 0);
        } else if (question instanceof SlideQuestion slideQuestion) {
            int answer = Integer.parseInt(submitAnswerDTO.getAnswer());
            int correctAnswer = slideQuestion.getAnswer().getCorrectValue();

            if (answer == correctAnswer) {
                return new SubmittedAnswerDTO<>(answer, correctAnswer, slideQuestion.getPoints());
            }

            return new SubmittedAnswerDTO<>(answer, correctAnswer, 0);
        } else if (question instanceof TrueOrFalseQuestion trueOrFalseQuestion) {
            String answer = submitAnswerDTO.getAnswer();
            String correctAnswer = trueOrFalseQuestion.getAnswers().stream()
                    .filter(TrueOrFalseAnswer::isIsCorrect)
                    .map(TrueOrFalseAnswer::getText)
                    .findFirst()
                    .orElse("No correct answer found");

            if (answer.equals(correctAnswer)) {
                return new SubmittedAnswerDTO<>(answer, correctAnswer, trueOrFalseQuestion.getPoints());
            }

            return new SubmittedAnswerDTO<>(answer, correctAnswer, 0);
        } else {
            throw new IllegalArgumentException("Unknown question type");
        }
    }

    private Question createTextQuestion(Quiz quiz, CreateTextQuestionDTO createTextQuestionDTO) {
        TextQuestion textQuestion = new TextQuestion();
        textQuestion.setQuiz(quiz);
        textQuestion.setText(createTextQuestionDTO.getText());
        textQuestion.setPoints(createTextQuestionDTO.getPoints());

        for (TextAnswerDTO textAnswerDTO : createTextQuestionDTO.getTextAnswerDTOS()) {
            TextAnswer textAnswer = new TextAnswer();
            textAnswer.setText(textAnswerDTO.getText());
            textAnswer.setIsCorrect(textAnswerDTO.isCorrect());
            textAnswer.setQuestion(textQuestion);
            textQuestion.addAnswer(textAnswer);
        }

        return questionRepository.save(textQuestion);
    }

    private Question createSlideQuestion(Quiz quiz, CreateSlideQuestionDTO createSlideQuestionDTO) {
        SlideQuestion slideQuestion = new SlideQuestion();
        slideQuestion.setQuiz(quiz);
        slideQuestion.setText(createSlideQuestionDTO.getText());
        slideQuestion.setPoints(createSlideQuestionDTO.getPoints());

        SlideAnswerDTO slideAnswerDTO = createSlideQuestionDTO.getSlideAnswerDTO();
        SlideAnswer slideAnswer = new SlideAnswer();
        slideAnswer.setCorrectValue(slideAnswerDTO.getCorrectValue());
        slideAnswer.setMin(slideAnswerDTO.getMin());
        slideAnswer.setMax(slideAnswerDTO.getMax());
        slideAnswer.setStepSize(slideAnswerDTO.getStepSize());
        slideAnswer.setQuestion(slideQuestion);
        slideQuestion.setAnswer(slideAnswer);

        return questionRepository.save(slideQuestion);
    }

    private Question createTrueOrFalseQuestion(Quiz quiz, CreateTrueOrFalseQuestionDTO createTrueOrFalseQuestionDTO) {
        TrueOrFalseQuestion trueOrFalseQuestion = new TrueOrFalseQuestion();
        trueOrFalseQuestion.setQuiz(quiz);
        trueOrFalseQuestion.setText(createTrueOrFalseQuestionDTO.getText());
        trueOrFalseQuestion.setPoints(createTrueOrFalseQuestionDTO.getPoints());

        for (TrueOrFalseAnswer trueOrFalseAnswer : createTrueOrFalseQuestionDTO.getTextAnswerDTOS()) {
            trueOrFalseAnswer.setQuestion(trueOrFalseQuestion);
            trueOrFalseQuestion.addAnswer(trueOrFalseAnswer);
        }

        return questionRepository.save(trueOrFalseQuestion);
    }
}
