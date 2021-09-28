<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add Account</title>
    </head>
    <body>
        <c:url var="add_account_url" value="/web/account/addAccount"/>
        <form:form action="${add_account_url}" method="post" modelAttribute="account">
            <form:label path="firstName">firstName: </form:label> <form:input type="text" path="firstName"/>
            <form:label path="lastName">lastName: </form:label> <form:input type="text" path="lastName"/>
            <form:label path="email">Email: </form:label> <form:input path="email"/>
            <input type="submit" value="submit"/>
        </form:form>
    </body>
</html>