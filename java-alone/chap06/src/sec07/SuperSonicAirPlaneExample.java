package sec07;

public class SuperSonicAirPlaneExample {

	public static void main(String[] args) {
		SuperSonicAirPlane sa 
		= new SuperSonicAirPlane();
		
		sa.takeOff();
		
		sa.fly();
		sa.flyMode = SuperSonicAirPlane.SUPERSONIC;
		
		sa.fly();
		sa.flyMode = SuperSonicAirPlane.NOMAL;

		sa.fly();
		sa.land();
	}

}
