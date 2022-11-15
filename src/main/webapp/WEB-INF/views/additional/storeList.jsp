<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/styleheader.jsp"%>


<h2 class="my-3 py-3 shadow-sm bg-light text-center">${keytarget} 주변 상권 정보</h2>
</div>
<div class="row">
	<div class="row align-self-center mb-2">
		<table class="table table-hover">
            <thead>
              <tr class="text-center">
                <th scope="col">점포명</th>
                <th scope="col">종류</th>
                <th scope="col">주소</th>
                <th scope="col">층수</th>
              </tr>
            </thead>
            <tbody>
			<c:forEach var="store" items="${slist}">
              <tr class="text-center">
                <td scope="row">${store.storeName}</td>
                <td>${store.category}</td>
                <td>${store.address}</td>
                <td>${store.floor}</td>
              </tr>
			</c:forEach>	
            </tbody>
          </table>
	</div>

</div>

</div>
</div>



<%@ include file="/WEB-INF/views/common/footer.jsp"%>