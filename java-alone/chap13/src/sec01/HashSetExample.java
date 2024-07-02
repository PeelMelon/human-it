package sec01;

import java.util.*;

public class HashSetExample {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("Java");
		set.add("JDBC");	//중복이 됐기 때문에 객체수는 4개로 나온다.(4번째)
		set.add("Servlet/JSP");
		set.add("Java"); 	// set 클래스 객체는 중복을 허용하지 않아 무시가 된다.
		set.add("iBATIS");
		
		int size = set.size();
		System.out.println("총 객체수: " + size);
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
		}
		
		set.remove("JDBC");
		set.remove("iBATIS");
		System.out.println("총 객체수: " + size);
		
		iterator = set.iterator();
		for(String element : set) { 	//향상된 for문
			System.out.println("\t" + element);
		}
		set.clear(); // 삭제하고 if(set.isEmpty()) 비어있음 출력
		if(set.isEmpty()) {System.out.println("비어있음");
		}
		
	}

}

