<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <body>
<!--        <td><input type="Submit" name="choice" value="FILTER"></td>
<td><input type="Submit" name="choice" value="SEARCH"></td>-->
        
        

        <form action="search">
            <div class="form-text">
                Choose an option:
            </div>
            <input type="text" hidden="" name="action" value="filter"/>
            <select name="opt" class="form-input">
                <option value="all">All types</option>
                <c:forEach items="${optionList}" var="o">
                    <option value="${o.id}">${o.name}</option>
                </c:forEach>
            </select>
            <input type="submit" value="FILTER" id="btnFilter">
        </form>


        <form action="search">
            <input type="text" hidden="" name="action" value="search"/>

            <div class="form-text">
                Enter a result:
            </div>
            <input type="text" name="keyword" value=""/>
            <input type="submit" value="SEARCH" id="btnSearch">
        </form>




        Result of Filter/Search:
        <table border="1" cellpadding="5">
            <tr>
                <th>ID</th><th>String str</th><th>Option</th>
                <th>Result</th>
            </tr>

            <c:forEach var="o" items="${list}">
                <tr>
                    <td>${o.id}</td>
                    <td >${o.str}</td>
                    <td >${o.opt}</td>
                    <td >${o.re}</td>

                </tr>
            </c:forEach>
        </table>

    </body>


</html>
