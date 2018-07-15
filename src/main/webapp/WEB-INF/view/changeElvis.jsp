<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>
<title>Change Elvis</title>
</head>

<body>

	<p>Change Elvis to Elvis2 and Elvis2 to Elvis</p>

	<form:form method="post" action="/elvis/change">
		<input type="submit" value="Change" />
	</form:form>

</body>

</html>