<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

    <head>
        <title>Employee Search By Name</title>
    </head>

    <body>
        Language : <a href="?language=en">English</a> |  <a href="?language=pl">Polish</a></br>

          <h2><spring:message code="employeeSearch.text" /></h2>

    <%--       <c:if test="${notFound == 'true'}"> --%>
    <%--         Can't find employee for specified<c:out value = "${incorrectNo}"/><br/>     --%>
    <!--         <br/> -->
    <%--       </c:if> --%>

          <form:form method="post" action="/employeeSearchByName" modelAttribute="form">
            <span><spring:message code="enterEmployeeName.text" /></span><br/>
            <spring:message code="firstName.text" />
            <form:input path="firstName"></form:input>
            <br/>
            <spring:message code="lastName.text" />
            <form:input path="lastName"></form:input>
            <br/>
            <input type="submit" value="Search" />
            <br/>
          </form:form>
          <br/>
          <a href="/employeeSearch"><spring:message code="searchByIdInstead.text" /></a>
        <br/><br/>
        <a href="/home"><spring:message code="home.text" /></a>
    </body>

 </html>