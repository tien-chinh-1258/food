<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="${pageContext.request.contextPath}/admin/category/insert" method="post" enctype="multipart/form-data">
    <label for="fname">Category name:</label><br>
    <input type="text" id="categoryname" name="categoryname"><br>
    
    <label for="lname">Images:</label><br>
    <c:if test="${not empty cate && not empty cate.images}">
        <img height="150" width="200" src="${cate.images}" />
    </c:if>
    <input type="file" id="images" name="images"><br>
    
    <label for="status">Status:</label><br>
    <select id="status" name="status">
        <option value="1">Hoạt động</option>
        <option value="0">Khóa</option>
    </select><br>

    <br><input type="submit" value="Submit">
</form>
