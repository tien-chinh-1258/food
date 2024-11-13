<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="${pageContext.request.contextPath}/admin/category/update" method="post" enctype="multipart/form-data">
    <input type="text" id="categoryid" name="categoryid" value="${cate.categoryid}" hidden="hidden"><br>
    <label for="categoryname">Category name:</label><br>
    <input type="text" id="categoryname" name="categoryname" value="${cate.categoryname}"><br>
    <label for="image">Images:</label><br>
    
    <c:choose>
        <c:when test="${cate.images.substring(0,5) == 'https'}">
            <c:url value="${cate.images}" var="imgUrl"></c:url>
        </c:when>
        <c:otherwise>
            <c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
        </c:otherwise>
    </c:choose>
    <img height="150" width="200" src="${imgUrl}" /><br>
    
    <input type="file" id="image" name="image"><br>
    
    <label for="status">Status:</label><br>
    <select id="status" name="status">
        <option value="1" ${cate.status == 1 ? 'selected' : ''}>Hoạt động</option>
        <option value="0" ${cate.status != 1 ? 'selected' : ''}>Khóa</option>
    </select><br>

    <br> <input type="submit" value="Submit">
</form>
