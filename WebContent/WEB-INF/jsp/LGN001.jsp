<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<spring:url value="/resources/theme/css/test.css" var="testCss" />
<link href="${testCss}" rel="stylesheet">
<title>Student Registration LGN001</title>
</head>
<body class="login-page-body">

	<div class="login-page">
		<div class="form">
			<div class="login">
				<div class="login-header">
					<h1>Welcome!</h1>
				</div>
			</div>
			<div style="color: red;">${msg }</div>

			<form:form class="login-form" action="/StudentRegistrationCRUD/login" name="confirm"
				method="post" >
				<input type="text" placeholder="User Id" name="id" />
				<form:errors path="id" style="color: red;"></form:errors>

				<input type="password" placeholder="Password" name="password" />
				<form:errors path="password" style="color: red;"></form:errors>

				<input type="submit" value="Login">
				<p class="message">
					Not registered? <a href="USR001.jsp">Create an account</a>
				</p>
			</form:form>
		</div>
	</div>
</body>

</html>