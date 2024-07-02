package sec01;

import java.util.List;
import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {
		// String으로 된 여러 개의 객체를 Array 처럼 사용하도록 ArrayList 객채를 생성
		List<String> list = new ArrayList<>(); // 뒤에 ArrayList<> 안에 클래스 이름은 생략이 가능
		// 리스트 원소 추가
		list.add("java"); 	//java값을 가진 객체를 0 번째 String 인덱스 추가 및 저장
		list.add("JDBC"); 	//1 번째 String 인덱스 추가 및 저장
		list.add("Servlet/JSP"); // 아래 객체를 2번에 넣었기 때문에 3번으로 밀려남
		list.add(2, "Database"); //2번(3번째) 인덱스에 Database 값을 가진 String 객체를 저장
		list.add("iBatis");		// 4번째 인덱스
		
		int size = list.size(); // 저장된 총 객체의 수
		System.out.println("총 객체 수: " + size);
		System.out.println();
		
		// 리스트 원속 검색
		String skill = list.get(2);
		System.out.println("2: " + skill);
		System.out.println();
		
		for(int i = 0; i <list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ":" + str);
		}
		System.out.println();
	
		//리스트 원소 삭제
		list.remove(2); //인덱스 2번값을 삭제 -> Database
		list.remove(2); // 그다음 2번 Servlet/JSP 삭제
		list.remove("iBatis");
	
		//리스트 원소 수정
		list.set(0, "Python");
	
		for(int i = 0; i <list.size(); i++) {
		String str = list.get(i);
		System.out.println(i + ":" + str);
		}	
		
	
		list.clear(); // 모두삭제
	}

}

