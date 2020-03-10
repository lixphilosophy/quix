package quix.controller;

import quix.domain.QuizInfo;
import quix.service.QuizInfoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminModifiedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<QuizInfo> quizInfos = QuizInfoService.getQuizzes();
        req.setAttribute("quizzes", quizInfos);

        req.setAttribute("action", "modified");
        req.setAttribute("title", "Modified Quiz");
        req.getServletContext().getRequestDispatcher("/pages/adminPage.jsp").forward(req, res);
    }
}
