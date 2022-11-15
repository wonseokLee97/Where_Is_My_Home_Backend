<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }"></c:set>
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
<title>구해줘 홈즈</title>
</head>
<body id="page-top">
	<%@ include file="/WEB-INF/views/common/styleheader.jsp"%>
	<c:if test="${!empty msg2}">
		<script>
			alert("${msg2}");
		</script>
	</c:if>

	<c:choose>
		<c:when test="${empty userinfo}">
			<c:if test="${cookie.ssafy_id.value ne null}">
				<c:set var="idck" value=" checked"></c:set>
				<c:set var="svid" value="${cookie.ssafy_id.value}"></c:set>
			</c:if>
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-8 col-md-10 col-sm-12">

						<div class="card-body p-0">
							<!-- Nested Row within Card Body -->
							<div class="row">
								<div class="col-lg-12">
									<div class="p-4">
										<div class="text-center">
											<h1 class="h2 text-gray-900 mb-4">로그인</h1>
										</div>
										<form id="form-login" class="user" action="" method="POST"
											name="loginForm">
											<div class="form-check mb-3 float-end">
												<input class="form-check-input" type="checkbox" value="ok"
													id="saveid" name="saveid" ${idck} /> <label
													class="form-check-label" for="saveid"> 아이디저장 </label>
											</div>

											<input type="text"
												class="form-control form-control-user form-group"
												id="userid" name="userid" aria-describedby="emailHelp"
												placeholder="아이디" required autofocus value="${svid}">
											<input type="password"
												class="form-control form-control-user form-group"
												id="userpwd" name="userpwd" placeholder="비밀번호" required>
										</form>
										<button type="button" id="btn-login"
											class="btn btn-primary btn-user btn-block">Login</button>
										<hr>
										<div class="text-danger mb-2">${msg}</div>
										<div class="col-auto text-center">
											<a class="small" id="btn-mv-join"
												href="${root}/user/findpw">비밀번호 찾기</a>
											&nbsp;&nbsp;&nbsp; <a class="small" id="btn-mv-findpw"
												href="${root}/user/join">회원가입</a>
										</div>
									</div>
								</div>
							</div>
						</div>


					</div>
				</div>
			</div>
			
						<script>
				//로그인
				document.querySelector("#btn-login").addEventListener("click",
						function() {
							if (!document.querySelector("#userid").value) {
								alert("아이디 입력!!");
								return;
							} else if (!document.querySelector("#userpwd").value) {
								alert("비밀번호 입력!!");
								return;
							} else {
								let form = document.querySelector("#form-login");
								form.setAttribute("action", "${root}/user/login");
								form.submit();
							}
						});
			</script>
		</c:when>
		<c:otherwise>
			<div class="container">

				<h1 class="h3 mb-4 text-gray-800">페이지 소개</h1>
				<div class="row g-5">
					<div class="col-md-5">
						<img src="${root}/resources/apartment.jpg" alt="아파트"
							style="width: 100%">
					</div>

					<div class="col-md-7">
						<p>
							<strong>구해줘 홈즈</strong> 는 아파트/다세대주택 별, 매매/전,월세 별 거래 내역 정보와 주택 정보를
							제공하는 사이트입니다.
						</p>
						<h4>주 기능</h4>
						<ol class="list-group list-group-numbered">
							<li
								class="list-group-item d-flex justify-content-between align-items-start">
								<div class="ms-2 me-auto">
									<strong class="fw-bold">아파트 동 선택 조회</strong><br> 메인 페이지에서
									바로 원하는 동네를 검색하여 매매 정보를 조회할 수 있습니다.
								</div>
							</li>
							<li
								class="list-group-item d-flex justify-content-between align-items-start">
								<div class="ms-2 me-auto">
									<strong class="fw-bold">회원 관리 서비스</strong><br> 기본적인 회원
									정보(등록/수정/삭제) 서비스를 제공합니다.
								</div>
							</li>
							<li
								class="list-group-item d-flex justify-content-between align-items-start">
								<div class="ms-2 me-auto">
									<strong class="fw-bold">관심 지역 주변 데이터 검색 기능</strong><br> 서울특별시 내 특정 구역에서 주변 상권 / 환경 점검 / 안심 병원 / 코로나 선별 진료소 정보를 확인할 수 있습니다.
								</div>
							</li>
						</ol>
					</div>

				</div>
			</div>


		</c:otherwise>
	</c:choose>
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>