<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 등록 화면</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript">
	$(function() {
		/* 저장 버튼 클릭 시 처리 이벤트 */
		$("#movieInsertBtn")
				.click(
						function() {
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
								/* 배열내의 값을 찾아서 인덱스를 반환(요소가 없을 경우-1반환)
								jQuery.inArray(찾을 값, 검색 대상의 배열)*/
								var ext = $('#file').val().split('.').pop()
										.toLowerCase();
								if (jQuery.inArray(ext, [ 'gif', 'png', 'jpg',
										'jpeg' ]) == -1) {
									alert('gif,png,jpg,jpeg 파일만 업로드 할수 있습니다.');
									return;
								}
								$("#f_writeForm").attr({
									"method" : "POST",
									"action" : "/movie/movieInsert.do"
								});
								$("#f_writeForm").submit();
							}
						});

		/* 목록 버튼 클릭 시 처리 이벤트 */
		$("#movieListBtn").click(function() {
			location.href = "/movie/movieList.do";
		});
	});
</script>
</head>
<body>

	<div class="contentContainer">
		<div class="contentTit">
			<h3>영화 등록</h3>
		</div>

		<div class="contentTB">
			<form id="f_writeForm" name="f_writeForm"
				enctype="multipart/form-data">
				<input type="hidden" name="csrf" value="${CSRF_TOKEN}" />
				<table id="movieWrite">
					<colgroup>
						<col width="17%" />
						<col width="83%" />
					</colgroup>

					<tr>
						<td>영화 상영등급</td>
						<td><input type="text" name="m_grade" id="m_grade"></td>
					</tr>
					<tr>
						<td>영화 제목</td>
						<td><input type="text" name="m_title" id="m_title"></td>
					</tr>
					<tr>
						<td>영화 줄거리</td>
						<td height="200"><textarea name="m_summary" id="m_summary"
								rows="10" cols="70"></textarea></td>
					</tr>
					<tr>
						<td>영화 감독</td>
						<td><input type="text" name="m_director" id="m_director"></td>
					</tr>					
					<tr>
						<td>영화 주연</td>
						<td><input type="text" name="m_star" id="m_star"></td>
					</tr>
					<tr>
						<td>영화 조연</td>
						<td><input type="text" name="m_support" id="m_support"></td>
					</tr>
					<tr>
						<td>영화 상영시간</td>
						<td><input type="text" name="m_runningtime"
							id="m_runningtime"></td>
					</tr>
					<tr>
						<td>영화 개봉일</td>
						<td><input type="text" name="m_releasedate"
							id="m_releasedate"></td>
					</tr>
					<tr>
						<td>영화 나라</td>
						<td><input type="text" name="m_country" id="m_country"></td>
					</tr>
					<tr>
						<td>영화 장르</td>
						<td><input type="text" name="m_genre" id="m_genre"></td>
					</tr>					
					<tr>
						<td>영화 평점</td>
						<td><input type="text" name="m_score" id="m_score"></td>
					</tr>					
					<tr>
						<td class="ac">포스터첨부파일</td>
						<td><input type="file" name="file" id="file"></td>
					</tr>
					<tr>
						<td>예고편 URL</td>
						<td><input type="text" name="m_preview" id="m_preview"></td>
					</tr>
				</table>
			</form>
		</div>

		<div id="movieBut">
			<input type="button" value="저장" class="but" id="movieInsertBtn">
			<input type="button" value="목록" class="but" id="movieListBtn">
		</div>
</body>
</html>