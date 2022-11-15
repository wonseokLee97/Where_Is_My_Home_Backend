<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<%@ include file="/common/styleheader.jsp"%>


<h2 class="my-3 py-3 shadow-sm bg-light text-center">지역 주변 데이터 검색하기</h2>
</div>
<div class="row">
	<div class="row align-self-center mb-2">
		<p>이 페이지에서는 내가 원하는 시/군/구/동을 입력합니다. 입력한 키워드에 해당하는 주변 상권 / 병원 / 코로나
			검사소 / 환경 점검 데이터를 검색합니다. 원하는 항목을 선택하는 해당 분류의 리스트 페이지로 이동합니다. 이 서비스는 현재 데이터가 서울특별시에 한해
			제공되므로, 서울특별시의 주소를 입력하기 바랍니다. (ex : 강남구, 종로구 )</p>
		<form class="d-flex" id="additional-search" method="POST"
			action="${root}/home?act=kmpsearch">
			<input class="form-control me-2" type="search" name="target" 
				placeholder="검색할 시/군/구/동을 입력하세요" aria-label="Search" required>
			<button class="btn btn-success" type="submit">search</button>
		</form>

		<div id="description">
			<c:choose>
				<c:when test="${empty amount or amount == 0}">
					<p>검색된 데이터가 없습니다.</p>
				</c:when>
				<c:otherwise>
					<p>${keytarget} 에 관한 정보가 ${amount } 개 검색되었습니다.</p>
				</c:otherwise>
			</c:choose>
			
		</div>

		<div id="store-list">
			<c:if test="${!empty slist}">
				<a href="${root}/home?act=mvstorelist">주변 상권 데이터가 ${ssize}
					개 검색되었습니다.</a>
			</c:if>
		</div>
		<div id="hospital-list">
			<c:if test="${!empty hlist}">
				<a href="${root}/home?act=mvhospitallist">주변 안심병원 데이터가 ${hsize}
					개 검색되었습니다.</a>
			</c:if>
		</div>
		<div id="corona-list">
			<c:if test="${!empty clist}">
				<a href="${root}/home?act=mvcoronalist">주변 코로나 선별 진료소 데이터가 ${csize}
					개 검색되었습니다.</a>
			</c:if>
		</div>
		<div id="pollution-list">
			<c:if test="${!empty plist}">
				<a href="${root}/home?act=mvpollutionlist">주변 환경 점검 데이터가 ${psize}
					개 검색되었습니다.</a>
			</c:if>
		</div>
	</div>

</div>

</div>
</div>



<%@ include file="/common/footer.jsp"%>