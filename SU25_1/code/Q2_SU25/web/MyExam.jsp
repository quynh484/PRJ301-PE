<%-- 
    Document   : MyExam
    Created on : Nov 2, 2025, 9:23:25 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <form action="execute" method="post">
            <table border="0">

                <tbody>
                    <tr>
                        <td>Enter height: </td>
                        <td><input type="text" name="height" id="height"></td>
                        <td>cm</td>
                    </tr>
                    <tr>
                        <td>Enter weight:</td>
                        <td><input type="text" name="weight" id="weight"></td>
                        <td>kg</td>
                    </tr>
                    <tr>
                        <td>Result: </td>
                        <td><input type="text" value="${txtOutput}" id="txtOutput"></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="BMI" id="btnBMI"></td>
                        <td></td>
                    </tr>          
                </tbody>
            </table>
        </form>
        <div id="txtError">${err}</div>

        <br/>
        
        Body Mass Index (BMI):

        <table border="1">
            <thead>
                <tr>
                    <th>Height</th>
                    <th>Weight</th>
                    <th>BMI</th>
                    <th>Conclude</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${sessionScope.list}" var="o" varStatus="i">
                <tr>
                    <td id="td_${i.index +1}_1">${o.height}</td>
                    <td id="td_${i.index +1}_2">${o.weight}</td>
                    <td id="td_${i.index +1}_2">${o.bmi}</td>
                    <td id="td_${i.index +1}_3">${o.conclude}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
