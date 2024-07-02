package sec07;

public class Car01 {
	public int speed;
	
	public void speedUp() {speed +=1;}
	public final void stop() { // 쿵이널 쾅타지
		System.out.println("차를 멈춤");
		speed = 0;
	}
}
