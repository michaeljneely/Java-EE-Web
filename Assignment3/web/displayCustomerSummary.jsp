<%-- 
CT5106 Assignment 3
Author: Michael Neely 13100590
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Summary</title>
         <%@include file="header.jsp"%>
    </head>
    <body>
        <h1 class="text-center">Customer Information Summary </h1>
        <hr>
        <div class="container">
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>Number</th>
                        <th>Name</th>
                        <th>City</th>
                        <th>Credit Limit</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <%--Loop over customers list in session and display all in formatted table --%>
                    <c:forEach var="cus" items="${customers}">
                        <tr>
                            <td>${cus.customerNumber}</td> 
                            <td>${cus.customerName}</td>
                            <td>${cus.city}</td> 
                            <td>${cus.creditLimit}</td>
                            <td>
                                <%--Form with hidden inputs to pass customer name and number to next page --%>
                                <form action="displayCustomerDetails.jsp" method="post">
                                    <input type="hidden" name="cnum" value="${cus.customerNumber}"/>
                                    <input type="hidden" name="cname" value="${cus.customerName}"/>
                                    <button type="submit" class="btn btn-info">Details</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>