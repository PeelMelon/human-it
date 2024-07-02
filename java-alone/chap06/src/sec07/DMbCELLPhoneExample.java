package sec07;

public class DMbCELLPhoneExample {


	public static void main(String[] args) {
		DmbCellPhone dmbCellPhone 
		= new DmbCellPhone ("자바폰", "검정", 10);
		
		System.out.println("모델: " + dmbCellPhone.model);
		System.out.println("색상: " + dmbCellPhone.color);
		
		System.out.println("채널: " + dmbCellPhone.channel);
		
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.sendVoice("여보세요");
		dmbCellPhone.receVoice("안녕하세요");
		dmbCellPhone.sendVoice("반갑습니다");
		dmbCellPhone.hangUp(null);
		
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannelDmb(12);
		dmbCellPhone.turnOffDmb();
		
	
		}
	}

