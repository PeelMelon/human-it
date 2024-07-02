package Practice06;

public class Service {
	
	public void login() {
		System.out.println("로그인");
	}
	
	public class MemberService extends Service {
		public void login() {
			System.out.println("멤버 로그인");
				
	/*
	public class AService extends MemberService {
		public void login() {
			System.out.println("A 로그인");
			*/
	
Controller controller = new Controller();

// controller.setService(new MemberService());
controller.service.login();

controller.setService(new AService());
controller.service.login();

		}
	}
}


		

