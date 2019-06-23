<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

    <head>
        <title>Home page</title>
    </head>

    <body>
        Language : <a href="?language=en">English</a> |  <a href="?language=pl">Polish</a></br>

        <h1><spring:message code="home.text" /></h1>
        <h3 style="color:blue; font-weight:bold"><spring:message code="selectAction.text"/></h3>
        <a href="/employeeSearchByName"><spring:message code="searchByName.text" /></a>
        <br/>
        <br/>
        <a href="/employeeSearch"><spring:message code="searchById.text" /></a>
        <br />
        <br />
        <a href="/salarySearch"><spring:message code="searchForSalary.text" /></a>
        <br />
        <br />
        <a href="/login"><spring:message code="goToLoginPage.text" /></a>
        <br />
        <br />
        <a href="/register"><spring:message code="goToRegisterPage.text" /></a>
        <br />
    </body>

</html>