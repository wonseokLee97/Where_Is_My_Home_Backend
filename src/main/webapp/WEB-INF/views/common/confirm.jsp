<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class="row justify-content-end">
	  <div class="">
		<strong>${userinfo.userName}</strong> (${userinfo.userId})님 안녕하세요.<br />
		<a href="${root}/user/logout">로그아웃</a>&nbsp;&nbsp;&nbsp;
		<a href="${root}/user/user">내 정보 조회</a><br />
	  </div>
	</div>