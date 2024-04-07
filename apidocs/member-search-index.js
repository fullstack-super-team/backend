memberSearchIndex = [{"p":"ntnu.fullstacksuperteam.backend.model","c":"TextQuestion","l":"addAnswer(TextAnswer)","u":"addAnswer(ntnu.fullstacksuperteam.backend.model.TextAnswer)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"TrueOrFalseQuestion","l":"addAnswer(TrueOrFalseAnswer)","u":"addAnswer(ntnu.fullstacksuperteam.backend.model.TrueOrFalseAnswer)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Answer","l":"Answer()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.controller","c":"AuthController","l":"AuthController()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"AuthService","l":"AuthService()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend","c":"BackendApplication","l":"BackendApplication()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.controller","c":"QuestionController","l":"createQuestion(long, QuestionDTO)","u":"createQuestion(long,ntnu.fullstacksuperteam.backend.dto.QuestionDTO)"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"QuestionService","l":"createQuestion(long, QuestionDTO)","u":"createQuestion(long,ntnu.fullstacksuperteam.backend.dto.QuestionDTO)"},{"p":"ntnu.fullstacksuperteam.backend.controller","c":"QuizController","l":"createQuiz(Authentication, QuizDTO)","u":"createQuiz(org.springframework.security.core.Authentication,ntnu.fullstacksuperteam.backend.dto.QuizDTO)"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"QuizService","l":"createQuiz(long, QuizDTO)","u":"createQuiz(long,ntnu.fullstacksuperteam.backend.dto.QuizDTO)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Category","l":"CULTURE"},{"p":"ntnu.fullstacksuperteam.backend.controller","c":"QuizController","l":"deleteQuiz(Authentication, long)","u":"deleteQuiz(org.springframework.security.core.Authentication,long)"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"QuizService","l":"deleteQuiz(long, long)","u":"deleteQuiz(long,long)"},{"p":"ntnu.fullstacksuperteam.backend.security","c":"JWTAuthorizationFilter","l":"doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)","u":"doFilterInternal(jakarta.servlet.http.HttpServletRequest,jakarta.servlet.http.HttpServletResponse,jakarta.servlet.FilterChain)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"DifficultyLevel","l":"EASY"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"ErrorResponse","l":"ErrorResponse(String)","u":"%3Cinit%3E(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Feedback","l":"Feedback()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.controller","c":"FeedbackController","l":"FeedbackController(FeedbackService)","u":"%3Cinit%3E(ntnu.fullstacksuperteam.backend.service.FeedbackService)"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"FeedbackService","l":"FeedbackService(FeedbackRepository, UserService)","u":"%3Cinit%3E(ntnu.fullstacksuperteam.backend.repository.FeedbackRepository,ntnu.fullstacksuperteam.backend.service.UserService)"},{"p":"ntnu.fullstacksuperteam.backend.repository","c":"QuizRepository","l":"findAllByAuthor(User)","u":"findAllByAuthor(ntnu.fullstacksuperteam.backend.model.User)"},{"p":"ntnu.fullstacksuperteam.backend.repository","c":"AnswerRepository","l":"findAllByQuestionId(long)"},{"p":"ntnu.fullstacksuperteam.backend.repository","c":"ScoresRepository","l":"findAllByQuizIdOrderByPointsDescDateDesc(long)"},{"p":"ntnu.fullstacksuperteam.backend.repository","c":"QuizRepository","l":"findAllByTitleContaining(String)","u":"findAllByTitleContaining(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.repository","c":"ScoresRepository","l":"findAllByUserIdAndQuizIdOrderByDateDesc(long, long)","u":"findAllByUserIdAndQuizIdOrderByDateDesc(long,long)"},{"p":"ntnu.fullstacksuperteam.backend.repository","c":"ScoresRepository","l":"findAllByUserIdOrderByDateDesc(long)"},{"p":"ntnu.fullstacksuperteam.backend.repository","c":"UserRepository","l":"findByEmail(String)","u":"findByEmail(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.repository","c":"AnswerRepository","l":"findByQuestionId(long)"},{"p":"ntnu.fullstacksuperteam.backend.repository","c":"QuestionRepository","l":"findByQuizId(long)"},{"p":"ntnu.fullstacksuperteam.backend.repository","c":"UserRepository","l":"findFirstByUsernameOrEmail(String, String)","u":"findFirstByUsernameOrEmail(java.lang.String,java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Category","l":"FOOD"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"DifficultyLevel","l":"fromInt(int)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Category","l":"fromString(String)","u":"fromString(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Category","l":"GENERAL"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"TokenService","l":"generateToken(Long)","u":"generateToken(java.lang.Long)"},{"p":"ntnu.fullstacksuperteam.backend.controller","c":"QuizController","l":"getAllQuizzes()"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"QuizService","l":"getAllQuizzes()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"SubmitAnswerDTO","l":"getAnswer()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"SlideQuestion","l":"getAnswer()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"TextQuestion","l":"getAnswers()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"TrueOrFalseQuestion","l":"getAnswers()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Quiz","l":"getAuthor()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"QuizDTO","l":"getCategory()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Quiz","l":"getCategory()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Feedback","l":"getComment()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"SubmittedAnswerDTO","l":"getCorrectAnswers()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"SlideAnswerDTO","l":"getCorrectValue()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"SlideAnswer","l":"getCorrectValue()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Feedback","l":"getCreatedAt()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Question","l":"getCreatedAt()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Quiz","l":"getCreatedAt()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"User","l":"getCreatedAt()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Score","l":"getDate()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"QuizDTO","l":"getDescription()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Quiz","l":"getDescription()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"QuizDTO","l":"getDifficultyLevel()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Quiz","l":"getDifficultyLevel()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"LoginDTO","l":"getEmail()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"RegisterDTO","l":"getEmail()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"UserDTO","l":"getEmail()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"User","l":"getEmail()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"RegisterDTO","l":"getFirstName()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"UserDTO","l":"getFirstName()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"User","l":"getFirstName()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"QuestionDTO","l":"getId()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"SlideAnswerDTO","l":"getId()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"TextAnswerDTO","l":"getId()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"TrueOrFalseAnswerDTO","l":"getId()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"UserDTO","l":"getId()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Answer","l":"getId()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Feedback","l":"getId()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Question","l":"getId()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Quiz","l":"getId()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Score","l":"getId()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"User","l":"getId()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"TextAnswerDTO","l":"getIsCorrect()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"TrueOrFalseAnswerDTO","l":"getIsCorrect()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"RegisterDTO","l":"getLastName()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"UserDTO","l":"getLastName()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"User","l":"getLastName()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"SlideAnswerDTO","l":"getMax()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"SlideAnswer","l":"getMax()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"ErrorResponse","l":"getMessage()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"SlideAnswerDTO","l":"getMin()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"SlideAnswer","l":"getMin()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"QuestionDTO","l":"getMultimediaUrl()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Question","l":"getMultimediaUrl()"},{"p":"ntnu.fullstacksuperteam.backend.controller","c":"QuizController","l":"getMyQuizzes(Authentication)","u":"getMyQuizzes(org.springframework.security.core.Authentication)"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"QuizService","l":"getMyQuizzes(long)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"LoginDTO","l":"getPassword()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"RegisterDTO","l":"getPassword()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"User","l":"getPassword()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"QuestionDTO","l":"getPoints()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Question","l":"getPoints()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Score","l":"getPoints()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"SubmittedAnswerDTO","l":"getPointsGiven()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Answer","l":"getQuestion()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"QuizDTO","l":"getQuestions()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Quiz","l":"getQuestions()"},{"p":"ntnu.fullstacksuperteam.backend.controller","c":"QuestionController","l":"getQuestionsByQuizId(long)"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"QuestionService","l":"getQuestionsByQuizId(long)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Question","l":"getQuiz()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Score","l":"getQuiz()"},{"p":"ntnu.fullstacksuperteam.backend.controller","c":"QuizController","l":"getQuizById(long)"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"QuizService","l":"getQuizById(long)"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"QuizService","l":"getQuizPlayVersionById(long)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"QuizDTO","l":"getRandomize()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Quiz","l":"getRandomize()"},{"p":"ntnu.fullstacksuperteam.backend.controller","c":"QuizController","l":"getRecentlyPlayedQuizzes(Authentication)","u":"getRecentlyPlayedQuizzes(org.springframework.security.core.Authentication)"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"QuizService","l":"getRecentlyPlayedQuizzes(long)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"User","l":"getScoreList()"},{"p":"ntnu.fullstacksuperteam.backend.controller","c":"ScoresController","l":"getScoresByQuizId(long)"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"ScoresService","l":"getScoresByQuizId(long)"},{"p":"ntnu.fullstacksuperteam.backend.controller","c":"ScoresController","l":"getScoresByUserAndQuizId(Authentication, long)","u":"getScoresByUserAndQuizId(org.springframework.security.core.Authentication,long)"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"ScoresService","l":"getScoresByUserAndQuizId(long, long)","u":"getScoresByUserAndQuizId(long,long)"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"ScoresService","l":"getScoresByUserId(long)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"SlideQuestionDTO","l":"getSlideAnswerDTO()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"SlideAnswerDTO","l":"getStepSize()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"SlideAnswer","l":"getStepSize()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"SubmittedAnswerDTO","l":"getSubmittedAnswer()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"QuestionDTO","l":"getText()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"TextAnswerDTO","l":"getText()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"TrueOrFalseAnswerDTO","l":"getText()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Question","l":"getText()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Tag","l":"getText()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"TextAnswer","l":"getText()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"TrueOrFalseAnswer","l":"getText()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"TextQuestionDTO","l":"getTextAnswerDTOS()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"TrueOrFalseQuestionDTO","l":"getTextAnswerDTOS()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"QuizDTO","l":"getTitle()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Quiz","l":"getTitle()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Token","l":"getToken()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"QuestionDTO","l":"getType()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Question","l":"getUpdatedAt()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Quiz","l":"getUpdatedAt()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"User","l":"getUpdatedAt()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Feedback","l":"getUser()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Score","l":"getUser()"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"UserService","l":"getUserById(long)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"RegisterDTO","l":"getUsername()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"UserDTO","l":"getUsername()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"User","l":"getUsername()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"DifficultyLevel","l":"HARD"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Category","l":"HISTORY"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"TextAnswer","l":"isIsCorrect()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"TrueOrFalseAnswer","l":"isIsCorrect()"},{"p":"ntnu.fullstacksuperteam.backend.security","c":"JWTAuthorizationFilter","l":"JWTAuthorizationFilter(TokenService)","u":"%3Cinit%3E(ntnu.fullstacksuperteam.backend.service.TokenService)"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"TokenService","l":"keyStr"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"AuthService","l":"login(LoginDTO)","u":"login(ntnu.fullstacksuperteam.backend.dto.LoginDTO)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"LoginDTO","l":"LoginDTO(String, String)","u":"%3Cinit%3E(java.lang.String,java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend","c":"BackendApplication","l":"main(String[])","u":"main(java.lang.String[])"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"DifficultyLevel","l":"MEDIUM"},{"p":"ntnu.fullstacksuperteam.backend.security","c":"SecurityConfig","l":"passwordEncoder()"},{"p":"ntnu.fullstacksuperteam.backend.controller","c":"QuizController","l":"playQuizById(long)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Question","l":"Question()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Question","l":"Question(Question)","u":"%3Cinit%3E(ntnu.fullstacksuperteam.backend.model.Question)"},{"p":"ntnu.fullstacksuperteam.backend.controller","c":"QuestionController","l":"QuestionController()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"QuestionDTO","l":"QuestionDTO()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"QuestionService","l":"QuestionService()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Quiz","l":"Quiz()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.controller","c":"QuizController","l":"QuizController()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"QuizDTO","l":"QuizDTO()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"QuizService","l":"QuizService()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"AuthService","l":"register(RegisterDTO)","u":"register(ntnu.fullstacksuperteam.backend.dto.RegisterDTO)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"RegisterDTO","l":"RegisterDTO(String, String, String, String, String)","u":"%3Cinit%3E(java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"FeedbackService","l":"saveFeedback(long, Feedback)","u":"saveFeedback(long,ntnu.fullstacksuperteam.backend.model.Feedback)"},{"p":"ntnu.fullstacksuperteam.backend.controller","c":"ScoresController","l":"saveScore(Authentication, long, Score)","u":"saveScore(org.springframework.security.core.Authentication,long,ntnu.fullstacksuperteam.backend.model.Score)"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"ScoresService","l":"saveScore(long, long, Score)","u":"saveScore(long,long,ntnu.fullstacksuperteam.backend.model.Score)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Category","l":"SCIENCE"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Score","l":"Score()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.controller","c":"ScoresController","l":"ScoresController()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"ScoresService","l":"ScoresService()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"QuizService","l":"searchQuizzes(String)","u":"searchQuizzes(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.controller","c":"QuizController","l":"searchQuizzes(String, String, String)","u":"searchQuizzes(java.lang.String,java.lang.String,java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.security","c":"SecurityConfig","l":"SecurityConfig()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.security","c":"SecurityConfig","l":"securityFilterChain(HttpSecurity)","u":"securityFilterChain(org.springframework.security.config.annotation.web.builders.HttpSecurity)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"SlideQuestion","l":"setAnswer(SlideAnswer)","u":"setAnswer(ntnu.fullstacksuperteam.backend.model.SlideAnswer)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"SlideQuestionDTO","l":"setAnswer(SlideAnswerDTO)","u":"setAnswer(ntnu.fullstacksuperteam.backend.dto.SlideAnswerDTO)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"SubmitAnswerDTO","l":"setAnswer(String)","u":"setAnswer(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"TextQuestion","l":"setAnswers(List<TextAnswer>)","u":"setAnswers(java.util.List)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"TextQuestionDTO","l":"setAnswers(List<TextAnswerDTO>)","u":"setAnswers(java.util.List)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"TrueOrFalseQuestion","l":"setAnswers(List<TrueOrFalseAnswer>)","u":"setAnswers(java.util.List)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"TrueOrFalseQuestionDTO","l":"setAnswers(List<TrueOrFalseAnswerDTO>)","u":"setAnswers(java.util.List)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Quiz","l":"setAuthor(User)","u":"setAuthor(ntnu.fullstacksuperteam.backend.model.User)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"QuizDTO","l":"setCategory(Category)","u":"setCategory(ntnu.fullstacksuperteam.backend.model.Category)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Quiz","l":"setCategory(Category)","u":"setCategory(ntnu.fullstacksuperteam.backend.model.Category)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Feedback","l":"setComment(String)","u":"setComment(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"TextAnswerDTO","l":"setCorrect(boolean)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"TrueOrFalseAnswerDTO","l":"setCorrect(boolean)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"SlideAnswerDTO","l":"setCorrectValue(int)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"SlideAnswer","l":"setCorrectValue(int)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Quiz","l":"setCreatedAt(Date)","u":"setCreatedAt(java.util.Date)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"QuizDTO","l":"setDescription(String)","u":"setDescription(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Quiz","l":"setDescription(String)","u":"setDescription(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"QuizDTO","l":"setDifficultyLevel(DifficultyLevel)","u":"setDifficultyLevel(ntnu.fullstacksuperteam.backend.model.DifficultyLevel)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Quiz","l":"setDifficultyLevel(DifficultyLevel)","u":"setDifficultyLevel(ntnu.fullstacksuperteam.backend.model.DifficultyLevel)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"UserDTO","l":"setEmail(String)","u":"setEmail(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"User","l":"setEmail(String)","u":"setEmail(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"UserDTO","l":"setFirstName(String)","u":"setFirstName(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"User","l":"setFirstName(String)","u":"setFirstName(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"QuestionDTO","l":"setId(long)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"SlideAnswerDTO","l":"setId(long)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"TextAnswerDTO","l":"setId(long)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"TrueOrFalseAnswerDTO","l":"setId(long)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"UserDTO","l":"setId(long)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Answer","l":"setId(long)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Feedback","l":"setId(long)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Question","l":"setId(long)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Quiz","l":"setId(long)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"User","l":"setId(Long)","u":"setId(java.lang.Long)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"TextAnswer","l":"setIsCorrect(boolean)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"TrueOrFalseAnswer","l":"setIsCorrect(boolean)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"UserDTO","l":"setLastName(String)","u":"setLastName(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"User","l":"setLastName(String)","u":"setLastName(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"SlideAnswerDTO","l":"setMax(int)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"SlideAnswer","l":"setMax(int)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"SlideAnswerDTO","l":"setMin(int)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"SlideAnswer","l":"setMin(int)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"QuestionDTO","l":"setMultimediaUrl(String)","u":"setMultimediaUrl(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Question","l":"setMultimediaUrl(String)","u":"setMultimediaUrl(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"User","l":"setPassword(String)","u":"setPassword(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"QuestionDTO","l":"setPoints(int)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Question","l":"setPoints(int)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Score","l":"setPoints(int)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Answer","l":"setQuestion(Question)","u":"setQuestion(ntnu.fullstacksuperteam.backend.model.Question)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Quiz","l":"setQuestions(List<Question>)","u":"setQuestions(java.util.List)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"QuizDTO","l":"setQuestions(List<QuestionDTO>)","u":"setQuestions(java.util.List)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Question","l":"setQuiz(Quiz)","u":"setQuiz(ntnu.fullstacksuperteam.backend.model.Quiz)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Score","l":"setQuiz(Quiz)","u":"setQuiz(ntnu.fullstacksuperteam.backend.model.Quiz)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"QuizDTO","l":"setRandomize(boolean)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Quiz","l":"setRandomize(boolean)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"User","l":"setScoreList(List<Score>)","u":"setScoreList(java.util.List)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"SlideAnswerDTO","l":"setStepSize(int)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"SlideAnswer","l":"setStepSize(int)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"QuestionDTO","l":"setText(String)","u":"setText(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"TextAnswerDTO","l":"setText(String)","u":"setText(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"TrueOrFalseAnswerDTO","l":"setText(String)","u":"setText(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Question","l":"setText(String)","u":"setText(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Tag","l":"setText(String)","u":"setText(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"TextAnswer","l":"setText(String)","u":"setText(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"TrueOrFalseAnswer","l":"setText(String)","u":"setText(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"QuizDTO","l":"setTitle(String)","u":"setTitle(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Quiz","l":"setTitle(String)","u":"setTitle(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"QuestionDTO","l":"setType(String)","u":"setType(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Quiz","l":"setUpdatedAt(Date)","u":"setUpdatedAt(java.util.Date)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Feedback","l":"setUser(User)","u":"setUser(ntnu.fullstacksuperteam.backend.model.User)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Score","l":"setUser(User)","u":"setUser(ntnu.fullstacksuperteam.backend.model.User)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"UserDTO","l":"setUsername(String)","u":"setUsername(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"User","l":"setUsername(String)","u":"setUsername(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"SlideAnswer","l":"SlideAnswer()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"SlideAnswerDTO","l":"SlideAnswerDTO()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"SlideQuestion","l":"SlideQuestion()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"SlideQuestion","l":"SlideQuestion(Question)","u":"%3Cinit%3E(ntnu.fullstacksuperteam.backend.model.Question)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"SlideQuestionDTO","l":"SlideQuestionDTO()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Category","l":"SPORT"},{"p":"ntnu.fullstacksuperteam.backend.controller","c":"QuestionController","l":"submitAnswer(long, SubmitAnswerDTO)","u":"submitAnswer(long,ntnu.fullstacksuperteam.backend.dto.SubmitAnswerDTO)"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"QuestionService","l":"submitAnswer(long, SubmitAnswerDTO)","u":"submitAnswer(long,ntnu.fullstacksuperteam.backend.dto.SubmitAnswerDTO)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"SubmitAnswerDTO","l":"SubmitAnswerDTO()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.controller","c":"FeedbackController","l":"submitFeedback(Authentication, Feedback)","u":"submitFeedback(org.springframework.security.core.Authentication,ntnu.fullstacksuperteam.backend.model.Feedback)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"SubmittedAnswerDTO","l":"SubmittedAnswerDTO(T, T, int)","u":"%3Cinit%3E(T,T,int)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Tag","l":"Tag()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Tag","l":"Tag(String)","u":"%3Cinit%3E(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"TextAnswer","l":"TextAnswer()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"TextAnswerDTO","l":"TextAnswerDTO()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"TextQuestion","l":"TextQuestion()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"TextQuestion","l":"TextQuestion(Question)","u":"%3Cinit%3E(ntnu.fullstacksuperteam.backend.model.Question)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"TextQuestionDTO","l":"TextQuestionDTO()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Token","l":"Token(String)","u":"%3Cinit%3E(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"TokenService","l":"TokenService()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"LoginDTO","l":"toString()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"SlideAnswerDTO","l":"toString()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"SlideQuestionDTO","l":"toString()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"TextAnswerDTO","l":"toString()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"TextQuestionDTO","l":"toString()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"TrueOrFalseQuestionDTO","l":"toString()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"UserDTO","l":"toString()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Feedback","l":"toString()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"TextAnswer","l":"toString()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"User","l":"toString()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"TrueOrFalseAnswer","l":"TrueOrFalseAnswer()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"TrueOrFalseAnswerDTO","l":"TrueOrFalseAnswerDTO()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"TrueOrFalseQuestion","l":"TrueOrFalseQuestion()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"TrueOrFalseQuestion","l":"TrueOrFalseQuestion(Question)","u":"%3Cinit%3E(ntnu.fullstacksuperteam.backend.model.Question)"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"TrueOrFalseQuestionDTO","l":"TrueOrFalseQuestionDTO()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"QuestionService","l":"updateQuestion(QuestionDTO)","u":"updateQuestion(ntnu.fullstacksuperteam.backend.dto.QuestionDTO)"},{"p":"ntnu.fullstacksuperteam.backend.controller","c":"QuizController","l":"updateQuiz(Authentication, long, QuizDTO)","u":"updateQuiz(org.springframework.security.core.Authentication,long,ntnu.fullstacksuperteam.backend.dto.QuizDTO)"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"QuizService","l":"updateQuiz(long, long, QuizDTO)","u":"updateQuiz(long,long,ntnu.fullstacksuperteam.backend.dto.QuizDTO)"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"UserService","l":"updateUser(long, User)","u":"updateUser(long,ntnu.fullstacksuperteam.backend.model.User)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"User","l":"User()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.controller","c":"UserController","l":"UserController()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.dto","c":"UserDTO","l":"UserDTO()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"UserService","l":"UserService()","u":"%3Cinit%3E()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Category","l":"valueOf(String)","u":"valueOf(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"DifficultyLevel","l":"valueOf(String)","u":"valueOf(java.lang.String)"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"Category","l":"values()"},{"p":"ntnu.fullstacksuperteam.backend.model","c":"DifficultyLevel","l":"values()"},{"p":"ntnu.fullstacksuperteam.backend.service","c":"TokenService","l":"verifyTokenAndGetUserId(String)","u":"verifyTokenAndGetUserId(java.lang.String)"}];updateSearchResults();