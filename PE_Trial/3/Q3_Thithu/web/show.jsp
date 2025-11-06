<%-- 
    Document   : show
    Created on : Nov 6, 2025, 9:20:49 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Customer Page</title>
    </head>
    <body>
        <form action="show">
            Customer name:
            <input type="text" name="search" value="${param.search}" id="txtName">
            <input type="submit" value="Filter by name" id="btnFilter">
            <br>
            <br>

            List of Customers:
            <br>

            <table border="1" cellpadding="5">
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Date of birth</th><th>Gender</th><th>Address</th><th></th>
                </tr>

                <c:forEach var="o" items="${list}" varStatus="i">
                    <tr>
                        <td id="td_code_${o.code}">${o.code}</td>
                        <td id="td_name_${o.code}">${o.name}</td>
                        <td id="td_dob_${o.code}">${o.dob}</td>
                        <td id="td_gender_${o.code}">${o.gender}</td>
                        <td id="td_address_${o.code}">${o.address}</td>
                        <td>
                            <a id="td_delete_${o.code}" href="show?action=delete&code=${o.code}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>

    </body>
</html>
