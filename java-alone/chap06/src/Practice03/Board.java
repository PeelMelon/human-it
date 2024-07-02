package Practice03;


public class Board {
	
	String title;
	String content;
	String writer;
	String date;
	int hitcount;
	
	
	public Board(String title, String content) {
		this(title, content, "황킹", "현재날짜", 0);
		}
		
	public Board(String title, String content, String writer) {
		this(title, content, writer, "현재날짜", 0);
		}
	
	public Board(String title, String content, String writer, String date) {
		this(title, "본문", writer, "현재날짜", 0);
		}
	
	public Board(String title, String content, String writer, String date, int hitcount){
	 	this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.hitcount = hitcount;
		}
	}

