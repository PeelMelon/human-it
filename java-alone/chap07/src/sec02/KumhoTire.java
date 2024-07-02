package sec02;

public class KumhoTire extends Tire {
	public KumhoTire (String location, int maxRtation) {
		super(location, maxRtation);
	}
	@Override
	public boolean roll() {
		++accumulatedRtation;
		if(accumulatedRtation < maxRtation) {
			System.out.println(location + "Kumho타이어수명: "
				+ (maxRtation - accumulatedRtation) + "회");
			return true;
		} else {
			System.out.println("*** " + location + "Kumho타이어 펑크 ***");
			return false;
		}
	}
}
