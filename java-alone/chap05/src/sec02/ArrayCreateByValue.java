package sec02;

public class ArrayCreateByValue {

	public static void main(String[] args) {
		
		int []scores = {83, 90, 87}; //
		
		System.out.println("scores[0]: " + scores[0]);
		System.out.println("scores[1]: " + scores[1]);
		System.out.println("scores[2]: " + scores[2]);
		
		scores[2] = 88; // 87을 88로 바꿈
		
		int sum = 0;
		for(int i = 0; i < 3; i++) {
			sum += scores[i];
			
		}
		System.out.println("총합: " + sum);
		double avg = (double)sum / 3; // 소수점 double 캐스팅
		System.out.println("평균: " + avg);
	}
	
	public static int add(int[] scores) {
		int sum = 0;
		for(int i= 0; i <3; i++) {
			sum += scores[i];
		}
		return sum;
	}

}
