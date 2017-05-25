<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>卖家你好</title>
</head>
<body>

<h2>内容发布</h2>
<form:form method="POST" action="/HelloSprintMVC/addSellerPublish">
   <table>
    <tr>
        <td><form:label path="title">标题：</form:label></td>
        <td><form:input path="title" /></td>
    </tr>
    <tr>
        <td><form:label path="summary">摘要：</form:label></td>
        <td><form:input path="summary" /></td>
    </tr>
    <tr>
        <td><form:label path="picture">图片：</form:label></td>
        <td><form:input path="picture" /></td>
    </tr>
    <tr>
        <td><form:label path="context">正文：</form:label></td>
        <td><form:input path="context" /></td>
    </tr>
    <tr>
        <td><form:label path="price">价格：</form:label></td>
        <td><form:input path="price" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="提交表单"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>