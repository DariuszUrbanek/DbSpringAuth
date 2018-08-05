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

	<span>List of employees with first name Elvis:</span>

	<c:forEach items="${elvisList}" var="elvis">
		${elvis.firstName} ${elvis.lastName} <br />
	</c:forEach>
	
</body>

</html>