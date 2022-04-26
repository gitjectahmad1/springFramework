<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>Luv2Code Company Home Page</title>
</head>

<body>
	<h2>luv2Code Company Home Page</h2>
	<hr>
	<p>
	Welcome to the luv2code Company home page!
	</p>
	
	<hr>
	
	<!-- display user name and role  -->
	<p>
		User: <security:authentication property="principal.username" />
		<br><br>
		Role(s): <security:authentication property="principal.authorities" />
	</p>
	
	<security:authorize access="hasRole('MANAGER')"> 
	<!-- Add a link to /leaders ... this is for the managers -->
	
		<P>
			<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
			(only for Manager peeps)
		</P>
	
	</security:authorize>
	
	
	<security:authorize access="hasRole('ADMIN')"> 
	<!-- Add a link to point to /systems ... this is only for the admins -->
		<P>
			<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
			(only for Admin peeps)
		</P>
	
	</security:authorize>
	<hr>
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath }/logout"
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
	
	
</body>

</html>