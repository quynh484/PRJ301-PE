<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <body>

        <form action="post" method="post">
            <input type="hidden" name="action" value="add">

            <table border="0">
                <tbody>
                    <tr>
                        <td>Account:</td>
                        <td>
                            <select name="account">
                                <c:forEach var="o" items="${listAccount}">
                                    <option ${o.account == account ? "selected" :""}>${o.account}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="text" name="password" value="${password}" required></td>
                        <td style="color: red">${err}</td>

                    </tr>
                    <tr>
                        <td>Your comment:</td>
                        <td><input type="text" name="comment" value="${comment}" required></td>
                        <td></td>

                    </tr>
                    <tr>
                        <td><input type="submit" value="POST"></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </form>

        <table border="1" cellpadding="5">
            <tr>
                <th>Comment</th>
                <th>Account</th>
                <th>Comment date</th>
            </tr>

            <c:forEach var="o" items="${list}">
                <tr>
                    <td>${o.comment}</td>
                    <td>${o.account}</td>
                    <td>${o.date}</td>
                </tr>
            </c:forEach>
        </table>


</html>
