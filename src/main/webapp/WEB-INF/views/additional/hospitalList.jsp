<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/styleheader.jsp"%>


<h2 class="my-3 py-3 shadow-sm bg-light text-center">${keytarget} 안심 병원 정보</h2>
</div>
<div class="row">
	<div class="row align-self-center mb-2">
		<table class="table table-hover">
            <thead>
              <tr class="text-center">
                <th scope="col">병원명</th>
                <th scope="col">주소</th>
                <th scope="col">전화번호</th>
              </tr>
            </thead>
            <tbody>
			<c:forEach var="hospital" items="${hlist}">
              <tr class="text-center">
                <td scope="row">${hospital.hospitalName}</td>
                <td>${hospital.address}</td>
                <td>${hospital.tel}</td>
              </tr>
			</c:forEach>	
            </tbody>
          </table>
	</div>

</div>

</div>
</div>



<%@ include file="/WEB-INF/views/common/footer.jsp"%>