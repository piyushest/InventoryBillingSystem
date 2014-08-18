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
	<form action="adminPage.jsp" method="get">
		<div class="container">
			<%
				String action = request.getParameter("action");

				if ("addDistributor".equals(action)) {
					String redirectURL = "addDistributor.jsp";
					response.sendRedirect(redirectURL);
					}
				if ("addRetailer".equals(action)) {
					String redirectURL = "addRetailer.jsp";
					response.sendRedirect(redirectURL);
					}
				if ("showRetailersByZip".equals(action)) {
					String redirectURL = "enterZipCode.jsp?param=retailer";
					response.sendRedirect(redirectURL);
					}
				if ("showDistributorByZip".equals(action)) {
					String redirectURL = "enterZipCode.jsp?param=distributor";
					response.sendRedirect(redirectURL);
					}
				if ("showDistributorWithPendingFees".equals(action)) {
					String redirectURL = "showDistributorsByZipCode.jsp?unpaid=true";
					response.sendRedirect(redirectURL);
					}
				if ("showRetailerWithPendingFees".equals(action)) {
					String redirectURL = "showRetailerByZipCode.jsp?unpaid=true";
					response.sendRedirect(redirectURL);
					}
				
			%>

			Menu Options
			<table class="table">
				<thead>

					<tr>
						<th><button class="btn btn-default" name="action"
								value="addDistributor">Add Distributor</button></th>
						<th><button class="btn btn-default" name="action"
								value="addRetailer">Add Retailer</button></th>
						<th><button class="btn btn-default" name="action"
								value="showRetailersByZip">Show Retailer By Zip Code</button></th>
						<th><button class="btn btn-default" name="action"
								value="showDistributorByZip">Show Distributor By Zip
								Code</button></th>
								<th><button class="btn btn-default" name="action"
								value="showDistributorWithPendingFees">Distributor pending fees</button></th>
								<th><button class="btn btn-default" name="action"
								value="showRetailerWithPendingFees">Retailer pending fees</button></th>
					</tr>
				</thead>
			</table>

		</div>
	</form>
</body>
</html>