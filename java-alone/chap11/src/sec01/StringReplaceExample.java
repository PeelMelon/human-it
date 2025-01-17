package sec01;

public class StringReplaceExample {

	public static void main(String[] args) {
		// replace 메소드 사용
		String oldstr = "자바는 객체 지향 언어 입니다. 자바는 풍부한 API를 지원합니다.";
		String newstr = oldstr.replace("자바", "JAVA"); // 바꿔야하는 문자 왼쪽, 바꿀 문자 오른쪽
	
		System.out.println(oldstr);
		System.out.println(newstr);
	
		// 문자열 잘라내기로 substring메소드 사용
		String ssn = "880815-1234567";
		
		String firstNum = ssn.substring(0, 6); // 왼쪽은 시작 인덱스 번호, 오른쪽은 가져올 만큼 문자열의 인덱스 번호
		System.out.println(firstNum); // 880815
		
		String secondNum = ssn.substring(7); // 시작 인덱스 번호부터끝의 인덱스 번호까지 무자열 가져오기
		System.out.println(secondNum); // 1234567
		
		
	}
}


