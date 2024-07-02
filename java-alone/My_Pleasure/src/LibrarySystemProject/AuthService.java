package LibrarySystemProject;

import java.sql.*;

public class AuthService {
	public boolean login(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = BookDBManager.getDBConnection(); // 데이터베이스 연결을 얻어옴
            pstmt = conn.prepareStatement(query);  // SQL 쿼리를 준비

            pstmt.setString(1, username); // 첫 번째 물음표에 사용자명 설정
            pstmt.setString(2, password); // 두 번째 물음표에 비밀번호 설정

            rs = pstmt.executeQuery();
            return rs.next();  // 결과 집합에 다음 레코드가 있다면 true 반환 (사용자 존재)
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // 예외 발생 시 false 반환
        } finally {
        	BookDBManager.dbClose(conn, pstmt, rs); // (연결, 문장, 결과 집합)
        }
    }

    public boolean register(String username, String password) {
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
        	conn = BookDBManager.getDBConnection();
            pstmt = conn.prepareStatement(query);

            pstmt.setString(1, username); // 첫 번째 물음표에 사용자명 설정
            pstmt.setString(2, password); // 두 번째 물음표에 비밀번호 설정

            int rowsAffected = pstmt.executeUpdate(); 
            // INSERT 쿼리 실행 후 영향을 받은 행 수 반환
            return rowsAffected > 0; // 영향을 받은 행 수가 1 이상이면 true 반환 (회원 가입 성공)
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // 예외 발생 시 false 반환
        } finally {
            BookDBManager.dbClose(conn, pstmt, null); // 리소스 정리 (연결, 문장, 결과 집합 없음)
        }
    }
}
