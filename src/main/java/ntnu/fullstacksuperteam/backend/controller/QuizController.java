package ntnu.fullstacksuperteam.backend.controller;

import ntnu.fullstacksuperteam.backend.dto.QuizDTO;
import ntnu.fullstacksuperteam.backend.service.QuizService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


/**
 * The {@code QuizController} class manages quiz-related operations within the application.
*/
@RestController
@RequestMapping("/quizzes")
public class QuizController {
    @Autowired
    private QuizService quizService;

    private final Logger logger = LoggerFactory.getLogger(QuizController.class);

    /**
     * Retrieves all quizzes available in the system.
     *
     * @return A {@code ResponseEntity} containing a list of all quizzes.
     */
    @GetMapping
    public ResponseEntity<?> getAllQuizzes() {
        logger.info("Getting all quizzes");
        return ResponseEntity.status(HttpStatus.OK).body(quizService.getAllQuizzes());
    }

    /**
     * Searches for quizzes based on a query string, and optionally, category and difficulty level.
     *
     * @param query The search query string.
     * @param category The category to filter quizzes (optional).
     * @param difficultyLevel The difficulty level to filter quizzes (optional).
     * @return A {@code ResponseEntity} containing the search results.
     */
    @GetMapping("/search")
    public ResponseEntity<?> searchQuizzes(@RequestParam String query, @RequestParam(required = false) String category, @RequestBody(required = false) String difficultyLevel) {
        logger.info("Searching for quizzes with query: " + query + category + difficultyLevel);
        return ResponseEntity.status(HttpStatus.OK).body(quizService.searchQuizzes(query));
    }

    /**
     * Retrieves quizzes created by the currently authenticated user.
     *
     * @param authentication Provides information about the current user.
     * @return A {@code ResponseEntity} containing a list of quizzes created by the user.
     */
    @GetMapping("/my")
    public ResponseEntity<?> getMyQuizzes(Authentication authentication) {
        long userId = Long.parseLong((String) authentication.getPrincipal());
        logger.info("Getting all quizzes");
        return ResponseEntity.status(HttpStatus.OK).body(quizService.getMyQuizzes(userId));
    }

    /**
     * Creates a new quiz with the given details.
     *
     * @param authentication Provides information about the current user.
     * @param quizDTO The data transfer object containing the new quiz's details.
     * @return A {@code ResponseEntity} with the created quiz.
     */
    @PostMapping()
    public ResponseEntity<?> createQuiz(Authentication authentication, @RequestBody QuizDTO quizDTO) {
        long userId = Long.parseLong((String) authentication.getPrincipal());
        return ResponseEntity.status(HttpStatus.CREATED).body(quizService.createQuiz(userId, quizDTO));
    }


    /**
     * Updates an existing quiz with new details.
     *
     * @param authentication Provides information about the current user.
     * @param quizId The ID of the quiz to update.
     * @param quizDTO The data transfer object containing the updated quiz's details.
     * @return A {@code ResponseEntity} with the updated quiz.
     */
    @PutMapping("/{quizId}")
    public ResponseEntity<?> updateQuiz(Authentication authentication, @PathVariable long quizId,
                                        @RequestBody QuizDTO quizDTO) {
        logger.info("Updating quiz with id: " + quizId);

        try {
            long userId = Long.parseLong((String) authentication.getPrincipal());
            return ResponseEntity.status(HttpStatus.OK).body(quizService.updateQuiz(userId, quizId, quizDTO));
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    /**
     * Retrieves quizzes that the currently authenticated user has recently played.
     *
     * @param authentication Provides information about the current user.
     * @return A {@code ResponseEntity} containing a list of recently played quizzes.
     */
    @GetMapping("/recent")
    public ResponseEntity<?> getRecentlyPlayedQuizzes(Authentication authentication) {
        long userId = Long.parseLong((String) authentication.getPrincipal());
        logger.info("Getting all recently played quizzes");
        return ResponseEntity.status(HttpStatus.OK).body(quizService.getRecentlyPlayedQuizzes(userId));
    }

    /**
     * Retrieves a specific play-version of quiz by its ID.
     *
     * @param quizId The ID of the quiz to retrieve.
     * @return A {@code ResponseEntity} containing the requested play-version quiz.
     */
    @GetMapping("/{quizId}/play")
    public ResponseEntity<?> playQuizById(@PathVariable long quizId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(quizService.getQuizPlayVersionById(quizId));
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    /**
     * Retrieves a specific quiz by its ID.
     *
     * @param quizId The ID of the quiz to retrieve.
     * @return A {@code ResponseEntity} containing the requested quiz.
     */
    @GetMapping("/{quizId}")
    public ResponseEntity<?> getQuizById(@PathVariable long quizId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(quizService.getQuizById(quizId));
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    /**
     * Deletes a quiz specified by its ID.
     *
     * @param authentication Provides information about the current user.
     * @param quizId The ID of the quiz to delete.
     * @return A {@code ResponseEntity} confirming the deletion of the quiz.
     */
    @DeleteMapping("/{quizId}")
    public ResponseEntity<?> deleteQuiz(Authentication authentication, @PathVariable long quizId) {
        try {
            long userId = Long.parseLong((String) authentication.getPrincipal());
            quizService.deleteQuiz(userId, quizId);
            return ResponseEntity.status(HttpStatus.OK).body("Quiz deleted");
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }
}
