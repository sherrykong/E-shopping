<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC表单处理</title>
</head>
<body>

<h2>提交的内容发布如下 - </h2>
   <table>
    <tr>
        <td>标题：</td>
        <td>${title}</td>
    </tr>
    <tr>
        <td>摘要：</td>
        <td>${summary}</td>
    </tr>
    <tr>
        <td>图片：</td>
        <td>${picture}</td>
    </tr>
     <tr>
        <td>正文：</td>
        <td>${context}</td>
    </tr>
     <tr>
        <td>价格：</td>
        <td>${price}</td>
    </tr>
     
</table>  
</body>
</html>