<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%
   String number = request.getParameter( "empNo" );
   session.setAttribute( "theName", number );
%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

      <head>
        <title>Hello World!</title>
      </head>

      <body>
        <form:form method="post" action="/employee/${employee.empNo}" modelAttribute="employee">
          <h2>Employee details:</h2>
          <br/>
          <p1>Employee number:</p1>
          <br/>
          <form:input path="empNo" readonly="true"></form:input>
          <br/>
          <p1>First name:</p1>
          <br/>
          <form:input path="firstName"></form:input>
          <br/>
          <p1>Last name:</p1>
          <br/>
          <form:input path="lastName"></form:input>
          <br/>
          <p1>Birth date:</p1>
          <br/>
          <form:input path="birthDate"></form:input>
          <br/>
          <p1>Hire date:</p1>
          <br/>
          <form:input path="hireDate"></form:input>
          <br/>
          <br/>
          <input type="submit" value="Save" />
          <br/>
          <a href="/salarySearch">Go to salary search page.</a>



        </form:form>
      </body>

      </html>