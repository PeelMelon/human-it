package sec01;

public class Audio implements RemoteControl {
private int volume;
	
	public void turnOn() {
		System.out.println("Audio를 켭니당");
	}
	
	public void turnOff() {
		System.out.println("Audio를 끕니당");
	}
	
	public void setVolume(int Volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			 this.volume = RemoteControl.MAX_VOLUME;
		} else if(volume < RemoteControl.MIN_VOLUME)
			 this.volume = RemoteControl.MIN_VOLUME;
		}
		//메소드 매개 타입이 인터페이스
		public void a(RemoteControl b) {}
}
