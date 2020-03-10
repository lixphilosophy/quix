package quix.controller;

import quix.domain.Question;
import quix.domain.QuizInfo;
import quix.pojo.ChoicePOJO;
import quix.pojo.QuestionPOJO;
import quix.service.QuestionService;
import quix.service.QuizInfoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AdminQuizAddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int quizID = Integer.parseInt(req.getParameter("quizID"));
        String questionType = req.getParameter("questionType");
        String questionString = req.getParameter("questionString");
        String[] questionChoices = req.getParameter("questionChoices").split("\\|");
        String correctChoice = req.getParameter("correctChoice");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM d yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String modifiedTime = dtf.format(now);
        int status = 1;

        QuestionPOJO questionPOJO = new QuestionPOJO();
        questionPOJO.setQuestionType(questionType);
        questionPOJO.setQuestionString(questionString);
        questionPOJO.setQuizID(quizID);
        questionPOJO.setModifiedTime(modifiedTime);
        questionPOJO.setStatus(status);

        List<ChoicePOJO> choices = new ArrayList<>();
        for(String questionChoice : questionChoices) {
            ChoicePOJO choice = new ChoicePOJO();
            choice.setChoiceString(questionChoice);
            if(questionChoice.equals(correctChoice))
                choice.setIfCorrect(true);
            else
                choice.setIfCorrect(false);
        }
        questionPOJO.setChoicesPOJOs(choices);

        QuestionService.addQuestion(questionPOJO);

        res.sendRedirect(req.getContextPath() + "/admin/quiz?id=" + quizID);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int quizId = Integer.parseInt(req.getParameter("id"));

        QuizInfo quizInfo = QuizInfoService.getQuizWithCache(quizId);
        req.setAttribute("quiz", quizInfo);

        req.setAttribute("action", "addQuestion");
        req.getServletContext().getRequestDispatcher("/pages/adminPage.jsp").forward(req, res);
    }
}
