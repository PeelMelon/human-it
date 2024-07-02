package sec05;

public class Person {
	final String nation = "Korea";
	final String ssn;
	String name;
	public Person(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
		
		//final 로 선언된 값은 무조건 초기화 할때 final로 선언된 변수를 초기화 해야 한다.
		}
	public Person(String ssn) {
		this.ssn = ssn;
	}
}
