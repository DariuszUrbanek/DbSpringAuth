<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

    <head>
      <title>Salary Search</title>
    </head>

    <body>
      <h2>Salary search:</h2>
      <br/>

      <c:if test="${notFound == 'true'}">
        Can't find salary for specified "from date" for employee number: <c:out value = "${id}"/><br/>     
        <br/>
      </c:if>ó

      <form:form method="post" action="/salarySearch" modelAttribute="form">
        <span>Enter employee number:</span><br/>
        <form:input path="empNo" value="${id}"></form:input>
        <br/>
        <span>From date:</span><br/>
        <form:input path="fromDate"></form:input>
        <br/>        
        <input type="submit" value="Search" />
      </form:form>
      <br/>
	  <br/>
	  <a href="/home">HOME</a>

    </body>

    </html>