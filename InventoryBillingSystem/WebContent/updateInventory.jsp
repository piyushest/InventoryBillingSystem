<%@page import="apis.InventoryOperations"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Inventory</title>
</head>
<body>
	<form action="updateInventory.jsp">

		<h1>Distributor Inventory</h1>

		<%
			String distributorId = request.getParameter("distributorId");
			if (distributorId == null) {
				distributorId = " ";
			}
			String productId = request.getParameter("productId");
			if (productId == null) {
				productId = " ";
			}

			String category = request.getParameter("category");
			if (category == null) {
				category = " ";
			}
			String description = request.getParameter("description");
			if (description == null) {
				description = " ";
			}
			String inventorycol = request.getParameter("inventorycol");
			if (inventorycol == null) {
				inventorycol = " ";
			}
			String name = request.getParameter("name");
			if (name == null) {
				name = " ";
			}
			String quantityAvailable = request
					.getParameter("quantityAvailable");
			if (quantityAvailable == null) {
				quantityAvailable = " ";
			}
			String rate = request.getParameter("rate");
			if (rate == null) {
				rate = " ";
			}
			String action = request.getParameter("action");
			if (action == null) {
				action = " ";
			}

			if ("update".equals(action)) {
				InventoryOperations operations = new InventoryOperations();
				operations.updateInventoryProduct(distributorId, productId,
						category, description, inventorycol, name,
						quantityAvailable, rate);
				response.sendRedirect("seeInventory.jsp?distributorId="+distributorId);
			}
		%>
		<table class="table">
			<thead>
				<tr>

					<th>category</th>
					<th>description</th>
					<th>inventorycol</th>
					<th>name</th>
					<th>quantityAvailable</th>
					<th>rate</th>
					<th>&nbsp;</th>
				</tr>
				<tr>
					<th><input name="category" value="<%=category%>"
						class="form-control" /></th>

					<th><input name="description" value="<%=description%>"
						class="form-control" /></th>

					<th><input name="inventorycol" value="<%=inventorycol%>"
						class="form-control" /></th>
					<th><input name="name" value="<%=name%>" class="form-control" /></th>
					<th><input name="quantityAvailable"
						value="<%=quantityAvailable%>" class="form-control" /></th>
					<th><input name="rate" value="<%=rate%>" class="form-control" /></th>
					<th><input type="hidden" name="distributorId"
						value="<%=distributorId%>" class="form-control" /></th>
					<th><input type="hidden" name="productId"
						value="<%=productId%>" class="form-control" /></th>
					<th><button class="btn btn-default" name="action"
							value="update">Update</button></th>
				</tr>
			</thead>
		</table>
	</form>
</body>
</html>