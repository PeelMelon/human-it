package sec02;

public class Bus implements Vehicle {

	@Override
	public void run() {
		System.out.println("버스가 돌격합니다.");
		
	}
	public void check() {
		System.out.println("승차 요금 체크");
	}
}
