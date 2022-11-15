<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
<%@ include file="/common/styleheader.jsp" %>


          <h2 class="my-3 py-3 shadow-sm bg-light text-center">공지 사항</h2>
        </div>
        <div class="row">
          <div class="row align-self-center mb-2">
            <div class="col-md-2 text-start">
            <c:if test="${userinfo.userId eq 'admin'}">
              <button type="button" id="btn-mv-register" class="btn btn-outline-primary btn-sm">
                	공지사항 작성
              </button>
            </c:if>
            </div>

          </div>
          <table class="table table-hover">
            <thead>
              <tr class="text-center">
                <th scope="col">글번호</th>
                <th scope="col">제목</th>
                <th scope="col">작성자</th>
                <th scope="col">조회수</th>
                <th scope="col">작성일</th>
              </tr>
            </thead>
            <tbody>

			<c:forEach var="dto" items="${articles}">
              <tr class="text-center">
                <th scope="row">${dto.articleNo}</th>
                <td class="text-start">
                  <a
                    href="#"
                    class="article-title link-dark"
                    data-no="${dto.articleNo}"
                    style="text-decoration: none"
                  >
                    	${dto.subject}
                  </a>
                </td>
                <td>${dto.userId}</td>
                <td>${dto.hit}</td>
                <td>${dto.registerTime}</td>
              </tr>
			</c:forEach>
            </tbody>
          </table>
        </div>

      </div>
    </div>
    <form id="form-no-param" method="get" action="${root}/board">
      <input type="hidden" id="act" name="act" value="view">
      <input type="hidden" id="pgno" name="pgno" value="">
      <input type="hidden" id="key" name="key" value="">
      <input type="hidden" id="word" name="word" value="">
      <input type="hidden" id="articleno" name="articleno" value="">
    </form>
    <script>
      let titles = document.querySelectorAll(".article-title");
      titles.forEach(function (title) {
        title.addEventListener("click", function () {
       	  document.querySelector("#articleno").value = this.getAttribute("data-no");
       		document.querySelector("#form-no-param").submit();
        });
      });

      let regist = document.querySelector("#btn-mv-register");
      if(regist != null){
	      regist.addEventListener("click", function () {
	        location.href = "${root}/board?act=mvwrite";
	      });
      }
    </script>
<%@ include file="/common/footer.jsp" %>
