package sec05;

public class PersonExample {

	public static void main(String[] args) {
	
		Person p1 = new Person("123456-1234567", "홍길동");
		
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
		
		
		//p1.nation = "천조국"; 
		// final 이라서 수정이 안되서 nation 을 바꾸려 하면 오류가 된다.
		p1.name = "홍삼원";
		
	}

}
