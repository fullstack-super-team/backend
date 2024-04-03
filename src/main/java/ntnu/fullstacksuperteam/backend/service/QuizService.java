package ntnu.fullstacksuperteam.backend.service;

import ntnu.fullstacksuperteam.backend.dto.CreateQuizDTO;
import ntnu.fullstacksuperteam.backend.model.Quiz;
import ntnu.fullstacksuperteam.backend.model.User;
import ntnu.fullstacksuperteam.backend.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private UserService userService;

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

    public Quiz createQuiz(Long userId, CreateQuizDTO createQuizDTO) {
        User author = userService.getUserById(userId);
        Quiz quiz = new Quiz();
        quiz.setAuthor(author);
        quiz.setTitle(createQuizDTO.getTitle());
        quiz.setCategory(createQuizDTO.getCategory());
        quiz.setDifficultyLevel(createQuizDTO.getDifficultyLevel());
        quiz.setDescription(createQuizDTO.getDescription());

        return quizRepository.save(quiz);
    }
}
