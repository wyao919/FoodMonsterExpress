<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.3/css/bootstrap.min.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/mystylesheet.css">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
					href="${pageContext.request.contextPath}/">Menu Controller<span
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

	<br>
	<br>
	<br>
	<br>


	<div class="container">
		<form:form action="save-item" method="POST" modelAttribute="menu">

			<form:hidden path="id"></form:hidden>
			<form:hidden path="menuDetail.detailId"></form:hidden>
			<div class="form-group">
				<label for="item">Item Name</label>
				<form:input id="item" class="form-control" path="item"
					required="autofocus" />
				<form:errors path="item" cssClass="errors"></form:errors>
			</div>
			<div class="form-group">
				<label for="price">Price</label>
				<form:input id="price" class="form-control" path="price"
					required="autofocus" />
				<form:errors path="price" cssClass="errors"></form:errors>

			</div>

			<div class="form-group">
				<label for="type">Type</label>
				<form:input id="type" class="form-control" path="menuDetail.type"
					required="autofocus" />
				<form:errors path="menuDetail.type" cssClass="errors"></form:errors>
			</div>

			<div class="form-group">
				<label for="Descriptin">Description</label>
				<form:textarea class="form-control" id="Descriptin"
					path="menuDetail.description" rows="3"></form:textarea>
				<form:errors path="menuDetail.description" cssClass="errors"></form:errors>
			</div>

			<input type="submit" value="Add / Update" class="btn btn-primary"></input>
		</form:form>
	</div>

	<div align="center" class="container demotext">
		<br> <br> <b>Note: </b>Please excuse the slow loading speed,
		this app is hosted on a AWS free-tier.

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
		if (name.length !== 0) {
			console.log('not null or empty' + name.length)
			console.log(name.length)
			$("#login").hide();
			$("#register").hide();
		} else {
			$("#logout").hide();
			console.log('in logout ' + name.length)
		}
		if (name.length === 0) {
			$("#cart").click(function() {
				alert('You must be logged in to view the cart');
			});
		}
	</script>
</body>
</html>