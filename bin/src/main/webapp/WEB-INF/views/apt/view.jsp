<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>

  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${root}/index.jsp">
        <div class="sidebar-brand-text mx-3">구해줘 홈즈</div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        실거래가 조회
      </div>

      <!-- Nav Item - Tables -->
      <li class="nav-item">
        <a class="nav-link" href="#">
          <i class="fas fa-fw fa-table"></i>
          <span>아파트 상세 검색</span></a>
      </li>

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

          <%@ include file="/common/confirm.jsp"%>

        </nav>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->          
        <div class="container-fluid">
          
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">아파트 매매 정보</h6>
            </div>
            <div class="card-body">
            
      <div class="row justify-content-center">
        <div class="col-lg-8 col-md-10 col-sm-12">
        
	  <h2>아파트 정보 상세보기</h2>
	  	<input type="hidden" name="action" value="productUpdate">
	    <div class="">
	      <table class="table">
	      <tr>
	      <th>동</th>
	      <td>${home.dong}</td>
	      </tr>
	      <tr>
	      <th>아파트 이름</th>
	      <td>${home.aptName}</td>
	      </tr>
	      <tr>
	      <th>거래금액</th>
	      <td>${home.dealAmount}</td>
	      </tr>
	      <tr>
	      <th>건축년도</th>
	      <td>${home.buildYear}</td>
	      </tr>
	      <tr>
	      <th>거래날짜</th>
	      <td>${home.dealYear}-${home.dealMonth}-${home.dealDay}</td>
	      </tr>
	      <tr>
	      <th>전용면적</th>
	      <td>${home.area}</td>
	      </tr>
	      <tr>
	      <th>층</th>
	      <td>${home.floor}</td>
	      </tr>
	      <tr>
	      <th>지번</th>
	      <td>${home.jibun}</td>
	      </tr>
	      </table>
	    </div>
        </div>
      </div>
    </div>
    <form id="form-no-param" method="get" action="${root}/board">
      <input type="hidden" id="act" name="act" value="view">
      <input type="hidden" id="pgno" name="pgno" value="1">
      <input type="hidden" id="key" name="key" value="">
      <input type="hidden" id="word" name="word" value="">
      <input type="hidden" id="articleno" name="articleno" value="">
    </form>

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
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>
  
  <script src="${root}/assets/js/date.js"></script>
  <script src="${root}/assets/js/regcode.js"></script>

  <!-- Bootstrap core JavaScript-->
  <script src="${root}/assets/vendor/jquery/jquery.min.js"></script>
  <script src="${root}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="${root}/assets/js/sb-admin-2.min.js"></script>

  <script>
    sendRequest("sido", "*00000000");
  
    let titles = document.querySelectorAll(".article-title");
    titles.forEach(function (title) {
      title.addEventListener("click", function () {
     	document.querySelector("#articleno").value = this.getAttribute("data-no");
    	document.querySelector("#form-no-param").submit();
      });
    });
  
    document.querySelector("#btn-search").addEventListener("click", function () {
	    let form = document.querySelector("#form-search");
	    let dongSel = document.querySelector("#dong");
        document.querySelector("#donginfo").setAttribute("value", dongSel[dongSel.selectedIndex].innerHTML);
        form.setAttribute("action", "${root}/home");
        form.submit();
    });
</script>
</body>
</html>