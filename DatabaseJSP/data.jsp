<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<body>
<sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/test"
         user = "root"  password = "ssn"/>
<sql:query dataSource = "${snapshot}" var = "result">
            select * from student;
         </sql:query>
<table border = "1" width = "100%">
         <tr>
            <th>rollno</th>
            <th>name</th>
            <th>marks</th>
         </tr>
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td> <c:out value = "${row.rollno}"/></td>
               <td> <c:out value = "${row.name}"/></td>
               <td> <c:out value = "${row.marks}"/></td>
            </tr>
         </c:forEach>
      </table>
</body>
</html>
