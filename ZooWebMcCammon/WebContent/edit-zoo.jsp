<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Zoo</title>
</head>
<body>
<form action ="EditZooFieldsServlet" method ="post">
Zoo Keeper: <input type="text" name="zooKeeper" value="${itemToEdit.zooKeeper}">
Zoo Name: <input type="text" name="nameOfZoo" value="${itemToEdit.nameOfZoo}">
Open Time: <input type="text" name="openTime" value="${itemToEdit.openTime}">
Close Time: <input type="text" name="closeTime" value="${itemToEdit.closeTime}">
<input type="hidden" name="id" value="${itemToEdit.id}">
<input type="submit" value="Save Edited Item">
</form>

</body>
</html>