<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<form action="${pageContext.request.contextPath}/admin/category/insert" method="post">
  <label for="categoryname">Category name:</label><br>
  <input type="text" id="categoryname" name="categoryname"><br>
  <label for="image">Images:</label><br>
  <input type="file" id="image" name="image"><br>
  <label for="status">Status:</label><br>
  <input type="text" id="status" name="status"><br>

  <br> <input type="submit" value="Submit">
</form> 