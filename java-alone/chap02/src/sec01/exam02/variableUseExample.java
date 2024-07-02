package sec01.exam02;

public class variableUseExample {

	public static void main(String[] args) {
		int hour = 3;
		int minute = 5;
		System.out.println(hour + "시간" + minute + "분");
		
		int totalMinute = (hour*60) + minute;
		System.out.println("총" + totalMinute + "분"); 
		//Python 은 타입이 같지 않아 오류지만 java 에서는 자동으로 바꿔준다.

	}

}
