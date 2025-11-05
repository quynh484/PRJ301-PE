<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <body>

        <form method="get" action="list">
            Search:
            <input type="text" name="search" value="${param.search}" id="txtName">
            <input type="submit" value="Filter by name" id="btnFilter">
        </form>

            <form action="list" id="filterForm">
            <input type="text" name="action" hidden value="sort">

            <!-- Sort theo name -->
            <span>Sort by name:</span>
            <input type="radio" name="sortName" value="asc" checked> Asc
            <input type="radio" name="sortName" value="desc"> Desc

            <br>

            <!-- Sort theo address -->
            <span>Sort by address:</span>
            <input type="radio" name="sortAddress" value="asc" checked> Asc
            <input type="radio" name="sortAddress" value="desc"> Desc

            <br>
            <button type="button" onclick="applyFilter()">Sort</button>
        </form>
        <br>


        <table border="1" cellpadding="5">
            <tr>
                <th>Code</th><th>Name</th><th>DOB</th><th>Gender</th><th>Address</th><th>Action</th>
            </tr>

            <c:forEach var="o" items="${list}">
                <tr>
                    <td id="td_code_${o.code}">${o.code}</td>
                    <td id="td_name_${o.code}">${o.name}</td>
                    <td id="td_dob_${o.code}">${o.dob}</td>
                    <td id="td_gender_${o.code}">${o.gender}</td>
                    <td id="td_address_${o.code}">${o.address}</td>
                    <td>
                        <a id="td_delete_${o.code}" href="list?action=delete&code=${o.code}">Delete</a>

                        <a href="list?action=delete&code=${o.code}" onclick="return confirm('Ban co chac chan?')">
                            Delete with confirm
                        </a>

                        <a href="list?action=edit&code=${o.code}" id="td_edit_${o.code}">Edit</a>
                    </td>
                </tr>
            </c:forEach>
        </table>



        <h3>Add new customer</h3>
        <form action="list" method="post">
            <input type="hidden" name="action" value="add">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Code:</td>
                        <td><input type="text" name="code" required></td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name" required></td>
                    </tr>
                    <tr>
                        <td>Gender:</td>
                        <td><select name="gender">
                                <option value="0">Male</option>
                                <option value="1">Female</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td>DOB:</td>
                        <td><input type="date" name="dob" required></td>
                    </tr>
                    <tr>
                        <td>Address:</td>
                        <td><input type="text" name="address" value="${editObj.address}" required></td>
                    </tr>
                </tbody>
            </table>

            <input type="submit" value="Add">
        </form>
        <hr>


        <c:if test="${requestScope.editObj != null}">
            <h3>Update customer</h3>
            <form action="list" method="post">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="code" value="${editObj.code}">

                <table border="0">
                    <tbody>
                        <tr>
                            <td>DOB:</td>
                            <td><input type="date" name="dob" value="${editObj.dob}" required></td>
                        </tr>
                        <tr>
                            <td>Gender:</td>
                            <td><input type="text" name="name" value="${editObj.name}" required></td>
                        </tr>
                        <tr>
                            <td>Name:</td>
                            <td><select name="gender">
                                    <option ${editObj.gender == '0' ? 'selected' : ''} value="0">Male</option>
                                    <option ${editObj.gender == '1' ? 'selected' : ''} value="1">Female</option>
                                </select></td>
                        </tr>
                        <tr>
                            <td>Address:</td>
                            <td><input type="text" name="address" value="${editObj.address}" required></td>
                        </tr>
                    </tbody>
                </table>

                <input type="submit" value="Update">
            </form>
            <hr>
        </c:if>
    </body>


    <script>
        function applyFilter() {
            const form = document.getElementById("filterForm");
            form.submit();
        }
    </script>



    <!--    <form action="delete" method="post" class="delete-form">
            <input type="hidden" name="id" value="${o.id}">
            <button type="submit">Xóa</button>
        </form>
    
        <script>
            const forms = document.querySelectorAll('.delete-form');
    
            forms.forEach(f => {
                f.addEventListener('submit', function (e) {
                    if (!confirm("Xác nh?n xóa?")) {
                        e.preventDefault(); // không g?i form
                    }
                });
            });
        </script>-->


</html>
