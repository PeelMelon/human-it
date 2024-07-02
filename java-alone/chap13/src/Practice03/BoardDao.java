package Practice03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class BoardDao {
	public List<Board> getBoardList(){
		List<Board> boardList = new ArrayList<>();
		Board board1 =  new Board("제목1", "내용1");
		boardList.add(board1);
		/*
		Board board2 =  new Board("제목2", "내용2");
		boardList.add(board2);
		*/
		boardList.add(new Board("제목2", "내용2"));
		boardList.add(new Board("제목3", "내용3"));
		boardList.add(new Board("제목4", "내용4"));
				
		return boardList;
	}
	

}
