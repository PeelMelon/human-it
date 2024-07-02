package sec04;

import java.util.Scanner;

public class ScannerExample {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String inputdata;
		
		while(true) {
			inputdata = scanner.nextLine();
			System.out.println("입력된 문자열: \"" + inputdata + "\"");
			
			if(inputdata.equals("q")){
				break;
			}
		}
		System.out.println("종료");
	}

}
