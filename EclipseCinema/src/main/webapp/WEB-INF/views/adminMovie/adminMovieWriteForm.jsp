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
	$(document).ready(
			function() {
				$("#adminMovieInsert").click(
						function() {
							$("#adminMovieWriteForm").attr("method", "POST");
							$("#adminMovieWriteForm").attr("action",
									"/adminMovie/adminMovieInsert.do");
							$("#adminMovieWriteForm").submit();
						})
			});
</script>



</head>
<body>
	영화등록 폼
	<form id="adminMovieWriteForm" name="adminMovieWriteForm">
		<table>
			<tr>
				<td>제목 :</td>
				<td><input type="text" id="m_title" name="m_title"></td>
			</tr>
			<tr>
				<td>금액 :</td>
				<td><input type="text" id="m_money" name="m_money"></td>
			</tr>



			<tr>
				<td>감독 :</td>
				<td><input type="text" id="m_director" name="m_director"></td>
			</tr>

			<tr>
				<td>주연 :</td>
				<td><input type="text" id="m_main" name="m_main"></td>
			</tr>

			<tr>
				<td>조연 :</td>
				<td><input type="text" id="m_support" name="m_support"></td>
			</tr>

			<tr>
				<td>상영시간 :</td>
				<td><input type="text" id="m_runningtime" name="m_runningtime"></td>
			</tr>

			<tr>
				<td>개봉일 :</td>
				<td><input type="date" id="m_releasedate" name="m_releasedate"></td>
			</tr>

			<tr>
				<td>줄거리 :</td>
				<td height="200"><textarea name="m_summary" id="m_summary"
						rows="10" cols="70"></textarea></td>
			</tr>

			<tr>
				<td>등급 :</td>
				
				<td><select name="m_grade" id="m_grade">
						<option value="전체관람가">전체관람가</option>
						<option value="12세 이상 관람가">12세 이상 관람가</option>
						<option value="15세 이상 관람가">15세 이상 관람가</option>
						<option value="청소년 관람 불가">청소년 관람 불가</option>
						<option value="제한상영가">제한 상영가</option>
				</select></td>
			</tr>

			<tr>
				<td>개봉나라 :</td>
				<td><input type="text" id="m_country" name="m_country"></td>
			</tr>

			<tr>
				<td>장르 :</td>
				<td><select name="m_genre" id="m_genre">
						<option value="로맨스">로맨스</option>
						<option value="액션">액션</option>
						<option value="코미디">코미디</option>
						<option value="스릴러">스릴러</option>
						<option value="공포">공포</option>
						<option value="SF">SF</option>
						<option value="드라마">드라마</option>
						<option value="로맨틱코미디">로맨틱코미디</option>
				</select></td>
			</tr>

			<tr>
				<td>상영관 :</td>
				<td><select name="m_view" id="m_view">
						<option value="1관">1관</option>
						<option value="2관">2관</option>
						<option value="3관">3관</option>
						<option value="4관">4관</option>
						<option value="5관">5관</option>
				</select></td>
			</tr>


		</table>
	</form>
	<div id="adminBut">
		<input type="button" value="저장" class="but" id="adminMovieInsert">
		<input type="button" value="목록" class="but" id="adminMovieList">
	</div>

</body>
</html>