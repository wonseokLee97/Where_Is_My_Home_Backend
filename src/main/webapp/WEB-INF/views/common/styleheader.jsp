<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Page Wrapper -->
<div id="wrapper">

	<!-- Sidebar -->
	<ul
		class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
		id="accordionSidebar">

		<!-- /WEB-INF/views/index.jsp -->
		<!-- Sidebar - Brand -->
		<a
			class="sidebar-brand d-flex align-items-center justify-content-center"
			href="/user/home"> <!-- <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div> -->
			<div class="sidebar-brand-text mx-3">구해줘 홈즈</div>
		</a>

		<!-- Divider -->
		<hr class="sidebar-divider my-0">

		<!-- Divider -->
		<hr class="sidebar-divider">

		<!-- Heading -->
		<div class="sidebar-heading">실거래가 조회</div>


		<!-- Nav Item - Tables -->
		<li class="nav-item"><a class="nav-link"
			onclick="location.href='${root}/home/apt'"> <i
				class="fas fa-fw fa-table"></i> <span>아파트별 상세 검색</span></a></li>
		<li class="nav-item"><a class="nav-link" href="${root}/home/deal"> <i class="fas fa-fw fa-table"></i> <span>아파트별
							매매가 검색</span></a></li>

		<li class="nav-item"><a class="nav-link" href="${root}/home/add"> <i class="fas fa-fw fa-table"></i> <span>관심지역</span></a></li>

<!--  		<li class="nav-item"><a class="nav-link"
			onclick="location.href='${root}/board?act=list&pgno=1&key=&word='">
				<i class="fas fa-fw fa-table"></i> <span>공지사항</span>
		</a></li>-->

		<!-- Divider -->
		<hr class="sidebar-divider d-none d-md-block">


		<!-- Sidebar Toggler (Sidebar) -->
		<div class="text-center d-none d-md-inline">
			<button class="rounded-circle border-0" id="sidebarToggle"></button>
		</div>

	</ul>
	<!-- End of Sidebar -->

	<!-- Content Wrapper -->
	<div id="content-wrapper" class="d-flex flex-column">
		<!-- Main Content -->
		<div id="content">
			<!-- Topbar -->
			<nav
				class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
				<div>구해줘 홈즈는 아파트/다세대주택 별, 매매/전,월세 별 거래 내역 정보와 주택 정보를 제공하는
					사이트입니다.</div>

			</nav>
			<!-- End of Topbar -->

			<!-- /.container-fluid -->

			<div class="container">

				<!-- Outer Row -->
				<div class="row justify-content-center">

					<div class="row">
						<c:if test="${!empty userinfo}">
							<%@ include file="/WEB-INF/views/common/confirm.jsp"%>
						</c:if>