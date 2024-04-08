package ntnu.fullstacksuperteam.backend.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import ntnu.fullstacksuperteam.backend.dto.*;
import ntnu.fullstacksuperteam.backend.model.*;
import ntnu.fullstacksuperteam.backend.repository.QuestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Service class for handling operations related to quiz questions.
 */
@Service
public class QuestionService {


    @Autowired
    private QuestionRepository questionRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private final Logger logger = LoggerFactory.getLogger(QuestionService.class);

    /**
     * Retrieves a list of questions associated with a specific quiz ID.
     *
     * @param quizId The ID of the quiz.
     * @return A list of Question entities.
     */
    public List<Question> getQuestionsByQuizId(long quizId) {
        logger.info("Getting questions by quiz id: " + quizId);
        List<Question> questions = questionRepository.findByQuizId(quizId);
        return questions;
    }

    /**
     * Creates a new question for a quiz based on provided details in QuestionDTO.
     *
     * @param quizId The ID of the quiz to which the question belongs.
     * @param questionDTO The data transfer object containing question details.
     * @return The created Question entity.
     * @throws IllegalArgumentException If the question type is unknown.
     */
    public Question createQuestion(long quizId, QuestionDTO questionDTO) {
        Quiz quiz = entityManager.getReference(Quiz.class, quizId);
        Question question = new Question();
        question.setQuiz(quiz);
        question.setText(questionDTO.getText());
        question.setPoints(questionDTO.getPoints());
        if (questionDTO instanceof TextQuestionDTO) {
            TextQuestion textQuestion = new TextQuestion(question);
            question = createTextQuestion(textQuestion, (TextQuestionDTO) questionDTO);
        } else if (questionDTO instanceof SlideQuestionDTO) {
            SlideQuestion slideQuestion = new SlideQuestion(question);
            question = createSlideQuestion(slideQuestion, (SlideQuestionDTO) questionDTO);
        } else if (questionDTO instanceof TrueOrFalseQuestionDTO) {
            TrueOrFalseQuestion trueOrFalseQuestion = new TrueOrFalseQuestion(question);
            question = createTrueOrFalseQuestion(trueOrFalseQuestion, (TrueOrFalseQuestionDTO) questionDTO);
        } else {
            throw new IllegalArgumentException("Unknown question type");
        }
        return this.questionRepository.save(question);
    }

    /**
     * Updates an existing question based on provided details in QuestionDTO.
     *
     * @param questionDTO The data transfer object containing new question details.
     * @return The updated Question entity.
     * @throws IllegalArgumentException If the question type is unknown.
     */
    public Question updateQuestion(QuestionDTO questionDTO) {
        Question question = questionRepository.findById(questionDTO.getId()).orElseThrow();
        question.setText(questionDTO.getText());
        question.setPoints(questionDTO.getPoints());
        if (questionDTO instanceof TextQuestionDTO) {
            TextQuestion textQuestion = new TextQuestion(question);
            question = createTextQuestion(textQuestion, (TextQuestionDTO) questionDTO);
        } else if (questionDTO instanceof SlideQuestionDTO) {
            SlideQuestion slideQuestion = new SlideQuestion(question);
            question = createSlideQuestion(slideQuestion, (SlideQuestionDTO) questionDTO);
        } else if (questionDTO instanceof TrueOrFalseQuestionDTO) {
            TrueOrFalseQuestion trueOrFalseQuestion = new TrueOrFalseQuestion(question);
            question = createTrueOrFalseQuestion(trueOrFalseQuestion, (TrueOrFalseQuestionDTO) questionDTO);
        } else {
            throw new IllegalArgumentException("Unknown question type");
        }
        return this.questionRepository.save(question);
    }

    /**
     * Submits an answer to a specific question and evaluates its correctness.
     *
     * @param questionId The ID of the question being answered.
     * @param submitAnswerDTO The data transfer object containing the answer details.
     * @return A DTO containing the evaluation of the submitted answer.
     * @throws IllegalArgumentException If the question type is unknown.
     */
    public SubmittedAnswerDTO<?> submitAnswer(long questionId, SubmitAnswerDTO submitAnswerDTO) {
        Question question = questionRepository.findById(questionId).orElseThrow();

        if (question instanceof TextQuestion textQuestion) {
            String answer = submitAnswerDTO.getAnswer();
            List<String> correctAnswers = textQuestion.getAnswers().stream()
                    .filter(TextAnswer::isIsCorrect).map(TextAnswer::getText).toList();

            if (correctAnswers.contains(answer)) {
                return new SubmittedAnswerDTO<>(answer, correctAnswers, textQuestion.getPoints());
            }

            return new SubmittedAnswerDTO<>(answer, correctAnswers, 0);
        } else if (question instanceof SlideQuestion slideQuestion) {
            int answer = Integer.parseInt(submitAnswerDTO.getAnswer());
            int correctAnswer = slideQuestion.getAnswer().getCorrectValue();

            if (answer == correctAnswer) {
                return new SubmittedAnswerDTO<>(answer, correctAnswer, slideQuestion.getPoints());
            }

            return new SubmittedAnswerDTO<>(answer, correctAnswer, 0);
        } else if (question instanceof TrueOrFalseQuestion trueOrFalseQuestion) {
            String answer = submitAnswerDTO.getAnswer();
            List<String> correctAnswers = trueOrFalseQuestion.getAnswers().stream()
                    .filter(TrueOrFalseAnswer::isIsCorrect).map(TrueOrFalseAnswer::getText).toList();

            if (correctAnswers.contains(answer)) {
                return new SubmittedAnswerDTO<>(answer, correctAnswers, trueOrFalseQuestion.getPoints());
            }

            return new SubmittedAnswerDTO<>(answer, correctAnswers, 0);
        } else {
            throw new IllegalArgumentException("Unknown question type");
        }
    }

    /**
     * Creates and saves a TextQuestion based on the provided DTO and existing question template.
     *
     * @param textQuestion The TextQuestion entity to be populated and saved.
     * @param textQuestionDTO The DTO containing information for creating text answers.
     * @return The saved TextQuestion entity with its answers.
     */
    private Question createTextQuestion(TextQuestion textQuestion, TextQuestionDTO textQuestionDTO) {
        for (TextAnswerDTO textAnswerDTO : textQuestionDTO.getTextAnswerDTOS()) {
            TextAnswer textAnswer = new TextAnswer();
            if (textAnswerDTO.getId() != 0) {
                textAnswer.setId(textAnswerDTO.getId());
            }
            textAnswer.setText(textAnswerDTO.getText());
            textAnswer.setIsCorrect(textAnswerDTO.getIsCorrect());
            textAnswer.setQuestion(textQuestion);
            logger.info(textAnswer.toString());
            textQuestion.addAnswer(textAnswer);
        }

        return questionRepository.save(textQuestion);
    }

    /**
     * Creates and saves a SlideQuestion based on the provided DTO and existing question template.
     *
     * @param slideQuestion The SlideQuestion entity to be populated and saved.
     * @param createSlideQuestionDTO The DTO containing information for creating a slide answer.
     * @return The saved SlideQuestion entity with its slide answer.
     */
    private Question createSlideQuestion(SlideQuestion slideQuestion, SlideQuestionDTO createSlideQuestionDTO) {
        SlideAnswerDTO slideAnswerDTO = createSlideQuestionDTO.getSlideAnswerDTO();
        SlideAnswer slideAnswer = new SlideAnswer();
        if (slideAnswerDTO.getId() != 0) {
            slideAnswer.setId(slideAnswerDTO.getId());
        }
        slideAnswer.setCorrectValue(slideAnswerDTO.getCorrectValue());
        slideAnswer.setMin(slideAnswerDTO.getMin());
        slideAnswer.setMax(slideAnswerDTO.getMax());
        slideAnswer.setStepSize(slideAnswerDTO.getStepSize());
        slideAnswer.setQuestion(slideQuestion);
        slideQuestion.setAnswer(slideAnswer);

        return questionRepository.save(slideQuestion);
    }

    /**
     * Creates and saves a TrueOrFalseQuestion based on the provided DTO and existing question template.
     *
     * @param trueOrFalseQuestion The TrueOrFalseQuestion entity to be populated and saved.
     * @param createTrueOrFalseQuestionDTO The DTO containing information for creating true or false answers.
     * @return The saved TrueOrFalseQuestion entity with its answers.
     */
    private Question createTrueOrFalseQuestion(TrueOrFalseQuestion trueOrFalseQuestion, TrueOrFalseQuestionDTO createTrueOrFalseQuestionDTO) {
        for (TrueOrFalseAnswerDTO trueOrFalseAnswerDTO : createTrueOrFalseQuestionDTO.getTextAnswerDTOS()) {
            TrueOrFalseAnswer trueOrFalseAnswer = new TrueOrFalseAnswer();
            if (trueOrFalseAnswerDTO.getId() != 0) {
                trueOrFalseAnswer.setId(trueOrFalseAnswerDTO.getId());
            }
            trueOrFalseAnswer.setText(trueOrFalseAnswerDTO.getText());
            trueOrFalseAnswer.setIsCorrect(trueOrFalseAnswerDTO.getIsCorrect());
            trueOrFalseAnswer.setQuestion(trueOrFalseQuestion);
            trueOrFalseQuestion.addAnswer(trueOrFalseAnswer);
        }

        return questionRepository.save(trueOrFalseQuestion);
    }
}
