<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
<title>Home page</title>
</head>
<body>

	<h1>HOME:</h1>
	<h3 style="color:blue; font-weight:bold">Select action:</h3>
	<a href="/employeeSearchByName">Search for employee by name</a>
	<br/>
	<br/>
	<a href="/employeeSearch">Search for employee by ID</a>
	<br />
	<br />
	<a href="/salarySearch">Search for salary of employee</a>
	<br />
	<br />
	<a href="/login">Go to login page</a>
	<br />
	<br />
	<a href="/register">Go to register page</a>
	<br />
	

</body>
</html>