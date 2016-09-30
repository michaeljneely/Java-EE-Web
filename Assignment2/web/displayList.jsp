<%-- 
    Document   : displayList
    Created on : Sep 21, 2016, 6:52:32 PM
    Author     : Michael Neely - 1300590
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Distribution List</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="mystyle.css">
    </head>
    <body>
        <div class="jumbotron text-left">
            <div class="container align-center">
                <div class="well">
                    <h1> Distribution List</h1>
                    <hr>
        <% 
            //Get Distribution List
            ArrayList<String> dl = (ArrayList<String>)session.getAttribute("distributionList");
            //Variables to hide the correct element
            String empty = "hidden";
            String showList = "hidden";
            //If list is null or empty, hide its div
            if(dl == null || dl.isEmpty()) empty = "";
            //Otherwise hide the 'distribution list is currently empty' <p> element
            else showList = "";
        %>
        <p <%=empty%>> The distribution list is currently empty </p>
        <div <%=showList%>>
        <% 
            //Print out Distribution List
            if(dl != null){
                for(String s : dl){ %>         
                <p>&bull;&nbsp;<%=s%> </p>
        <%}}%>
        </div>
         <a class="btn btn-info" href="${pageContext.request.contextPath}/addUser.html"> Add an Email to the List </a>
         <a class="btn btn-info" href="${pageContext.request.contextPath}/index.jsp"> Return to Home Page </a>
                </div>
            </div>
        </div>
    </body>
</html>
