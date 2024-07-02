package Practice03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import sec01.Member;
import sec01.Student;

public class HashSetExamlple {

	public static void main(String[] args) {
		Set<Student> set = new HashSet<Student>();
		
		set.add(new Student(1, "홍길동"));
		set.add(new Student(2, "신용권"));
		set.add(new Student(2, "조민우"));
		
		Iterator<Student> interator = set.iterator();
		
		
		

	}

}
