<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html xmlns="http://www.w3.org/1999/xhtml"	xmlns:th="http://www.thymeleaf.org"	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

    <head>
        <title>Register</title>
    </head>

    <body>
      Language : <a href="?language=en">English</a> |  <a href="?language=pl">Polish</a></br>
        <p style="font-size:20px;color:blue;font-weight:bold"><spring:message code="registrationForm.text" /><br /><b /><b /></p>

        <form:form method="post" action="/register" modelAttribute="register">
            <div>
	            <form:label path="username"> <spring:message code="userName.text" /> </form:label><br />
	            <form:input name="username" path="username" id="username"/>
	            <form:errors path="username" style="color: red"/>
            </div>
            <div>
	            <form:label path="password"> <spring:message code="password.text" /> </form:label><br />
	            <form:password name="password" path="password" id="password"/>
	            <form:errors path="password" style="color: red"/>
            </div>
            <div>
	            <form:label path="passwordRepeated"> <spring:message code="repeatPassword.text" /> </form:label><br />
	            <form:password name="passwordRepeated" path="passwordRepeated" id="passwordRepeated"/>
	            <form:errors path="passwordRepeated" style="color: red"/>
            </div>
            <div><br /><input type="submit" value=<spring:message code="register.text" />></div>
        </form:form>
    </body>

</html>