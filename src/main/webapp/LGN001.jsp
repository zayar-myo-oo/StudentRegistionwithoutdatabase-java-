<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.UserBean"%>
<%@page import="org.apache.catalina.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>
<%
UserBean userbean=new UserBean();
userbean.setEmail("zayar1832003@gmail.com");
userbean.setPassword("zayar");
userbean.setRole("1");
userbean.setUserId("USR001");
userbean.setUserName("zayar");
List<UserBean> userList=(ArrayList<UserBean>)request.getServletContext().getAttribute("userApp");
if(userList ==null){
	List<UserBean> list=new ArrayList<UserBean>();
	list.add(userbean);
	request.getServletContext().setAttribute("userApp", list);
}
%>
  <head>
    <link rel="stylesheet" href="test.css">
    <title> Student Registration LGN001 </title>
  </head>
  <body class="login-page-body">

    <div class="login-page">
      <div class="form">
        <div class="login">
          <div class="login-header">
            <h1>Welcome!</h1>   
            <p>${error}</p>
          </div>
        </div>
        <form class="login-form" action="LoginUserServlet" method="post" name="confirm">
          <input type="text" placeholder="User ID" value="USR001" name="lguserid"/>
          <input type="password" placeholder="Password" value="zayar" name="lgpassword"/>
          <button>login</button>
          <p class="message">Not registered? <a href="#">Create an account</a></p>
        </form>
      </div>
    </div>
  </body>

  </html>