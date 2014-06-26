<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Spring Mvc Architecture</title>
</head>
<body>
	<h1>Spring Mvc Architecture</h1>
	<P>The time on the server is ${serverTime}.</P>

	<form method="post" action="details">
		First name: <input id="firstName" type="text" name="firstName"><br>
		Last name: <input id="lastName" type="text" name="lastName"><br>
		<br> <input type="Submit" value="Submit"> <br> <br>
	</form>
</body>
</html>
