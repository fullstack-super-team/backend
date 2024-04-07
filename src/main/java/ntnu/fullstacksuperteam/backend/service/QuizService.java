package ntnu.fullstacksuperteam.backend.service;

import ntnu.fullstacksuperteam.backend.dto.QuestionDTO;
import ntnu.fullstacksuperteam.backend.dto.QuizDTO;
import ntnu.fullstacksuperteam.backend.model.*;
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
    private ScoresService scoresService;

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
        return quiz;
    }

    public Quiz getQuizPlayVersionById(long id) {
        Quiz quiz = quizRepository.findById(id).orElse(null);
        if (quiz == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Quiz not found");
        }
        if (!quiz.getRandomize()) {
            return quiz;
        }
        logger.info("Randomizing quiz questions and answers");
        List<Question> questions = quiz.getQuestions();
        // Randomize question answers order if question type is multiple choice
        for (Question question : questions) {
            if (question instanceof TextQuestion textQuestion) {
                List<TextAnswer> randomizedAnswers = new ArrayList<>();
                while (!textQuestion.getAnswers().isEmpty()) {
                    int randomIndex = (int) (Math.random() * textQuestion.getAnswers().size());
                    randomizedAnswers.add(textQuestion.getAnswers().get(randomIndex));
                    textQuestion.getAnswers().remove(randomIndex);
                }
                textQuestion.setAnswers(randomizedAnswers);
            }
        }

        List<Question> randomizedQuestions = new ArrayList<>();
        while (!questions.isEmpty()) {
            int randomIndex = (int) (Math.random() * questions.size());
            randomizedQuestions.add(questions.get(randomIndex));
            questions.remove(randomIndex);
        }
        quiz.setQuestions(randomizedQuestions);

        return quiz;
    }

    public Quiz createQuiz(long userId, QuizDTO quizDTO) {
        User author = userService.getUserById(userId);
        Quiz quiz = new Quiz();
        quiz.setAuthor(author);
        quiz.setTitle(quizDTO.getTitle());
        quiz.setCategory(quizDTO.getCategory());
        quiz.setDifficultyLevel(quizDTO.getDifficultyLevel());
        quiz.setDescription(quizDTO.getDescription());
        quiz.setRandomize(quizDTO.getRandomize());

        Quiz savedQuiz = quizRepository.save(quiz);

        List<Question> questions = new ArrayList<>();
        for (QuestionDTO questionDTO : quizDTO.getQuestions()) {
            questions.add(this.questionService.createQuestion(savedQuiz.getId(), questionDTO));
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
        quiz.setRandomize(quizDTO.getRandomize());

        List<Question> updatedQuestions = new ArrayList<>();
        for (QuestionDTO questionDTO : quizDTO.getQuestions()) {
            if (questionDTO.getId() > 0) {
                // Update existing question
                Question updatedQuestion = questionService.updateQuestion(questionDTO);
                updatedQuestions.add(updatedQuestion);
                continue;
            }
            Question updatedOrNewQuestion = questionService.createQuestion(quizId, questionDTO);
            updatedQuestions.add(updatedOrNewQuestion);
        }

        quiz.getQuestions().removeIf(question -> !updatedQuestions.contains(question));

        for (Question question : updatedQuestions) {
            if (!quiz.getQuestions().contains(question)) {
                quiz.getQuestions().add(question);
            }
        }

        return quizRepository.save(quiz);
    }

    public void deleteQuiz(long userId, long quizId) {
        Quiz quiz = quizRepository.findById(quizId).orElse(null);
        if (quiz == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Quiz not found");
        }
        if (quiz.getAuthor().getId() != userId) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not the author of this quiz");
        }
        quizRepository.delete(quiz);
    }

    public List<Quiz> getRecentlyPlayedQuizzes(long userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        List<Score> scores = scoresService.getScoresByUserId(userId);
        List<Score> recentScores = scores.subList(0, Math.min(scores.size(), 3));
        List<Quiz> quizzes = new ArrayList<>();
        for (Score score : recentScores) {
            if (!quizzes.contains(score.getQuiz())) {
                quizzes.add(score.getQuiz());
            }
        }
        return quizzes;
    }
}
