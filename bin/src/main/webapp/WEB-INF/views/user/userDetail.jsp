<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<%@ include file="/common/styleheader.jsp"%>
<form id="form-modify" method="POST" action="">
	<input type="hidden" name="act" value="userModify">
	<div class="mb-3">
		<label for="username" class="form-label">이름 : </label>
		<input type="text" class="form-control" id="username" name="username" value="${userinfo.userName}"/>
	</div>
	<div class="mb-3">
		<label for="userid" class="form-label">아이디 : </label>
		<input type="text" class="form-control" id="userid" name="userid" value="${userinfo.userId}" readonly/>
	</div>
	<div id="idcheck-result"></div>
	<div class="mb-3">
		<label for="userpwd" class="form-label">변경 비밀번호 : </label>
		<input type="password" class="form-control" id="userpwd" name="userpwd" value=""/>
	</div>
	<div class="mb-3">
		<label for="pwdcheck" class="form-label">변경 비밀번호확인 : </label>
		<input type="password" class="form-control" id="pwdcheck" value=""/>
	</div>
	<div class="mb-3">
		<label for="emailid" class="form-label">이메일 : </label>
		<div class="input-group">
			<input type="text" class="form-control" id="emailid" name="emailid"
				value="${userinfo.emailId}" /> <span
				class="input-group-text">@</span> <select class="form-select"
				id="emaildomain" name="emaildomain" aria-label="이메일 도메인 선택">
				<option selected>${userinfo.emailDomain}</option>
				<option value="ssafy.com">싸피</option>
				<option value="google.com">구글</option>
				<option value="naver.com">네이버</option>
				<option value="kakao.com">카카오</option>
			</select>
		</div>
	</div>
	<div class="col-auto text-center">
		<button type="button" id="btn-modify"
			class="btn btn-outline-primary mb-3">변경</button>
		<button type="button" id="btn-delete"
			class="btn btn-outline-danger mb-3">회원탈퇴</button>
	</div>
</form>
<script>      
      document.querySelector("#btn-modify").addEventListener("click", function () {
        if (!document.querySelector("#username").value) {
          alert("이름 입력!!");
          return;
        } else if (!document.querySelector("#userpwd").value) {
          alert("비밀번호 입력!!");
          return;
        } else if (document.querySelector("#userpwd").value != document.querySelector("#pwdcheck").value) {
          alert("비밀번호 확인!!");
          return;
        } else {
          let form = document.querySelector("#form-modify");
          form.setAttribute("action", "${root}/user");
          form.submit();
        }
      });
      
      document.querySelector("#btn-delete").addEventListener("click", function () {
		if(confirm("정말로 탈퇴하시겠습니까? 정보는 삭제되고 메인 화면으로 돌아갑니다.")){
			alert("탈퇴 처리!!");
			location.href="${root}/user?act=userDelete";
		}  
        });
    </script>
<%@ include file="/common/footer.jsp"%>