package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentReg;
import model.UserBean;

/**
 * Servlet implementation class UpdateStuServlet
 */
@WebServlet("/UpdateStuServlet")
public class UpdateStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStuServlet() {
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
		StudentReg stu=new StudentReg();
		stu.setStuId(request.getParameter("upid"));
		stu.setName(request.getParameter("upname"));
		stu.setPhnumber(request.getParameter("upphone"));
		stu.setDob(request.getParameter("updob"));
		stu.setEducation(request.getParameter("upselect"));
		stu.setAttend(request.getParameterValues("upCourse"));
		List<StudentReg> list=(ArrayList<StudentReg>) request.getServletContext().getAttribute("stuApp");
		Iterator<StudentReg> itr = list.iterator();
		while (itr.hasNext()) {
			if (itr.next().getStuId().equals(stu.getStuId())) {				
				System.out.println("removed");
				itr.remove();	
			}
			
			list.add(stu);
			request.getServletContext().setAttribute("stuApp", list);
			request.getRequestDispatcher("STU003.jsp").forward(request, response);

		}
		}

}