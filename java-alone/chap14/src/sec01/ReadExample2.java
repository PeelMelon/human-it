package sec01;

import java.io.*;

public class ReadExample2 {

	public static void main(String[] args) throws Exception {
		//Reader reader = new FileReader("./bin/sec01/test1.txt");
		
		/*
		while(true) {
			int data = reader.read();
			if(data == -1) break;
			System.out.println("1cahr data > " + (char)data);
		*/
		Reader reader = new FileReader("./bin/sec01/test2.txt");
		
		char[] bufferArray = new char[100];
		
		while(true) {
			int readCharNum =reader.read(bufferArray);
			if(readCharNum == -1) break;
			
			for(char buffer :bufferArray) {
				System.out.println("1char data ->" +(char)buffer);
			}
		}
	}
}


