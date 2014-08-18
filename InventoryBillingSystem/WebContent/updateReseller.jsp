
<%@page import="Dao.AdminretailerregistrationDao"%>
<%@page import="model.Adminretailerregistration"%>
<%@page import="Dao.AdminregistrationDao"%>
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
	<form action="updateReseller.jsp" method="get">
		<div class="container">

			<h1>
				<a href="adminPage.jsp" class="btn btn-default">Back To Menu</a>
			</h1>

			<%
			
			String resellerId = request.getParameter("resellerId");
				String area = request.getParameter("area");
				if (area == null)
					area = "";

				String memberSince = request.getParameter("memberSince");
				if (memberSince == null)
					memberSince = "";

				String name = request.getParameter("name");
				if (name == null)
					name = "";

				String statusoffees = request.getParameter("statusoffees");
				if (statusoffees == null)
					statusoffees = "";

				String subscriptionFees = request.getParameter("subscriptionFees");
				if (subscriptionFees == null)
					subscriptionFees = "";

				String zipCode = request.getParameter("zipCode");
				if (zipCode == null)
					zipCode = "";

				String action = request.getParameter("action");
				AdminretailerregistrationDao retailerDao = new AdminretailerregistrationDao();

				if ("update".equals(action)) {
					Adminretailerregistration entity = new Adminretailerregistration(resellerId,
							area, memberSince, name, statusoffees,
							subscriptionFees, zipCode);
					retailerDao.update(entity);
					String redirectURL = "addRetailer.jsp";
					response.sendRedirect(redirectURL);
				}
			%>
			<table class="table">
				<thead>
					<tr>

						<th>area</th>
						<th>memberSince</th>
						<th>name</th>
						<th>statusoffees</th>
						<th>subscriptionFees</th>

						<th>zipCode</th>
						<th>&nbsp;</th>
					</tr>
					<tr>
						<th><input name="area" value="<%=area%>" class="form-control" /></th>

						<th><input name="memberSince" value="<%=memberSince%>"
							class="form-control" /></th>

						<th><input name="name" value="<%=name%>" class="form-control" /></th>
						<th><input name="statusoffees" value="<%=statusoffees%>"
							class="form-control" /></th>

						<th><input name="subscriptionFees"
							value="<%=subscriptionFees%>" class="form-control" /></th>



						<th><input name="zipCode" value="<%=zipCode%>"
							class="form-control" /></th>
							<th><input type="hidden" name="resellerId"
							value="<%=resellerId%>" class="form-control" /></th>
						<th><button class="btn btn-default" name="action" value="update">Update</button>
						</th>
					</tr>
				</thead>
			</table>

		</div>
	</form>

</body>
</html>