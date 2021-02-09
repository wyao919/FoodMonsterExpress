<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
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
                   action="${pageContext.request.contextPath}/searchItems" method="get">
            <input class="form-control mr-sm-2" type="search" name="itemName"
                   placeholder="Search Menu" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-lg-0" type="submit">Search</button>
        </form:form>
    </div>
</nav>


<div class="container">
    <!-- this is for alignment -->
    <br>

    <h1 align="center">Menu Control Editor</h1>

    <br> <a class="btn btn-outline-primary" href="showAddItemPage">Add
    item</a>

    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th>Item Name</th>
            <th>Price</th>
            <th>Show Details</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${menuItems}" var="tempMenu" varStatus="temp">
            <tr>

                <td>${tempMenu.item}</td>
                <td><fmt:formatNumber value="${tempMenu.price}"
                                      type="currency"/></td>
                <td>
                    <!-- Button trigger modal --> <a href="#" data-toggle="modal"
                                                     data-target="#exampleModalCenter${tempMenu.id}">Details</a>
                    <!-- Modal -->

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
                                            data-dismiss="modal">Close
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
                <td>

                    <div class="updateButton">
                        <a
                                href="${pageContext.request.contextPath}/showUpdatePage?menuID=${tempMenu.id}"
                                class="btn btn-success">Update</a>
                    </div>
                </td>

                <td>

                    <div>
                        <!-- Button trigger modal -->
                        <div class="deleteButton">
                            <button type="button" class="btn btn-danger"
                                    data-toggle="modal" data-target="#exampleModal${tempMenu.id}">Delete
                            </button>
                            <!-- Modal -->
                        </div>
                        <div class="modal fade" id="exampleModal${tempMenu.id}"
                             tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                             aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">${tempMenu.item}</h5>
                                        <button type="button" class="close" data-dismiss="modal"
                                                aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">Are you sure you want to delete
                                        this item?
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary"
                                                data-dismiss="modal">Close
                                        </button>
                                        <a
                                                href="${pageContext.request.contextPath}/deleteMenuItem?menuID=${tempMenu.id}"
                                                type="button" class="btn btn-danger">DELETE</a>
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
</div>
<br>
<div class="container demotext">
    <h4>
        <b>Hello! Welcome to my Demo App</b>
    </h4>

    For demo purposes, the Menu Controller/Editor will be open for you to demo the
    database functions.<br> Feel free to add, delete, update and
    search items. <br> <br> In order to preserve this
    demo, please do not delete all items or items that you have not
    created.<br> <br>
    <b>Note: </b>Please
    excuse the slow loading speed, this app is hosted on a free-tier AWS
    server<br> <br>
</div>

<div class="container demotext">

    <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample"
            aria-expanded="false" aria-controls="collapseExample">
        View App Features and Technologies
    </button>

    <div class="collapse" id="collapseExample">
        <div class="card card-body">

            <h4>
                <b>Languages and Technologies</b>
            </h4>
            *JAVA, Spring MVC, Spring Security, Hibernate, JavaScript, HTML, CSS,
            JQuery, Bootstrap, MySQL, AWS <br> <br>
            <h4>
                <b>App Features</b>
            </h4>
            *BCrypt Password Encoder, SQL Relational Databases, Java Mail Sender,
            JSR Custom Annotations <br> <br>
        </div>
    </div>
</div>

<br><br><br><br><br>


<%--<div class="demotext container">
    <h4>
        <b>Hello! Welcome to my Demo App</b>
    </h4>

    For demo purposes, the Menu Controller/Editor will be open for you to demo the
    database functions.<br> Feel free to add, delete, update and
    search items. <br> <br> Note: In order to preserve this
    demo, please do not delete all items or items that you have not
    created.<br> <br>

    <h4>
        <b>Languages and Technologies</b>
    </h4>
    *JAVA, Spring MVC, Spring Security, Hibernate, JavaScript, HTML, CSS,
    Jquery, BootStrap, MySQL, AWS <br> <br>
    <h4>
        <b>App Features</b>
    </h4>
    *BCrypt Password Encoder, SQL Relational Databases, Java Mail Sender,
    JSR 380 Custom Annotations <br> <br> <b>Note: </b>Please
    excuse the slow loading speed, this app is hosted on a free-tier AWS
    server
</div>
--%>

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
        $("#cart").click(function () {
            alert('You must be logged in to view the cart');
        });
    }
</script>

</body>
</html>