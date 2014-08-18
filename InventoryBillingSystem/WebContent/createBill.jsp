<%@page import="apis.CreateBillToReseller"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Billing</title>
</head>
<body>
<form action="createBill.jsp" method="get">
		<div class="container">
			<%
			   String distributorId = request.getParameter("distributorId");
			   if(distributorId == null)
				   distributorId = "";
			
			   String resellerId = request.getParameter("resellerId");
			   if(resellerId == null)
				   resellerId = "";
			   
			   String name = request.getParameter("name");
				if (name == null)
					name = "";
				
				String totalPrice = request.getParameter("totalPrice");
				if (totalPrice == null)
					totalPrice = "";
				
				String action = request.getParameter("action");
               if ("add".equals(action)) {
					CreateBillToReseller createBill = new CreateBillToReseller();
					createBill.createBillsForOrders(resellerId,distributorId,
							 name, totalPrice);
					response.sendRedirect("distributorMenu.jsp?id="+distributorId);
					
				}
			%>

			Welcome
			<table class="table">
				<thead>
					<tr>
						
						<th>Reseller Id</th>
						<th>Name</th>
						<th>Total Price</th>
						
					</tr>
					<tr>

						<th><input name="resellerId" value="<%=resellerId%>" class="form-control" /></th>
						<th><input name="name" value="<%=name%>"
							class="form-control" /></th>
						<th><input name="totalPrice" value="<%=totalPrice%>"
							class="form-control" /></th>
						<th><input name="distributorId" type = "hidden" value="<%=distributorId%>"
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