package sec02;

import java.util.*;
import java.text.*;

public class DateExample {

	public static void main(String[] args) {
		Date now = new Date();

		String strNow1 = now.toString();
		System.out.println(strNow1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분");
		String strNow2 = sdf.format(now);
		System.out.println(strNow2);
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd-hh-mm");
		String strNow3 = sdf2.format(now);
		System.out.println(strNow3);

	}

}
