<%@page import="java.util.ArrayList"%>
<%@page import="model.StudentReg"%>
<%@page import="controller.StuTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="test.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">



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
					<p>User:${sessionScope.userLName.userName}</p>
					<p>
						Current Date :
						<%=new StuTime().showLocalTime()%>
					</p>
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

			<button class="dropdown-btn">
				Class Management <i class="fa fa-caret-down"></i>
			</button>

			<div class="dropdown-container">
				<a href="BUD003.jsp">Course Registration </a> <a
					href="STU001.jsp?stuIdCount=STU001">Student Registration </a> <a
					href="STU003.jsp">Student Search </a>
			</div>
			<a href="USR003.jsp">Users Management</a>
		</div>
		<div class="main_contents">
			<div id="sub_content">
				<form action="StudentRegisterServlet" method="post">

					<h2 class="col-md-6 offset-md-2 mb-5 mt-4">Student
						Registration</h2>
					<div class="row mb-4">
						<div class="col-md-2"></div>
						<label for="studentID" class="col-md-2 col-form-label">Student
							ID</label>
						<div class="col-md-4">
						
						<%
						int maxId= 1;
		ArrayList<StudentReg> stuApp=(ArrayList<StudentReg>) request.getServletContext().getAttribute("stuApp");
					
						if(stuApp!=null){
							
							for(int i=0;i<stuApp.size();i++)
								//1
							{
								int cur = Integer.parseInt(stuApp.get(i).getStuId().substring(3));
								if( cur > maxId )
								{
									maxId = cur;
								}
							
							}
							
							maxId += 1;
							
							
						}
							String studentId = "STU";
							switch( String.valueOf(maxId).length() )
							{
							case 1 : 
								studentId += "00"+maxId;
								break;
							case 2 : 
								studentId += "0"+maxId;
								break;
							default : 
								studentId += maxId;
							}
							
							
							
						%>
						
						
						
							<input type="text" class="form-control"
								value="<%= studentId %>" id="studentID" name="stuId"
								readonly>
						</div>
					</div>
					<div class="row mb-4">
						<div class="col-md-2"></div>
						<label for="stuName" class="col-md-2 col-form-label">Name</label>
						<div class="col-md-4">
							<input type="text" class="form-control" id="stuName"
								value="" name="stuName">
						</div>
					</div>
					<div class="row mb-4">
						<div class="col-md-2"></div>
						<label for="stuDOB" class="col-md-2 col-form-label">DOB</label>
						<div class="col-md-4">
							<input type="date" class="form-control" id="stuDOB" name="stuDOB">
						</div>
					</div>
					<fieldset class="row mb-4">
						<div class="col-md-2"></div>
						<legend class="col-form-label col-md-2 pt-0">Gender</legend>
						<div class="col-md-4">
							<div class="form-check-inline">
								<input class="form-check-input" type="radio" id=stuGender
									name="stuGender" value="male" checked> <label
									class="form-check-label" for="stuGender"> Male </label>
							</div>
							<div class="form-check-inline">
								<input class="form-check-input" type="radio" id="stuGender"
									name="stuGender" value="female"> <label
									class="form-check-label" for="stuGender"> Female </label>
							</div>

						</div>
					</fieldset>

					<div class="row mb-4">
						<div class="col-md-2"></div>
						<label for="phone" class="col-md-2 col-form-label">Phone</label>
						<div class="col-md-4">
							<input type="text" class="form-control" id="stuPhone" value=""
								name="stuPhone">
						</div>
					</div>
					<div class="row mb-4">
						<div class="col-md-2"></div>
						<label for="stuEdu" class="col-md-2 col-form-label">Education</label>
						<div class="col-md-4">
							<select class="form-select" aria-label="Education" id="stuEdu"
								name="stuEdu">
								<option value="edu" selected disabled>SELECT your
									EDUCATION</option>
								<option value="1">Bachelor of Information Technology</option>
								<option value="2">Diploma in IT</option>
								<option value="3">Bachelor of Computer Science</option>

							</select>
						</div>
					</div>
					<fieldset class="row mb-4">
						<div class="col-md-2"></div>
						<legend class="col-form-label col-md-2 pt-0">Attend</legend>
						<div class="col-md-4">
						
						<c:forEach items="${applicationScope.course }" var="data">
						<div class="form-check-inline col-md-2">	
								
									<input class="form-check-input" type="checkbox"
										name="stuCourse" id="stuCourse" value="${data.getCourseName() }"> <label
										class="form-check-label" for="stuCourse">
										${data.getCourseName() } </label>
								

						</div>	
						</c:forEach>
						
						</div>
					</fieldset>
					

					<div class="row mb-4">
						<div class="col-md-4"></div>

						<div class="col-md-4">
							<button type="reset" class="btn btn-danger ">Reset</button>
							<button type="button"
								class="btn btn-secondary col-md-2 addsubmits"
								data-bs-toggle="modal" data-bs-target="#exampleModal">
								Add</button>
							<div class="modal fade" id="exampleModal" tabindex="-1"
								aria-labelledby="exampleModalLabel" aria-hidden="true">
								<div class="modal-dialog modal-dialog-centered">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLabel">Student
												Registration</h5>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Close"></button>
										</div>
										<div class="modal-body">
											<h5 style="color: rgb(127, 209, 131);"
												id="addusersuccessfuls">Registered Succesfully !</h5>
										</div>
										<div class="modal-footer">
											<button type="submit" class="btn btn-success col-md-2"
												id="okbtns" data-bs-dismiss="modal">Ok</button>

										</div>
									</div>
								</div>
							</div>
						</div>


					</div>





				</form>
			</div>
		</div>
	</div>
	<div id="testfooter">
		<span>Copyright &#169; ACE Inspiration 2022</span>
	</div>
	<script src="stuReg.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script>
		/* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
		var dropdown = document.getElementsByClassName("dropdown-btn");
		var i;

		for (i = 0; i < dropdown.length; i++) {
			dropdown[i].addEventListener("click", function() {
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