<%@page import="model.Adminretailerregistration"%>
<%@page import="apis.GetRetailers,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retailers;</title>
</head>
<body>
	<form action="getResellerForDistributor.jsp">

		<h1>Retailers:</h1>

		<%
			String id = request.getParameter("id");
			if (id == null) {
				id = " ";
			}
			GetRetailers apiCall = new GetRetailers();
			List<Adminretailerregistration> retailers = apiCall
					.getRetailerByDistributorId(id);
		%>
		<table>
			<tbody>
				<tr>
					<th>&nbsp;</th>
					<th>ResellerId</th>
					<th>&nbsp;</th>
					<th>Name</th>
					<th>&nbsp;</th>
					<th>Area</th>
					<th>&nbsp;</th>
					<th>Fees Status</th>
					<th>&nbsp;</th>
					<th>Fees</th>
					<th>&nbsp;</th>
					<th>Zip Code</th>
					<th>&nbsp;</th>
					<th>Joining Date</th>
				</tr>
				<%
					for (Adminretailerregistration retailer : retailers) {
				%>
				<tr>
					<th>&nbsp;</th>
					<td><%=retailer.getResellerId()%>
					<th>&nbsp;</th>
					<td><%=retailer.getName()%>
					<th>&nbsp;</th>
					<td><%=retailer.getArea()%>
					<th>&nbsp;</th>
					<td><%=retailer.getStatusoffees()%>
					<th>&nbsp;</th>
					<td><%=retailer.getSubscriptionFees()%>
					<th>&nbsp;</th>
					<td><%=retailer.getZipCode()%>
					<th>&nbsp;</th>
					<td><%=retailer.getMemberSince()%>
					<th>&nbsp;</th>
					<th><input name="id" type="hidden" value="<%=id%>" class="form-control" /></th>
					<th><a href="showOrders.jsp?distributorId=<%= id %>&resellerId=<%= retailer.getResellerId() %>&all=false">showOrders</a></th>
				</tr>
				<%
			}
%>
			</tbody>
		</table>
	</form>

</body>
</html>