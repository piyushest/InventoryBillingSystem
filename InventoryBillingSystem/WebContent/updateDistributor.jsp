<%@page import="Dao.AdminregistereddistributorDao"%>
<%@page import="model.Adminregistereddistributor"%>
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
	<form action="updateDistributor.jsp" method="get">
		<div class="container">
			<h1>
				<a href="adminPage.jsp" class="btn btn-default">Back To Menu</a>
			</h1>
			<%
				String distributorId = request.getParameter("distributorId");

				String name = request.getParameter("name");
				if (name == null)
					name = "";
				String phone = request.getParameter("phone");
				if (phone == null)
					phone = "";
				String zipCode = request.getParameter("zipCode");
				if (zipCode == null)
					zipCode = "";
				String memberSince = request.getParameter("memberSince");
				if (memberSince == null)
					memberSince = "";
				String subscriptionFees = request.getParameter("subscriptionFees");
				if (subscriptionFees == null)
					subscriptionFees = "";
				String statusOfFees = request.getParameter("statusOfFees");
				if (statusOfFees == null)
					statusOfFees = "";
				String action = request.getParameter("action");
				AdminregistereddistributorDao distributorDao = new AdminregistereddistributorDao();

				if ("update".equals(action)) {
					Adminregistereddistributor entity = new Adminregistereddistributor(
							distributorId, memberSince, name, phone, statusOfFees,
							subscriptionFees, zipCode);
					distributorDao.update(entity);
					String redirectURL = "addDistributor.jsp";
					response.sendRedirect(redirectURL);
				}
			%>

			Welcome
			<table class="table">
				<thead>
					<tr>

						<th>Name</th>
						<th>Phone</th>
						<th>ZipCode</th>
						<th>MemberSince</th>
						<th>SubscriptionFees</th>
						<th>StatusOfFees</th>
						<th>&nbsp;</th>
					</tr>
					<tr>

						<th><input name="name" value="<%=name%>" class="form-control" /></th>
						<th><input name="phone" value="<%=phone%>"
							class="form-control" /></th>
						<th><input name="zipCode" value="<%=zipCode%>"
							class="form-control" /></th>
						<th><input name="memberSince" value="<%=memberSince%>"
							class="form-control" /></th>
						<th><input name="subscriptionFees"
							value="<%=subscriptionFees%>" class="form-control" /></th>
						<th><input name="statusOfFees" value="<%=statusOfFees%>"
							class="form-control" /></th>
						<th><input type="hidden" name="distributorId"
							value="<%=distributorId%>" class="form-control" /></th>
						<th><button class="btn btn-default" name="action"
								value="update">Update</button></th>
					</tr>
				</thead>
			</table>

		</div>
	</form>
</body>
</html>