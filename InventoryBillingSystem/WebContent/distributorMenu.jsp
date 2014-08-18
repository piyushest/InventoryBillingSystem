<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.css" rel="stylesheet" />
<title>Welcome</title>
</head>
<body>
	<form action="distributorMenu.jsp" method="get">
		<div class="container">
			<%
				String id = request.getParameter("id");
				if (id == null) {
					id = "";
				}
				String action = request.getParameter("action");
				if ("getRetailersInArea".equals(action)) {
					String redirectURL = "getResellersForDistributor.jsp?id=" + id;
					response.sendRedirect(redirectURL);
				} else if ("getAllOrders".equals(action)) {
					String redirectURL = "showOrders.jsp?distributorId="+id+"&all=true&resellerId=0";
					response.sendRedirect(redirectURL);
				} else if ("createBillForRetailer".equals(action)) {
					String redirectURL = "createBill.jsp?distributorId="+id;
					response.sendRedirect(redirectURL);
				} else if ("updateBillForRetailer".equals(action)) {
					String redirectURL = "showDistributorsByZipCode.jsp?unpaid=true";
					response.sendRedirect(redirectURL);
				} else if ("checkInventory".equals(action)) {
					String redirectURL = "seeInventory.jsp?distributorId="+id;
					response.sendRedirect(redirectURL);
				} else if ("addInventory".equals(action)) {
					String redirectURL = "addInventory.jsp?distributorId="+id;
					response.sendRedirect(redirectURL);
				}
			%>

			Menu Options
			<table class="table">
				<thead>

					<tr>
						<th><input name="id" type="hidden" value="<%=id%>"
							class="form-control" /></th>
						<th><button class="btn btn-default" name="action"
								value="getRetailersInArea">Get Resellers</button></th>
						<th><button class="btn btn-default" name="action"
								value="getAllOrders">All Orders</button></th>
						<th><button class="btn btn-default" name="action"
								value="createBillForRetailer">Create Bill</button></th>
						<th><button class="btn btn-default" name="action"
								value="updateBillForRetailer">Update Bill</button></th>
						<th><button class="btn btn-default" name="action"
								value="checkInventory">Check Inventory</button></th>
						<th><button class="btn btn-default" name="action"
								value="addInventory">Add Inventory</button></th>
					</tr>
				</thead>
			</table>

		</div>
	</form>
</body>
</html>