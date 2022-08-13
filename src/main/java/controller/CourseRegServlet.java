package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CourseReg;
import model.UserBean;

/**
 * Servlet implementation class CourseRegServlet
 */
@WebServlet("/CourseRegServlet")
public class CourseRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseRegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String courseId=request.getParameter("courseId");
				String courseName=request.getParameter("courseName");
		CourseReg course=new CourseReg();
		course.setCourseId(courseId);
		course.setCourseName(courseName);
		ArrayList<CourseReg> courseList=(ArrayList<CourseReg>) request.getServletContext().getAttribute("course");
		if(courseList ==null) {
			courseList=new ArrayList<CourseReg>();
			courseList.add(course);
			request.getServletContext().setAttribute("course", courseList);
			request.getRequestDispatcher("BUD003.jsp").include(request, response);
		}else {
			for(CourseReg culist:courseList) {
				if(culist.getCourseName().equals(courseName)) {
					request.setAttribute("errorCu", "Duplicate Course Name");
					request.setAttribute("CourseName", courseName);
					request.setAttribute("CourseId", courseId);
					request.getRequestDispatcher("BUD003.jsp").include(request, response);
				}else {
					
					courseList.add(course);
					request.getServletContext().setAttribute("course", courseList);
					request.getRequestDispatcher("BUD003.jsp").include(request, response);
				}
			}
		}
		
		
	}

}
