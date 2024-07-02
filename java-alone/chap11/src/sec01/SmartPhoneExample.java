package sec01;

public class SmartPhoneExample {

	public static void main(String[] args) {
		//SmartPhone 객체 생성
		SmartPhone myPhone = new SmartPhone("구글","안드로이드");
		
		String strObj = myPhone.toString();
		System.out.println("toString()값" + strObj); // myPhone.toString
		System.out.println("myPhone객체를 sy.pri 했을경우" + myPhone);
		
		System.out.println("1");
		System.out.println(1);
		System.out.println(1.0); // 내부적으로 toString() 메소드 가짐

	}

}

// Object 클래스의 가장 많이 사용 하는 메소드들
// 1. equals()
// 2. hashCode()
// 3. toString()
