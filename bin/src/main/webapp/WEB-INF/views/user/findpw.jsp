<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
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
	<%@ include file="/common/styleheader.jsp"%>
	<div class="card-body p-0">
		<!-- Nested Row within Card Body -->
		<div class="row">
			<div class="col-lg-6">
				<div class="p-5">
					<div class="text-center">
						<h1 class="h4 text-gray-900 mb-4">비밀번호를 찾기 위한 데이터 입력</h1>
					</div>
					<form class="user" action="" method="POST" id="form-find" name="form-find">
						<input type="hidden" name="act" value="findUser">
						<input type="text"
							class="form-group form-control form-control-user" id="userId" name="userid"
							required placeholder="아이디" required> <input type="text"
							class="form-group form-control form-control-user" id="userName" name="username"
							required placeholder="이름"  required >
						<div class="input-group mb-3">
							<input type="text" class="form-control form-control-user"
								placeholder="이메일아이디" aria-label="Username" name="emailid"  required >
								<span class="input-group-text">@</span>
							<select class="form-select" aria-label="Default select example" name="emaildomain"  required >
								<option selected>선택</option>
								<option value="ssafy.com">싸피</option>
								<option value="google.com">구글</option>
								<option value="naver.com">네이버</option>
								<option value="kakao.com">카카오</option>
							</select>
						</div>
						</select> <input type="submit" value="유저 검색" id="btn-find"
							class="form-group btn btn-warning btn-user btn-block">
					</form>
					<hr>
					<div class="text-center">
						<a class="small" href="${root}/user?act=mvlogin">로그인</a> &nbsp;&nbsp;&nbsp;
						<a class="small" href="${root}/user?act=mvjoin">회원가입</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
	 document.querySelector("#btn-find").addEventListener("click", function () {
          let form = document.querySelector("#form-find");
          form.setAttribute("action", "${root}/user");
          form.submit();
	 });
	</script>
	<%@ include file="/common/footer.jsp"%>