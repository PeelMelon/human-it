package sec02;

public class AdbencedForExample {

	public static void main(String[] args) {
		int[] scores = { 97, 71, 84, 93, 87 };
		
		int sum = 0;
		for(int score : scores) {
			sum = sum + score;
			}
		System.out.println("점수 총합 = " + sum);
		
		double avg = (double) sum / scores.length;
		System.out.println("점수 평균 = " + avg);

	}

}
