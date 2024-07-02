package sec02;

import java.io.*;
import java.util.*;
import java.text.*;

public class ObjectStreamExample {

	public static void main(String[] args) throws Exception {
		// Object 보조 스트림 활용 예제
		
		// 게시판 등록
		wirteList();
		
		// 게시판 조회
		List<Board> boardList = readList();
		for(Board board : boardList) {
			System.out.println(
					board.getBno() + "\t" + 
					board.getTitle() + "\t" +
					board.getContent() + "\t" +
					board.getWriter() + "\t" +
					board.getWriter() + "\t" +
					new SimpleDateFormat("yyyy-MM-dd").format(board.getDate())
			);
		}
	
		System.out.println("프로그램 종료");
	}
	public static void wirteList() throws Exception {
		List<Board> boardList = new ArrayList<>();
		
		boardList.add(new Board(1, "제목1", "내용1", "글쓴이1", new Date()));
		boardList.add(new Board(2, "제목2", "내용2", "글쓴이2", new Date()));
		boardList.add(new Board(3, "제목3", "내용3", "글쓴이3", new Date()));
		
		FileOutputStream fos = new FileOutputStream("./bin/sec02/board.db");
		ObjectOutputStream oos = new ObjectOutputStream(fos);  // objectoutput 보조 스트림 사용
		oos.writeObject(boardList);
		oos.flush();
		oos.close();
	}
	// board.db파일에 있는 게시판의 내용들을 조회하여 List객체를 리턴한다.
	public static List<Board> readList() throws Exception {
		FileInputStream fis = new FileInputStream("./bin/sec02/board.db");
		ObjectInputStream ois = new ObjectInputStream(fis);  // objectinput 보조 스트림 사용
		List<Board> boardList = (List<Board>)ois.readObject();
		
		return boardList;
	}
}
