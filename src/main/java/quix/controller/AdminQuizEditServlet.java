package quix.controller;

import quix.domain.Question;
import quix.domain.QuizInfo;
import quix.service.QuestionService;
import quix.service.QuizInfoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminQuizEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int questionId = Integer.parseInt(req.getParameter("id"));
        int quizId = Integer.parseInt(req.getParameter("quizId"));

        Question question = QuestionService.getQuestion(questionId, true);
        req.setAttribute("question", question);
        req.setAttribute("quizId", quizId);

        req.setAttribute("action", "editQuestion");
        req.getServletContext().getRequestDispatcher("/pages/adminPage.jsp").forward(req, res);
    }
}
