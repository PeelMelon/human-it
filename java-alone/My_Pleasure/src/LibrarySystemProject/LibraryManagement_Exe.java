package LibrarySystemProject;

import java.util.*;

public class LibraryManagement_Exe {

	public static void main(String[] args) {
		LibraryJoinSystem.main(args);
		System.out.println("도서 관리 프로그램 \"시작\"");
		
		LibraryService libraryService = new LibraryService();
        Scanner scanner = new Scanner(System.in);
		
        // 0. 도서 관리 프로그램 대기를 위해 무한 루프 코드 작성
        while (true) {
        	// 도서 관리 시스템 제목
        	System.out.println("                        『 SP도서관 도서 관리 시스템 』");
            System.out.println();
        	System.out.println("==========================================================================");
            System.out.println("    1.도서 등록 | 2.도서 목록 | 3.상세 보기 | 4.도서 정보 수정 | 5.도서 삭제 |");
            System.out.println();
            System.out.println("    6.카테고리 등록 | 7.카테고리별 도서 | 8.카테고리 목록 | 9.카테고리 설정 |");
            System.out.println();
            System.out.println("    10.카테고리 수정 | 11.카테고리 삭제 | 12.종료 | ");
            System.out.println("==========================================================================");
            System.out.print(" 메뉴 번호를 입력해 주세요: ");
            // 1. 메뉴 선택 번호를 입력받기
            int menuNumber = 0;
            try {
                menuNumber = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("잘못된 값을 입력하였습니다. 다시 입력 해주세요.");
                continue;
            }
            System.out.print("선택된 번호: " + menuNumber);

            if (menuNumber < 1 || menuNumber > 12) {
                System.out.println("\n1에서 12번 숫자만 가능합니다.");
                continue;
            }
            switch (menuNumber) {
            case 1:    // 도서 등록 실행
            	System.out.println("(도서 등록)");
            	libraryService.insertBook();
            	break;
            case 2:    // 도서 목록 실행
            	System.out.println("(도서 목록)");
            	libraryService.selectAllBooks();
            	break;
            case 3:    // 도서 상세 보기 실행
            	System.out.println("(상세 보기)");
            	libraryService.selectOneBook();
            	break;
            case 4:    // 도서 정보 수정 실행
            	System.out.println("(도서 정보 수정)");
            	libraryService.updateOneBook();
            	break;
            case 5:    // 도서 삭제 실행
            	System.out.println("(등록 도서 삭제)");
            	libraryService.deleteBook();
            	break; 
            case 6:    // 카테고리 등록 실행
        		System.out.println("(카테고리 등록)");
        		libraryService.insertCategory();
        		break;
            case 7:   		 // 카테고리별 도서 목록
            	System.out.println("(카테고리별 도서 목록)");
            	libraryService.getBooksByCategory();
            	break;	
            case 8:    // 카테고리 목록 조회
				System.out.println("(카테고리 목록)");
				libraryService.listCategories();
				break;            	
            case 9:     // 카테고리 설정 (카테고리와 책 매핑) 실행
            	System.out.println("(카테고리 설정)");
            	libraryService.mapBookToCategory();        
            	break;
            case 10:    // 카테고리 수정 실행
        		System.out.println("(카테고리 수정)");
        		libraryService.updateCategory();
        		break;
        	case 11:   // 카테고리 삭제 실행
        		System.out.println("(카테고리 삭제)");
        		libraryService.deleteCategory();
        		break;
            }
            if(menuNumber == 12) {
            	System.out.println("(종료)");
				break;
            }
        }
        System.out.println("도서 관리 프로그램 \"종료\"");
	}
}

