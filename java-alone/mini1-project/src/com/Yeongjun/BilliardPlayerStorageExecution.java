package com.Yeongjun;

public class BilliardPlayerStorageExecution {

	public static void main(String[] args) {
		BilliardPlayerStorage storage = new BilliardPlayerStorage();
        storage.loadPlayers(); // 프로그램 시작 시 불러오기
        storage.showMenu();
	}
 }
