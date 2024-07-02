package sec03;

import java.util.*; 
import java.util.Scanner;

//상품을 관리하는 메인 클래스
public class ProductStoage {
	
	Scanner scanner = new Scanner(System.in);
	private int counter = 0;
	private List<Product> listProduct = new ArrayList();
	// 메뉴를 보여주는 메소드
	public void showMenu() {
		while(true) {
		System.out.println("--------------------------");
		System.out.println("1.등록  |  2.목록  |  3. 종료");
		System.out.println("--------------------------");
		System.out.println("선택: ");
		
		//키보드를 입력받는 코드
		String selectNo = scanner.nextLine();
		switch(selectNo) {
		case "1":	// 등록
			break;
		case "2":	// 조회
			break;
		case "3":	// 종료
			return;
		
			}
		}
	}
	// 상품 등록 실행
	public void registerProduct() {
		try {
		Product product = new Product();
		product.setPno(++counter);
		
		System.out.print("상품명: ");
		product.setName(scanner.nextLine());
		
		System.out.print("가격: ");
		product.setPrice(Integer.parseInt(scanner.nextLine()));
		
		System.out.print("재고: ");
		product.setStock(Integer.parseInt(scanner.nextLine()));
		
		listProduct.add(product);
	} catch(Exception e) {
		System.out.println("등록 에러: " + e.getMessage());
	
		}
	}
	
	public void showProduct() {
		for(Product p : listProduct) {
			System.out.println(p.getPno() + "\t" 
					+ p.getName() + "\t" 
					+ p.getPrice() + "\t" 
					+ p.getStock());
		}
	}
}

