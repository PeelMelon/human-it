package sec01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		Map<String, Integer>map = new HashMap<String, Integer>();
		
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95); //Overwrite
		System.out.println("총 Entry 수" + map.size()); // 홍길동 중복 키는 3
		
		System.out.println("\t홍길동: "+ map.get("홍길동")); //95
		System.out.println();
		
		Set<String> KeySet = map.keySet();
		Iterator<String> keyIterator = KeySet.iterator(); // Key값만 iterator
		while(keyIterator.hasNext()) {
			String Key = keyIterator.next(); //도는 메소드
			Integer value = map.get(Key); 	// 값을 꺼내온다.
			System.out.println("\t" + Key + ":" + value);
		}
		System.out.println();
		
		//객체 삭제
		map.remove("홍길동"); // Key값으로 entry객체를 제거
		System.out.println("총 Entry 수"+ map.size()); //2
		
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		
		while(entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next();
			String Key = entry.getKey(); // 키를 가저옴
			Integer value = entry.getValue(); // 벨류 가저옴
			System.out.println("\t" + Key + ":" + value);
		}
		System.out.println();
		
		//객체 전체 삭제
		map.clear();
		System.out.println("총 Entry 수" + map.size()); // 0
	}
	
		
		
		
}
