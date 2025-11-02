<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="add">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Enter player code:</td>
                        <td><input type="text" name="code"></td>
                    </tr>
                    <tr>
                        <td>Enter player name:</td>
                        <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td>Choose an position:</td>
                        <td>
                            <input type="radio" name="pos" value="Striker"> Striker
                            <input type="radio" name="pos" value="Midfielder"> Midfielder
                            <input type="radio" name="pos" value="Defender"> Defender
                        </td>
                    </tr>
                    <tr>
                        <td>Enter shirt number:</td>
                        <td><input type="text" name="shirtNum"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="ADD"></td>
                        <td>${err}</td>
                    </tr>
                </tbody>
            </table>
        </form>

        <table border="1">
            <thead>
                <tr>
                    <th>Player code</th>
                    <th>Player name</th>
                    <th>Position</th>
                    <th>Shirt number</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="p" >
                    <tr>
                        <td>${p.code}</td>
                        <td>${p.name}</td>
                        <td>${p.pos}</td>
                        <td>${p.shirt_num}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
