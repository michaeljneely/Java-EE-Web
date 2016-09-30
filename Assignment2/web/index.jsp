<%-- 
    Document   : index
    Created on : Sep 21, 2016, 6:49:20 PM
    Author     : Michael Neely - 13100590
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Email Distribution List</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="mystyle.css">
    </head>
    <body>
        <div class="jumbotron text-center">
            <div class="container align-center">
                <div class="well">
                    <div>
                    <h1> Distribution List System</h1>
                    <hr>
                    <h2>Select an Action </h2>
                    <%
                        //Display Session Message if there is one
                        String display = (session.getAttribute("message") == null) ? "hidden" : "";%>
                    <div<%=display%>>
                        <%if (session.getAttribute("message") != null) {%>
                        <p> <%=session.getAttribute("message")%> </p>
                        <%}%>
                    </div>
                    <a class="btn btn-info" href="${pageContext.request.contextPath}/DistributionListServlet"> Get the Distribution List </a>
                    <a class="btn btn-info" href="${pageContext.request.contextPath}/addUser.html"> Add an Email to the List </a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
