<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 수정 화면</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		/* 수정 버튼 클릭 시 처리 이벤트 */
		$("#movieUpdate").click(function() {
			//입력값 체크
			if (!chkSubmit($('#m_grade'), "상영등급을"))
				return;
			else if (!chkSubmit($('#m_title'), "제목을"))
				return;
			else if (!chkSubmit($('#m_summary'), "줄거리를"))
				return;
			else if (!chkSubmit($('#m_director'), "감독을"))
				return;
			else {
				$("#f_writeForm").attr("method", "POST");
				$("#f_writeForm").attr("action", "/movie/movieUpdate.do");
				$("#f_writeForm").submit();
			}
		});
		/* 목록 버튼 클릭 시 처리 이벤트 */
		$("#movieList").click(function() {
			location.href = "/movie/movieList.do";
		});
	});
</script>
</head>
<body>

	<div id="movieTit">
		<h3>글수정</h3>
	</div>

	<form id="f_writeForm" name="f_writeForm">
		<input type="hidden" id="m_num" name="m_num"
			value="${updateData.m_num}" />
		<table cellspacing="0" cellpadding="0" id="boardWrite">
			<tr>
				<td>상영등급</td>
				<td><input type="text" name="m_grade" id="m_grade"
					value="${updateData.m_grade}" /></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="m_title" id="m_title"
					value="${updateData.m_title}" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td height="200"><textarea name="m_summary" id="m_summary"
						rows="10" cols="70">${updateData.m_summary}</textarea></td>
			</tr>
			<tr>
				<td>감독</td>
				<td><input type="text" name="m_director" id="m_director"
					value="${updateData.m_director}" /> <label>수정할 감독을 입력해
						주세요.</label></td>
			</tr>
			<tr>
				<td>주연</td>
				<td><input type="text" name="m_star" id="m_star"
					value="${updateData.m_star}" /></td>
			</tr>
			<tr>
				<td>조연</td>
				<td><input type="text" name="m_support" id="m_support"
					value="${updateData.m_support}" /></td>
			</tr>
			<tr>
				<td>상영시간</td>
				<td><input type="text" name="m_runningtime" id="m_runningtime"
					value="${updateData.m_runningtime}" /></td>
			</tr>
			<tr>
				<td>개봉일</td>
				<td><input type="text" name="m_releasedate" id="m_releasedate"
					value="${updateData.m_releasedate}" /></td>
			</tr>
			<tr>
				<td>나라</td>
				<td><input type="text" name="m_country" id="m_country"
					value="${updateData.m_country}" /></td>
			</tr>
			<tr>
				<td>장르</td>
				<td><input type="text" name="m_genre" id="m_genre"
					value="${updateData.m_genre}" /></td>
			</tr>
			<tr>
				<td>상영관번호</td>
				<td><input type="text" name="m_theaternumber"
					id="m_theaternumber" value="${updateData.m_theaternumber}" /></td>
			</tr>
			<tr>
				<td>평점</td>
				<td><input type="text" name="m_score" id="m_score"
					value="${updateData.m_score}" /></td>
			</tr>			
		</table>
	</form>
	<div id="movieBut">
		<input type="button" value="수정" class="but" id="movieUpdate" /> <input
			type="button" value="목록" class="but" id="movieList" />
	</div>

</body>
</html>