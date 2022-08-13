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

/**
 * Servlet implementation class StudentRegisterServlet
 */
@WebServlet("/StudentRegisterServlet")
public class StudentRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegisterServlet() {
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
		 String stuName = request.getParameter("stuName");
		  String stuDOB = request.getParameter("stuDOB");
		  String stuGender = request.getParameter("stuGender");
		  String stuPhone = request.getParameter("stuPhone");
		    String stuEdu = request.getParameter("stuEdu");
		    String[] stuCourse = request.getParameterValues("stuCourse");
		   String stuId = request.getParameter("stuId"); 
		   
		   StudentReg stuReg=new StudentReg();
		   stuReg.setName(stuName);
		   stuReg.setDob(stuDOB);
		   stuReg.setGender(stuGender);
		   stuReg.setPhnumber(stuPhone);
		   stuReg.setEducation(stuEdu);
		   stuReg.setAttend(stuCourse);
		   stuReg.setStuId(stuId);
		   
		   List<StudentReg> stu=(ArrayList<StudentReg>) request.getServletContext().getAttribute("stuApp");
		   if(stu!=null) {
			   stu.add(stuReg);
			   request.getServletContext().setAttribute("stuApp", stu);
			   request.getRequestDispatcher("STU001.jsp").include(request, response);
		   }else {
			   ArrayList<StudentReg> stuApp=new ArrayList<StudentReg>();
			   stuApp.add(stuReg);
			   request.getServletContext().setAttribute("stuApp", stuApp);
			   request.getRequestDispatcher("STU001.jsp").include(request, response);
		   }
		   
		   
		   
		   
		   

	}

}
