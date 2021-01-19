<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/pageform.css">
<head>
    <title>Orders</title>
</head>
<style>
    .page-form form button {
        background-color: rgb(202, 36, 195) !important;
    }

    .page-form form button:hover {
        background-color: rgb(202, 36, 195) !important;
    }


</style>
<body>
<div class="page-form">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">

            <div class="collapse navbar-collapse" id="myNavbar">

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${pageContext.request.contextPath}/logout"><span
                            class="glyphicon glyphicon-log-in"></span> Log out</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-left">
                    <li><a href="${pageContext.request.contextPath}/add"><span class="glyphicon"></span> Create order</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <form class="page-form" action="${pageContext.request.contextPath}/userOrders" method="get">
        <h2>Orders</h2>
        <div class=" table">
            <table class="table table-striped table-bordered table-sm">
                <tr>
                    <th>OrderId</th>
                    <th>Baggage type</th>
                    <th>Dimension</th>
                    <th>Weight</th>
                    <th>Direction</th>
                    <th>Date of receiving</th>

                </tr>
                <c:set var="orders" value="${requestScope.get('orders')}"/>
                <c:forEach var="order" items="${orders}">
                    <tr>
                        <td>${order.getOrderID()}</td>
                        <td>${order.getTypeID().getName()}</td>
                        <td>${order.getDimencionID().getName()}</td>
                        <td>${order.getWeight().getName()}</td>
                        <td>${order.getDirection().getName()}</td>
                        <td>${order.getDateOfReceiving()}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <c:set var="href" value="/orders?" scope="request"/>
        <jsp:include page="../pagination.jsp"/>
    </form>


</div>
</body>
</html>
