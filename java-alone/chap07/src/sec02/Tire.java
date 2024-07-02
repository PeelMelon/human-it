package sec02;

public class Tire {
	//3개의 필드
	public int maxRtation;
	int accumulatedRtation;
	public String location;

	//1개의 생성자
	public Tire(String location, int maxRtation) {
		this.location = location;
		this.maxRtation = maxRtation;
	}
	
	//1개의 메소드
	public boolean roll() {
		++accumulatedRtation;
		if(accumulatedRtation < maxRtation) {
			System.out.println(location + "타이어수명: "
				+ (maxRtation - accumulatedRtation) + "회");
			return true;
		} else {
			System.out.println("*** " + location + "타이어 펑크 ***");
			return false;
		}
	}
}
