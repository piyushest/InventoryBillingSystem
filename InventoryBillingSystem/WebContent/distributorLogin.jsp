<%@page import="apis.Login"%>
<%@page import="model.Adminregistration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.css" rel="stylesheet" />
<title>Login</title>
</head>
<body>
	<form action="distributorLogin.jsp" method="get">
		<div class="container">
			<%
				String id = request.getParameter("id");
				if (id == null) {
					id = "";
				}
				String name = request.getParameter("name");
				if (name == null)
					name = "";
				String password = request.getParameter("password");
				if (password == null)
					password = "";
				String action = request.getParameter("action");
				Login validate = new Login();
				if ("login".equals(action)) {
					if (validate.isValidateDistributor(id,name, password)) {
						String redirectUrl = "distributorMenu.jsp?id="+id;
						response.sendRedirect(redirectUrl);
					}
				}
			%>

			Welcome
			<table class="table">
				<thead>
					<tr>
						<th>Distributor Id</th>
						<th>Name</th>
						<th>Password</th>
						<th>&nbsp;</th>
					</tr>
					<tr>
						<th><input name="id" value="<%=id%>" class="form-control" /></th>
						<th><input name="name" value="<%=name%>" class="form-control" /></th>
						<th><input name="password" value="<%=password%>"
							class="form-control" /></th>

						<th><button class="btn btn-default" name="action"
								value="login">Login</button></th>

					</tr>
				</thead>
			</table>

		</div>
	</form>
</body>
</html>