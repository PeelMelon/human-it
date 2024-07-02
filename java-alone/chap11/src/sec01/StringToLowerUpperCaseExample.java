package sec01;

public class StringToLowerUpperCaseExample {

	public static void main(String[] args) {
		String str1 = "JAVA programming";
		String str2 = "java programming";
		
		System.out.println(str1.equals(str2));
		// str1.equals(str2)는 false를 출력,
		// 이는 str1과 str2가 대소문자가 다르기 때문에 문자열이 다르다고 인식
		
		String lowerStr1 = str1.toLowerCase();
		String lowerStr2 = str2.toLowerCase();
		System.out.println(lowerStr1.equals(lowerStr2));
		// str1과 str2를 모두 소문자로 변환한 lowerStr1과 lowerStr2를 비교하면,
		// 둘 다 "java programming"이므로 lowerStr1.equals(lowerStr2)는 true를 출력
		
		System.out.println(str1.equalsIgnoreCase(str2));
		//str1.equalsIgnoreCase(str2)는 대소문자를 무시하고 비교하기 때문에 true를 출력
	}

}
