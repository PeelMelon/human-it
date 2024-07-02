package LibrarySystemProject;

import java.util.*;

public class LibraryJoinSystem {
	private static final AuthService authService = new AuthService();
	private static final LibraryService libraryService = new LibraryService();
	// 기존의 LibraryService 클래스

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\"SP도서관 관리 프로그램\"에 오신 것을 환영합니다.");

		while (true) {
			System.out.println("========================");
			System.out.println("1. 로그인");
	        System.out.println("2. 회원 가입");
	        System.out.println("========================");
	        System.out.print("선택: ");
	        int choice = scanner.nextInt();
	        scanner.nextLine();  // 버퍼 비우기
	        
	         if (choice == 1) {
	        	 if (login(scanner)) {
	        		 System.out.println("로그인 성공! 관리 프로그램을 시작합니다.");
	        		 runLibraryManagement(scanner);  // 도서관 관리 프로그램 기능 호출
	        		 break;
	        	 } else {
	        		 System.out.println("아이디 또는 비밀번호가 잘못되었습니다. 다시 시도해주세요.");
	        	 }
	         } else if (choice == 2) {
	        	 register(scanner);
	        } else {
	        	System.out.println("잘못된 선택입니다. 다시 시도해주세요.");
	        }
		}
	}

	private static boolean login(Scanner scanner) {
		System.out.print("아이디: ");
		String username = scanner.nextLine();
		System.out.print("비밀번호: ");
		String password = scanner.nextLine();

		return authService.login(username, password);
	}

	private static void register(Scanner scanner) {
		System.out.print("새 아이디: ");
	    String username = scanner.nextLine();
	    System.out.print("새 비밀번호: ");
	    String password = scanner.nextLine();

	    if (authService.register(username, password)) {
	    	System.out.println("회원 가입 성공! 이제 로그인 할 수 있습니다.");
	    } else {
	    	System.out.println("회원 가입 실패! 다시 시도해주세요.");
	    }
	}

	private static void runLibraryManagement(Scanner scanner) {
	}
}
