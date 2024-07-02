package sec01;

import java.util.HashMap;

public class Keyexample {
	

	public static void main(String[] args) {
		HashMap<Key,String> hashMap = new HashMap<Key,String>();
		
		hashMap.put(new Key(1), "홍길동");
		
		String value = hashMap.get(new Key(1));
		System.out.println(value); // 넘버 값을 가져오도록 해시코드 메소드를 재정의 하였다면 "홍길동"을 가져온다
	}

}
