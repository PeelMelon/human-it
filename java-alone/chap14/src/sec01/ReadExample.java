package sec01;

import java.io.*;

public class ReadExample {

	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("./bin/sec01/test1.db");
		
		/*
		int data1 = is.read(); // test1.db 안의 1바이트 읽어 리턴 만약에 못읽으면 -1을 리턴
		System.out.println("1byte: " + data1);
		int data2 = is.read(); // test1.db 안의 1바이트 읽어 리턴
		System.out.println("1byte: " + data2);
		*/
		/*
		while(true) {
			int data = is.read();
			if (data == -1) {
				break;
			}
			System.out.println("1byte data: " + data);
			*/
		/*
		InputStream is = new FileInputStream("./bin/sec01/test2.db");
		byte[] buffer = new byte[3];
	
			int readbyteNum = is.read(buffer); //buffer 크기만큼 test2.db 있는 데이터를 가져온다.
			
			for(byte b1 : buffer) {
			System.out.println(b1);
			}
	*/
		
		byte[] buffer = new byte[5];
		int readbyteNum = is.read(buffer ,2,3);
		if(readbyteNum != -1) {	//읽은 것이 있다면
			for(byte b1 : buffer) {
				System.out.println(b1);
			}
		}
		is.close();
	}	
}

