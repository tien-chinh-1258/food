<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>


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
    <!-- BEGIN FOOTER -->

<footer class="footer">
    <div class="container">
        <p>Họ và tên: [Nguyễn Tiến Chinh]</p>
        <p>MSSV: [18146270]</p>
    </div>
</footer>
    <!-- END FOOTER -->
    
    
    
     <!-- BEGIN User -->
<html>
<head>
    <meta charset="UTF-8">
    <title><sitemesh:write property='title'/></title>
    <link href="${pageContext.request.contextPath}/assets/css/styles.css" rel="stylesheet">
</head>
<body>
    <!-- Include Header -->
    <%@ include file="/commons/header.jsp" %>
    
    <!-- Main Content -->
    <div class="main-content">
        <sitemesh:write property='body'/>
    </div>
    
    <!-- Include Footer -->
    <%@ include file="/commons/footer.jsp" %>
    
    <!-- Scripts -->
    <script src="${pageContext.request.contextPath}/assets/js/scripts.js"></script>
</body>
</html>
    <!-- User END -->   