<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<%@ include file="/common/styleheader.jsp"%>


<h2 class="my-3 py-3 shadow-sm bg-light text-center">${keytarget} 환경 점검 정보</h2>
</div>
<div class="row">
	<div class="row align-self-center mb-2">
		<table class="table table-hover">
            <thead>
              <tr class="text-center">
                <th scope="col">점검 정보</th>
                <th scope="col">점검 종류</th>
                <th scope="col">주소</th>
              </tr>
            </thead>
            <tbody>
			<c:forEach var="pollution" items="${plist}">
              <tr class="text-center">
                <td scope="row">${pollution.pollName}</td>
                <td>${pollution.category}</td>
                <td>${pollution.address}</td>
              </tr>
			</c:forEach>	
            </tbody>
          </table>
	</div>

</div>

</div>
</div>



<%@ include file="/common/footer.jsp"%>