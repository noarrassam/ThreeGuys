<%-- 
    Document   : index
    Created on : 27-Apr-2021, 11:15:07 AM
    Author     : noorr
--%>

<%@page import="interfaceapp.Car"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page import="Helper.ConvHtml"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome, ${param.id}</title>
          <link rel="stylesheet" href="style.css">
    </head>
        <body>
            <%@ include file="/_shared/userbar.jsp"%>
            <c:if test="${empty sessionScope.uid}">
            <p style="color:red;">Unauthorized</p>
        </c:if>
        <c:if test="${not empty sessionScope.uid}">
        <br />
        <h2>Cars Web Service</h2>
        <form action="CarSearchServlet" method="POST" enctype="multipart/form-data">
            <table>
                <tr>
                    <td><input type="hidden" name="id" value="${list.id}"/></td>
                </tr>
                <tr>
                    <td>Brand:</td>
                    <td><input type="text" name="brand" value="${list.brand}"/></td>
                </tr>
                <tr>
                    <td>Model:</td>
                    <td><input type="text" name="model" value="${list.model}"/></td>
                </tr>
                <tr>
                    <td>Engine:</td>
                    <td><input type="text" name="engine" value="${list.engine}" /></td>
                </tr>
                <tr>
                    <td>Transmission:</td>
                    <td><input type="text" name="transmission" value="${list.transmission}" /></td>
                </tr>
                <tr>
                    <td>Year:</td>
                    <td><input type="number" name="year" value="${list.year}" /></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><input type="number" name="price" value="${list.price}" /></td>
                </tr>
                <tr>
                    <td>Upload Image:</td>
                    <td><input type="file" name="fileToUpload" id="fileToUpload" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="Submit" name="operation" value="Add" />
<!--                        <input type="Submit" name="operation" value="Edit" />
                        <input type="Submit" name="operation" value="Delete" />-->
                    </td>
                </tr>                
            </table>
        </form>
    </c:if>
    </body>
</html>
