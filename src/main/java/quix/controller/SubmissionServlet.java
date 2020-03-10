package quix.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import quix.domain.UserSubmission;
import quix.pojo.Response;
import quix.pojo.UserAnswerPOJO;
import quix.pojo.UserSubmissionPOJO;
import quix.service.UserSubmissionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SubmissionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        int userID = (int) session.getAttribute("userID");

        int quizId = Integer.parseInt(req.getParameter("quizID"));
        String startTime = req.getParameter("startTime");
        String endTime = req.getParameter("endTime");

        String submitAnswer = req.getParameter("submitAnswer");
        TypeToken<List<Map<String, String>>> typeToken = new TypeToken<List<Map<String, String>>>() {
        };
        List<Map<String, String>> answers = new Gson().fromJson(submitAnswer, typeToken.getType());

        Response response = new Response();

        UserSubmissionPOJO userSubmissionPOJO = new UserSubmissionPOJO();

        userSubmissionPOJO.setStartTime(startTime);
        userSubmissionPOJO.setEndTime(endTime);
        userSubmissionPOJO.setUserID(userID);
        userSubmissionPOJO.setQuizId(quizId);

        List<UserAnswerPOJO> userAnswerPOJOs = new ArrayList<>();
        for (Map<String, String> answer : answers) {
            UserAnswerPOJO userAnswerPOJO = new UserAnswerPOJO();
            int questionID = Integer.parseInt(answer.get("questionID"));

            userAnswerPOJO.setQuestionID(questionID);
            userAnswerPOJO.setAnswerString(answer.getOrDefault("userAnswer", ""));

            userAnswerPOJOs.add(userAnswerPOJO);
        }
        userSubmissionPOJO.setUserAnswerPOJOs(userAnswerPOJOs);

        UserSubmission userSubmission = UserSubmissionService.setSubmissionWithReturn(userSubmissionPOJO);

        if(userSubmission != null) {
            response.setSuccess(true);
            response.setRedirectUrl(req.getContextPath() + "/page/submission?id=" + userSubmission.getSubmissionID());
        } else {
            response.setSuccess(false);
            response.setErrMsg("Database Connection Error.");
        }

        PrintWriter writer = res.getWriter();
        Gson gson = new Gson();
        String respJson = gson.toJson(response);
        writer.append(respJson);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String ID = req.getParameter("id");

        if (ID != null) {

			int submissionId = Integer.parseInt(ID);

			UserSubmission userSubmission = UserSubmissionService.getSubmissionWithCache(submissionId);

			req.setAttribute("submission", userSubmission);
			req.setAttribute("action", "submission");

            if(userSubmission.getCorrectCount() > userSubmission.getTotalCount() * 0.6)
                req.setAttribute("status", "PASS");
            else
                req.setAttribute("status", "NO PASS");

            req.getServletContext().getRequestDispatcher("/pages/quizPage.jsp").forward(req, res);

        } else {
            res.sendRedirect(req.getContextPath()+"/page/quiz");
        }
    }
}
