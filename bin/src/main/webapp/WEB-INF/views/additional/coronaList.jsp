<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/styleheader.jsp"%>


<h2 class="my-3 py-3 shadow-sm bg-light text-center">${keytarget} 코로나 선별 진료소 정보</h2>
</div>
<div class="row">
	<div class="row align-self-center mb-2">
		<table class="table table-hover">
            <thead>
              <tr class="text-center">
                <th scope="col">진료소명</th>
                <th scope="col">주소</th>
                <th scope="col">전화번호</th>
              </tr>
            </thead>
            <tbody>
			<c:forEach var="corona" items="${clist}">
              <tr class="text-center">
                <td scope="row">${corona.hospitalName}</td>
                <td>${corona.address}</td>
                <td>${corona.tel}</td>
              </tr>
			</c:forEach>	
            </tbody>
          </table>
	</div>

</div>

</div>
</div>




<%@ include file="/WEB-INF/views/common/footer.jsp"%>