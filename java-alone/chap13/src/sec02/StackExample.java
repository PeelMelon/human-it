package sec02;

import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {
		Stack<Coin>coinbox = new Stack<Coin>();
		
		coinbox.push(new Coin(100));
		coinbox.push(new Coin(50));
		coinbox.push(new Coin(500));
		coinbox.push(new Coin(10));
		
		while(!coinbox.isEmpty()) {
			Coin coin = coinbox.pop();
			System.out.println("꺼내온 킹전 : " + coin.getvalue() + "원");
		}

	}

}
