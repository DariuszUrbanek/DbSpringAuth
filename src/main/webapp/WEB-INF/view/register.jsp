<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Spring Security Register</title>
    </head>
    <body>
        <p style="font-size:20px;color:blue;font-weight:bold">Registration form:</p>
        <br/>
        <br/>

        <form:form method="post" action="/register" modelAttribute="register">
            <div>
	            <form:label path="username"> User Name : </form:label>
	            <form:input name="username" path="username" id="username"/>
	            <form:errors path="username" style="color: red"/>
            </div>
            <div>
	            <form:label path="password"> Password: </form:label>
	            <form:password name="password" path="password" id="password"/>
	            <form:errors path="password" style="color: red"/>
            </div>
            <div>
	            <form:label path="passwordRepeated"> Repeat password: </form:label>
	            <form:password name="passwordRepeated" path="passwordRepeated" id="passwordRepeated"/>
	            <form:errors path="passwordRepeated" style="color: red"/>
            </div>
            <div><input type="submit" value="Register"/></div>
        </form:form>
    </body>
</html>