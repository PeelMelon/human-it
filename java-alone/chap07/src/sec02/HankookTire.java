package sec02;

public class HankookTire extends Tire {
	//1 개의 생성자
	public HankookTire (String location, int maxRtation) {
		super(location, maxRtation);
	}
	@Override
	public boolean roll() {
		++accumulatedRtation;
		if(accumulatedRtation < maxRtation) {
			System.out.println(location + "Hankook타이어수명: "
				+ (maxRtation - accumulatedRtation) + "회");
			return true;
		} else {
			System.out.println("*** " + location + "Hankook타이어 펑크 ***");
			return false;
		}
	}
}
