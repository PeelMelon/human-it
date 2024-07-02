package sec07;

public class ChildExample {

	public static void main(String[] args) {
		Child child = new Child();
		
		child.method1(); // Parent 의 method1
		child.method2(); // Child 의 method2
		child.method3(); // Child 의 method3
		
		Parent parent = new Parent();
		//Parent.method2(); 
		
	}

}
