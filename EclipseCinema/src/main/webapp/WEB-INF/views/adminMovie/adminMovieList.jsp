<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		/*  글쓰기 버튼 클릭 시 처리 이벤트*/
		$("#writeForm").click(function() {
			location.href = "/adminMovie/adminMovieWriteForm.do";
		});
	});
</script>
</head>
<body>
	영화목록
	<div id="adminMovieList">
		<table cellspacing="0" cellpadding="0" summary="등록된 영화 리스트">
			<thead>
				<tr>
					<th>영화등록번호</th>
					<th>제목</th>
					<th>금액</th>
					<th>등급</th>
					<th>상영관</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty adminMovieList}">
						<c:forEach var="adminMovie" items="${adminMovieList}"
							varStatus="status">

							<tr align="center">
								<td>${adminMovie.m_num}</td>
								<td align="left"><a
									href="javascript:goDetail(${board.b_num})">${adminMovie.m_title}</a></td>
								<td>${adminMovie.m_money}</td>
								<td>${adminMovie.m_grade}</td>
								<td>${adminMovie.m_view}</td>
							<td>${adminMovie.m_date}</td>


							</tr>

						</c:forEach>
					</c:when>

					<c:otherwise>
						<tr>
							<td colspan="4" align="center">등록된게시물이 존재하지 않습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>

			</tbody>

		</table>
	</div>


	<div id="adminBut"></div>
	<input type="button" value="영화등록" id="writeForm">


</body>
</html>
