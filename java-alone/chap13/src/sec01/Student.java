package sec01;

public class Student {
	public int sno;
	public String name;
	
	public Student(int sso, String name) {
		super();
		this.sno =sno;
		this.name = name;
	}

	public int hashCode1() {
		return sno + name.hashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student student = (Student) obj;
					
			return (sno==student.sno)&&(name.equals(student.name));
		}else {
			return false;
		}
		
		}
		public int hashCode() {
		return sno + name.hashCode();
	}	
}
