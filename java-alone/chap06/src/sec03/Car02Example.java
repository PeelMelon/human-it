package sec03;

public class Car02Example {

	public static void main(String[] args) {
		
		Car02 car1 = new Car02();
		System.out.println("car1.company: " + car1.company);
		System.out.println(); // 기본 생성자
		
		Car02 car2 = new Car02("자가용");
		System.out.println("car1.company: " + car2.company);
		System.out.println("car1.company: " + car2.model);
		System.out.println(); // 각 Car02 에서 순서대로 실행
		
		Car02 car3 = new Car02("자가용", "로즈골드");
		System.out.println("car1.company: " + car3.company);
		System.out.println("car1.company: " + car3.model);
		System.out.println("car1.company: " + car3.color);
		System.out.println();
		
		Car02 car4 = new Car02("택시", "블랙", 200);
		System.out.println("car1.company: " + car4.company);
		System.out.println("car1.company: " + car4.model);
		System.out.println("car1.company: " + car4.color);
		System.out.println("car1.company: " + car4.maxSpeed);
		

	}

}
