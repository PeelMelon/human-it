package com.Student1;

import java.sql.*;

public class JavaSqlExample {

	public static void main(String[] args) {
		// java 와 oracle sql 연동 예제

		// 1. java 와 oracle 연동해주는 드라이버 를 설정(오라클에서 jar파일로 제공)
		//	 (1) ojdbc8~ jar파일 프로젝트 내에 저장
		//	 (2) java build path - library - class path에 external jars로 (1)의 파일을 등록 
		
		// 2. odjbc의 패키지 라이브러리 클래스 파일 중에 접속 및 연동을 도와준는 클래스 객체를 선언 
		// 	 (1) connection -> DBMS 접속 관리 클래스
		//	 (2) 
		//	 (3)
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");				// 오라클 접속을 위한 Driver 사전작업
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";	// 오라클 접속할 위치값 저장
			String username = "boarduser1";		// 오라클 접속 계정id
			String password = "1234";			// 오라클 접속 계정pw
			
			// 실제 오라클 접속하여 접속을 다루는 객체를 받아서 Connection클래스 객체에 대입
			conn = DriverManager.getConnection(url, username, password);					
		} catch(Exception e) {
			e.printStackTrace();		// 에러 추적 표시
			
			System.out.println("DB연결 오류");
		}
		
		// 게시글 조회 쿼리(query)
		//String sql1 = "SELECT seq, title, content, create_date, read_count FROM board WHERE seq = 2";
//		String sql1 = "SELECT * FROM board";
//		String sql1 = "SELECT seq, title, content, create_date, read_count FROM board WHERE seq = ? or title = ?";
		String sql1 = "SELECT seq, title, content, create_date, read_count FROM board " 
						+ "WHERE seq = " + 2 + " or title = '" + "제목입니다1"  +  "'";
		try {
			pstmt = conn.prepareStatement(sql1);	// sql1문자열에 있는 sql문을 실행준비
//			pstmt.setInt(1, 2);				// 첫번째 ?에 숫자 2를 세팅
//			pstmt.setString(2, "제목입니다1");	// 두번째 ?에 문자열'제목입니다1'를 세팅
			rs = pstmt.executeQuery();				// sql1문자열에 있는 sql문(select문)을 실행
			
			while(rs.next()) {		// rs.next()는 가져온 데이터들의 행을 가져오고 값이 있다면 true를 반환 \
				// 한꺼번에 주석처리 -> 블록을 지정하고 ctrl + / 하면 됨
				System.out.println("게시글 번호: " + rs.getString("seq")); 	// 각 행의 seq컬럼의 값(리턴값타입 string)을 가져온다.
				System.out.println("게시글 제목: " + rs.getString("title")); 	// 각 행의 title컬럼의 값(리턴값타입 string)을 가져온다.
				System.out.println("게시글 내용: " + rs.getString("content")); 	// 각 행의 content컬럼의 값(리턴값타입 string)을 가져온다.
				System.out.println("게시글 생성일자: " + rs.getString("create_date")); 	// 각 행의 create_date컬럼의 값(리턴값타입 string)을 가져온다.
				System.out.println("게시글 조회수: " + rs.getString("read_count")); 	// 각 행의 read_count컬럼의 값(리턴값타입 string)을 가져온다.
				
//				System.out.println("게시글 번호: " + rs.getString(1)); 	// 각 행의 첫번째컬럼(seq컬럼)의 값(리턴값타입 string)을 가져온다.
//				System.out.println("게시글 제목: " + rs.getString(2)); 	// 각 행의 두번째컬럼(title컬럼)의 값(리턴값타입 string)을 가져온다.
//				System.out.println("게시글 내용: " + rs.getString(3)); 	// 각 행의 세번째컬럼(content컬럼)의 값(리턴값타입 string)을 가져온다.
//				System.out.println("게시글 생성일자: " + rs.getString(4)); 	// 각 행의 네번째컬럼(create_date컬럼)의 값(리턴값타입 string)을 가져온다.
//				System.out.println("게시글 조회주: " + rs.getString(5)); 	// 각 행의 다섯번째(read_count컬럼)f의 값(리턴값타입 string)을 가져온다.
//				
//				System.out.println("게시글 번호: " + rs.getInt("seq")); 	// 각 행의 첫번째컬럼(seq컬럼)의 값(리턴값타입 int)을 가져온다.
//				System.out.println("게시글 번호: " + rs.getInt(1)); 	    // 각 행의 첫번째컬럼(seq컬럼)의 값(리턴값타입 int)을 가져온다.
//				//System.out.println("게시글 번호: " + rs.getInt("title")); 	// error -> title컬럼의 데이터 형태는 string이기 때문
//				System.out.println("게시글 번호: " + rs.getInt(5)); 	// null일 경우에는 기본적으로 0
				
				System.out.println("----------------------------------------------");
			}
			
			// DB입출력 자원 정리
			if (rs != null) {	    // 데이터 가져온 것을 close
				rs.close();
			}
			if (pstmt != null) {	// 데이터 가져온 실행을 close
				pstmt.close();
			}
			if (conn != null) {		// 오라클 접속을 close
				conn.close();
			}
		} catch(SQLException se) {
			se.printStackTrace();		// 에러 추적 표시
			
			System.out.println("db-sql실행오류");
		}
		
		System.out.println("javasql 테스트 프로그램 종료");
	}
}
