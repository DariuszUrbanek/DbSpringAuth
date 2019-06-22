<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
    <head>
        <title>Spring Logout</title>
    </head>
    <body>
    <c:out value="${user}"/>
    	<h1>logged out!</h1>		    
    </body>
</html>