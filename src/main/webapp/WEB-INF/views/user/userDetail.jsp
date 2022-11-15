<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/styleheader.jsp"%>
<form id="form-modify" method="POST" action="">
	<input type="hidden" name="act" value="">
	<div class="mb-3">
		<label for="username" class="form-label">이름 : </label>
		<input type="text" class="form-control" id="userName" name="userName" value="${userinfo.userName}"/>
	</div>
	<div class="mb-3">
		<label for="userid" class="form-label">아이디 : </label>
		<input type="text" class="form-control" id="userId" name="userId" value="${userinfo.userId}" readonly/>
	</div>
	<div id="idcheck-result"></div>
	<div class="mb-3">
		<label for="userpwd" class="form-label">변경 비밀번호 : </label>
		<input type="password" class="form-control" id="userPwd" name="userPwd"/>
	</div>
	<div class="mb-3">
		<label for="pwdcheck" class="form-label">변경 비밀번호확인 : </label>
		<input type="password" class="form-control" id="pwdcheck"/>
	</div>
	<div class="mb-3">
		<label for="emailid" class="form-label">이메일 : </label>
		<div class="input-group">
			<input type="text" class="form-control" id="emailId" name="emailId"
				value="${userinfo.emailId}" /> <span
				class="input-group-text">@</span> <select class="form-select"
				id="emailDomain" name="emailDomain" aria-label="이메일 도메인 선택">
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
        if (!document.querySelector("#userName").value) {
          alert("이름 입력!!");
          return;
        } else if (!document.querySelector("#userPwd").value) {
          alert("비밀번호 입력!!");
          return;
        } else if (document.querySelector("#userPwd").value != document.querySelector("#pwdcheck").value) {
          alert("비밀번호 확인!!");
          return;
        } else {
	      let modifyinfo = {
	       			  userName: document.querySelector("#userName").value,
	       	          userId: document.querySelector("#userId").value,
	       	          userPwd: document.querySelector("#userPwd").value,
	       	          emailId: document.querySelector("#emailId").value,
	       	          emailDomain: document.querySelector("#emailDomain").value,
	       	};
          let config = {
                  method: "PUT",
                  headers: {
                    "Content-Type": "application/json",
                  },
                  body: JSON.stringify(modifyinfo),
          };
          console.log(modifyinfo);
          fetch(`${root}/user/user`, config)
          .then((response) => response.json())
          
          location.href="${root}/user/home"; 
/*           let form = document.querySelector("#form-modify");
          console.log(document.querySelector("#userPwd").value);
          form.setAttribute("action", "${root}/user/userModify");
          form.submit(); */
        }
        

        
         
      });
      
      document.querySelector("#btn-delete").addEventListener("click", function () {
		if(confirm("정말로 탈퇴하시겠습니까? 정보는 삭제되고 메인 화면으로 돌아갑니다.")){
			alert("탈퇴 처리!!");
			let config = {
	                  method: "DELETE",
	                  headers: {
	                    "Content-Type": "application/json",
	                  },
	          };
			fetch(`${root}/user/user`, config)
			.then((response) => response.json())
			
			location.href="${root}/user/logout";
		}  
        });
    </script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>