package sec02.casting;

public class ChildExample {

	public static void main(String[] args) {
		
		Parent parent = new Child(); // 자동 형변환
		parent.field1 = "data1";
		parent.method1();
		parent.method2();
		
		//parent.field2 = "data2"; // 둘다 못받아서 에러
		//parent.method3();
		
		Child child = (Child) parent; // 강제 형변환(casting)
		child.field2 = "data2";
		child.method3();
		
		/*Parent parent2 =  new Parent(); //
		Child child = (Child) parent2;
		child.field2 ="data2";
		child.method3(); // runtime 에러
		*/
	}

}
