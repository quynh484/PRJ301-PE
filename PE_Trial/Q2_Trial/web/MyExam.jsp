<%-- 
    Document   : MyExam
    Created on : Nov 2, 2025, 8:51:52 PM
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
                        <td>Enter an integer a:</td>
                        <td><input type="text" name="txta" id="txta"></td>
                    </tr>
                    <tr>
                        <td>Enter an integer b:</td>
                        <td><input type="text" name="txtb" id="txtb"></td>
                    </tr>
                    <tr>
                        <td>Result:</td>
                        <td><input  readonly type="text" name="txtOutput" id="txtOutput"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="SHOW PRIME" id="btnSum"></td>
                        <td></td>
                    </tr>   

                </tbody>
            </table>
            <div id="txtError">${err}</div>
        </form>
        <br/>
        List of Executions:
        <table border="1">
            <thead>
                <tr>
                    <th>a</th>
                    <th>b</th>
                    <th>Result</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="o" varStatus="i">
                    <!--todo: them id-->
                    <tr>
                        <td id="td_${i.index +1}_1">${o.a}</td>
                        <td id="td_${i.index +1}_2">${o.b}</td>
                        <td id="td_${i.index +1}_3">${o.result}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
