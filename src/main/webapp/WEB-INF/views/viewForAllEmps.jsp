<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Professional
  Date: 20.07.2024
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Information for all employees</h3>
    <br><br>

    <security:authorize access="hasRole('HR')">
        <input type="button" value="salary"
               onclick="window.location.href = 'hr_info'">
        Only for HR staff
    </security:authorize>
    <br><br>

    <security:authorize access="hasRole('MANAGER')">
        <input type="button" value="performance"
               onclick="window.location.href = 'manager_info'">
        Only for HR managers
    </security:authorize>

</body>
</html>
