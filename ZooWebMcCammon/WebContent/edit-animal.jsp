<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit animal</title>
</head>
<body>
<form action ="EditAnimalFieldsServlet" method ="post">
Name: <input type="text" name="name" value="${itemToEdit.name}">
Weight: <input type="text" name="weight" value="${itemToEdit.weight}">
Length: <input type="text" name="length" value="${itemToEdit.length}">
Height: <input type="text" name="height" value="${itemToEdit.height}">
<label>Diet:</label>
				<select name="dietTypes">			
					<c:forEach items="${requestScope.dietTypes}" var="currentitem">
						<option value="${currentitem.diet}">${currentitem.diet}</option>
					</c:forEach>
				</select>  <br />
			<label>Nocturnal:</label>
				<select name="nocturnal">			
						<option value=0>false</option>
						<option value=1>true</option>
				</select>  <br />
			<label>Lays Eggs:</label>
				<select name="laysEggs">			
						<option value=0>false</option>
						<option value=1>true</option>
				</select>  <br />
<label>Gender:</label>
				<select name="gender">			
					<c:forEach items="${requestScope.genders}" var="currentitem">
						<option value="${currentitem.gender}">${currentitem.gender}</option>
					</c:forEach>
				</select>  <br />
<label>Animal Class: </label>
			<select name="animalType" onchange="jsFunction(this.value);">
				<option value=0>----</option>			
				<c:forEach items="${requestScope.animalTypes}" var="currentitem">
					<option value="${currentitem.id}">${currentitem.animal_type}</option>
				</c:forEach>
			</select>  <br />
<label>Zoo:</label>
<c:choose>
				<c:when test="${empty requestScope.allZoos}">
					<span>There are currently no zoos in the database</span><br />
				</c:when>
				<c:otherwise>
					<select name="zoo">	
						<option value=0>----</option>		
						<c:forEach items="${requestScope.allZoos}" var="currentitem">
							<option value="${currentitem.id}">${currentitem.nameOfZoo}</option>
						</c:forEach>
					</select>  <br />
	  			</c:otherwise>
  			</c:choose><br />
<input type="hidden" name="animalId" value="${itemToEdit.id}">
<input type="submit" value="Save Edited Item">
</form>

</body>
</html>