<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="saveDetails" class="com.sample.jsp.DbConnection" ></jsp:useBean>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="../css/styles.css">
		<title>Jsp Demo</title>
	</head>
	<body>
		<!-- JSP scriplet  -->
		<% {  
				if(request.getParameter("firstName") != null) {
					String firstName = request.getParameter("firstName");
					String lastName = request.getParameter("lastName");
					System.out.println("scriplet "+firstName +" == "+lastName);
					saveDetails.saveUser(firstName, lastName);
				}
			}
		%>
		<form id="myForm" method="post"  >
			<p>
				Date: <%= (new java.util.Date()).toLocaleString() %>
			</p>
			
			First name: <input id="firstName" type="text" name="firstName"><br>
			Last name: <input id="lastName"  type="text" name="lastName"><br><br>
			<input type="Submit" value="Submit" > 
			
			<br>
			<br>
			<label>Existing Users</label>
			<%= saveDetails.readUsers() %>
		</form>
		
	</body>
</html>