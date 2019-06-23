<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html xmlns="http://www.w3.org/1999/xhtml"	xmlns:th="http://www.thymeleaf.org"	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

    <head>
        <title>Employee Search</title>
    </head>

    <body>
        Language : <a href="?language=en">English</a> |  <a href="?language=pl">Polish</a></br>
        <h2><spring:message code="employeeSearch.title.text" /></h2>

        <c:if test="${notFound == 'true'}">
            Can't find employee for specified employee number: <c:out value="${incorrectNo}" /><br /><b />
        </c:if>

        <form:form method="post" action="/employeeSearch" modelAttribute="form">
            <span><spring:message code="enterEmployeeNumber.text" /></span><br/>
            <form:input path="empNo"></form:input>
            <form:errors path="empNo" style="color: red" /><br /><br/>
            <input type="submit" value=<spring:message code="submit.text" /> />
        </form:form>
        <br/>
        <a href="/employeeSearchByName"><spring:message code="searchByNameInstead.text"/></a>
        <br/><br/>
        <a href="/home"><spring:message code="home.text" /></a>
    </body>

</html>