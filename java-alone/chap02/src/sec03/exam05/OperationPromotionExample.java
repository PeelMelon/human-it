package sec03.exam05;

public class OperationPromotionExample {

	public static void main(String[] args) {
		/*
		 byte byteValue1 = 10;
		byte byteValue2 = 20;
		
		int intValue1 = byteValue1+ byteValue2;
		System.out.println(intValue1);
		
		char charValue1 = 'A';
		char charValue2 = 1;
		
		int intValue2 = charValue1 + charValue2;
		System.out.println("유니코드="+ intValue2);
		System.out.println("출력문자="+ (char)intValue2);
		
		int intValue3 = 10;
		int intValue4 = intValue3 / 4; //2.5 만 2가 출력 (소수점 버림)
		System.out.println(intValue4);
		
		int intValue5 = 10;
		double doubleValue = intValue5 / 4.0; //10 / 4.0 -> 10.0 / 4.0 = 2.5
		System.out.println(doubleValue);
		
		int x = 1;
		int y = 2;
		double result =  (double) x / y;
		System.out.println(result);
		*/
		
		 int value = 10 + 2 + 8;
		 System.out.println("Value: " + value);
		 
		 String str1 = 10 + 2 + "8";
		 System.out.println("str1: " + str1);
		 
		 String str2 = 10 + "2" + 8;
		 System.out.println("str2: " + str2);
		 
		 String str3 = "10" + 2 + 8;
		 System.out.println("str3: " + str3);
		 
		 String str4 = "10" + (2 + 8);
		 System.out.println("str4 " + str4);
		 
		 
		 //문자열을 기본 타입으로 강제 타입 변환 예제
		 int Value1 = Integer.parseInt("10");
		 double Value2 = Double.parseDouble("3.14");
		 boolean Value3 = Boolean.parseBoolean("ture");
		 
		 System.out.println("Value1: " + Value1);
		 System.out.println("Value2: " + Value2);
		 System.out.println("Value3: " + Value3);
		 
		 String st1 = String.valueOf(10);
		 String st2 = String.valueOf(3.14);
		 String st3 = String.valueOf(true);
		 
		 System.out.println("str1: " + st1);
		 System.out.println("str2: " + st2);
		 System.out.println("str3: " + st3);
	}

}
