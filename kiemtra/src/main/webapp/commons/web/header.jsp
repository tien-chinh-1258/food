<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp" %>
    <!-- BEGIN Header -->
<nav class="header-navigation">
    <div class="container">
        <ul class="nav-menu">
            <!-- Common Menu Items -->
            <li><a href="${pageContext.request.contextPath}/home">Trang Chủ</a></li>
            <li><a href="${pageContext.request.contextPath}/products">Sản phẩm</a></li>
            
            <!-- Login/User Info -->
            <c:choose>
                <c:when test="${empty sessionScope.account}">
                    <li><a href="${pageContext.request.contextPath}/login">Đăng nhập</a></li>
                </c:when>
                <c:otherwise>
                    <li>
                        <a href="${pageContext.request.contextPath}/account">
                            ${sessionScope.account.fullname}
                        </a>
                    </li>
                    <!-- Admin Menu -->
                    <c:if test="${sessionScope.account.role == 'ADMIN'}">
                        <li><a href="${pageContext.request.contextPath}/admin">Trang quản trị</a></li>
                    </c:if>
                    <li><a href="${pageContext.request.contextPath}/logout">Đăng xuất</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>
    <!-- Header END -->