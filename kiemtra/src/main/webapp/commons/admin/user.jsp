<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp" %>
    <!-- BEGIN Header -->

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
    <!-- Header END -->