<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/mystylesheet.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.3/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Demo App Complete!</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Food Monster Express</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-item nav-link active"
					href="${pageContext.request.contextPath}/">Menu Controller <span
						class="sr-only">(current)</span></a></li>
				<li class="nav-item active"><a class="nav-item nav-link active"
					href="${pageContext.request.contextPath}/placeOrderPage">Order</a>
				</li>
				<li class="nav-item active"><a id="cart"
					class="nav-item nav-link active"
					href="${pageContext.request.contextPath}/cart">Cart</a></li>
				<li class="nav-item active"><a id="login"
					class="nav-item nav-link active"
					href="${pageContext.request.contextPath}/login">Login</a></li>
				<li class="nav-item active"><a id="register"
					class="nav-item nav-link active"
					href="${pageContext.request.contextPath}/register">Register</a></li>


				<li class="nav-item active"><a id="logout"
					class="nav-item nav-link active"
					href="${pageContext.request.contextPath}/logout">Logout</a></li>
			</ul>
		</div>
	</nav>
	<div align="center" class ="demotext">
	<br>
	<br>
	<br>
		<h2>Thank you for completing my App Demo!</h2>
		<br>
		<h3>If you created an account and used a real email address</h3>
		<h3>An Email has also been sent to your inbox!!</h3>
		<br><br>
		<h4><a href="https://willyyao.com/resume/Current%20Resume.pdf">Click here to Download my Resume</a></h4>
		<h4><a href="mailto:wyao919@gmail.com">Shoot me a message!</a></h4>
		<h4><a href="https://willyyao.com/">www.WillyYao.com</a></h4>
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