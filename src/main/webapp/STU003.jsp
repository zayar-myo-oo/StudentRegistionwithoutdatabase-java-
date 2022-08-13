<%@page import="controller.StuTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="test.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">



    <title>Course Registration</title>
  </head>

  <body>
    <div id="testheader">
      <div class="container">
        <div class=row>
          <div class="col-md-5 ">
            <a href="MNU001.jsp">
              <h3>Student Registration</h3>
            </a>
          </div>
                                  <div class="col-md-6">
                        <p>User:${sessionScope.userLName.userName } </p>
                        <p>Current Date : <%=new StuTime().showLocalTime() %> </p>
                    </div>
          <div class="col-md-1">
               <input type="button" class="btn-basic" id="lgnout-button" value="Log Out"
              onclick="location.href='LogoutServlet'">
          </div>
        </div>
      </div>

    </div>
    <!-- <div id="testsidebar">Hello World </div> -->
    <div class="container">
      <div class="sidenav">

        <button class="dropdown-btn"> Class Management <i class="fa fa-caret-down"></i></button>

        <div class="dropdown-container">
          <a href="BUD003.jsp">Course Registration </a>
     <a href="STU001.jsp">Student Registration </a>
          <a href="STU003.jsp">Student Search </a>
        </div>        <a href="USR003.jsp">Users Management</a>
      </div>
      <div class="main_contents">
        <div id="sub_content">
          <form class="row g-3 mt-3 ms-2" action="StudentSearchServlet" method="get">
            <div class="col-auto">
              <label for="searchId" class="visually-hidden">studentID</label>
              <input type="text" class="form-control" id="searchId" placeholder="Student ID" name="id">
            </div>
            <div class="col-auto">
              <label for="searchName" class="visually-hidden">studentName</label>
              <input type="text" class="form-control" id="searchName" placeholder="Student Name" name="name">
            </div>
            <div class="col-auto">
              <label for="searchCourse" class="visually-hidden">Course</label>
              <input type="text" class="form-control" id="searchCourse" placeholder="Course" name="course">
            </div>
            <div class="col-auto">
              <button type="submit" class="btn btn-success mb-3" id="searchs">Search</button>
            </div>
            <div class="col-auto">
              <button type="reset" class="btn btn-secondary mb-3">Reset</button>
            </div>
          </form>
          <div>
            <table class="table table-striped" id="stduentTable">
              <thead>
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">Student ID</th>
                  <th scope="col">Name</th>
                  <th scope="col">Course Name</th>
                  <th scope="col">Details</th>
                </tr>
              </thead>
              <tbody>
              <%
              	int no = 1;
              %>
                   <c:forEach items="${stuApp }" var="s">
                            <tr>
                  
                  <th scope="row"><%=no %></th>
                  <td>${s.getStuId()}</td>
                  <td>${s.getName() }</td>
                  
                  <td>
                  <c:forEach var="att" items="${s.getAttend()}" >
                  ${att}
                  </c:forEach>
                  </td>
                  <% no++; %>                      
                  <td>
                    <button type="button" class="btn btn-success"
						onclick="location.href = 'STU002.jsp?id=${s.getStuId()}&name=${s.getName()}&dob=${s.getDob()}&phone=${s.getPhnumber()}'"
						>See More</button>
                    <!-- <a href="STU002.jsp" class="text-decoration-none">See more</a> -->
                  </td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
    <div id="testfooter">
      <span>Copyright &#169; ACE Inspiration 2022</span>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="searchStu.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"></script>
    <script>
      /* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
      var dropdown = document.getElementsByClassName("dropdown-btn");
      var i;

      for (i = 0; i < dropdown.length; i++) {
        dropdown[i].addEventListener("click", function () {
          this.classList.toggle("active");
          var dropdownContent = this.nextElementSibling;
          if (dropdownContent.style.display === "block") {
            dropdownContent.style.display = "none";
          } else {
            dropdownContent.style.display = "block";
          }
        });
      }
    </script>
  </body>

  </html>