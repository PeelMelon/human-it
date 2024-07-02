package sec02;

//import java.util.

public class exam03 {

	// 항 연산자 문제
	public static void main(String[] args) throws Exception {
		//3번 문제 풀이
		//boolean stop = true; //true면 무한 반복, false이면 while문 실행 안함
		//!true = false, 
		//while(!stop)
		
		
	// 4번 문제
		int p = 534;
		int s = 30;
		int pers = (p / s);
		System.out.println(pers);
		
		int left = (p % s);
		System.out.println(left);
		
		
	// 5번 문제
		int var1 = 5;
		int var2 = 2;
		double var3 = var1 / var2;     // <= double 캐스팅
		int var4 = (int)(var3 * var2); // <= int 캐스팅 ㄴㄴ
		System.out.println(var4);
		
	
		double v1 = 5;
		double v2 = 2;
		double v3 = v1 / v2;
		System.out.println(v3);
		double v4 = (v3 * v2);
		System.out.println(v4);
		
	// 7번 문제
		double r1 = 10;
		double r2 = r1 / 100;
		System.out.println(r2); // <-- 
			if (r2 == 0.1) {
			    System.out.println("10% OO");
			}else {
				System.out.println("10% XX");
				
				
	//8번 문제 풀이(윗변+아랫변)* 높이 / 2
		int lt = 5;
		int lb = 10;
		int h = 7;
		double area = (lt + lb) * h / (double)2;
		System.out.println(area);
		
	//9번 문제 풀이
	
		
		
	    //10번 문제
				
				
		
	    }
	}
}

