package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentReg;
import model.UserBean;

@WebServlet("/SearchUserServlet")
public class SearchUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String id = req.getParameter("id");
		String name = req.getParameter("name");

		List<UserBean> students = (ArrayList<UserBean>) req.getServletContext().getAttribute("stuApp");

		List<UserBean> foundUser = new ArrayList<>();

		boolean shouldRedirect = false;

		if (students != null) {
			if (!id.equals("") && name.equals("")) {
				foundUser = this.findyById(students, id);
			}

			else if (id.equals("") && !name.equals("")) {
				foundUser = this.findByName(students, name);
			}

			else if (!id.equals("") && !name.equals("")) {
				foundUser = this.findByIdAndName(students, id, name);
			} else {
				shouldRedirect = true;
			}
		}

		if (shouldRedirect) {
			res.sendRedirect("USR003.jsp");
		}

		else {
			req.setAttribute("userApp", foundUser);
			req.getRequestDispatcher("USR003.jsp").forward(req, res);
		}

	}

	public List<UserBean> findyById(List<UserBean> users, String id) {
		List<UserBean> foundUser = new ArrayList<>();

		for (UserBean user : users) {
			if (user.getUserId().contains(id)) {
				foundUser.add(user);
			}
		}

		return foundUser;
	}

	public List<UserBean> findByName(List<UserBean> users, String name) {
		List<UserBean> foundUser = new ArrayList<>();

		for (UserBean user : users) {
			if (user.getUserName().contains(name)) {
				foundUser.add(user);
			}
		}

		return foundUser;

	}

	public List<UserBean> findByIdAndName(List<UserBean> users, String id, String name) {
		List<UserBean> foundUser = new ArrayList<>();

		for (UserBean user : users) {
			if (user.getUserId().contains(id) && user.getUserName().contains(name)) {
				foundUser.add(user);
			}
		}

		return foundUser;

	}

}