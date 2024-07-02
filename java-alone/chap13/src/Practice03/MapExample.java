package Practice03;

import java.util.*;
import java.util.Map.Entry;

public class MapExample {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);
		
		String name = null;
		int maxScore = 0;
		int totalScore = 0;
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		/*
		for(Map.Entry<String, Integer>) mapEntty : entrySet();
			
			totalScore += entry.getValue();
			
			if(maxScore < entry.getValue()) {
			maxScore = entry.getValue(); // 최고점수
			name = entry.getKey();	// 최고점수를 받은 아이딘
			}	
		}
		*/
		
		//while문을 사용
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		
		while(entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next();
			
			totalScore = entry.getValue();
			
			if(maxScore < entry.getValue()) {
			maxScore = entry.getValue(); // 최고점수
				name = entry.getKey();		// 최고점수를 받은 아이딘
			}
		}
		
		double avScore = (double) totalScore / map.size();
		
		System.out.println("최고점수: " + maxScore);
		System.out.println("최고점수받은놈: " + name);
		System.out.println("평균점수: " + avScore);
		
		}
		
}
	



