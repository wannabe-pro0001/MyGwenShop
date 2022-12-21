<%--
  Created by IntelliJ IDEA.
  User: TOAN
  Date: 12/18/2022
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@include file="/views/common/taglib.jsp"%>--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Site meta -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>GwenShop</title>
    <!-- CSS -->

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/chitiet.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/home.css">
    <dec:head />
</head>
<body>
<jsp:include page="/common/user/header.jsp" />
<dec:body />
<jsp:include page="/common/user/footer.jsp" />
<!-- JS -->
<script src="//code.jquery.com/jquery-3.2.1.slim.min.js"
        type="text/javascript"></script>
<script
        src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        type="text/javascript"></script>
<script
        src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        type="text/javascript"></script>
</body>
</html>