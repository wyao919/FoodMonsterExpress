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


<meta charset="ISO-8859-1">
<title>Cart</title>


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
	<div class="container">
		<h2>${name}'s Shopping Cart:</h2>
		<br>
		<div class="row">
			<div class="col"></div>
		</div>

		<table class="table">
			<thead class="thead-dark">
				<tr>

					<th>Item Name</th>
					<th>Price</th>
					<th>Quantity</th>
					<th></th>
					<th></th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cartItems}" var="tempCart" varStatus="temp">
					<tr>

						<td>${tempCart.menu.item}</td>
						<td><fmt:formatNumber value="${tempCart.menu.price}"
								type="currency" /></td>
						<td>${tempCart.quantity}</td>

						<td>

							<div class="updateButton">
								<a
									href="${pageContext.request.contextPath}/addToCart?menuID=${tempCart.menu.id}"
									class="btn btn-success">Add Qty</a>
							</div>
						</td>

						<td>

							<div>
								<!-- Button trigger modal -->
								<div class="deleteButton">
									<button type="button" class="btn btn-danger"
										data-toggle="modal" data-target="#exampleModal${tempCart.id}">DELETE</button>
									<!-- Modal -->
								</div>
								<div class="modal fade" id="exampleModal${tempCart.id}"
									tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
									aria-hidden="true">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLabel">${tempCart.menu.item}</h5>
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>
											<div class="modal-body">Are you sure you want to delete
												this item?</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													data-dismiss="modal">Close</button>
												<a
													href="${pageContext.request.contextPath}/deleteCartItem?cartID=${tempCart.id}"
													type="button" class="btn btn-danger">Delete Qty</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="${pageContext.request.contextPath}/placeOrderPage">Go
			Back to add more items</a> <br> <br>
		<h3 align="right">
			<br> Current Total:
			<fmt:formatNumber value="${runningTotal}" type="currency" />
		</h3>
		<br>

		<div align="right">
			<a id= "placeOrder" href="${pageContext.request.contextPath}/orderSent" type="button"
				class="btn btn-outline-primary btn-lg">Place Order</a>

		</div>


		<%-- <form class="form-signin" method="post"
			action="${pageContext.request.contextPath}/logout">

			<button class="btn btn btn-primary btn-block" type="submit">Logout</button>
		</form> --%>

<br><br><br><br><br>
	</div>
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
	<script>
		var name = `${name}`
		var total = `${runningTotal}`
		console.log(name)
		console.log(total)
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

		if (total === "0.0") {
			$("#placeOrder").click(function() {
				alert('Your Shopping cart is empty. Please add to cart before you check out!');
			});
		}




	</script>

</body>
</html>