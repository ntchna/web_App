<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/css/formpage.css">
<style>
    .page-form form button{
        background-color: rgb(202, 36, 195) !important;
    }
    .page-form form button:hover{
        background-color: rgb(202, 36, 195) !important;
    }
    .page-form h2:before, .page-form h2:after {
        width: 20% !important;
    }

</style>
<head>
    <title>Add Order</title>
</head>
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
                    <li><a href="${pageContext.request.contextPath}/userOrders"><span class="glyphicon"></span> All orders</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <form action="${pageContext.request.contextPath}/add" method="post">
        <h2>Add Order</h2>
        <p class="hint-text">Here you can create order</p>
        <div class=" page-form row">
            <select class="btn btn-info dropdown-toggle" name="baggageType" id="baggageType">
                    <c:choose>
                        <c:when test="${param.baggageType=='Documents'}">
                            <option value ="none">Baggage Type</option>
                            <option value="1" selected>Documents</option>
                            <option value="2">Large cargo</option>
                            <option value="3">Palletized cargo</option>
                            <option value="4">Fragile cargo</option>
                        </c:when>
                        <c:when test="${param.baggageType=='Large cargo'}">
                            <option value ="none">Baggage Type</option>
                            <option value="1">Documents</option>
                            <option value="2"selected>Large cargo</option>
                            <option value="3">Palletized cargo</option>
                            <option value="4">Fragile cargo</option>
                        </c:when>
                        <c:when test="${param.baggageType=='Palletized cargo'}">
                            <option value ="none">Baggage Type</option>
                            <option value="1">Documents</option>
                            <option value="2">Large cargo</option>
                            <option value="3"selected>Palletized cargo</option>
                            <option value="4">Fragile cargo</option>
                        </c:when>
                        <c:when test="${param.baggageType=='Fragile cargo'}">
                            <option value ="none">Baggage Type</option>
                            <option value="1">Documents</option>
                            <option value="2">Large cargo</option>
                            <option value="3">Palletized cargo</option>
                            <option value="4"selected>Fragile cargo</option>
                        </c:when>
                        <c:otherwise>
                            <option value ="none" selected>Category</option>
                            <option value="1" selected>Documents</option>
                            <option value="2">Large cargo</option>
                            <option value="3">Palletized cargo</option>
                            <option value="4">Fragile cargo</option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </div>
            <div >
                <div>
                    <select class="btn btn-info dropdown-toggle" name="dimension" id="dimension">
                        <c:choose>
                            <c:when test="${param.dimension=='0.2'}">
                                <option value ="none">Dimension</option>
                                <option value="1" selected>0.2</option>
                                <option value="2">0.3</option>
                                <option value="3">0.5</option>
                                <option value="4">0.8</option>
                                <option value="5">1</option>
                                <option value="6">1.2</option>
                            </c:when>
                            <c:when test="${param.dimension=='0.3'}">
                                <option value ="none">Dimension</option>
                                <option value="1">0.2</option>
                                <option value="2"selected>0.3</option>
                                <option value="3">0.5</option>
                                <option value="4">0.8</option>
                                <option value="5">1</option>
                                <option value="6">1.2</option>
                            </c:when>
                            <c:when test="${param.dimension =='0.5'}">
                                <option value ="none">Dimension</option>
                                <option value="1">0.2</option>
                                <option value="2">0.3</option>
                                <option value="3"selected>0.5</option>
                                <option value="4">0.8</option>
                                <option value="5">1</option>
                                <option value="6">1.2</option>
                            </c:when>
                            <c:when test="${param.dimension =='0.8'}">
                                <option value ="none">Dimension</option>
                                <option value="1">0.2</option>
                                <option value="2">0.3</option>
                                <option value="3">0.5</option>
                                <option value="4"selected>0.8</option>
                                <option value="5">1</option>
                                <option value="6">1.2</option>
                            </c:when>
                            <c:when test="${param.dimension =='1'}">
                                <option value ="none">Dimension</option>
                                <option value="1">0.2</option>
                                <option value="2">0.3</option>
                                <option value="3">0.5</option>
                                <option value="4">0.8</option>
                                <option value="5"selected>1</option>
                                <option value="6">1.2</option>
                            </c:when>
                            <c:when test="${param.dimension =='1.2'}">
                                <option value ="none">Dimension</option>
                                <option value="1">0.2</option>
                                <option value="2">0.3</option>
                                <option value="3">0.5</option>
                                <option value="4">0.8</option>
                                <option value="5">1</option>
                                <option value="6"selected>1.2</option>
                            </c:when>
                            <c:otherwise>
                                <option value ="none"selected>Dimension</option>
                                <option value="1" >0.2</option>
                                <option value="2">0.3</option>
                                <option value="3">0.5</option>
                                <option value="4">0.8</option>
                                <option value="5">1</option>
                                <option value="6">1.2</option>
                            </c:otherwise>
                        </c:choose>
                    </select></div>
            </div>
            <div >
                <div>
                    <select class="btn btn-info dropdown-toggle" name="weight" id="weight">
                        <c:choose>
                            <c:when test="${param.weight=='до 500 г'}">
                                <option value ="none">Weight</option>
                                <option value="до 500 г<" selected>до 500 г</option>
                                <option value="до 800 г">до 800 г</option>
                                <option value="до 1 кг">до 1 кг</option>
                                <option value="до 1.5 кг">до 1.5 кг</option>
                                <option value="до 2 кг">до 2 кг</option>
                                <option value="до 2.5 кг">до 2.5 кг</option>
                                <option value="до 3 кг">до 3 кг</option>
                                <option value="до 5 кг">до 5 кг</option>
                                <option value="до 8 кг">до 8 кг</option>
                            </c:when>
                            <c:when test="${param.weight=='до 800 г'}">
                                <option value ="none">Weight</option>
                                <option value="до 500 г" >до 500 г</option>
                                <option value="до 800 г"selected>до 800 г</option>
                                <option value="до 1 кг">до 1 кг</option>
                                <option value="до 1.5 кг">до 1.5 кг</option>
                                <option value="до 2 кг">до 2 кг</option>
                                <option value="до 2.5 кг">до 2.5 кг</option>
                                <option value="до 3 кг">до 3 кг</option>
                                <option value="до 5 кг">до 5 кг</option>
                                <option value="до 8 кг">до 8 кг</option>
                            </c:when>
                            <c:when test="${param.weight=='до 1 кг'}">
                                <option value ="none">Weight</option>
                                <option value="до 500 г" >до 500 г</option>
                                <option value="до 800 г">до 800 г</option>
                                <option value="до 1 кг"selected>до 1 кг</option>
                                <option value="до 1.5 кг">до 1.5 кг</option>
                                <option value="до 2 кг">до 2 кг</option>
                                <option value="до 2.5 кг">до 2.5 кг</option>
                                <option value="до 3 кг">до 3 кг</option>
                                <option value="до 5 кг">до 5 кг</option>
                                <option value="до 8 кг">до 8 кг</option>
                            </c:when>
                            <c:when test="${param.weight=='до 1.5 кг'}">
                                <option value ="none">Weight</option>
                                <option value="до 500 г" >до 500 г</option>
                                <option value="до 800 г">до 800 г</option>
                                <option value="до 1 кг">до 1 кг</option>
                                <option value="до 1.5 кг"selected>до 1.5 кг</option>
                                <option value="до 2 кг">до 2 кг</option>
                                <option value="до 2.5 кг">до 2.5 кг</option>
                                <option value="до 3 кг">до 3 кг</option>
                                <option value="до 5 кг">до 5 кг</option>
                                <option value="до 8 кг">до 8 кг</option>
                            </c:when>
                            <c:when test="${param.weight=='до 2 кг'}">
                                <option value ="none">Weight</option>
                                <option value="до 500 г" >до 500 г</option>
                                <option value="до 800 г">до 800 г</option>
                                <option value="до 1 кг">до 1 кг</option>
                                <option value="до 1.5 кг">до 1.5 кг</option>
                                <option value="до 2 кг" selected>до 2 кг</option>
                                <option value="до 2.5 кг">до 2.5 кг</option>
                                <option value="до 3 кг">до 3 кг</option>
                                <option value="до 5 кг">до 5 кг</option>
                                <option value="до 8 кг">до 8 кг</option>
                            </c:when>
                            <c:when test="${param.weight=='до 2.5 кг'}">
                                <option value ="none">Weight</option>
                                <option value="до 500 г" >до 500 г</option>
                                <option value="до 800 г">до 800 г</option>
                                <option value="до 1 кг">до 1 кг</option>
                                <option value="до 1.5 кг">до 1.5 кг</option>
                                <option value="до 2 кг">до 2 кг</option>
                                <option value="до 2.5 кг" selected>до 2.5 кг</option>
                                <option value="до 3 кг">до 3 кг</option>
                                <option value="до 5 кг">до 5 кг</option>
                                <option value="до 8 кг">до 8 кг</option>
                            </c:when>
                            <c:when test="${param.weight=='до 3 кг'}">
                                <option value ="none">Weight</option>
                                <option value="до 500 г" >до 500 г</option>
                                <option value="до 800 г">до 800 г</option>
                                <option value="до 1 кг">до 1 кг</option>
                                <option value="до 1.5 кг">до 1.5 кг</option>
                                <option value="до 2 кг">до 2 кг</option>
                                <option value="до 2.5 кг">до 2.5 кг</option>
                                <option value="до 3 кг" selected>до 3 кг</option>
                                <option value="до 5 кг">до 5 кг</option>
                                <option value="до 8 кг">до 8 кг</option>
                            </c:when>
                            <c:when test="${param.weight=='до 5 кг'}">
                                <option value ="none">Weight</option>
                                <option value="до 500 г" >до 500 г</option>
                                <option value="до 800 г">до 800 г</option>
                                <option value="до 1 кг">до 1 кг</option>
                                <option value="до 1.5 кг">до 1.5 кг</option>
                                <option value="до 2 кг">до 2 кг</option>
                                <option value="до 2.5 кг">до 2.5 кг</option>
                                <option value="до 3 кг">до 3 кг</option>
                                <option value="до 5 кг" selected>до 5 кг</option>
                                <option value="до 8 кг">до 8 кг</option>
                            </c:when>
                            <c:when test="${param.weight=='до 8 кг'}">
                                <option value ="none">Weight</option>
                                <option value="до 500 г" >до 500 г</option>
                                <option value="до 800 г">до 800 г</option>
                                <option value="до 1 кг">до 1 кг</option>
                                <option value="до 1.5 кг">до 1.5 кг</option>
                                <option value="до 2 кг">до 2 кг</option>
                                <option value="до 2.5 кг">до 2.5 кг</option>
                                <option value="до 3 кг">до 3 кг</option>
                                <option value="до 5 кг">до 5 кг</option>
                                <option value="до 8 кг" selected>до 8 кг</option>
                            </c:when>
                            <c:otherwise>
                                <option value ="none" selected>Weight</option>
                                <option value="до 500 г" >до 500 г</option>
                                <option value="до 800 г">до 800 г</option>
                                <option value="до 1 кг">до 1 кг</option>
                                <option value="до 1.5 кг">до 1.5 кг</option>
                                <option value="до 2 кг">до 2 кг</option>
                                <option value="до 2.5 кг">до 2.5 кг</option>
                                <option value="до 3 кг">до 3 кг</option>
                                <option value="до 5 кг">до 5 кг</option>
                                <option value="до 8 кг">до 8 кг</option>
                            </c:otherwise>
                        </c:choose>
                    </select></div>
            </div>
            <div>
                <div>
                    <select class="btn btn-info dropdown-toggle" name="direction" id="direction">
                        <c:choose>
                            <c:when test="${param.direction=='Одеса'}">
                                <option value ="none">Direction</option>
                                <option value="Одеса<" selected>Одеса</option>
                                <option value="Запоріжжя">Запоріжжя</option>
                                <option value="Донецьк">Донецьк</option>
                                <option value="Харків">Харків</option>
                                <option value="Кіровоград">Кіровоград</option>
                                <option value="Полтава">Полтава</option>
                                <option value="Суми">Суми</option>
                                <option value="Чернігів">Чернігів</option>
                                <option value="Вінниця">Вінниця</option>
                            </c:when>
                            <c:when test="${param.direction=='Запоріжжя'}">
                                <option value ="none">Direction</option>
                                <option value="Одеса<">Одеса</option>
                                <option value="Запоріжжя" selected>Запоріжжя</option>
                                <option value="Донецьк">Донецьк</option>
                                <option value="Харків">Харків</option>
                                <option value="Кіровоград">Кіровоград</option>
                                <option value="Полтава">Полтава</option>
                                <option value="Суми">Суми</option>
                                <option value="Чернігів">Чернігів</option>
                                <option value="Вінниця">Вінниця</option>
                            </c:when>
                            <c:when test="${param.direction=='Донецьк'}">
                                <option value ="none">Direction</option>
                                <option value="Одеса<">Одеса</option>
                                <option value="Запоріжжя">Запоріжжя</option>
                                <option value="Донецьк" selected>Донецьк</option>
                                <option value="Харків">Харків</option>
                                <option value="Кіровоград">Кіровоград</option>
                                <option value="Полтава">Полтава</option>
                                <option value="Суми">Суми</option>
                                <option value="Чернігів">Чернігів</option>
                                <option value="Вінниця">Вінниця</option>
                            </c:when>
                            <c:when test="${param.direction=='Харків'}">
                                <option value ="none">Direction</option>
                                <option value="Одеса<">Одеса</option>
                                <option value="Запоріжжя">Запоріжжя</option>
                                <option value="Донецьк">Донецьк</option>
                                <option value="Харків" selected>Харків</option>
                                <option value="Кіровоград">Кіровоград</option>
                                <option value="Полтава">Полтава</option>
                                <option value="Суми">Суми</option>
                                <option value="Чернігів">Чернігів</option>
                                <option value="Вінниця">Вінниця</option>
                            </c:when>
                            <c:when test="${param.direction=='Кіровоград'}">
                                <option value ="none">Direction</option>
                                <option value="Одеса<">Одеса</option>
                                <option value="Запоріжжя">Запоріжжя</option>
                                <option value="Донецьк">Донецьк</option>
                                <option value="Харків">Харків</option>
                                <option value="Кіровоград" selected>Кіровоград</option>
                                <option value="Полтава">Полтава</option>
                                <option value="Суми">Суми</option>
                                <option value="Чернігів">Чернігів</option>
                                <option value="Вінниця">Вінниця</option>
                            </c:when>
                            <c:when test="${param.direction=='Полтава'}">
                                <option value ="none">Direction</option>
                                <option value="Одеса<">Одеса</option>
                                <option value="Запоріжжя">Запоріжжя</option>
                                <option value="Донецьк">Донецьк</option>
                                <option value="Харків">Харків</option>
                                <option value="Кіровоград">Кіровоград</option>
                                <option value="Полтава" selected>Полтава</option>
                                <option value="Суми">Суми</option>
                                <option value="Чернігів">Чернігів</option>
                                <option value="Вінниця">Вінниця</option>
                            </c:when>
                            <c:when test="${param.direction=='Суми'}">
                                <option value ="none">Direction</option>
                                <option value="Одеса<">Одеса</option>
                                <option value="Запоріжжя">Запоріжжя</option>
                                <option value="Донецьк">Донецьк</option>
                                <option value="Харків">Харків</option>
                                <option value="Кіровоград">Кіровоград</option>
                                <option value="Полтава">Полтава</option>
                                <option value="Суми" selected>Суми</option>
                                <option value="Чернігів">Чернігів</option>
                                <option value="Вінниця">Вінниця</option>
                            </c:when>
                            <c:when test="${param.direction=='Чернігів'}">
                                <option value ="none">Direction</option>
                                <option value="Одеса<">Одеса</option>
                                <option value="Запоріжжя">Запоріжжя</option>
                                <option value="Донецьк">Донецьк</option>
                                <option value="Харків">Харків</option>
                                <option value="Кіровоград">Кіровоград</option>
                                <option value="Полтава">Полтава</option>
                                <option value="Суми">Суми</option>
                                <option value="Чернігів" selected>Чернігів</option>
                                <option value="Вінниця">Вінниця</option>
                            </c:when>
                            <c:when test="${param.direction=='Вінниця'}">
                                <option value ="none">Direction</option>
                                <option value="Одеса<">Одеса</option>
                                <option value="Запоріжжя">Запоріжжя</option>
                                <option value="Донецьк">Донецьк</option>
                                <option value="Харків">Харків</option>
                                <option value="Кіровоград">Кіровоград</option>
                                <option value="Полтава">Полтава</option>
                                <option value="Суми">Суми</option>
                                <option value="Чернігів">Чернігів</option>
                                <option value="Вінниця" selected>Вінниця</option>
                            </c:when>
                            <c:otherwise>
                                <option value ="none" selected>Direction</option>
                                <option value="Одеса<">Одеса</option>
                                <option value="Запоріжжя">Запоріжжя</option>
                                <option value="Донецьк">Донецьк</option>
                                <option value="Харків">Харків</option>
                                <option value="Кіровоград">Кіровоград</option>
                                <option value="Полтава">Полтава</option>
                                <option value="Суми">Суми</option>
                                <option value="Чернігів">Чернігів</option>
                                <option value="Вінниця">Вінниця</option>
                            </c:otherwise>
                        </c:choose>
                    </select></div>
            </div>

        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block">Save</button>
        </div>
    </form>
    <div class="text-center">Return to <a href="${pageContext.request.contextPath}/userOrders">main page</a>?</div>
</div>
</body>
</html>
