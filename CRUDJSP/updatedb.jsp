<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
 
<html>
    <body>
        
        <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost/test"
                           user="root"  password="ssn"/>
 
 
        <sql:update dataSource="${snapshot}" var="result">
            update student set name=?,marks=? where rollno=?;
            <sql:param value="${param.name}" />
	    <sql:param value="${param.marks}" />
	    <sql:param value="${param.rollno}" />
        </sql:update>
	<c:if test="${result>=1}">
            <c:out value="Data updated successfully"/>
        </c:if> 
    </body>
</html>
