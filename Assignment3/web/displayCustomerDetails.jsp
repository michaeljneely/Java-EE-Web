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
        <title>${param.cname}</title>
        <%@include file="header.jsp"%>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center"> Customer Details : ${param.cname}</h1>
            <hr>
            <table class="table table-striped table-hover">
                <tbody>
                    <%--
                    Loop over customers list in session
                    Find customer that matches passed customer number
                    Display that customer's details
                    --%>
                    <c:forEach var="cus" items="${customers}">
                        <c:if test="${param.cnum == cus.customerNumber}">
                            <tr>
                                <td><h3>Contact</h3></td>
                                <td><h3>${cus.contactLastName}
                                        ${cus.contactFirstName}</h3></td>
                            </tr>
                            <tr>
                                <td><h3>Phone</h3></td>
                                <td><h3>${cus.phone}</h3></td> 
                            </tr>
                            <tr>
                                <td><h3>Address</h3></td>
                                <td>
                                    <h3>
                                        ${cus.addressLine1}
                                        <c:if test="${cus.addressLine2 != null}">
                                            <br>${cus.addressLine2}
                                        </c:if>
                                        <br>${cus.city}
                                        <c:if test="${cus.state != null}">
                                            <br>${cus.state}
                                        </c:if>
                                        <br>${cus.country}
                                    </h3>
                                </td> 
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table>
            <a href="displayCustomerSummary.jsp" class="btn btn-info">Back</a>
        </div>
    </body>
</html>