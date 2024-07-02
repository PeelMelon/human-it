package sec01;

public class StringEqualsEx {

	public static void main(String[] args) {
		String strv1 = "신민철";//String은 참조 타입 (referrance)
		String strv2 = "신민철";
		
		if(strv1 == strv2) { //값이 같으면 true
			System.out.println("strv1과 strv2는 참조가 같음");
			}else {
			System.out.println("strv1과 strv2는 참조가 다름");
			}
		if(strv1.equals(strv2)) {
			System.out.println("strv1과 strv2는 문자열이 같음");
		}
		
		String strv3 = new String("신민철");
		String strv4 = new String("신민철");
		
		if(strv3 == strv4) { 
			System.out.println("strv1과 strv2는 참조가 같음");
			}else {
			System.out.println("strv1과 strv2는 참조가 다름");
         }
		
		//참조 타입의 변수들은 모두 null 이라는 것을 가진다.
		String str = "abc"; // " " -> Empty //null 아무것도 없다.
		System.out.println("총 문자수" + str.length());
		//기본 타입 (Primitive type)은 null을 가질 수 없다.
		//int inValue1 = null;
	}
}
