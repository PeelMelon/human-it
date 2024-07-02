package sec06.exam06;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		
		// setter 메소드 호출
		myCar.setSpeed(-50);
		System.out.println("현재속도: " + myCar.getSpeed());
		
		myCar.setSpeed(60);
		System.out.println("현재속도: " + myCar.getSpeed());
		
		//if(!myCar.isStop()) {
		//	myCar.setSpeed(true);
		//}
		System.out.println("현재속도: " + myCar.getSpeed());
	}

}
