package sec02;

public class VehicleExample {

	public static void main(String[] args) {
		Vehicle vehicle = new Bus();
		vehicle.run(); //버스가 달립니당
		//vehicle.check(); // error Vehicle 인터페이스에 check 메소드가 없어서
	
		Bus bus = (Bus)vehicle; // 강제 형변환
		bus.run();
		bus.check();  // bus의 객체인 bus에서 check 메소드가 존재하므로 실행 가능

	}

}
