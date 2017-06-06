<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.yibai.springmvc.Goods"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC表单处理(多项)</title>
</head>
<body>
	<h2>商品列表 -</h2>

	<table border="1">
	<%
		ArrayList<Goods> goodsLst = (ArrayList<Goods>) request.getAttribute("data");
		for (Goods goods : goodsLst) {
			out.println("<tr><td>" + goods.toString() + "</td></tr>");
			int goodsId = 123;
			out.println("<button onCLick=\"location.href='/HelloSprintMVC/addCart?goodsId="+
			goods.getGoodsId()  +
			"'\">加入购物车</button>");
			/* out.println("<button type="+
			
			+">添加</button>"); */
		}
	%>
	</table>
</body>
</html>