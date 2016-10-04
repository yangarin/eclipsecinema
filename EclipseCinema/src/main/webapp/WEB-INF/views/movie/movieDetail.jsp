<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 상세 보기</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript">
	var butChk = 0; // 수정버튼과 삭제버튼을 구별하기 위한 변수

	$(function() {
		$("#pwdChk").hide();

		/* 첨부파일 이미지 보여주기 위한 속성 추가 */
		var file = "<c:out value='${detail.m_file}' />";
		if (file != "") {
			$("#fileImage").attr({
				src : "/uploadStorage/${detail.m_file}",
				width : "450px",
				height : "200px"
			});
		}

		/* 수정 버튼 클릭 시 처리 이벤트 */
		$("#updateForm").click(function() {
			/* $("#pwdChk").show();
			$("#msg").text("작성시 입력한 비밀번호를 입력해 주세요.").css("color", "#000099"); */
			butChk = 1;
			goUrl = "/movie/updateForm.do";
			$("#f_data").attr("action", goUrl);
			$("#f_data").submit();
		});

		/* 삭제 버튼 클릭 시 처리 이벤트 */
		$("#movieDelete").click(function() {
			/* $("#pwdChk").show();
			$("#msg").text("작성시 입력한 비밀번호를 입력해 주세요.").css("color", "#000099"); */
			butChk = 2;
			goUrl = "/movie/movieDelete.do";
			$("#f_data").attr("action", goUrl);
			$("#f_data").submit();
		});

		/* 비밀번호 확인 버튼 클릭 시 처리 이벤트 */
		/* $("#pwdBut").click(function() {
			pwdConfirm();
		}); */

		/* 목록 버튼 클릭 시 처리 이벤트 */
		$("#movieList")
				.click(
						function() {
							location.href = "/movie/movieList.do?page=${param.page}&pageSize=${param.pageSize}";
						});
	});

	/* 비밀번호 클릭시 실질적인 처리 함수 */
	/* function pwdConfirm() {
		 if (!chkSubmit($('#m_pwd'), "비밀번호를"))
			return;
		else { 
			$.ajax({
				 url : "/movie/pwdConfirm.do", //전송 url
				type : "POST", // 전송 시 method 방식
				data : $("#f_pwd").serialize(), //폼전체 데이터 전송
				error : function() { //실행시 오류가 발생하였을 경우
					alert('시스템 오류 입니다. 관리자에게 문의 하세요');
				}, //정상적으로 실행이 되었을 경우
				success : function(resultData) {
					var goUrl = ""; // 이동할 경로를 저장할 변수
					if (resultData == 0) { // 일치하지 않는 경우
						$("#msg").text("작성시 입력한 비밀번호가 일치하지 않습니다.").css("color",
								"red");
						$("#b\m_pwd").select();
					} else if (resultData == 1) { // 일치할 경우 
						$("#msg").text("");
						if (butChk == 1) {
							goUrl = "/movie/updateForm.do";
						} else if (butChk == 2) {
							goUrl = "/movie/movieDelete.do";
						}
						$("#f_data").attr("action", goUrl);
						$("#f_data").submit();
					 } 
				 } 
			});
		 } 
	} */
</script>
</head>
<body>

	<
	<div id="boardTit">
		<h3>영화 상세</h3>
	</div>
	<form name="f_data" id="f_data" method="POST">
		<input type="hidden" name="m_num" id="m_num" value="${detail.m_num}" />
	</form>

	<%-- ========= 비밀번호 확인 버튼 및 버튼 추가 시작 ====== --%>
	<table id="moviePwdBut">
		<tr>
			<td id="btd1">
				<div id="pwdChk">
					<form name="f_pwd" id="f_pwd">
						<input type="hidden" name="m_num" id="m_num"
							value="${detail.m_num}" /> <label for="m_pwd" id="l_pwd">비밀번호
							: </label> <input type="password" name="m_pwd" id="m_pwd" /> <input
							type="button" id="pwdBut" value="확인" /> <span id="msg"></span>
					</form>
				</div>
			</td>
			<td id="btd2"><input type="button" value="수정" id="updateForm">
				<input type="button" value="삭제" id="movieDelete"> <input
				type="button" value="목록" id="movieList"></td>
		</tr>
	</table>
	<%-- ========= 비밀번호 확인 버튼 및 버튼 추가 종료 ====== --%>

	<%-- =============== 상세 정보 보여주기 시작 ============ --%>
	<div id="movieDetail">
		<table>
			<colgroup>
				<col width="25%" />
				<col width="25%" />
				<col width="25%" />
				<col width="25%" />
			</colgroup>
			<tbody>
				<tr>
					<td class="ac">상영등급</td>
					<td>${detail.m_grade}</td>
					<td class="ac">작성일</td>
					<td>${detail.m_date}</td>
				</tr>
				<tr>
					<td class="ac">제목</td>
					<td colspan="3">${detail.m_title}</td>
				</tr>
				<tr class="ctr">
					<td class="ac">내용</td>
					<td colspan="3">${detail.m_summary}</td>
				</tr>
				<tr>
					<td class="ac">감독</td>
					<td colspan="3">${detail.m_director}</td>
				</tr>
				<tr>
					<td class="ac vm">첨부파일 이미지</td>
					<td colspan="3"><img id="fileImage"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<%-- =============== 상세 정보 보여주기 종료 ============ --%>
	
<jsp:include page="reply.jsp"></jsp:include>
</body>
</html>