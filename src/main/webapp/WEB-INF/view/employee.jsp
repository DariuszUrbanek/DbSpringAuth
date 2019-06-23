<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%   String number = request.getParameter( "empNo" );   session.setAttribute( "theName", number );%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

    <head>
        <title>Employee</title>
    </head>

    <body>

        <form:form method="post" action="/employee/${employee.empNo}" modelAttribute="employee">
            <h2>Employee details:</h2>
            <c:if test="${success == 'success'}"><h3 style="color:#32CD32; font-weight:bold">Employee ${employee.firstName} ${employee.lastName} saved successfully!</h3></c:if>
            <br/>
            <span>Employee number:</span><br/>
            <form:input path="empNo" readonly="true"></form:input>
            <br/>
            <span>First name:</span><br/>
            <form:input path="firstName"></form:input>
            <br/>
            <span>Last name:</span><br/>
            <form:input path="lastName"></form:input>
            <br/>
            <span>Birth date:</span><br/>
            <form:input path="birthDate"></form:input>
            <br/>
            <span>Hire date:</span><br/>
            <form:input path="hireDate"></form:input>
            <br/>
            <br/>
            <input type="submit" value="Save" />
            <br/>
            <br/>
            <a href="/salarySearch/${employee.empNo}">Go to salary search page.</a>
        </form:form>

    </body>

</html>