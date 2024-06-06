<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
<input type="button" onclick="location.href='http://localhost:8080/home'" value="Exit"/>
<p></p>
<form:form method="post" action="detail" modelAttribute="order">
    <table>
        <tr>
            <td><form:label path="id">id</form:label></td>
            <td><form:input path="id" /></td>
            <td><form:errors path="id" cssStyle="color: red"/></td>
        </tr>
        <tr>
            <td><form:label path="nameorder">name</form:label></td>
            <td><form:select path="nameorder">
                <form:option value="Bánh">Bánh</form:option>
                <form:option value="Gạo">Gạo</form:option>
                <form:option value="Dầu ăn">Dầu ăn</form:option>
            </form:select></td>

        </tr>
        <tr>
            <td><form:label path="quantity">quantity</form:label></td>
            <td><form:input path="quantity" /></td>
            <td><form:errors path="quantity" cssStyle="color: red"/></td>
        </tr>
        <tr>
            <td><form:label path="price">price</form:label></td>
            <td><form:input path="price"/></td>
            <td><form:errors path="price" cssStyle="color: red"/></td>
        </tr>
        <tr>
            <td><form:label path="customer">customer</form:label></td>
            <td>
                <c:forEach items="${customer}" var="customer">
                    <form:select path="customer">
                        <form:option value="${customer.id}">${customer.name}</form:option>
                    </form:select>
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="submit"/></td>

        </tr>
    </table>
</form:form>
</body>
</html>