<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tag" uri="/WEB-INF/tld/custom_tag.tld"%>
<c:if test="${csrfError != null}">
	<c:remove var="csrfError" />
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 목록</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		/* 검색 후 검색 대상과 검색 단어 출력 */
		if ("<c:out value='${data.keyword}' />" != "") {
			$("#keyword").val("<c:out value='${data.keyword}' />");
			$("#search").val("<c:out value='${data.search}' />");
		}

		/* 한페이지에 보여줄 레코드 수 조회 후 선택한 값 그대로 유지하기 위한 설정*/
		if ("<c:out value='${data.pageSize}' />" != "") {
			$("#pageSize").val("<c:out value='${data.pageSize}' />");
		}

		/* 검색 대상이 변경될 때마다 처리 이벤트 */
		$("#search").change(function() {
			if ($("#search").val() == "all") {
				$("#keyword").val("글 목록 전체 조회");
			} else if ($("#search").val() != "all") {
				$("#keyword").val("");
				$("#keyword").focus();
			}
		});

		/* 검색 버튼 클릭 시 처리 이벤트 */
		$("#searchData").click(function() {
			if ($("#search").val() != "all") {
				if (!chkSubmit($('#keyword'), "검색어를"))
					return;
			}
			goPage(1);
		});

		/* 한페이지에 보여줄 레코드 수를 변경될 때마다 처리 이벤트 */
		$("#pageSize").change(function() {
			goPage(1);
		});

		/* 제목 클릭시 상세 페이지 이동을 위한 처리 이벤트 */
		$(".goDetail").click(function() {
			var m_num = $(this).parents("tr").attr("data-num");
			$("#m_num").val(m_num);
			console.log("글번호 : " + m_num);
			// 상세 페이지로 이동하기 위해 form 추가 (id : detailForm)
			$("#detailForm").attr({
				"method" : "get",
				"action" : "/movie/movieDetail.do"
			});
			$("#detailForm").submit();
		});

		/* 글쓰기 버튼 클릭 시 처리 이벤트*/
		$("#InsertFormBtn").click(function() {
			location.href = "/movie/writeForm.do";
		});
	});

	/* 정렬 버튼 클릭 시 처리 함수 */
	function setOrder(order_by) {
		$("#order_by").val(order_by);
		if ($("#order_sc").val() == 'DESC') {
			$("#order_sc").val('ASC');
		} else {
			$("#order_sc").val('DESC');
		}
		goPage(1);
	}

	/* 검색과 한 페이지에 보여줄 레코드 수 처리 및 페이징을 위한 실질적인 처리 함수 */
	function goPage(page) {
		if ($("#search").val() == "all") {
			$("#keyword").val("");
		}
		$("#page").val(page);
		$("#f_search").attr({
			"method" : "get",
			"action" : "/movie/movieList.do"
		});
		$("#f_search").submit();
	}

	/* 정렬 및 검색 시 실질적인 처리 함수 */
	/* function goPage(page) {
		$("#page").val(page);
		$("#f_search").attr("method", "POST");
		$("#f_search").attr("action", "/movie/movieList.do");
		$("#f_search").submit();
	} */

	/* 상세 페이지 이동 함수 (location 객체로 이동 url은 한라인으로 작성할것) */
	/* function goDetail(m_num, page, pageSize) {
		location.href = "/movie/movieDetail.do?m_num=" + m_num + "&page="
				+ page + "&pageSize=" + pageSize;
	} */
</script>
</head>
<body>

	<div id="moviehome">
		<h2>
			<a href="/">초기화면으로(index페이지)</a>
		</h2>
	</div>
	<div id="movieTit">
		<h3>글목록</h3>
	</div>

	<h3>영화 리스트</h3>
	<%-- ========= 상세 페이지 이동을 위한 FORM ============= --%>
	<form name="detailForm" id="detailForm">
		<input type="hidden" name="m_num" id="m_num"> <input
			type="hidden" name="page" value="${data.page}"> <input
			type="hidden" name="pageSize" value="${data.pageSize}">
	</form>

	<%-- ============== 검색기능 시작(이 부분을 추가하면 된다) ============= --%>
	<div id="movieSearch">
		<form id="f_search" name="f_search">
			<input type="hidden" id="page" name="page" value="${data.page}" /> <input
				type="hidden" id="order_by" name="order_by" value="${data.order_by}" />
			<input type="hidden" id="order_sc" name="order_sc"
				value="${data.order_sc}" />
			<table border="0" summary="검색">
				<colgroup>
					<col width="70%"></col>
					<col width="30%"></col>
				</colgroup>
				<tr>
					<td id="btd1"><label>검색조건</label> <select id="search"
						name="search">
							<option value="all">전체</option>
							<option value="m_title">제목</option>
							<option value="m_director">감독</option>
							<option value="m_grade">상영등급</option>
					</select> <input type="text" name="keyword" id="keyword" value="검색어를 입력하세요" />
						<input type="button" value="검색" id="searchData" /></td>
					<td id="btd2">한 페이지에 <select id="pageSize" name="pageSize">
							<option value="10">10줄</option>
							<option value="20">20줄</option>
							<option value="30">30줄</option>
							<option value="50">50줄</option>
							<option value="70">70줄</option>
							<option value="100">100줄</option>
					</select>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<%-- ================== 검색기능 종료 ================= --%>

	<%-- =================== 리스트 시작 ================== --%>
	<div id="movieList">
		<table cellspacing="0" cellpadding="0" summary="게시판 리스트">
			<colgroup>
				<col width="15%" />
				<col width="40%" />
				<col width="15%" />
				<col width="15%" />
				<col width="15%" />
			</colgroup>
			<thead>
				<tr>
					<th><a href="javascript:setOrder('m_num');">글번호 <c:choose>
								<c:when
									test="${data.order_by=='m_num' and data.order_sc=='ASC'}">▲</c:when>
								<c:when
									test="${data.order_by=='m_num' and data.order_sc=='DESC'}">▼</c:when>
								<c:otherwise>▲</c:otherwise>
							</c:choose>
					</a></th>
					<th>영화제목</th>
					<th><a href="javascript:setOrder('m_date');">등록일 <c:choose>
								<c:when
									test="${data.order_by=='m_date' and data.order_sc=='ASC'}">▲</c:when>
								<c:when
									test="${data.order_by=='m_date' and data.order_sc=='DESC'}">▼</c:when>
								<c:otherwise>▲</c:otherwise>
							</c:choose>
					</a></th>
					<th>상영등급</th>
					<th>감독</th>
				</tr>
			</thead>
			<tbody>
				<!-- 데이터 출력 -->
				<c:choose>
					<c:when test="${not empty movieList}">
						<c:forEach var="movie" items="${movieList}" varStatus="status">
							<tr class="tac" data-num="${movie.m_num}">
								<td>${count - (status.count-1)}</td>
								<td class="tal"><span class="goDetail">${movie.m_title}</span>
								</td>
								<td>${movie.m_date}</td>
								<td>${movie.m_grade}</td>
								<td>${movie.m_director}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="4" align="tac">등록된 게시물이 존재하지 않습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
	<%-- =================== 리스트 종료 ================== --%>
	<%-- ================ 글쓰기 버튼 출력 시작 =============== --%>
	<div id="contentBtn">
		<input type="button" value="영화 등록" id="InsertFormBtn">
	</div>
	<%-- ================ 글쓰기 버튼 출력 종료 =============== --%>

	<%-- ================ 페이지 네비게이션 시작 =============== --%>
	<div id="moviePage">
		<tag:paging page="${param.page}" total="${total}"
			list_size="${data.pageSize}" />
	</div>
	<%-- ================ 페이지 네비게이션 시작 =============== --%>


</body>
</html>