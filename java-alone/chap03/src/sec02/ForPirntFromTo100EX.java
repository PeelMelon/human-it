package sec02;

public class ForPirntFromTo100EX {

	public static void main(String[] args) {
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		int i = 1;
		for(; i<= 100; i++) {
			System.out.println(i);
		}
		for(;;){ 		//무한루프 == while(true)
			break;
		}
		for(int j =0; ; j++) { //무한루프 == while(true)
			break;
		}
	}

}
