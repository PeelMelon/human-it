package sec02;

public class ArrayReferenceObjectEx {

	public static void main(String[] args) {
		
		String[] strArray = new String[3]; // null
		strArray[0] = "java";
		strArray[1] = "java";
		strArray[2] = new String("java");
		
		System.out.println(strArray[0] == strArray[1]); 	// true
		System.out.println(strArray[0] == strArray[2]); 	// 서로의 다른 주소겂을 가지는 경우 false
		System.out.println(strArray[0].equals( strArray[2]));// 값만 비교할 경우에는 true
		
	}

}
