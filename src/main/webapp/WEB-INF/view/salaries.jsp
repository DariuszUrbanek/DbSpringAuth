<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html xmlns="http://www.w3.org/1999/xhtml"	xmlns:th="http://www.thymeleaf.org"	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

    <head>
        <title>Salaries</title>
    </head>

    <body>

        <h2>Salaries for employee:</h2>
        <table>
            <tr>
                <td>
                    <span>Employee number:</span>
                    <b>${employee.empNo}</b>,
                    <span>First name:</span>
                    <b>${employee.firstName}</b>,
                    <span>Surname:</span>
                    <b>${employee.lastName}</b>
                </td>
                <td>
                    <form:form method="get" action="/employee/${employee.empNo}">
                        <input type="submit" value="Employee details"/>
                    </form:form>
                </td>
            </tr>
        </table>
        <br/><br/>

        <table>
            <tr>
                <th>
                    <table><tr>
                    <td style="width:173px">From date:</td><td style="width:173px">To date:</td><td style="width:173px">Salary:</td>
                    </tr></table>
                </th>
            </tr>

            <c:forEach items="${salaries}" var="salary">

                <tr>
                    <td>
                        <form:form method="post" action="/salary" modelAttribute="${salary.fromDate}">

                            <table><tr>
                                <td style="width:173px"><form:input path="fromDate"></form:input></td>

                                <td style="width:173px"><form:input path="toDate"></form:input></td>

                                <td style="width:173px"><form:input path="salary"></form:input></td>

                                <form:hidden path="empNo" value="${salary.empNo}"/>

                                <td><input type="submit" value="Save" /></td>
                            </tr></table>
                        </form:form>
                    </td>
                    <td>
                        <form:form method="post" action="/deleteSalary/${salary.empNo}/${salary.fromDate}">
                            <input type="submit" value="Delete"/>
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </body>

</html>