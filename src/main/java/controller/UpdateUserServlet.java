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

import model.UserBean;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
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
		String userid=request.getParameter("upid");
			UserBean user=new UserBean();
			user.setEmail(request.getParameter("upemail"));
			user.setUserName(request.getParameter("upname"));
			user.setUserId(request.getParameter("upid"));
			user.setPassword(request.getParameter("uppassword"));
			user.setRole(request.getParameter("uprole"));
			List<UserBean> list=(List<UserBean>) request.getServletContext().getAttribute("userApp");
			Iterator<UserBean> itr = list.iterator();
			while (itr.hasNext()) {
				if (itr.next().getUserId().equals(user.getUserId())) {
					System.out.println(user.getUserId());
					System.out.println("removed");
					itr.remove();
					
				}
				list.add(user);
				request.getServletContext().setAttribute("userApp", list);
				request.getRequestDispatcher("USR003.jsp").forward(request, response);
				

			}
			}

}
