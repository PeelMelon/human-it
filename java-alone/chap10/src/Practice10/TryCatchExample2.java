package Practice10;

public class TryCatchExample2 {

	public static void main(String[] args) {
		try {
			System.out.println("야리코미");
			return;
		} catch(Exception e) {
			System.out.println("Exception 발생");
		} finally { //try 블록에서 return 을 만나더라도 무조건 실행되는 코드
			System.out.println("finally 실행됨"); // return 이 있더라도 finally 가 실행이 된다.
		}
		System.out.println("프로그램 종료"); // 실행 되지 않는다.
	}

}
