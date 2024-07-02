package sec01;

// 내부적으로는 java.lang.Object 클래스를 자동 상속이 됨
public class Member extends Object{
	public String id;
	
	public Member(String id) {
		this.id  = id;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member ) {
			Member member = (Member)obj;
	
		if(id.equals(member.id))
			return true;
		}
		return false;
	}
}
