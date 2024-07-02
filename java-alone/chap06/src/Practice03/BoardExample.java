package Practice03;

public class BoardExample {

	public static void main(String[] args) {
		
		Board board1 = new Board(
				"테스트 제목", 
				"테스트 본문"
				);
		Board board2 
			= new Board("테스트제목", "테스트본문", "홍길동");
		Board board3 
			= new Board("테스트제목", "테스트본문", "홍길동", "날짜");
		Board board4 
			= new Board("테스트제목", "테스트본문", "홍길동", "날짜", 0);

	}

}
