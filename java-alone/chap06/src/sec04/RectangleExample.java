package sec04;

public class RectangleExample {

	public static void main(String[] args) {
		Calculator04 myCal = new Calculator04();
		
		double result1 = myCal.areaRectangle(10);
		
		double result2 = myCal.areaRectangle(10, 20);
		
		System.out.println("정사각형 넓이=" + result1);
		System.out.println("직사각형 넓이=" + result2);

	}

}
