package ntnu.fullstacksuperteam.backend.service;

import ntnu.fullstacksuperteam.backend.dto.CreateQuestionDTO;
import ntnu.fullstacksuperteam.backend.dto.QuizDTO;
import ntnu.fullstacksuperteam.backend.model.Question;
import ntnu.fullstacksuperteam.backend.model.Quiz;
import ntnu.fullstacksuperteam.backend.model.User;
import ntnu.fullstacksuperteam.backend.repository.QuizRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionService questionService;

    private final Logger logger = LoggerFactory.getLogger(QuizService.class);

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public List<Quiz> searchQuizzes(String query) {
        return quizRepository.findAllByTitleContaining(query);
    }

    public List<Quiz> getMyQuizzes(long id) {
        User user = userService.getUserById(id);
        return quizRepository.findAllByAuthor(user);
    }

    public Quiz getQuizById(long id) {
        Quiz quiz = quizRepository.findById(id).orElse(null);
        if (quiz == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Quiz not found");
        }
        return quizRepository.findById(id).orElse(null);
    }

    public Quiz createQuiz(long userId, QuizDTO quizDTO) {
        User author = userService.getUserById(userId);
        Quiz quiz = new Quiz();
        quiz.setAuthor(author);
        quiz.setTitle(quizDTO.getTitle());
        quiz.setCategory(quizDTO.getCategory());
        quiz.setDifficultyLevel(quizDTO.getDifficultyLevel());
        quiz.setDescription(quizDTO.getDescription());

        Quiz savedQuiz = quizRepository.save(quiz);

        List<Question> questions = new ArrayList<>();
        for (CreateQuestionDTO createQuestionDTO : quizDTO.getQuestions()) {
            questions.add(this.questionService.createQuestion(savedQuiz.getId(), createQuestionDTO));
        }
        savedQuiz.setQuestions(questions);

        return savedQuiz;
    }

    public Quiz updateQuiz(long userId, long quizId, QuizDTO quizDTO) {
        Quiz quiz = quizRepository.findById(quizId).orElse(null);
        if (quiz == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Quiz not found");
        }
        if (quiz.getAuthor().getId() != userId) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not the author of this quiz");
        }

        quiz.setTitle(quizDTO.getTitle());
        quiz.setCategory(quizDTO.getCategory());
        quiz.setDifficultyLevel(quizDTO.getDifficultyLevel());
        quiz.setDescription(quizDTO.getDescription());

        // Update the questions
        List<Question> questions = new ArrayList<>();
        for (CreateQuestionDTO createQuestionDTO : quizDTO.getQuestions()) {
            questions.add(this.questionService.createQuestion(quizId, createQuestionDTO));
        }
        quiz.setQuestions(questions);

        return quizRepository.save(quiz);
    }
}
