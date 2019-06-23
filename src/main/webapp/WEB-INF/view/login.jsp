<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html xmlns="http://www.w3.org/1999/xhtml"	xmlns:th="http://www.thymeleaf.org"	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

    <head>
        <title>Login</title>
    </head>

    <body>
        Language : <a href="?language=en">English</a> |  <a href="?language=pl">Polish</a></br>

        <p style="font-size: 20px; color: blue; font-weight: bold"><spring:message code="login.text" /></p><br/>

        <c:if test="${registeredMessage == 'true'}"><spring:message code="registered.text" /><br /></c:if>
        <c:if test="${wrongLogin == 'true'}"><spring:message code="wrongLogin.text" /><a href="/register"><spring:message code="registerSmall.text" /></a><spring:message code="ifYouDidnt.text" /><br /></c:if>
        <c:if test="${wrongPassword == 'true'}"><spring:message code="wrongPassword.text" /><br /></c:if>

        <form:form method="post" action="/login" modelAttribute="login">
            <div>
                <form:label path="username"> <spring:message code="userName.text" /></form:label><br />
                <form:input name="username" path="username" id="username" /><br />
                <form:errors path="username" style="color: red" />
            </div>
            <div>
                <form:label path="password"> <spring:message code="password.text" /></form:label><br />
                <form:password name="password" path="password" id="password" /><br />
                <form:errors path="password" style="color: red" />
            </div>
            <div>
                <br /><input type="submit" value=<spring:message code="login.text" /> />
            </div>
        </form:form>
    </body>

</html>