<%-- 
    Document   : Home
    Created on : 25-Apr-2021, 8:22:15 PM
    Author     : noorr
--%>

<%@page import="interfaceapp.Users"%>
<%@page import="services.IUser"%>
<%@page import="services.UsersImpService"%>
<%@page import="Helper.ConvHtml"%>
<%@page import="interfaceapp.Car"%>
<%@page import="services.ICar"%>
<%@page import="java.util.List"%>
<%@page import="services.CarImpService"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
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
            CarImpService service = new CarImpService();
            ICar port = service.getCarImpPort();
            List<Car> carList = port.getAllCars();

            try {
                out.println(ConvHtml.GetHtml(carList, "Car List"));
            } catch (Exception e) {
                e.printStackTrace();
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
