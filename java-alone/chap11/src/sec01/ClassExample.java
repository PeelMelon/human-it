package sec01;

public class ClassExample {

	public static void main(String[] args) {
		// 첫번째 방법
		Class clazz = Car.class;
		
		//Class clazz = String.class;
		
		// 두번째 방법
		//Class clazz = Class.forName("sec01.Car");
		
		// 세번째 방법
		String str1 = "aaa";
		Class clazz3 = str1.getClass();
		
		System.out.println(clazz.getName());
		System.out.println(clazz.getSimpleName());
		System.out.println(clazz.getPackageName());
		
		// Car 클래스 메타정보 가져오기	
		//CAr car = new Car();
		//Class clazz = car.getClass;
	}
	
}
