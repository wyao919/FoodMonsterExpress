<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/mystylesheet.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/login-Form.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.3/css/bootstrap.min.css">

<!-- Fonts -->
<link rel="dns-prefetch" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600"
	rel="stylesheet" type="text/css">


<meta charset="ISO-8859-1">
<title>Registration Page</title>


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
					href="${pageContext.request.contextPath}/register">Register</a>

				<a
						id="updatePW" class="nav-item nav-link active"
						href="${pageContext.request.contextPath}/updatePw">Update Password</a>
				<a
					id="logout" class="nav-item nav-link active"
					href="${pageContext.request.contextPath}/logout">Logout</a>
			</div>
		</div>
	</nav>


	<main class="login-form">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<div class="card">
						<div class="card-header">Register</div>
						<div class="card-body">
							<form:form action="${pageContext.request.contextPath}/save-user"
								method="POST" modelAttribute="userAccount"
								onsubmit="return true">

								<div class="form-group row">
									<label for="name" class="col-md-4 col-form-label text-md-right">Full
										Name</label>
									<div class="col-md-6">
										<form:input id="name" class="form-control"
											path="customer.name" required="autofocus" />
										<form:errors path="customer.name" cssClass="errors"></form:errors>
									</div>
								</div>

								<div class="form-group row">
									<label for="username"
										class="col-md-4 col-form-label text-md-right">User
										Name</label>
									<div class="col-md-6">
										<form:input id="username" class="form-control" path="username"
											required="autofocus" />
										<form:errors path="username" cssClass="errors"></form:errors>
									</div>
								</div>

								<div class="form-group row">
									<label for="password"
										class="col-md-4 col-form-label text-md-right">Password</label>
									<div class="col-md-6">
										<form:password id="password" class="form-control"
											path="password" />
										<form:errors path="password" cssClass="errors"></form:errors>
									</div>
								</div>

								<div class="form-group row">
									<label for="rPassword"
										   class="col-md-4 col-form-label text-md-right">Retype Password</label>
									<div class="col-md-6">
										<form:password id="rPassword" class="form-control"
													   path="rPassword" />
										<form:errors path="rPassword" cssClass="errors"></form:errors>
									</div>
								</div>

								<div class="form-group row">
									<label for="email"
										class="col-md-4 col-form-label text-md-right">E-Mail
										Address</label>
									<div class="col-md-6">
										<form:input id="email" class="form-control" path="email" />
										<form:errors path="email" cssClass="errors"></form:errors>
									</div>
								</div>

								<div class="form-group row">
									<label for="phonenumber"
										class="col-md-4 col-form-label text-md-right">Phone
										Number</label>
									<div class="col-md-6">
										<form:input id="phonenumber" class="form-control"
											path="customer.phoneNumber" required="autofocus" />
										<form:errors path="customer.phoneNumber" cssClass="errors"></form:errors>
									</div>
								</div>


								<div class="col-md-6 offset-md-4">
									<button type="submit" class="btn btn-primary">
										Register</button>

								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>

	</main>
	<br>
	<br>
	<br>

	<div class="container demotext" align="center">
		<h5>Don't want to register? Don't worry! Please go to the
			login page and follow the directions.</h5>
		<h5>For a more personalized experience, please register :)
			</h5>
		<br> <br>


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
			$("#updatePW").hide();
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