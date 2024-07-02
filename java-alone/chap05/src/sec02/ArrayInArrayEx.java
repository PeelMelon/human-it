package sec02;

public class ArrayInArrayEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] scores1 = new int[2][3];   // 2개의 행과 3개의 열
		int[][][] scores2 = new int[4][5][6]; // 4개의 행과 5개의 열과 6개의 높이
		
		System.out.println(scores1.length); // 2
		System.out.println(scores1[0].length); // 3 (첫번째 해의 3개의 열)
		System.out.println(scores1[1].length); // 3 (두번째 열의 3개의 열)
		
		System.out.println(scores2.length); //4
		
		int[][] scores3 = new int[2][];
		scores3[0] = new int[2]; 	// 첫번째 행의 2개의 열 공간 만듦
		scores3[1] = new int[3]; 	// 두번째 행의 3개 열 공간을 만듦
		
		// 다차원배열 생겅과 초기화 같이 하는 방법
		int[][] scores4 = {{95, 80}, {92, 96}}; // 2개의행과 2개의 열 공간을 만듦
		System.out.println(scores4[0][1]); // 80 (1번째 행의 2번째 열)
		System.out.println(scores4[1][1]); // 96( 2번째 행의 2번째 열)

		int[][] mathScores = new int [2][3];
		for(int i = 0; i < mathScores.length; i++)
			for(int k = 0; k < mathScores.length; k++) {
				System.out.println("mathScore[" + i + "]["+ k + "]=" + mathScores[i][k]);
			}
		}
	}

