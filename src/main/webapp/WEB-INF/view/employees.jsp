<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>
<title>Elvis list</title>
</head>

<body>

	<p>List of employees with first name "${firstName}" and last name
		"${lastName}" :</p>

	<c:forEach items="${list}" var="employee">
		ID: <a href="/employee/${employee.empNo}">${employee.empNo}</a>, Birth date: ${employee.birthDate}, Hire date: ${employee.hireDate}, 
		Name: ${employee.firstName}, Surname: ${employee.lastName} <br />
	</c:forEach>

</body>

</html>