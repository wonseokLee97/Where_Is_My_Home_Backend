<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
<%@ include file="/common/styleheader.jsp" %>

          <h2 class="my-3 py-3 shadow-sm bg-light text-center">
            <mark class="sky">글쓰기</mark>
          </h2>
        </div>
        <div class="col-xl-10 col-lg-12 col-md-9">
          <form id="form-register" method="POST" action="">

            <div class="mb-3">
              <label for="subject" class="form-label">제목 : </label>
              <input
                type="text"
                class="form-control"
                id="subject"
                name="subject"
                placeholder="제목..."
              />
            </div>
            <div class="mb-3">
              <label for="contents" class="form-label">내용 : </label>
              <textarea class="form-control" id="contents" name="content" rows="7"></textarea>
            </div>
            <div class="col-auto text-center">
              <button type="button" id="btn-register" class="btn btn-outline-primary mb-3">
                글작성
              </button>
              <button type="button" id="btn-list" class="btn btn-outline-danger mb-3">
                목록으로이동...
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>

    <script>
      document.querySelector("#btn-register").addEventListener("click", function () {
        if (!document.querySelector("#subject").value) {
          alert("제목 입력!!");
          return;
        } else if (!document.querySelector("#contents").value) {
          alert("내용 입력!!");
          return;
        } else {
          let form = document.querySelector("#form-register");
          form.setAttribute("action", "${root}/board?act=write&curId=${userinfo.userId}&curName=${userinfo.userName}");
          form.submit();
        }
      });
      
      document.querySelector("#btn-list").addEventListener("click", function () {
    	if(confirm("취소를 하시면 작성한 글은 삭제됩니다.\n취소하시겠습니까?")) {
			location.href="${root}/board?act=list";
   	    }
      });
    </script>
<%@ include file="/common/footer.jsp" %>
