package com.Yeongjun;

import java.io.*;

public class BilliardPlayer implements Serializable {
	 private int playerNo;  	// 선수 고유 번호
	    private String name; 	// 선수 이름
		   private int age; 	// 선수 나이
	    private String rank;  	// 선수 랭킹
		public int getPlayerNo() {
			return playerNo;
		}
		public void setPlayerNo(int playerNo) {
			this.playerNo = playerNo;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getRank() {
			return rank;
		}
		public void setRank(String rank) {
			this.rank = rank;
		}
}
