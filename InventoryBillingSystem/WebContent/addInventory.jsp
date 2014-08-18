<%@page import="apis.InventoryOperations"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add To Inventory</title>
</head>
<body>
<form action="addInventory.jsp" method="get">
		<div class="container">
			<%
				String distributorId = request.getParameter("distributorId");
				if (distributorId == null)
					distributorId = "";
				String productId = request.getParameter("productId");
				if (productId == null)
					productId = "";
				String category = request.getParameter("category");
				if (category == null)
					category = "";
				String description = request.getParameter("description");
				if (description == null)
					description = "";
				String inventorycol = request.getParameter("inventorycol");
				if (inventorycol == null)
					inventorycol = "";
				String name = request.getParameter("name");
				if (name == null)
					name = "";
				String quantityAvailable = request.getParameter("quantityAvailable");
				if (quantityAvailable == null)
					quantityAvailable = "";
				String rate = request.getParameter("rate");
				if (rate == null)
					rate = "";
				String action = request.getParameter("action");
				

				if ("add".equals(action)) {
					InventoryOperations operations = new InventoryOperations();
					operations.addProductsInInventory(distributorId, productId, category, description, inventorycol, name, quantityAvailable, rate);
				    response.sendRedirect("seeInventory.jsp?distributorId="+distributorId);
				}
			%>

			Welcome
			<table class="table">
				<thead>
					<tr>

						<th>productId</th>
						<th>category</th>
						<th>description</th>
						<th>inventorycol</th>
						<th>name</th>
						<th>quantityAvailable</th>
						<th>rate</th>
						<th>&nbsp;</th>
					</tr>
					<tr>

						<th><input name="productId" value="<%=productId%>" class="form-control" /></th>
						<th><input name="category" value="<%=category%>"
							class="form-control" /></th>
						<th><input name="description" value="<%=description%>"
							class="form-control" /></th>
						<th><input name="inventorycol" value="<%=inventorycol%>"
							class="form-control" /></th>
							<th><input name="name" value="<%=name%>"
							class="form-control" /></th>
						<th><input name="quantityAvailable"
							value="<%=quantityAvailable%>" class="form-control" /></th>
						<th><input name="rate" value="<%=rate%>"
							class="form-control" /></th>
							<th><input name="distributorId" type="hidden" value="<%=distributorId%>"
							class="form-control" /></th>
						<th><button class="btn btn-default" name="action" value="add">Add</button>
						</th>
					</tr>
				</thead>
			</table>

		</div>
	</form>

</body>
</html>