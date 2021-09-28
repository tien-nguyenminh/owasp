<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Account</title>
    </head>
    <body>
    	<p>First name: ${account.firstName}<c:out value="${account.firstName}"/></p>
    	<p>Last name: <c:out value="${account.lastName}"/></p>
    </body>
</html>