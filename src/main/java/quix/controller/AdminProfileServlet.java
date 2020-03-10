package quix.controller;

import quix.domain.UserInfo;
import quix.service.UserInfoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        List<UserInfo> userInfos = UserInfoService.getUsers();
        req.setAttribute("users", userInfos);

        req.setAttribute("action", "profile");
        req.setAttribute("title", "View Profile");
        req.getServletContext().getRequestDispatcher("/pages/adminPage.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int userId = Integer.parseInt(req.getParameter("userId"));
        int userStatus = Integer.parseInt(req.getParameter("status"));

        userStatus = userStatus == 1 ? 2 : 1;
        UserInfoService.updateUserStatus(userId, userStatus);

        res.sendRedirect(req.getContextPath()+"/admin/profile");
    }
}
