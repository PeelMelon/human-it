package sec01;

public interface RemoteControl {

	public int MAX_VOLUME = 10; 
	final public int MIN_VOLUME = 0;   //public final static 상수
	
	// 생성자가 없다.
	
	// 추상 메소드 
	void turnOn(); //implements RemoteControl
	void turnOff();
	void setVolume(int Volume);
}
