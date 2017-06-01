<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC表单处理</title>
</head>
<body>


<form:form method="POST" action="/HelloSprintMVC/userRegister">
   <table>
    <tr>
        <td><form:label path="name">用户名：</form:label></td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td><form:label path="password">密码：</form:label></td>
        <td><form:input path="password" /></td>
    </tr>
   
    <tr>
        <td colspan="2">
            <input type="submit" value="注册"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>