<%@page import="apis.InventoryOperations"%>
<%@page import="Dao.InventoryDao"%>
<%@page import="model.Inventory,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inventory</title>
</head>
<body>
	<form action="seeInventory.jsp">

		<h1>Distributor Inventory</h1>

		<%
			String distributorId = request.getParameter("distributorId");
			String productId = request.getParameter("productId");

			String category = request.getParameter("category");
			String description = request.getParameter("description");
			String inventorycol = request.getParameter("inventorycol");
			String name = request.getParameter("name");
			String quantityAvailable = request
					.getParameter("quantityAvailable");
			String rate = request.getParameter("rate");

			String action = request.getParameter("action");
			if (action == null) {
				action = " ";
			}

			InventoryOperations inventory = new InventoryOperations();
			List<Inventory> fullInventory = inventory
					.getFullInventoryForDistributor(distributorId);
		%>
		<table>
			<tbody>
				<tr>
					<th>&nbsp;</th>
					<th>DistributorId</th>
					<th>&nbsp;</th>
					<th>productId</th>
					<th>&nbsp;</th>
					<th>category</th>
					<th>&nbsp;</th>
					<th>description</th>
					<th>&nbsp;</th>
					<th>inventorycol</th>
					<th>&nbsp;</th>
					<th>name</th>
					<th>&nbsp;</th>
					<th>quantityAvailable</th>
					<th>&nbsp;</th>
					<th>rate</th>
				</tr>
				<%
					for (Inventory store : fullInventory) {
				%>
				<tr>
					<th>&nbsp;</th>
					<td><%=store.getId().getDistributorId()%>
					<th>&nbsp;</th>
					<td><%=store.getId().getProductId()%>
					<th>&nbsp;</th>
					<td><%=store.getCategory()%>
					<th>&nbsp;</th>
					<td><%=store.getDescription()%>
					<th>&nbsp;</th>
					<td><%=store.getInventorycol()%>
					<th>&nbsp;</th>
					<td><%=store.getName()%>
					<th>&nbsp;</th>
					<td><%=store.getQuantityAvailable()%>
					<th>&nbsp;</th>
					<td><%=store.getRate()%>
					<a href="updateInventory.jsp?distributorId=<%= store.getId().getDistributorId() %>&productId=<%= store.getId().getProductId() %>
					&category=<%= store.getCategory() %>&description=<%= store.getDescription()%>&inventorycol=<%=store.getInventorycol()%>&name=<%= store.getName()%>&quantityAvailable=<%=store.getQuantityAvailable()%>&rate=<%=store.getRate()%>">Update</a>
				</tr>
				<%
			}
%>
			</tbody>
		</table>
	</form>
</body>
</html>