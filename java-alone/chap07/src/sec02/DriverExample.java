package sec02;

public class DriverExample {

	public static void main(String[] args) {
		
		Diver diver = new Diver();
		
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		diver.diver(bus); // 버스가 // 자동 프로모션, 자식 메소드 재정의
		diver.diver(taxi); //택시

	}

}
