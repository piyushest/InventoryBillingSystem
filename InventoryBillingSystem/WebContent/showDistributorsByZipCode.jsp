<%@page import="apis.GetDistributors"%>
<%@page import="model.Adminregistereddistributor,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Distributors</title>
</head>
<body>
	<form action="showDistributorsByZipCode.jsp">

		<h1>Distributors:</h1>

		<%
			String unpaid = request.getParameter("unpaid");
			String zipCode = request.getParameter("zipCode");
			String action = request.getParameter("action");
			if(action == null){
				action =" ";
			}
			GetDistributors apiCall = new GetDistributors();
			List<Adminregistereddistributor> distributors = new ArrayList<Adminregistereddistributor>();
			
			if(unpaid.equalsIgnoreCase("true")){
				distributors = apiCall.getDistributorsWithUnpaidFees();
			}
			else {
			distributors = apiCall
					.getAllDistributorsByZip(zipCode);
			}
		%>
		<table>
			<tbody>
				<tr>
					<th>&nbsp;</th>
					<th>DistributorId</th>
					<th>&nbsp;</th>
					<th>Name</th>
					<th>&nbsp;</th>
					<th>Phone</th>
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
					for (Adminregistereddistributor distributor : distributors) {
				%>
				<tr>
					<th>&nbsp;</th>
					<td><%=distributor.getDistributorId()%>
					<th>&nbsp;</th>
					<td><%=distributor.getName()%>
					<th>&nbsp;</th>
					<td><%=distributor.getPhone()%>
					<th>&nbsp;</th>
					<td><%=distributor.getStatusoffees()%>
					<th>&nbsp;</th>
					<td><%=distributor.getSubscriptionfees()%>
					<th>&nbsp;</th>
					<td><%=distributor.getZipcode()%>
					<th>&nbsp;</th>
					<td><%=distributor.getMembersince()%>
					
					<a href="updateDistributor.jsp?distributorId=<%= distributor.getDistributorId() %>&name=<%= distributor.getName() %>&zipCode=<%= distributor.getZipcode() %>&memberSince=<%= distributor.getMembersince()%>&subscriptionFees=<%=distributor.getSubscriptionfees()%>&phone=<%= distributor.getPhone()%>&statusOfFees=<%=distributor.getStatusoffees()%>">Update</a>
				</tr>
				<%
			}
%>
			</tbody>
		</table>
	</form>
</body>
</html>