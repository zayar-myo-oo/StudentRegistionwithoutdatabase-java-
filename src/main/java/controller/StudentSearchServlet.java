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

@WebServlet("/StudentSearchServlet")
public class StudentSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentSearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String course = req.getParameter("course");

		List<StudentReg> students = (ArrayList<StudentReg>) req.getServletContext().getAttribute("stuApp");

		List<StudentReg> foundStudents = new ArrayList<>();

		boolean shouldRedirect = false;

		if (students != null) {
			if (!id.equals("") && name.equals("") && course.equals("")) {
				foundStudents = this.findyById(students, id);
			}

			else if (id.equals("") && !name.equals("") && course.equals("")) {
				foundStudents = this.findByName(students, name);
			}

			else if (id.equals("") && name.equals("") && !course.equals("")) {
				foundStudents = this.findByCourse(students, course);
			}

			else if (!id.equals("") && !name.equals("") && course.equals("")) {
				foundStudents = this.findByIdAndName(students, id, name);
			}

			else if (!id.equals("") && name.equals("") && !course.equals("")) {
				foundStudents = this.findByIdAndCourse(students, id, course);
			}

			else if (id.equals("") && !name.equals("") && !course.equals("")) {
				foundStudents = this.findByNameAndCourse(students, name, course);
			}

			else if (!id.equals("") && !name.equals("") && !course.equals("")) {
				foundStudents = this.findByIdAndNameAndCourse(students, id, name, course);
			}

			else {
				shouldRedirect = true;
			}
		}

		if (shouldRedirect) {
			res.sendRedirect("STU003.jsp");
		}

		else {
			req.setAttribute("stuApp", foundStudents);
			req.getRequestDispatcher("STU003.jsp").forward(req, res);
		}

	}

	public List<StudentReg> findyById(List<StudentReg> students, String id) {
		List<StudentReg> foundStudents = new ArrayList<>();

		for (StudentReg student : students) {
			if (student.getStuId().contains(id)) {
				foundStudents.add(student);
			}
		}

		return foundStudents;
	}

	public List<StudentReg> findByName(List<StudentReg> students, String name) {
		List<StudentReg> foundStudents = new ArrayList<>();

		for (StudentReg student : students) {
			if (student.getName().contains(name)) {
				foundStudents.add(student);
			}
		}

		return foundStudents;

	}

	public List<StudentReg> findByCourse(List<StudentReg> students, String course) {
		List<StudentReg> foundStudents = new ArrayList<>();

		for (StudentReg student : students) {
			for (String attendCourse : student.getAttend()) {
				if (attendCourse.contains(course)) {
					foundStudents.add(student);
				}
			}
		}

		return foundStudents;
	}

	public List<StudentReg> findByIdAndName(List<StudentReg> students, String id, String name) {
		List<StudentReg> foundStudents = new ArrayList<>();

		for (StudentReg student : students) {
			if (student.getStuId().contains(id) && student.getName().contains(name)) {
				foundStudents.add(student);
			}
		}

		return foundStudents;

	}

	public List<StudentReg> findByIdAndCourse(List<StudentReg> students, String id, String course) {
		List<StudentReg> foundStudents = new ArrayList<>();

		for (StudentReg student : students) {

			for (String attendCourse : student.getAttend()) {
				if (attendCourse.contains(course) && student.getStuId().contains(id)) {
					foundStudents.add(student);
				}
			}
		}

		return foundStudents;
	}

	public List<StudentReg> findByNameAndCourse(List<StudentReg> students, String name, String course) {
		List<StudentReg> foundStudents = new ArrayList<>();

		for (StudentReg student : students) {
			if (student.getName().contains(name) && student.getAttend().toString().contains(course)) {
				foundStudents.add(student);
			}
		}

		return foundStudents;
	}

	public List<StudentReg> findByIdAndNameAndCourse(List<StudentReg> students, String id, String name, String course) {
		List<StudentReg> foundStudents = new ArrayList<>();

		for (StudentReg student : students) {
			for (String attendCourse : student.getAttend()) {
				if (attendCourse.contains(course) && student.getStuId().contains(id)
						&& student.getName().contains(name)) {
					foundStudents.add(student);
				}
			}
		}

		return foundStudents;
	}

}