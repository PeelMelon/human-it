package com.Yeongjun;

import java.io.*;

import java.util.*;

public class BilliardPlayerStorage {
	
Scanner scanner = new Scanner(System.in);
private int counter = 0;
private List<BilliardPlayer> listPlayers = new ArrayList<>();


private static final String FILE_PATH = 
"C:/JoYeongJun/Billiard/players.txt"; // 파일 경로 설정


public void showMenu() {
    while (true) {
    System.out.println("==============================================================================");
    System.out.println("1. 선수등록  |  2. 상세보기  |  3. 수정하기  |  4. 삭제하기  |  5. 파일저장  |  6. 종료");
    System.out.println("==============================================================================");
    System.out.print("선택: ");

    String selectNo = scanner.nextLine();
    switch (selectNo) {
        case "1":    // 선수 등록
        	registerPlayer();
            break;
        case "2":    // 상세보기
            viewPlayerDetail();
            break;
        case "3":    // 수정하기
            modifyPlayer();
            break;
        case "4":    // 삭제하기
            deletePlayer();
            break;
        case "5":    // 파일 저장
            savePlayers();
            break;
        case "6":    // 종료
            return;
    		}
    	}
	}
//선수 등록 실행
public void registerPlayer() {
    try {
    	
    	BilliardPlayer player = new BilliardPlayer();
        player.setPlayerNo(++counter);

        System.out.print("이름: ");
        player.setName(scanner.nextLine());

        System.out.print("나이: ");
        player.setAge(Integer.parseInt(scanner.nextLine()));

        System.out.print("랭킹: ");
        player.setRank(scanner.nextLine());

        listPlayers.add(player);
        System.out.println("선수가 등록되었습니다.");
        
     // 등록된 선수 목록 다시 출력
        System.out.println("등록된 선수 목록:");
        showPlayers();
    } catch (Exception e) {
        System.out.println("등록 에러: " + e.getMessage());
    }
}
	// 선수 목록 조회
public void showPlayers() {
	for (BilliardPlayer p : listPlayers) {
		System.out.println(p.getPlayerNo() + "\t"
				+ p.getName() + "\t"
				+ p.getAge() + "\t"
				+ p.getRank());
		}
	}
	// 선수 상세 보기
	public void viewPlayerDetail() {
		System.out.println("등록된 선수 목록:");
		showPlayers(); // 등록된 선수 목록을 먼저 출력합니다.
		
		while (true) {
			System.out.print("상세보기할 선수 번호 (종료: q): ");
			String input = scanner.nextLine();
			if (input.equalsIgnoreCase("q")) {
				return;
			}
			int playerNo = Integer.parseInt(input);
			boolean found = false;
			for (BilliardPlayer p : listPlayers) {
				if (p.getPlayerNo() == playerNo) {
					System.out.println("번호: " + p.getPlayerNo());
					System.out.println("이름: " + p.getName());
					System.out.println("나이: " + p.getAge());
					System.out.println("랭킹: " + p.getRank());
					found = true;
					break;
			}
        }     
		if (!found) {
            System.out.println("선수를 찾을 수 없습니다.");
        }
    }
}
	// 선수 수정하기
	public void modifyPlayer() {
		System.out.print("수정할 선수 번호: ");
		int playerNo = Integer.parseInt(scanner.nextLine());
		for (BilliardPlayer p : listPlayers) {
			if (p.getPlayerNo() == playerNo) {
				System.out.print("새 이름: ");
				p.setName(scanner.nextLine());

				System.out.print("새 나이: ");
				p.setAge(Integer.parseInt(scanner.nextLine()));

				System.out.print("새 랭킹: ");
				p.setRank(scanner.nextLine());

				System.out.println("선수 정보가 수정되었습니다.");
				return;
            }
        }
        System.out.println("선수를 찾을 수 없습니다.");
    }

    // 선수 삭제하기
public void deletePlayer() {
	System.out.print("삭제할 선수 번호: ");
	int playerNo = Integer.parseInt(scanner.nextLine());
	Iterator<BilliardPlayer> iterator = listPlayers.iterator();
    while (iterator.hasNext()) {
    	BilliardPlayer p = iterator.next();
    	if (p.getPlayerNo() == playerNo) {
    		iterator.remove();
    		System.out.println("선수가 삭제되었습니다.");
    		return;
    	}
    }
    System.out.println("선수를 찾을 수 없습니다.");
    }

    // 선수 목록 저장 (텍스트 파일로)
public void savePlayers() {
	File file = new File(FILE_PATH);
    try {
        if (file.createNewFile()) {
            System.out.println("새 파일이 생성되었습니다: " + file.getName());
        } else {
            System.out.println("파일이 이미 존재합니다.");
        }
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            for (BilliardPlayer p : listPlayers) {
                pw.println(p.getPlayerNo() + "," +
                        p.getName() + "," + p.getAge() + "," + p.getRank());
            }
            System.out.println("선수 목록이 저장되었습니다.");
        }
    } catch (Exception e) {
        System.out.println("파일 생성 및 저장 에러: " + e.getMessage());
    }
	
	try (PrintWriter pw = new PrintWriter(new FileWriter("players.txt"))) {
		 for (BilliardPlayer p : listPlayers) {
			pw.println(p.getPlayerNo() + "," + 
			p.getName() + "," + p.getAge() + "," + p.getRank());
	}
		System.out.println("선수 목록이 저장되었습니다.");
	} catch (Exception e) {
		System.out.println("저장 에러: " + e.getMessage());
	}
}

// 선수 목록 불러오기
public void loadPlayers() {
	try (BufferedReader br = new BufferedReader(new FileReader("players.txt"))) {
		String line;
		while ((line = br.readLine()) != null) {
			String[] data = line.split(",");
			BilliardPlayer player = new BilliardPlayer();
			player.setPlayerNo(Integer.parseInt(data[0]));
			player.setName(data[1]);
			player.setAge(Integer.parseInt(data[2]));
			player.setRank(data[3]);
			listPlayers.add(player);
			counter = player.getPlayerNo();
		}
	} catch (FileNotFoundException e) {
		System.out.println("기존 선수 목록을 찾을 수 없습니다. 새로 시작합니다.");
	} catch (Exception e) {
		System.out.println("불러오기 에러: " + e.getMessage());
		}
	}
}

