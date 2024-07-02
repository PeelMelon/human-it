package practice02;

import java.io.*;
import java.util.*;

public class AddLineNumberExample {

	public static void main(String[] args) throws Exception {
		String filePath = "src/practice02/AddLineNumberExample.java";
		//짱돌을 던져, 돌무지덧널무덤을 만들자
		Reader reader = new FileReader(filePath);
		BufferedReader br = new BufferedReader(reader);
		
		int rowNumber = 1;
		while(true) {
			String dataLine = br.readLine();
			if(dataLine == null) break;
			System.out.println((rowNumber++)+": "+dataLine);
		}
		br.close();
	}
}
