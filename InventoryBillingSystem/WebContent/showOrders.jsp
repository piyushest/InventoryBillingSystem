<%@page import="apis.GetOrdersFromRetailers"%>
<%@page import="model.Orderdetail"%>
<%@page import="apis.GetRetailers,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Orders</title>
</head>
<body>
<form action="showOrders.jsp">

		<h1>Orders:</h1>

		<%
			String resellerId = request.getParameter("resellerId");
			String distributorId = request.getParameter("distributorId");
			String all = request.getParameter("all");
			
			GetOrdersFromRetailers apicalls = new GetOrdersFromRetailers();
			List<Orderdetail> orderDetail = new ArrayList<Orderdetail>();
			if(all.equalsIgnoreCase("false")){
			orderDetail = apicalls.getOrders(false,resellerId, distributorId);
			}
			else if(all.equalsIgnoreCase("true")){
				orderDetail = apicalls.getOrders(true,resellerId, distributorId);
			}
		%>
		<table>
			<tbody>
				<tr>
					<th>&nbsp;</th>
					<th>Order Id</th>
					<th>&nbsp;</th>
					<th>Name</th>
					<th>&nbsp;</th>
					<th>Total Price</th>
				</tr>
				<%
					for (Orderdetail order : orderDetail) {
				%>
				<tr>
					<th>&nbsp;</th>
					<td><%=order.getOrderId()%>
					<th>&nbsp;</th>
					<td><%=order.getName()%>
					<th>&nbsp;</th>
					<td><%=order.getTotalPrice()%>
				</tr>
				<%
			}
%>
			</tbody>
		</table>
	</form>
</body>
</html>