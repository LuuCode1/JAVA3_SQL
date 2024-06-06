<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
<p>Hello</p>
<input type="button" onclick="location.href='http://localhost:8080/create'" value="create"/>
<p></p>
<form method="post" action="seach">
    <input type="text" name="name"> <span><button type="submit">Tìm Kiếm</button> </span>
</form>
<p></p>
<form method="post" action="sorts">
    <button type="submit">Sắp xếp</button> </span>
</form>
<p></p>
<table border="1">
    <tr>
        <th>id</th>
        <th>nameOrder</th>
        <th>quantity</th>
        <th>price</th>
        <th>nameCustomer</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Action</th>
    </tr>
    <c:forEach var="order" items="${order}">
        <tr>
            <td>${order.id}</td>
            <td>${order.nameorder}</td>
            <td>${order.quantity}</td>
            <td>${order.price}</td>
            <td>${order.customer.name}</td>
            <td>${order.customer.phone}</td>
            <td>${order.customer.email}</td>
            <td><input type="button" onclick="location.href ='http://localhost:8080/delete?id=${order.id}'" value="xoá">
                <input type="button" onclick="location.href ='http://localhost:8080/update?id=${order.id}'" value="Sửa">
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>