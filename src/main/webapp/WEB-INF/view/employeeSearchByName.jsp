<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

    <head>
      <title>Employee Search By Name</title>
    </head>

    <body>
      <h2>Employee search:</h2>
 
<%--       <c:if test="${notFound == 'true'}"> --%>
<%--         Can't find employee for specified<c:out value = "${incorrectNo}"/><br/>     --%>
<!--         <br/> -->
<%--       </c:if> --%>

      <form:form method="post" action="/employeeSearchByName" modelAttribute="form">
        <span>Enter employee name:</span><br/>
        First name:
        <form:input path="firstName"></form:input>
        <br/>
        Last name:
        <form:input path="lastName"></form:input>
        <br/>
        <input type="submit" value="Search" />
        <br/>        
      </form:form>
      <br/>
      <a href="/employeeSearch">Search by ID instead.</a>
	<br/><br/>
	<a href="/home">HOME</a>


    </body>

    </html>