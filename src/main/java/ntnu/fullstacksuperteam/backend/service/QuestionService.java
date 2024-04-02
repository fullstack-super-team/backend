package ntnu.fullstacksuperteam.backend.service;

import ntnu.fullstacksuperteam.backend.dto.*;
import ntnu.fullstacksuperteam.backend.model.*;
import ntnu.fullstacksuperteam.backend.repository.AnswerRepository;
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

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuizService quizService;

    private final Logger logger = LoggerFactory.getLogger(QuestionService.class);

    public List<Question> getQuestionsByQuizId(long quizId) {
        logger.info("Getting questions by quiz id: " + quizId);
        List<Question> questions = questionRepository.findByQuizId(quizId);
        return questions;
    }

    public Question createQuestion(long quizId, CreateQuestionDTO createQuestionDTO) {
        Quiz quiz = quizService.getQuizById(quizId);

        if (createQuestionDTO instanceof CreateTextQuestionDTO) {
            return createTextQuestion(quiz, (CreateTextQuestionDTO) createQuestionDTO);
        } else if (createQuestionDTO instanceof CreateSlideQuestionDTO) {
            return createSlideQuestion(quiz, (CreateSlideQuestionDTO) createQuestionDTO);
        }

        return new Question();
    }

    private Question createTextQuestion(Quiz quiz, CreateTextQuestionDTO createTextQuestionDTO) {
        TextQuestion textQuestion = new TextQuestion();
        textQuestion.setQuiz(quiz);
        textQuestion.setText(createTextQuestionDTO.getText());
        textQuestion.setPoints(createTextQuestionDTO.getPoints());

        for (TextAnswerDTO textAnswerDTO : createTextQuestionDTO.getTextAnswerDTOS()) {
            TextAnswer textAnswer = new TextAnswer();
            textAnswer.setText(textAnswerDTO.getText());
            textAnswer.setCorrect(textAnswerDTO.isCorrect());
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
        slideAnswer.setSteps(slideAnswerDTO.getSteps());
        slideQuestion.setAnswer(slideAnswer);

        return questionRepository.save(slideQuestion);
    }
}
