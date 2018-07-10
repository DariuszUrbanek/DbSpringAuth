<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

  <head>
    <title>Spring Salary</title>
  </head>

  <body>
    <form:form method="post" action="/salary/${salary.empNo}/${salary.fromDate}" modelAttribute="salary" >
      <h2>Employee details:</h2>
      <p1>Employee number:</p1><br/>
      <form:input path="empNo" readonly = "true"></form:input><br/>
      <p1>From date:</p1><br/>
      <form:input path="fromDate" readonly="true"></form:input><br/>
      <p1>To date:</p1><br/>
      <form:input path="toDate"></form:input><br/>
      <p1>Salary:</p1><br/>
      <form:input path="salary"></form:input><br/>
      <input type="submit" value="Save" />
      



    </form:form>
  </body>

  </html>