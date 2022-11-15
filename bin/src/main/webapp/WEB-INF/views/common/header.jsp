<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- jstl 환경설정 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 변수 선언 jstl tag -->
<c:set var="root" value="${pageContext.request.contextPath}/WEB-INF/views"/>
<!-- user info 객체 lookup
   scope객체를 지정하지 않으면 자동으로 순서대로 lookup
   현재페이지 -> requsetScope -> sessionScope -> applicationScope
 -->
<c:if test="${empty userinfo}">
	<script type="text/javascript">
		alert("로그인 후 이용 가능한 페이지입니다.");
		location.href = "${root}/user?act=mvlogin";
	</script>
</c:if>
<!DOCTYPE html>
<html lang="ko">
  <head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<link href="${root}/assets/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="${root}/assets/css/sb-admin-2.css" rel="stylesheet">
<link href="${root}/assets/css/app.css" rel="stylesheet" />
<style>
    #sido, #gugun, #dong, #year, #month{
      width: 15%;
      margin: 10px;
    }
  </style>
<title>구해줘 홈즈</title>
</head >
  <body id="page-top">