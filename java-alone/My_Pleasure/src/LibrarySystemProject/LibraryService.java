package LibrarySystemProject;

import java.sql.*;
import java.util.*;
import LibrarySystemProject.BookDBManager;


public class LibraryService {
	
	private Scanner scanner = new Scanner(System.in);
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
    
	public int insertBook() {
		System.out.println("도서 등록을 시작합니다.");
		// 1. 도서 제목 받기
		System.out.print("도서 제목(취소: q): ");
	    String title = scanner.nextLine();  // 키보드로 '도서 제목' 받기
	    if (title.equals("q")) {
	    	System.out.println("제목 등록이 취소되었습니다.");
	        return -1;
	    }
	    
	    // 2. 도서 설명 받기
	    System.out.print("도서 설명(취소: q): ");
	    String description = scanner.nextLine();  // 키보드로 '도서 설명' 받기
	    if (description.equals("q")) {
	        System.out.println("설명 등록이 취소되었습니다.");
	        return -1;
	    }
	    
	    // 3. 위의 입력된 도서 제목과 설명을 받아서 Oracle DB에 저장할 수 있도록 DB 접속 준비
	    Connection conn = BookDBManager.getDBConnection();
	    
	    // 4. Oracle DB에 데이터를 삽입하기 위해 insert SQL문을 작성
	    String insertSql = """
	            INSERT INTO library_sys(book_no, b_title, descript, view_count)
	            VALUES(library_sqc.NEXTVAL, ?, ?, 0)
	    """;
	    
	    int resultRows = 0;  // insert문을 실행한 뒤에 테이블에 영향을 받은 행 개수
	    
	    try {
	        // 5. Oracle DB에 데이터를 삽입할 준비
	        pstmt = conn.prepareStatement(insertSql);
	        pstmt.setString(1, title);   // 위 insertSql의 첫 번째 ?에 키보드로 입력받은 제목을 세팅 
	        pstmt.setString(2, description); // 위 insertSql의 두 번째 ?에 키보드로 입력받은 설명을 세팅
	        
	        // 6. 실제로 SQL 코드를 실행
	        resultRows = pstmt.executeUpdate();  // executeUpdate로 insert, update, delete SQL 코드를 실행
	        
	        System.out.println("도서가 성공적으로 등록되었습니다.");
	    } catch (SQLException se) {
	        System.out.println("도서 등록 도중 에러 발생했습니다.: " + se.getMessage());
	    } finally {
	        // 7. Oracle DB 접속 관련 객체들 정리
	        BookDBManager.dbClose(conn, pstmt, null);
	    }
	    
	    return resultRows;
	}

	public void selectAllBooks() {
		System.out.println("도서 목록을 조회합니다.");
		// 도서 목록 조회 로직 작성
		// 게시판 목록조회 화면구성
		System.out.println("============================================================================");
		System.out.println("No. |      제목      |       등록 시간       |     수정 일자      |  조회수");
		System.out.println("============================================================================");
		
		Connection conn = BookDBManager.getDBConnection();
		
		String selectSql = "SELECT book_no, b_title, public_date, view_count, update_date FROM library_sys ORDER BY book_no DESC";
		int countRows = 0;
		        
		try {
			pstmt = conn.prepareStatement(selectSql);
			rs = pstmt.executeQuery();
					
			while(rs.next()) {
				countRows++;
//				System.out.println(
//					String.format("%-5s", rs.getString("book_no")) + 
//					String.format("%-15s", rs.getString("b_title")) + 
//					String.format("%-15s", rs.getString("public_date")) + 
//					String.format("%-10s", rs.getDate("update_date") 
//						== null ? "" : rs.getDate("update_date")) +
//					String.format("%10s",  rs.getString("view_count"))
//					);
				int bookNo = rs.getInt("book_no");
		            String title = rs.getString("b_title");
		            String publicDate = rs.getString("public_date");
		            String updateDate = rs.getString("update_date");
		            int viewCount = rs.getInt("view_count");

		            System.out.printf("| %-2s | %-9s | %-14s | %-14s | %-2s |%n",
		            	bookNo, title, publicDate, updateDate, viewCount);
				
			}
			if (countRows == 0) {		// 테이블에 데이터가 없을 경우
				 System.out.println("| 도서가 존재하지 않습니다.                                      |");
			}
		} catch(SQLException se) {
			System.out.println("도서 목록을 조회 하는 중에 오류가 발생했습니다: " + se.getMessage());
		} finally {
			// Oracle DB 접속 관련 객체들 정리
			BookDBManager.dbClose(conn, pstmt, rs);
		}
		System.out.println("============================================================================");
	}
	
	private int getbookNo() {
		int bookNo = 0;
		while(true) {
			System.out.print("도서 번호를 입력하세요:");

			try {
				bookNo = Integer.parseInt(scanner.nextLine());
				break;
			} catch (InputMismatchException | NumberFormatException e) {
				System.out.println("잘못된 값을 입력 했습니다. 다시 입력 해주세요.");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("알 수 없는 오류: " + e.getMessage());
			}
		}	
		return bookNo;
	}

	public void selectOneBook() {
		System.out.println("도서 상세 보기를 시작합니다.");
		int bookNo = 0;
		while(true) {
			System.out.print("정보를 조회할 도서 번호를 입력하세요: ");
			
			//입력값이 잘못 됐을 때 오류 메시지를 예외 처리
			try {
				bookNo = Integer.parseInt(scanner.nextLine());
				break;
			} catch(InputMismatchException | NumberFormatException e) {
				System.out.println("잘못된 값을 입력 했습니다. 다시 입력 해주세요.");
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("알 수 없는 오류: " + e.getMessage());
			}
		}

		// 1. 게시글의 상세 데이터를 받기 위해 Oracle DB접속준비
		Connection conn = BookDBManager.getDBConnection();
		
		String countSql = "SELECT COUNT(*) FROM library_sys WHERE book_no = ?";

		//조회수**
		String updateReadCountSql = "UPDATE library_sys SET view_count = NVL(view_count, 0) + 1 WHERE book_no = ?";
		
		String detailSelectSql = """
		        SELECT ls.book_no, ls.b_title, ls.descript, ls.public_date, ls.view_count, ls.update_date, 
		               c.category_id, c.c_name
		        FROM library_sys ls
		        LEFT JOIN book_categories bc ON ls.book_no = bc.book_no
		        LEFT JOIN categories c ON bc.category_id = c.category_id
		        WHERE ls.book_no = ?
		        """;

		try {
			pstmt = conn.prepareStatement(countSql);
			pstmt.setInt(1, bookNo);
			rs = pstmt.executeQuery();	// select 실행(count)

			if (rs.next()) { 	// sql실행한 데이터들의 1행을 가져옴(데이터가 있으면 true, 없으면 false)
				int rowCount = rs.getInt(1);	// count(*)값 가져오기
				
				if (rowCount == 0) {			// 상세조회할 게시글이 없는 경우
					System.out.println("정보를 조회 할 등록 번호 도서가 없습니다.");
					return;
				}
			}
			// 조회수 증가시키는 SQL 실행 **
            pstmt = conn.prepareStatement(updateReadCountSql);
            pstmt.setInt(1, bookNo);
            pstmt.executeUpdate();
            
			// sql실행(detailSelectSql)
			pstmt = conn.prepareStatement(detailSelectSql);
			pstmt.setInt(1, bookNo);
			rs = pstmt.executeQuery();	// select 실행(detail)
			
			if (rs.next()) {
				System.out.println("-------------------------------------------------------------");
				System.out.println("도서 번호: " + rs.getInt("book_no"));
	            System.out.println("도서 제목: " + rs.getString("b_title"));
	            System.out.println("도서 설명: " + rs.getString("descript"));
	            System.out.println("정보 작성일: " + rs.getDate("public_date"));
	            System.out.println("수정 일자: " + rs.getDate("update_date"));
	            System.out.println("조회수: " + rs.getInt("view_count"));
				// 카테고리 정보 출력
	            int categoryId = rs.getInt("category_id");
	            String categoryName = rs.getString("c_name");
	            
	            if (categoryName != null) {
	            	System.out.printf("카테고리: %s, 카테고리ID번호: %d%n", categoryName, categoryId);
	            }
	            // 추가 카테고리 정보가 있을 경우 계속 출력
	            while (rs.next()) {
	            	categoryId = rs.getInt("category_id");
	            	categoryName = rs.getString("c_name");
	                    
	            	if (categoryName != null) {
	            		System.out.printf("카테고리: %s, 카테고리ID번호: %d%n", categoryName, categoryId);
	            	}
	            }
	            System.out.println();
	            System.out.println("-------------------------------------------------------------");
			}
		} catch(SQLException se) {
			System.out.println("도서 설명 열람 Qurry 실행 오류: " + se.getMessage());
		} finally {
			// Oracle DB 접속 관련 객체들 정리
			BookDBManager.dbClose(conn, pstmt, rs);
		}
	}
		
	public void updateOneBook() {
		System.out.println("도서 등록 정보를 수정합니다.");
		// 1. 수정할 게시글 번호   
		System.out.print("수정할 도서 번호를 입력하세요: ");
		int boardNo = Integer.parseInt(scanner.nextLine());
				
		// 입력한 게시글 번호의 개수를 가져오기
		String countSql = "SELECT COUNT(*) FROM library_sys WHERE book_no = ?";

		// 게시글의 상세 데이터를 받기 위해 Oracle DB접속준비
		Connection conn = BookDBManager.getDBConnection();
		
		int resultRow = 0;
		try {  	// *수정할 글이 없을 때 메세지를 출력하는 추가코드
			 	// 3. sql실행
			pstmt = conn.prepareStatement(countSql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery(); // select실행(count)			
			if(rs.next()) {
				resultRow = rs.getInt(1);
					if(resultRow == 0) {
						System.out.println("없는 도서 번호 입니다.");
							return;
					}
			}
		} catch(SQLException se) {
			System.out.println("도서 등록 번호 개수 Query 실행 오류: " + se.getMessage());
		}
				
		// 2. 수정할 게시글 제목
		System.out.print("수정할 제목를 입력하세요: ");
		String updateTitle = scanner.nextLine();
		// 3. 수정할 게시글 내용
		System.out.print("수정할 내용를 입력하세요: ");
		String updateContent = scanner.nextLine();
				
		// 2. 게시글 특정번호 수정 sql
		String updateOneSql = "UPDATE library_sys SET b_title = ?, descript = ?, "
				+ "update_date = sysdate WHERE book_no = ?";
				
		try {
			// 3. sql실행
			pstmt = conn.prepareStatement(updateOneSql);
			pstmt.setString(1, updateTitle);
			pstmt.setString(2, updateContent);
			pstmt.setInt(3, boardNo);
			resultRow = pstmt.executeUpdate(); // update실행

			System.out.println("도서 " + boardNo + "번을 성공적으로 수정 하였습니다!");
		} catch(SQLException se) {
			System.out.println("등록 도서 수정 Query 실행 오류: " + se.getMessage());
		} finally {
			// Oracle DB 접속 관련 객체들 정리
			BookDBManager.dbClose(conn, pstmt, rs);
		}
	}

	public void deleteBook() {
		System.out.println("도서를 삭제합니다.");
		System.out.print("삭제할 등록 번호를 입력하세요: ");
		int bookNo = Integer.parseInt(scanner.nextLine());
		
		// 삭제 더블체크
		System.out.print("정말 " + bookNo + "번 등록 도서를 삭제 하시겠습니까? (소문자)(y/n)");
		String confirmYN = scanner.nextLine();
		if (!confirmYN.equals("y"))
			return;

		// 1. 게시글의 상세 데이터를 받기 위해 Oracle DB접속준비
		Connection conn = BookDBManager.getDBConnection();
		
		// 입력한 게시글 번호의 개수를 가져오기
		String countSql = "SELECT COUNT(*) FROM library_sys WHERE book_no = ?";
		
		// 게시글 특정번호 삭제 sql
		String deleteOneSql = "DELETE FROM library_sys WHERE book_no = ?";
		
		int resultRow = 0;
		
		try {
			// sql실행
			pstmt = conn.prepareStatement(countSql);
			pstmt.setInt(1, bookNo);
			rs = pstmt.executeQuery(); // select실행
			
			if (rs.next()) {
				resultRow = rs.getInt(1); // count(*)값 가져오기
				
				if (resultRow == 0) {
					System.out.println("삭제 할 도서 등록 번호가 없습니다.");
					return;
				}
			}
						
			// sql실행
			pstmt = conn.prepareStatement(deleteOneSql);
			pstmt.setInt(1, bookNo);
			resultRow = pstmt.executeUpdate(); // delete실행

			System.out.println("도서 번호 " + bookNo + "번을 성공적으로 삭제하였습니다.");
		} catch(SQLException se) {
			System.out.println("등록 도서 삭제 Query 실행 오류: " + se.getMessage());
		} finally {
			// Oracle DB 접속 관련 객체들 정리
			BookDBManager.dbClose(conn, pstmt, rs);
		}
	}
		
		// 카테고리 추가 메소드 // 메뉴 6
	public void insertCategory() {
		System.out.print("추가할 카테고리 이름을 입력하세요: ");
		String categoryName = scanner.nextLine();
		    
		String insertCategorySql = "INSERT INTO categories (category_id, c_name) VALUES (library_sqc.nextval, ?)";
		Connection conn = BookDBManager.getDBConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(insertCategorySql);
			pstmt.setString(1, categoryName);
			pstmt.executeUpdate();
			System.out.println("카테고리가 성공적으로 추가되었습니다.");
		} catch (SQLException se) {
			System.out.println("카테고리 추가 도중 에러 발생했습니다: " + se.getMessage());
		} finally {
			BookDBManager.dbClose(conn, pstmt, null);
		}	
	}
	
	// 특정 카테고리에 속한 책 조회 메소드 		// 메뉴7
	public void getBooksByCategory() {
		System.out.print("조회할 카테고리 이름을 입력하세요:");
		String categoryName = scanner.nextLine();
		    
		String selectBooksSql = """
			SELECT b.book_no, b.b_title, c.c_name 
			FROM library_sys b 
		    JOIN book_categories bc ON b.book_no = bc.book_no 
		    JOIN categories c ON bc.category_id = c.category_id 
		    WHERE c.c_name = ?
		    """;
		    
		Connection conn = BookDBManager.getDBConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		    
		try {
			pstmt = conn.prepareStatement(selectBooksSql);
			pstmt.setString(1, categoryName);
			rs = pstmt.executeQuery();
		        
			System.out.println("도서 목록:");
			boolean hasResults = false;
			while (rs.next()) {
				hasResults = true;
				int bookNo = rs.getInt("book_no");
				String title = rs.getString("b_title");
				String catName = rs.getString("c_name");
		            
				System.out.printf("도서 번호: %d, 제목: %s, 카테고리: %s%n", bookNo, title, catName);
			}
			if (!hasResults) {
		            System.out.println("해당 카테고리에 도서가 존재하지 않습니다.");
			}
			
		} catch (SQLException se) {
			System.out.println("카테고리별 도서 조회 도중 에러 발생했습니다: " + se.getMessage());
		} finally {
			BookDBManager.dbClose(conn, pstmt, rs);
		}
	}
	
	//카테고리 목록 조회 	// 메뉴 8
	public void listCategories() {
		System.out.println("등록된 카테고리 목록을 조회합니다.");
	    String selectCategoriesSql = "SELECT * FROM categories ORDER BY category_id";
	    Connection conn = BookDBManager.getDBConnection();
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        pstmt = conn.prepareStatement(selectCategoriesSql);
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            int categoryId = rs.getInt("category_id");
	            String categoryName = rs.getString("c_name");
	            System.out.printf("카테고리 ID: %d, 이름: %s%n", categoryId, categoryName);
	        }
	    } catch (SQLException se) {
	    	System.out.println("카테고리 목록 조회 도중 에러 발생했습니다: " + se.getMessage());
	    } finally {
	        BookDBManager.dbClose(conn, pstmt, rs);
	    }
	}
		
	// 책을 카테고리에 매핑하는 메소드 // 메뉴 9
	public void mapBookToCategory() {
		System.out.print("카테고리에 추가할 도서 번호를 입력하세요: ");
		int bookNo = Integer.parseInt(scanner.nextLine());
		System.out.print("추가할 카테고리 번호를 입력하세요: ");
		int categoryId = Integer.parseInt(scanner.nextLine());

		String insertMappingSql = "INSERT INTO book_categories"
    		+ "(book_no, category_id) VALUES (?, ?)";
		Connection conn = BookDBManager.getDBConnection();
		PreparedStatement pstmt = null;

    try {
        // 책 번호와 카테고리 아이디가 존재하는지 확인
        if (isBookExists(bookNo, conn) && isCategoryExists(categoryId, conn)) {
            pstmt = conn.prepareStatement(insertMappingSql);
            pstmt.setInt(1, bookNo);
            pstmt.setInt(2, categoryId);
            pstmt.executeUpdate();
            System.out.println("책이 카테고리에 성공적으로 추가되었습니다.");
        } else {
            System.out.println("입력한 도서 번호 또는 카테고리 번호가 존재하지 않습니다.");
        }
    } catch (SQLException se) {
        System.out.println("책을 카테고리에 추가 도중 에러 발생했습니다: " + se.getMessage());
    } finally {
        BookDBManager.dbClose(conn, pstmt, null);
    }
}

	private boolean isBookExists(int bookNo, Connection conn) throws SQLException {
		String checkBookSql = "SELECT 1 FROM library_sys WHERE book_no = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(checkBookSql)) {
			pstmt.setInt(1, bookNo);
			try (ResultSet rs = pstmt.executeQuery()) {
				return rs.next();
			}
		}
	}

	private boolean isCategoryExists(int categoryId, Connection conn) throws SQLException {
		String checkCategorySql = "SELECT 1 FROM categories WHERE category_id = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(checkCategorySql)) {
			pstmt.setInt(1, categoryId);
			try (ResultSet rs = pstmt.executeQuery()) {
				return rs.next();
			}
		}
	}
	
	// 카테고리 수정 // 메뉴10
	public void updateCategory() {
	    System.out.print("수정할 카테고리 ID번호를 입력하세요: ");
	    int categoryId = Integer.parseInt(scanner.nextLine());
	    System.out.print("새로운 카테고리 이름을 입력하세요(취소: q): ");
	    String newCategoryName = scanner.nextLine();

	    String updateCategorySql = "UPDATE categories SET c_name = ? WHERE category_id = ?";
	    Connection conn = BookDBManager.getDBConnection();
	    PreparedStatement pstmt = null;

	    try {
	        pstmt = conn.prepareStatement(updateCategorySql);
	        pstmt.setString(1, newCategoryName);
	        pstmt.setInt(2, categoryId);
	        int result = pstmt.executeUpdate();

	        if (result > 0) {
	            System.out.println("카테고리가 성공적으로 수정되었습니다.");
	        } else {
	            System.out.println("해당 카테고리 ID번호를 가진 카테고리가 존재하지 않습니다.");
	        }
	    } catch (SQLException se) {
	        System.out.println("카테고리 수정 도중 에러 발생했습니다: " + se.getMessage());
	    } finally {
	        BookDBManager.dbClose(conn, pstmt, null);
	    }
	}
	
	// 카테고리 삭제 // 메뉴 11
	public void deleteCategory() {
	    System.out.print("삭제할 카테고리 ID번호를 입력하세요: ");
	    int categoryId = Integer.parseInt(scanner.nextLine());

	    String deleteCategorySql = "DELETE FROM categories WHERE category_id = ?";
	    Connection conn = BookDBManager.getDBConnection();
	    PreparedStatement pstmt = null;

	    try {
	        pstmt = conn.prepareStatement(deleteCategorySql);
	        pstmt.setInt(1, categoryId);
	        int result = pstmt.executeUpdate();

	        if (result > 0) {
	            System.out.println("카테고리가 성공적으로 삭제되었습니다.");
	        } else {
	            System.out.println("해당 카테고리 ID번호를 가진 카테고리가 존재하지 않습니다.");
	        }
	    } catch (SQLException se) {
	        System.out.println("카테고리 삭제 도중 에러 발생했습니다: " + se.getMessage());
	    } finally {
	        BookDBManager.dbClose(conn, pstmt, null);
	    }
	}
}

