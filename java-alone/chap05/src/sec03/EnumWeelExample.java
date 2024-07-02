package sec03;

import java.util.Calendar;

public class EnumWeelExample {

	public static void main(String[] args, int week) {
		Week week1 = Week.SATURDAY;
		Week week2 = Week.FRIDAY;
		System.out.println(week1 != week2);
		
		Week week3 = Week.MONDAY;
		Week week4 = Week.MONDAY;
		System.out.println(week3 == week4);
		
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR); //final int 변수 -> 연도
		System.out.println("현재연도:" + year);
		
		int month = now.get(Calendar.MONTH);
		System.out.println("현재연도:" + month);
		
		int day = now.get(Calendar.DAY_OF_MONTH);
		System.out.println("일:" + day);
		
		int weeke = now.get(Calendar.DAY_OF_WEEK);
		System.out.println("현재 요일:" + weeke);
		
		int hour = now.get(Calendar.HOUR);
		System.out.println("현재 시각:" + hour);
		
		int minute = now.get(Calendar.MINUTE);
		System.out.println("분:" + minute);
		
		int second = now.get(Calendar.SECOND);
		System.out.println("초:" + second);
		
		Week today = null;
		
		
		switch(week){
			case 1:
				today = Week.SUNDAY; break;
			case 2:
				today = Week.MONDAY; break;
			case 3:
				today = Week.TUESDAY; break;
			case 4:
				today = Week.WEDNESDAY; break;
			case 5:
				today = Week.THURSDAY; break;
			case 6:
				today = Week.FRIDAY; break;
			case 7:
				today = Week.SATURDAY; break;
		}
		System.out.println("오늘 요일 : " + today);
		
		if(today == Week.SUNDAY) {
			System.out.println("일요일에는 야구를 합니다.");
		}else {
			System.out.println("열심히 자바 공부합니다.");
		}
		
	}

}
