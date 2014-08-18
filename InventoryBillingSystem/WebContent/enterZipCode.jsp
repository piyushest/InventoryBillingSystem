<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="enterZipCode.jsp" method="get">
		<div class="container">
			<h1>
				<a href="adminPage.jsp" class="btn btn-default">Back To Menu</a>
			</h1>
			<%
				String zipCode = request.getParameter("zipCode");
				if (zipCode == null)
					zipCode = "";
				String param = request.getParameter("param");
				if (param == null)
					param = "";
				String action = request.getParameter("action");
				
				
				if ("submit".equals(action)&&param.equalsIgnoreCase("distributor")) {
					String url = "showDistributorsByZipCode.jsp?zipCode="+zipCode+"&unpaid=false";
					response.sendRedirect(url);
				}
				else if ("submit".equals(action)&&param.equalsIgnoreCase("retailer")) {
					String url = "showRetailerByZipCode.jsp?zipCode="+zipCode+"&unpaid=false";
					response.sendRedirect(url);
				}
				
			%>

			Welcome
			<table class="table">
				<thead>
					<tr>

						<th>Zip Code</th>
						
						
						<th>&nbsp;</th>
					</tr>
					<tr>

						<th><input name="zipCode" value="<%=zipCode%>" class="form-control" /></th>
						<th><input type="hidden" name="param"  value="<%=param%>" class="form-control" /></th>
						<th><button class="btn btn-default" name="action" value="submit">Submit</button>
						</th>
					</tr>
				</thead>
			</table>

		</div>
	</form>
</body>
</html>