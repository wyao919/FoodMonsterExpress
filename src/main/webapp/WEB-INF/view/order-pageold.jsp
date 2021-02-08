<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.3/css/bootstrap.min.css">

<meta charset="ISO-8859-1">
<title>Order</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Food Monster Express</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
				<a class="nav-item nav-link active"
					href="${pageContext.request.contextPath}/">Menu Controller <span
					class="sr-only">(current)</span></a> <a
					class="nav-item nav-link active"
					href="${pageContext.request.contextPath}/placeOrderPage">Order</a>
				<a id="cart" class="nav-item nav-link active"
					href="${pageContext.request.contextPath}/cart">Cart</a> <a
					id="login" class="nav-item nav-link active"
					href="${pageContext.request.contextPath}/login">Login</a> <a
					id="register" class="nav-item nav-link active"
					href="${pageContext.request.contextPath}/register">Register</a> <a
					id="logout" class="nav-item nav-link active"
					href="${pageContext.request.contextPath}/logout">Logout</a>
			</div>
		</div>
	</nav>
	<div class="container">

		<h2 align="center">Please Order here</h2>
		<form:form action="ordersaved" method="POST"
			modelAttribute="orderInfo">

			<!-- BootStrap Code Start -->
			<p align="center">
				<a class="btn btn-primary existingCustomers" data-toggle="collapse"
					href="#multiCollapseExample1" role="button" aria-expanded="false"
					aria-controls="multiCollapseExample1">Existing Customers</a>
				<button class="btn btn-secondary" type="button"
					data-toggle="collapse" data-target="#multiCollapseExample2"
					aria-expanded="false" aria-controls="multiCollapseExample2">New
					Customer</button>

			</p>
			<div class="row">
				<div class="col">
					<div class="collapse multi-collapse" id="multiCollapseExample1">
						<div class="card card-body">
							<label>Customer ID: </label>
							<form:input path="customer.customerId" />

						</div>
					</div>
				</div>
				<div class="col">
					<div class="collapse multi-collapse" id="multiCollapseExample2">
						<div class="card card-body">
							<label>Customer Name: </label>
							<form:input path="customer.name" />
							<br /> <label>Phone Number: </label>
							<form:input path="customer.phoneNumber" />
						</div>
					</div>
				</div>
			</div>

			<!-- BootStrap Code end -->
			<br />

			<label>Choose items: </label>
			<form:select path="menu.id">
				<form:option value="0">--------SELECT--------</form:option>
				<form:options items="${items}" itemLabel="item" itemValue="id" />
				<br />
			</form:select>

			<br />
			<label>Order Type: </label>
			<form:select path="orderType">
				<form:option value="0">--------SELECT--------</form:option>
				<form:option value=" takeOut">Take Out</form:option>
				<form:option value=" deilvery">Delivery</form:option>
			</form:select>
			<br />
			<label>Order Date</label>
			<form:input path="date" />
			<form:errors path="date"></form:errors>
			<form:button>Submit</form:button>


		</form:form>

	</div>
	<script
		src="${pageContext.request.contextPath}/webjars/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/webjars/bootstrap/4.5.3/js/bootstrap.min.js"></script>
	<script
		type="${pageContext.request.contextPath}/webjars/popper.js/1.16.0/umd/popper.min.js"></script>
			<script>
		var name = `${name}`
		console.log(name)
		if (name.length != 0) {
			console.log('not null or empty' + name.length)
			console.log(name.length)
			$("#login").hide();
			$("#register").hide();
		} else {
			$("#logout").hide();
			console.log('in logout ' + name.length)
		}
		if(name.length == 0)
		{
		$("#cart").click( function() { alert('You must be logged in to view the cart'); });
		}
	</script>
</body>
</html>