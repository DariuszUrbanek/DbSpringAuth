<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html xmlns="http://www.w3.org/1999/xhtml"	xmlns:th="http://www.thymeleaf.org"	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

    <head>
        <title>Employees</title>
    </head>

    <body>

        <c:if test="${firstName == '*' && (lastName == '*' || lastName == null) }">
            <h2>List of first 100 employees:</h2><br/>
            </c:if>

            <c:if test="${firstName != '*' && (lastName == '*' || lastName == null)}">
                <h2>List of employees with first name: "${firstName}"</h2><br/>
            </c:if>

            <c:if test="${firstName == '*' && (lastName != '*' && lastName != null)}">
                <h2>List of employees with last name: "${lastName}"</h2><br/>
            </c:if>

            <c:if test="${firstName != '*' && (lastName != '*' && lastName != null)}">
                <h2>List of employees with first name "${firstName}" and last name
                "${lastName}" :</h2><br/>
            </c:if>


            <c:forEach items="${list}" var="employee">
                <table>
                    <tr>
                        <td>
                            <form:form style="display:inline" method="post" action="/employee" modelAttribute="${employee.empNo}">
                                ID: <a href="/employee/${employee.empNo}">${employee.empNo}</a>:
                                <form:hidden path="empNo" value="${employee.empNo}"/>
                                Birth date:
                                <form:input path="birthDate"/>
                                Hire date:
                                <form:input path="hireDate"/>
                                Name:
                                <form:input path="firstName"/>
                                Surname:
                                <form:input path="lastName"/>
                                <input type="submit" value="Save"/>
                            </form:form>
                        </td>
                        <td>
                            <form:form method="post" action="/deleteEmployee/${employee.empNo}">
                                <input type="submit" value="Delete"/>
                            </form:form>
                        </td>
                        <td>
                            <form:form method="get" action="/salaries/${employee.empNo}">
                                <input type="submit" value="Salaries"/>
                            </form:form>
                        </td>
                    </tr>
                </table>
            </c:forEach>

        </body>

</html>