package sec07;

public class DmbCellPhone extends CellPhone {
	int channel;
	
	public DmbCellPhone() {
		//super(); //CellPhone의 기본 생성자 호출
	}
	
	DmbCellPhone(String model, String color, int channel){
		// this.model은 CellPhone에 있는 모델
		this.model = model;
		this.color = color;
		this.channel = channel;
		//super();
		// 해당코드가 없어도 자동으로 만들어짐
	}
	
	void turnOnDmb() {
		System.out.println("채널 " + channel + "번 DMB방송 수신을 시작합니다");
	}
	void changeChannelDmb(int Channel) {
		this.channel = channel;
		System.out.println("채널 " + channel + "번으로 바꿉니다");
	}
	void turnOffDmb() {
		System.out.println("DMB 방송 수신을 멈춥니다");
	}
}
