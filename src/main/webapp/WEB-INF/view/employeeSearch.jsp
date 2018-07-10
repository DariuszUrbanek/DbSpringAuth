<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

    <head>
      <title>Spring Employee Search</title>
    </head>

    <body>
      <h2>Employee search:</h2>
      <br/>

      <c:if test="${notFound == 'true'}">
        Can't find employee for specified employee number: <c:out value = "${incorrectNo}"/><br/>     
        <br/>
      </c:if>

      <form:form method="post" action="/employeeSearch" modelAttribute="form">
        <p1>Enter employee number:</p1>
        <br/>
        <form:input path="empNo"></form:input>
        <form:errors path="empNo" style="color: red"/>
        <br/>
        <input type="submit" value="Search" />
      </form:form>


    </body>

    </html>