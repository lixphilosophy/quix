package quix.controller;

import quix.domain.UserSubmission;
import quix.service.UserSubmissionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminSubmissionDetailServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String ID = req.getParameter("id");

        if (ID != null) {

            int submissionId = Integer.parseInt(ID);

            UserSubmission userSubmission = UserSubmissionService.getSubmissionWithCache(submissionId);

            req.setAttribute("submission", userSubmission);
            req.setAttribute("action", "admin");

            if(userSubmission.getCorrectCount() > userSubmission.getTotalCount() * 0.6)
                req.setAttribute("status", "PASS");
            else
                req.setAttribute("status", "NO PASS");

            req.getServletContext().getRequestDispatcher("/pages/quizPage.jsp").forward(req, res);

        } else {
            res.sendRedirect(req.getContextPath()+"/admin");
        }
    }
}
