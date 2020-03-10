package quix.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import quix.domain.UserInfo;
import quix.pojo.Response;
import quix.pojo.UserInfoPOJO;
import quix.service.UserInfoService;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		int status = 1;
		String firstName = req.getParameter("firstname");
		String lastName = req.getParameter("lastname");
		String email = req.getParameter("email");
		String birthDate = req.getParameter("birthdate");
		int groupID = 1;

		Response response = new Response();

		if (userName == null || userName.length() == 0) {
			response.setSuccess(false);
			response.setErrMsg("Username is Empty!");
		} else if (password == null || password.length() == 0) {
			response.setSuccess(false);
			response.setErrMsg("Password is Empty!");
		} else if (password.length() < 6) {
			response.setSuccess(false);
			response.setErrMsg("Password should be at least 6 characters!");
		} else if (firstName == null || firstName.length() == 0) {
			response.setSuccess(false);
			response.setErrMsg("First name is Empty!");
		}else if (!isValidDate(birthDate)) {
			response.setSuccess(false);
			response.setErrMsg("Date of birth should be a valid date.");
		} else if (!isValidEmail(email)) {
			response.setSuccess(false);
			response.setErrMsg("Email should be a valid email address.");
		} else if (UserInfoService.getUser(userName, password) != null) {
			response.setSuccess(false);
			response.setErrMsg("Username exists.");
		}

		if (response.isSuccess()) {

			UserInfoPOJO userInfoPOJO = new UserInfoPOJO();

			userInfoPOJO.setUserName(userName);
			userInfoPOJO.setUserPassword(password);
			userInfoPOJO.setUserStatus(status);
			userInfoPOJO.setFirstName(firstName);
			userInfoPOJO.setLastName(lastName);
			userInfoPOJO.setBirthDate(birthDate);
			userInfoPOJO.setEmail(email);
			userInfoPOJO.setGroupID(groupID);

			boolean success = UserInfoService.setUser(userInfoPOJO);
			UserInfo userInfo = UserInfoService.getUser(userName, password);

			if(success && userInfo != null) {
				HttpSession session = req.getSession();

				session.setAttribute("userID", userInfo.getUserId());
				session.setAttribute("firstName", userInfo.getFirstName());
				session.setAttribute("lastName", userInfo.getLastName());

				response.setSuccess(true);
				response.setRedirectUrl(req.getContextPath() + "/page/quiz");
			} else {
				response.setSuccess(false);
				response.setErrMsg("Unexpected Error.");
			}
		}

		PrintWriter writer = res.getWriter();
		Gson gson = new Gson();
		String respJson = gson.toJson(response);
		writer.append(respJson);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("action", "register");
		req.getServletContext().getRequestDispatcher("/pages/loginPage.jsp").forward(req, res);
	}

	private boolean isValidDate(String date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(date);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	private boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}
}
