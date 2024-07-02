package sec04;

public class CalculatorExample {

	public static void main(String[] args) {
		Calculator mycal = new Calculator(); // 객체를 만들었습니다.
		mycal.powerOn();
		
		int result1 = mycal.plus(5, 6); // 숫자를 대입
		System.out.println("result1: " + result1); // 리절트1 받아서 계산 수행
		
		byte x = 10;
		byte y = 4;
		double result2 = mycal.divide(x, y);
		System.out.println("result2: " + result2);
		
		mycal.powerOff(); // 리턴값이 없는 메소드
	}
}
