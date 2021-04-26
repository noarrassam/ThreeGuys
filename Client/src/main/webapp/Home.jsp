<%-- 
    Document   : Home
    Created on : 25-Apr-2021, 8:22:15 PM
    Author     : noorr
--%>

<%@page import="Helper.ConvHtml"%>
<%@page import="Helper.ConvHtml"%>
<%@page import="interfaceapp.Cars"%>
<%@page import="services.ICars"%>
<%@page import="java.util.List"%>
<%@page import="services.CarsImpService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Service</title>
    </head>
    <body>
        <h1 style="color:blue;">Welcome to Cars Service</h1>

        <%
            CarsImpService service = new CarsImpService();
            ICars port = service.getCarsImpPort();
            List<Cars> carList = port.getAllCars();

            try {
                out.println(ConvHtml.GetHtml(carList, "Car List"));
            } catch (Exception e) {
            }
        %>

        <br/>
        <form action="CarServlet" method="get">
            <input type="text" style="width: 300px" id="search" name="search" placeholder="Enter the service description"/>
            <input type="submit" value="Search" />
        </form>

        <hr/>

        <form action="CarServlet" method="post">
            <input type="submit" value="View Car services statistics" />
        </form>

    </body>
</html>
