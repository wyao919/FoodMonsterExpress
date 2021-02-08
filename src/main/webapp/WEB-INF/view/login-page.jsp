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
<title>Login Page</title>
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
	<br>
	<br>
	<br>
	<br>
	<main class="login-form">
		<div class="cotainer">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<div class="card">
						<div class="card-header">Login</div>
						<div class="card-body">
							<form:form action="" method="POST" onsubmit="return true">
								<div class="alert alert-info text-center" id="addtocart">${addtocartmessage}</div>
								<div class="alert alert-info text-center" id="registersuccess">${message}</div>

								<div class="form-group row">
									<label for="email_address"
										class="col-md-4 col-form-label text-md-right">User
										Name</label>
									<div class="col-md-6">
										<input type="text" placeholder="username" name="username">

									</div>
								</div>

								<div class="form-group row">
									<label
										class="col-md-4 col-form-label text-md-right">Password</label>
									<div class="col-md-6">
										<input type="password" placeholder="password" name="password">

									</div>
								</div>



								<div class="col-md-6 offset-md-4">
									<button type="submit" class="btn btn-primary">Login</button>

								</div>

							</form:form>


						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="loginError">
			<c:if test="${param.error !=null}">

Username or password is incorrect

</c:if>
		</div>
		<br> <br> <br> <br> <br> <br>
		<div align="center" class="container demotext">
			<h4>Hello! If you do not wish to create an account, you may use
				the test account below.</h4>
			<h4>However, you will have a more personalized experience if you
				register your own account.</h4>
			<br>
			<h5>
				Username: test<br> Password: test123 <br>
			</h5>
			<br> <br> <br> <b>Note: </b>Please
			excuse the slow loading speed, this app is hosted on a free-tier AWS
			server

		</div>

		.

	</main>

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
		var addtocart = `${addtocartmessage}`
		var message = `${message}`
		if (message.length === 0) {
			$("#registersuccess").hide();
		}
		if (addtocart.length === 0) {
			$("#addtocart").hide();
		}
	</script>

</body>
</html>