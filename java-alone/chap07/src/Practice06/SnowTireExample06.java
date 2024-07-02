package Practice06;

public class SnowTireExample06 {

	public static void main(String[] args) {
		SnowTire06 snowTire = new SnowTire06();
		Tire06 tire = snowTire; //자동 형변환 promotion
		// tire는 regacy가 된다.
		
		snowTire.run();
		tire.run(); 
	
	}

}
