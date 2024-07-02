package sec02;

import java.util.Scanner;

public class Exam02_06 {

	public static void main(String[] args) {
		boolean run = true;
		int sNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("-----------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5.종료");
			System.out.println("-----------------------");
			
			System.out.print("선택> ");
			
			int sel = Integer.parseInt(scanner.nextLine());
			
			if(sel == 1) {
				System.out.print("학생수 >");
				sNum = Integer.parseInt(scanner.nextLine());
				scores = new int[sNum];
				}else if (sel == 2) {
					for(int i = 0; i < scores.length; i++) {
						System.out.print("scores["+ i +"]>");
						scores[i] = Integer.parseInt(scanner.nextLine());
					}
				}else if (sel == 3) {
					for(int i =0; i < scores.length; i++) {
						System.out.print("scores["+ i +"]>");
						
					}
				}else if (sel == 4) {
				 int max = 0;
				 int sum = 0; 
				 double avg = 0;
				 for(int i =0; i < scores.length; i++) {
					 max = (max <scores[i])? scores[i] : max;
					 sum += scores[i];
				 }
				avg = (double) sum / sNum;
				System.out.println("최고점수: " + max);
				System.out.println("평균점수: " + avg);
				 }else if (sel == 5) {
					 run = false;
				 }
			   }
		 System.out.println("야로그램 코료");
			}

		}
