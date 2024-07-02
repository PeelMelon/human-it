package sec02;

public class ForExam04 {

	public static void main(String[] args) {
		//문제 2
		for (int a = 1; a <= 100; a++) {
			if (a % 3 == 0){
				System.out.println(a);
			}
			
		}
		/*
		//문제 5
		/*for (int b = 1; 1 <= 4;) {
			System.out.println(String '*' * b++); */
		int rows = 4;
		for (int i = 1; i <= rows; i++) {  // 외부 for문: 줄 수 만큼 반복
            for (int j = 1; j <= i; j++) { // 내부 for문: i개 만큼 별 출력
                System.out.print("*");
            }
            System.out.println();
        }
		//문제 6
		//for(int h = 4; > 0; h--) {
			//for(int h =4; h > 0; h--) {
			//System.out.println(" ");
			//}else {
				//System.out.println("*");
			}
		}




	
