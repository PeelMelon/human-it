package sec01;

public class StringGetByteExample {

	public static void main(String[] args) {
		//UTF-8
		String str1 = "안녕하시올";	//ㅇㅏㄴ 3byte, ㅎ ㅏ(빈칸) 3byte
		String str2 = "Hello";		// h - > h
		
		byte[] bytes1 = str1.getBytes(); // 인코딩 바이트로 바꿈 encoding
		System.out.println("bytes1.length: " + bytes1.length); // 15개
		
		byte[] bytes2 = str2.getBytes();
		System.out.println("bytes1.length: " + bytes2.length); // 5개
		
		String str3 = new String(bytes1);	// 디코딩 String 로 바꿈 decoding
		System.out.println("bytes1 -> String:" + str3);
		
		String str4 = new String(bytes2);
		System.out.println("bytes2 -> String:" + str4);
		
		try {
			// euc-kr(대소문자 구분 안함) -> 한국어 인코딩 타입이름
			byte[] bytes3 = str1.getBytes("euc-kr"); // 햛 //cuc-kr 2byte 
			System.out.println("bytes3.length: " + bytes3.length);
			String str5 = new String(bytes3, "euc-kr");
			System.out.println("bytes3 - > String: " + str5);
			
			// utf-8 다국어 인코딩 타입 이름
			byte[] bytes4 = str1.getBytes("utf-8"); //3바이트  utf-8 인코딩
			System.out.println("bytes4.length: " + bytes3.length);
			String str6 = new String(bytes3, "euc-kr");  // utf-8 디코딩
			System.out.println("bytes4 - > String: " + str6);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

