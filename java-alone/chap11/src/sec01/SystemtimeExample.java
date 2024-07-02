package sec01;

public class SystemtimeExample {

	public static void main(String[] args) {
		long time1 = System.nanoTime();			// 10의 -9승
		long itme3 = System.currentTimeMillis(); // 10 의 -6승
		
		int sum = 0;
		for(int i=1; i<=999999999L; i++) {
			sum += i;
		}
		long time2 = System.nanoTime();
		
		System.out.println("1~999999999까지의 합: " + sum);
		System.out.println("계산에 " + (time1 - time2) + " 나노초가 소요되었습니다.");
		System.out.println("계산에 " + (time1 - time2) / ((double)1000000000) + " 초가 소요되었습니다.");
			
	}

}
