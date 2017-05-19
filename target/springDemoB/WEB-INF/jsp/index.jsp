<%-- 
    Document   : index
    Created on : May 16, 2017, 10:37:07 AM
    Author     : zion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form:form method="POST" action="loginsubmit" modelAttribute="loginForm">
            <label for="username">User Name</label>
            <input type="text" id="username" name="username"/>
            </br>
            <label for="password">Password</label>
            <input type="password" id="password" name="password" />
             </br>
            <input type="submit" value="Login"  />
        </form:form>
    </body>
</html>
