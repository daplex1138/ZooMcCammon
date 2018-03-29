<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Zoo List</title>
<style>
table, th, td {
    border: 1px solid black;
}
</style>
</head>
<body>
<form method ="post" action="editZooServlet">
<table>
<tr>
<th>Select</th>
 <th>Zoo Keeper</th>
   <th>Zoo Name</th>
   <th>Open Time</th>
   <th>Close Time</th>      
 </tr>
<c:forEach items="${requestScope.allItems}" var="currentitem">
<tr>
<td><input type="radio" name="id" value="${currentitem.id}"></td>
<td>${currentitem.zooKeeper}</td>
<td>${currentitem.nameOfZoo}</td>
<td>${currentitem.openTime}</td>
<td>${currentitem.closeTime}</td>
<%--<td><fmt:setLocale value = "en_US"/>
<fmt:formatNumber value = "${currentitem.value}" type = "currency"/></td>--%>
</tr>
</c:forEach>
</table>
<input type="submit" value="Edit Selected Zoo" name="doThisToItem">
<input type="submit" value="Delete Selected Zoo" name="doThisToItem">
<input type="submit" value="Add New Zoo" name="doThisToItem">
</form>
</body>
</html>