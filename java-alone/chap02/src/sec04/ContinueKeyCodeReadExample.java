package sec04;

public class ContinueKeyCodeReadExample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int keyCode;
		
		while(true) {
			keyCode = System.in.read();
			System.out.println("keyCode: " + keyCode);
			
			if(keyCode == 113) {   //q문자 입력
				break;
			}
		}
		System.out.println("종료");
	}
}

