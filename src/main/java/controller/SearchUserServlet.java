package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		List<UserBean> users = (ArrayList<UserBean>) req.getServletContext().getAttribute("userApp");

		List<UserBean> foundusers= new ArrayList<>();

		boolean shouldRedirect = false;

		if (users != null) {
			if (!id.equals("") && name.equals("")) {
				foundusers = this.findyById(users, id);
			}else if (id.equals("") && !name.equals("")) {
				foundusers = this.findByName(users, name);
			} else if (!id.equals("") && !name.equals("")) {
				foundusers = this.findByIdAndName(users, id, name);
			} else {
				shouldRedirect = true;
			}
		}

		if (shouldRedirect) {
			res.sendRedirect("USR003.jsp");
		}

		else {
			req.setAttribute("userApp", foundusers);
			req.getRequestDispatcher("USR003.jsp").forward(req, res);
		}

	}

	public List<UserBean> findyById(List<UserBean> students, String id) {
		List<UserBean> foundStudents = new ArrayList<>();
		for (UserBean student : students) {
			if (student.getUserId().contains(id)) {
				foundStudents.add(student);
			}
		}
		return foundStudents;
	}

	public List<UserBean> findByName(List<UserBean> students, String name) {
		List<UserBean> foundStudents = new ArrayList<>();
		for (UserBean student : students) {
			if (student.getUserName().contains(name)) {
				foundStudents.add(student);
			}
		}

		return foundStudents;
	}
	public List<UserBean> findByIdAndName(List<UserBean> students, String id, String name) {
		List<UserBean> foundStudents = new ArrayList<>();
		for (UserBean student : students) {
			if (student.getUserId().contains(id) && student.getUserName().contains(name)) {
				foundStudents.add(student);
			}
		}
		return foundStudents;

	}
}