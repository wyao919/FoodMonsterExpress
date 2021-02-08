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
	href="${pageContext.request.contextPath}/resources/css/login-Form.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.3/css/bootstrap.min.css">

<!-- Fonts -->
<link rel="dns-prefetch" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600"
	rel="stylesheet" type="text/css">




<title>MENU</title>
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
			<form:form class="form-inline my-2 my-sm-0"
				action="${pageContext.request.contextPath}/searchorderpage"
				method="get">
				<input class="form-control mr-sm-2" type="search" name="itemName"
					placeholder="Search Menu" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-lg-0" type="submit">Search</button>
			</form:form>
		</div>
	</nav>
	<br>
	<br>

	<div class="container">
		<!-- this is for alignment -->

		<h1 align="center">Menu Items</h1>
		<h1>${name}</h1>


		<br>


		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>Item Name</th>
					<th>Price</th>
					<th>Show Details</th>
					<th>Add To cart</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${menuItems}" var="tempMenu" varStatus="temp">
					<tr>
						<td>${tempMenu.item}</td>
						<td><fmt:formatNumber value="${tempMenu.price}"
								type="currency" /></td>
						<td>
							<!-- Button trigger modal --> <a href="#" data-toggle="modal"
							data-target="#exampleModalCenter${tempMenu.id}">Get Details</a> <!-- Modal -->

							<div class="modal fade" id="exampleModalCenter${tempMenu.id}"
								tabindex="-1" role="dialog"
								aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
								<div class="modal-dialog modal-dialog-centered" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLongTitle">${tempMenu.item}</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">
											Description : ${tempMenu.menuDetail.description}<br>
											Type : ${tempMenu.menuDetail.type}<br>

										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
										</div>
									</div>
								</div>
							</div>
						</td>
						<td>
							<div id="addtocart" class="updateButton">
								<a onclick="myFunction()" id="additem"
									href="${pageContext.request.contextPath}/addToCart?menuID=${tempMenu.id}"
									class="btn btn-success">Add To Cart</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<br>
	<br>
	<br>
	<br>
	<div align="center" class="container demotext">
		<h4>All items that are added to your cart will be saved to your
			account</h4>
		<h4>and will be available to you the next time you login.</h4>
		<br> <b>Note: </b>Please excuse the slow loading speed, this app
		is hosted on a free-tier AWS Server

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
			/* $("#additem").click(function() {
				alert('You must be logged in to view the cart');
			}); */
		}
	</script>
</body>
</html>