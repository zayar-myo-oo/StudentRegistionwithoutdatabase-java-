package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserBean;

/**
 * Servlet implementation class AddUserControllerServlet
 */
@WebServlet("/AddUserControllerServlet")
public class AddUserControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUserControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserBean user = new UserBean();
		user.setEmail( request.getParameter("email"));
		user.setPassword( request.getParameter("password"));
		user.setRole( request.getParameter("role"));
		user.setUserName( request.getParameter("name"));
			
			boolean isDuplicate = false;
			
		List<UserBean> users = (ArrayList<UserBean>) request.getServletContext().getAttribute("userApp");
				
				if( users != null ){
					for( UserBean usr : users )
					{
						if( usr.getEmail().equals(user.getEmail()) )
						{
							isDuplicate = true;
						}
					}
				}
				
				
				if(isDuplicate)
				{
					request.setAttribute( "user" ,  user );
					request.setAttribute( "error", "Duplicate Email!");
					
					request.getRequestDispatcher("USR001-01.jsp").forward( request , response );
				}
				else {
					
					int maxId = 0;
					
					for( int i = 0 ; i < users.size() ; i++ )
					{
						int cur = Integer.parseInt(users.get(i).getUserId().substring(3)) ;
						if( cur > maxId )
						{
							maxId = cur;
						}
					}
					
					int idNum = maxId + 1;
					
					String resultId = "USR";
					
					switch( String.valueOf(idNum).length() )
					{
					case 1 : 
						resultId += "00"+idNum;
						break;
					case 2 : 
						resultId += "0"+idNum;
						break;
					default : 
						resultId += idNum;
					}
					
					user.setUserId(resultId);
					users.add(user);
					request.getServletContext().setAttribute( "userApp" , users );
					request.getRequestDispatcher("USR001-01.jsp").forward( request , response );
				}
				
			}
			
				
		
	}
