package Practice08;

public class DaoExample {
	
	public static void bdWork(DataAccessObject dao) {
		//dao.select
		//dao.insert
		//dao.update
		//dao.delete
	}

	public static void main(String[] args) {
		bdWork(new OracleDao());
		bdWork(new MySqlDao());
		
		
	}

}
