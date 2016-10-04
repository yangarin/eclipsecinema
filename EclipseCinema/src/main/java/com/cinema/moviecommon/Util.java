package com.cinema.moviecommon;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

	public static int nvl(String text) {
		return nvl(text, 0);
	}

	/***********************************************************
	 * nvl() 메서드는 문자열을 숫자로 변환하는 메서드. *
	 * 
	 * @param (숫자로
	 *            변환할 문자열, 초기값으로 사용할 값(대체값)) 참고 : 예외 처리는 체크예외와 비체크예외로 구분. 체크 예외는
	 *            파일입출력 / 네트워크 입출력 / 데이터베이스 입출력. 나머지는 비체크 예외로 인식.
	 * @return int
	 ***********************************************************/
	public static int nvl(String text, int def) {
		int ret = def;
		try {
			ret = Integer.parseInt(text);
		} catch (Exception e) {
			ret = def;
		}
		return ret;
	}

	public static String nvl(Object text, String def) {
		if (text == null || "".equals(text.toString().trim())) {
			return def;
		} else {
			return text.toString();
		}
	}

	/***********************************************************
	 * verify() 메서드는 입력값에 대한 유효성 체크 메서드.
	 * 
	 * @param (유효성
	 *            패턴 , 패턴을 비교할 입력값) 참고 : . : 임의의 한문자 / ? : 문자가 존재하지 않거나 하나의 문자 /
	 *            * : 문자가 존재하지 않거나 하나 이상 반복 / + : 문자가 한번 이상 반복 (?=pattern) or
	 *            연산으로 정의된 패턴과 일치하는 문자열 / (?:pattern) 패턴의 일부를 or문자(|)를 사용해 결합 예시
	 *            : 이메일 유효성 체크 - ^[a-zA-Z0-9]+@[a-zA-Z0-9.]+$ 핸드폰 번호 유효성 체크 -
	 *            ^01(?:0|1|[6-9])-(?:\d{3,4})-\d{4}$
	 * @return boolean
	 ***********************************************************/
	/*public static boolean verify(String pwdPolicy, String password) {
		Pattern pattern = Pattern.compile(pwdPolicy);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}*/

}
