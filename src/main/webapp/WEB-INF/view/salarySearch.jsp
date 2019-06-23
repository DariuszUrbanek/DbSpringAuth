<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

    <head>
      <title>Salary Search</title>
    </head>

    <body>
      Language : <a href="?language=en">English</a> |  <a href="?language=pl">Polish</a></br>
      <h2><spring:message code="salarySearch.text" /></h2>
      <br/>

      <c:if test="${notFound == 'true'}">
        Can't find salary for specified "from date" for employee number: <c:out value = "${id}"/><br/>     
        <br/>
      </c:if>

      <form:form method="post" action="/salarySearch" modelAttribute="form">
        <span><spring:message code="enterEmployeeNumber.text"/></span><br/>
        <form:input path="empNo" value="${id}"></form:input>
        <br />
        <span><spring:message code="fromDate.text" /></span><br/>
        <form:input path="fromDate"></form:input>
        <br /><br />
        <input type="submit" value=<spring:message code="search.text" /> />
      </form:form>
      <br/>
	  <br/>
	  <a href="/home"><spring:message code="home.text" /></a>

    </body>
</html>