<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Animal List</title>
<style>
table, th, td {
    border: 1px solid black;
}
</style>
</head>
<body>
<form method ="post" action="EditAnimalServlet">
<table>
<tr>
<th>Select</th>
<th>id</th>
 <th>Name</th>
   <th>Weight</th>
   <th>Length</th>
   <th>Height</th>
	<th>Diet</th>
	<th>Nocturnal</th>
	<th>Gender Id</th>
	<th>Lays Eggs?</th>
	<th>Animal Type</th>
	<th>Zoo</th> 
 </tr>
<c:forEach items="${requestScope.allItems}" var="currentitem">
<tr>
<td><input type="radio" name="animalId" value="${currentitem.id}"></td>
<td>${currentitem.id}</td>
<td>${currentitem.name}</td>
<td>${currentitem.weight}</td>
<td>${currentitem.length}</td>
<td>${currentitem.height}</td>
<td>${currentitem.diet}</td>
<td>${currentitem.isNocturnal}</td>
<td>${currentitem.gender}</td>
<td>${currentitem.laysEggs}</td>
<td>${currentitem.animalType}</td>
<td>${currentitem.zoo.nameOfZoo}</td>
<%--<td><fmt:setLocale value = "en_US"/>
<fmt:formatNumber value = "${currentitem.value}" type = "currency"/></td>--%>
</tr>
</c:forEach>
</table>
<input type="submit" value="Edit Selected Animal" name="doThisToItem">
<input type="submit" value="Delete Selected Animal" name="doThisToItem">
<input type="submit" value="Add New Animal" name="doThisToItem">
</form>
</body>
</html>