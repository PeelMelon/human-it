package sec01;

public class SmartTelevision implements RemoteControl, Searchable {
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
		System.out.println("현재 볼륨:" + this.volume);
	}
	public void search(String url) {
		System.out.println(url + "검색합니당");	
	}

}
