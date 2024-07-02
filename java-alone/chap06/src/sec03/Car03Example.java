package sec03;

public class Car03Example {

	public static void main(String[] args) {
		Car03 car1= new Car03();
		System.out.println("car1.company : " + car1.company);
		System.out.println();
		
		Car03 car2= new Car03("개인차");
		System.out.println("car2.company : " + car2.company);
		System.out.println("car2.model : " + car2.model);
		System.out.println();
		
		Car03 car3= new Car03("개인차", "버건디");
		System.out.println("car3.company : " + car3.company);
		System.out.println("car3.model : " + car3.model);
		System.out.println("car3.color : " + car3.color);
		System.out.println();
		
		Car03 car4= new Car03("개인차", "블랙", 250);
		System.out.println("car4.company : " + car4.company);
		System.out.println("car4.model : " + car4.model);
		System.out.println("car4.color : " + car4.color);
		System.out.println("car4.maxSpeed : " + car4.maxSpeed);
		
	}

}
