package sec03;

public class Car03 {
	
	String company = "모던자동차";
	String model;
	String color;
	int maxSpeed;
	
	Car03() {
	}
	
	Car03(String model) {
		this(model, "은색", 250);
	}
	
	Car03(String model, String color) {
		this(model, color, 250);
	}
	
	Car03(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}
