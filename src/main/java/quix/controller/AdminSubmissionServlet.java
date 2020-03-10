package quix.controller;

import quix.domain.UserSubmission;
import quix.service.UserSubmissionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminSubmissionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        List<UserSubmission> userSubmissions = UserSubmissionService.getSubmissions();
        req.setAttribute("submissions", userSubmissions);

        req.setAttribute("action", "submission");
        req.setAttribute("title", "View Submission");
        req.getServletContext().getRequestDispatcher("/pages/adminPage.jsp").forward(req, res);
    }
}
