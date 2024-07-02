package sec01;
//implements로 세팅된 인터페이스 안의 모든 추상 메소드들은 반드시 클래스로 구현 해야한다.
public class Television implements RemoteControl {
	private int volume;
	
	public void turnOn() { // 턴온 메소드
		System.out.println("TV를 켭니당");
	}
	
	public void turnOff() {
		System.out.println("TV를 끕니당");
	}
	
	public void setVolume(int vol) {
		if(volume > RemoteControl.MAX_VOLUME) {
			 this.volume = RemoteControl.MAX_VOLUME;
		} else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			 this.volume = vol;
	}
	
}
}

	 
