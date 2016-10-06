<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안내페이지</title>
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/common.css" />
<script type="text/javascript">
	$(document).ready(function() {
		/* 영화관안내 메뉴 클릭시 처리 이벤트 */
		$("#infoForm").click(function() {
			location.href = "/movie/infoForm.do";
		});
	});
</script>
<style>
#info_map {
	width: 727px;
	height: 668px;
	margin: 0 auto;
}

#info_pic {
	background-color: black;
	width: 900px;
	height: 1700px;
	margin: 0 auto;
	margin-top: 16px;
}

.info_pic1 {
	float: left;
}

.info_pic2 {
	float: left;
}

.info_pic3 {
	float: left;
}
</style>
</head>
<body id="InfoPage">

	<div id="wrapper">

		<header id="main_header">
			<div>
				<a href="/"><img class="main_logo"
					src="../../resources/images/eclipse.png"></a>
			</div>
			<ul>
				<li id="infoForm">영화관안내</li>
				<li>고객센터</li>
				<li>로그인</li>
				<li>회원가입</li>
			</ul>
		</header>

		<div id="main_blank"></div>

		</br>
		<p>찾아오시는 길</p>
		</br>
		</br>
		<div id="info_map">
			<img class="info_map" src="../../resources/images/info_map.jpg">
		</div>

		</br>
		</br>
		</br>
		<p>편의시설 및 영화관 구조</p>
		</br>
		</br>
		<div id="info_pic">
			<img class="info_pic1" src="../../resources/images/info_pic1.png">
			</br>
			</br>
			</br> <img class="info_pic2" src="../../resources/images/info_pic2.png">
			</br>
			</br>
			</br> <img class="info_pic3" src="../../resources/images/info_pic3.png">
		</div>

		<footer id="main_footer">
			<img class="footer_logo" src="../../resources/images/eclipse.png">

			<pre>
		서울시 성동구 도선동 39-1 신방빌딩 4, 5층 미래능력개발교육원
        	대표자명 양현진 | 개인정보관리책임자 영업본부 본부장 배석화
         	사업자등록번호 123-45-67890 | 통신판매업신고번호 제 호옹이 
         	<b>전화번호 02-441-6006</b>

       		Copyright 2016 by EclipseCinema. All rights reserved
			</pre>
		</footer>

	</div>

</body>
</html>