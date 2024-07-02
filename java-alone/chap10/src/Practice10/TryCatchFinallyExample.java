package Practice10;

import java.lang.*; // 생략 하더라고 기본적으로 자바에서 import를 해준다.

public abstract class TryCatchFinallyExample {

	public static void main(String[] args) {
		String[] strArray = {"10", "2a"};
		int value = 0;
		for(int i = 0; i < 2; i++) {
		try {
			value = Integer.parseInt(strArray[i]);
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("인덱스를 초과했음");
			} catch(NumberFormatException e) {
				System.out.println("숫자로 변환할 수 없음");
			} finally {
				System.out.println(value);
			}
		}
	}
}


