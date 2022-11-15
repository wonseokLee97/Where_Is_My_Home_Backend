<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>

		<!-- Page Wrapper -->
		<div id="wrapper">

			<!-- Sidebar -->
			<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

				<!-- Sidebar - Brand -->
				<a class="sidebar-brand d-flex align-items-center justify-content-center" href="/">
					<div class="sidebar-brand-text mx-3">구해줘 홈즈</div>
				</a>

				<!-- Divider -->
				<hr class="sidebar-divider my-0">

				<!-- Divider -->
				<hr class="sidebar-divider">

				<!-- Heading -->
				<div class="sidebar-heading">실거래가 조회</div>

				<!-- Nav Item - Tables -->
				<li class="nav-item"><a class="nav-link" href="#"> <i class="fas fa-fw fa-table"></i> <span>아파트별 상세
							검색</span></a></li>

				<li class="nav-item"><a class="nav-link" href="${root}/home/deal"> <i class="fas fa-fw fa-table"></i> <span>아파트별
							매매가 검색</span></a></li>
				
				<li class="nav-item"><a class="nav-link" href="${root}/home/add"> <i class="fas fa-fw fa-table"></i> <span>관심지역</span></a></li>
				
				
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
					<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

						<%@ include file="/WEB-INF/views/common/confirm.jsp" %>

					</nav>
					<!-- End of Topbar -->

					<!-- Begin Page Content -->
					<div class="container-fluid">

						<!-- Page Heading -->
						<h1 class="h3 mb-2 text-gray-800">지도</h1>
						<div id="map" style="width: 100%; height: 350px;"></div>
						<!-- <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
						For more information about DataTables, please visit the <a target="_blank"
							href="https://datatables.net">official DataTables documentation</a>.</p> -->

						<!-- DataTales Example -->
						<div class="card shadow mb-4">
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary">아파트 매매 정보</h6>
							</div>
							<div class="card-body">

								<div class="row justify-content-center">
									<div class="col-lg-8 col-md-10 col-sm-12">
										<form class="d-flex" id="form-search" action="">
											<input type="hidden" id="act" name="act" value="list">
											<input type="hidden" id="donginfo" name="donginfo">
											<div>
												<select id="sido" class="custom-select custom-select-sm form-control form-control-sm">
													<option value="">시도선택</option>
												</select> <select id="gugun" name="gugun"
													class="custom-select custom-select-sm form-control form-control-sm">
													<option value="">구군선택</option>
												</select> <select id="dong" name="dong"
													class="custom-select custom-select-sm form-control form-control-sm">
													<option value="">동선택</option>
												</select>
												<!--<select id="year" name="year"
											class="custom-select custom-select-sm form-control form-control-sm"></select>
										<select id="month" name="month"
											class="custom-select custom-select-sm form-control form-control-sm">
											<option value="">매매월선택</option>
										</select>-->
											</div>
											<div>
												<button id="btn-add" class="btn btn-outline-primary" type="button">등록</button>
											</div>
										</form>
									</div>
									<table class="table table-hover">
										<thead>
											<tr class="text-center">
												<th scope="col">시,도</th>
												<th scope="col">구,군</th>
												<th scope="col">동</th>
												<th scope="col">삭제</th>
											</tr>
										</thead>
										<tbody class="home-list"></tbody>
									</table>
								</div>
								<div class="row">
									<ul class="pagination justify-content-center" id="pagination">
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- End of Main Content -->

		<!-- Footer -->
		<footer class="sticky-footer bg-white">
			<div class="container my-auto">
				<div class="copyright text-center my-auto">
					<span>Copyright &copy; ssafy 8th 2022</span>
				</div>
			</div>
		</footer>
		<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

		</div>
		<!-- End of Page Wrapper -->

		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i class="fas fa-angle-up"></i>
		</a>

		<script src="/assets/js/regcode.js"></script>

		<!-- Kakao map -->
		<script type="text/javascript"
			src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d78ec103e48aa2fe673ee006385cc58f&libraries=services"></script>
		<script src="/assets/js/map.js"></script>

		<!-- Bootstrap core JavaScript-->
		<script src="/assets/vendor/jquery/jquery.min.js"></script>
		<script src="/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

		<!-- Custom scripts for all pages-->
		<script src="/assets/js/sb-admin-2.min.js"></script>

		<script>
			sendRequest("sido", "*00000000");
			loadTable();
			
			document.querySelector("#btn-add").addEventListener("click", function () {
				addTable();
			});

			function addTable() {
				let form = document.querySelector("#form-search");
				let dongSel = document.querySelector("#dong");
				let dongCode = dongSel[dongSel.selectedIndex].value;
				document.querySelector("#donginfo").setAttribute("value",
					dongSel[dongSel.selectedIndex].innerHTML);
				const payload = new FormData(document.querySelector("#form-search"));
				
				fetch('${root}/home/favorite?dong=' + dongCode, {
					method: 'POST',
					headers: {
						'Content-Type': 'application/x-www-form-urlencoded'
					},
				})
				
					loadTable();
			}
			
			function loadTable() {
				fetch('${root}/home/favorite', { 
						method: 'GET',
						headers: {
							'Content-Type': 'application/x-www-form-urlencoded'
						},
					})
					.then(res => res.json())
					.then(homes => {
						let tbody = document.querySelector("tbody");
						tbody.innerHTML = "";
						
						for (let i = 0; i < homes.length; i++) {
							tbody.innerHTML += createHTMLRow(homes[i]);
						}
					})
					.catch(() => {
						let tbody = document.querySelector("tbody");
						tbody.innerHTML = "";
					});
			}
			
			function deleteTable(el) {
		        let id = el.parentNode.parentNode.getAttribute("data-id");
				
				fetch('${root}/home/favorite/' + id, { 
					method: 'DELETE',
					headers: {
						'Content-Type': 'application/x-www-form-urlencoded'
					},
				})
				
					
				loadTable();
			}
			
			
			

			function createHTMLRow(home) {
				return '<tr id=' + home['dongCode'] + ' data-id=' + home['dongCode'] + ' style="" class="text-center"><td>' + home['sidoName'] + '</td><td>' + home['gugunName'] +
					'</td><td>' + home['dongName'] + '</td>' + 
					'<td><button type="button" class="modifyBtn btn btn-primary btn-sm" onclick="deleteTable(this);">삭제</button></td>' + '</tr>';
			}

		</script>
		</body>

		</html>