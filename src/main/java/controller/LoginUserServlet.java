package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserBean;

/**
 * Servlet implementation class LoginUserServlet
 */
@WebServlet("/LoginUserServlet")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUserServlet() {
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
		
		UserBean user=new UserBean();
		user.setUserId(request.getParameter("lguserid"));
		user.setPassword(request.getParameter("lgpassword"));
		
		if(user.getUserId().equals("") || user.getPassword().equals("")) {
			request.setAttribute("user", user);
			request.setAttribute("error","Please check your data again");
			request.getRequestDispatcher("LGN001.jsp").forward(request, response);
		}else {
			List<UserBean> users=(ArrayList<UserBean>) request.getServletContext().getAttribute("userApp");
			
			for(UserBean usr:users) {
				System.out.println(usr.getPassword()+user.getPassword());
				if(usr.getUserId().equals(user.getUserId()) && usr.getPassword().equals(user.getPassword())) {
					user=usr;
					request.setAttribute("welcome","Welcome Back...");
					request.getSession().setAttribute("userLName", user);

					request.getRequestDispatcher("MNU001.jsp").forward( request , response );					
				}
				
			}
			
				request.setAttribute( "error" , "Please check your data again." );
				request.setAttribute( "user", user );
				request.getRequestDispatcher("LGN001.jsp").forward( request , response );		
			
		}
		}
	}	
		
		
