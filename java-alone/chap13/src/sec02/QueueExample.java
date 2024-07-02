package sec02;

import java.util.*;

public class QueueExample {

	public static void main(String[] args) {
		
		Queue<Message> messageQueue = new LinkedList<>();
		messageQueue.offer(new Message("sendMail", "ㅋㅋ 버근가"));
		messageQueue.offer(new Message("sendSMS", "서걱"));
		messageQueue.offer(new Message("sendKaotalk", "진혼곡"));
		
		while(!messageQueue.isEmpty()) { // 큐 안에 객체들이 비어있을때까지 반복
			Message message = messageQueue.poll();
			switch(message.command) {
			case "sendMail": 	// first 제일 먼저 실행
				System.out.println(message.to + "님에게 메일을 보냄");
				break;
			case "sendSMS":	// second
				System.out.println(message.to + "님에게 SMS을 보냄");
				break;
			case "sendKaotalk": //third // 순서 바꿔도 입력이 3번이라서 3번째 나옴
				System.out.println(message.to + "님에게 Kaotalk을 보냄");
				break;
			}
		}
	}
}
