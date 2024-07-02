package sec03;

public class Car02 {
	
	String company = "모던자동차";
	String model;
	String color;
	int maxSpeed;
	
	Car02() {
		
	}
	
	Car02(String model) {
		this.model = model;
	}
	
	Car02(String model, String color){
		this.model = model;
		this.color = color;
	}
	Car02(String model, String color, int maxSpeed){
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}
