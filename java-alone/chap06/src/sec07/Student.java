package sec07;

public class Student extends People {
	public int studentNo;
	
	public Student(String name, String ssn, int studentNo) {
		super(name, ssn); // 부모가 가지는 2개의 인수를 가진 생성자 호출 // 생성자를 만들어줌
		this.studentNo = studentNo; // 이 줄을 넣어서 StudentNo 를 초기화 해준다.
	}
}
