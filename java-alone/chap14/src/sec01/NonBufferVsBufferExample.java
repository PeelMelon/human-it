package sec01;

import java.io.*;

public class NonBufferVsBufferExample {

	public static void main(String[] args) throws Exception {
		// 버퍼드를 사용하지 않고 카피
		// 카피할 파일의 패스 가져오기
		String originalFilePath1 = 
				NonBufferVsBufferExample.class.getResource("dog1.jpg").getPath();
		System.out.println("originalFilePath1 >" + originalFilePath1);
		
		//복사 대상의 패스 세팅
		String targetFilepath1= "./bin/sec01/dog1-copy.jpg";
		FileInputStream fis = new FileInputStream(originalFilePath1);
		FileOutputStream fos = new FileOutputStream(originalFilePath1);
		
		long nonBufferElaspTime = copy(fis, fos);
		System.out.println("버퍼를 사용하지 않았을 때:\t" + nonBufferElaspTime + "ns");
		
		
		String originalFilePath2 = 
				NonBufferVsBufferExample.class.getResource("dog2.jpg").getPath();
		System.out.println("originalFilePath2 >" + originalFilePath2);
		
		//복사 대상의 패스 세팅
		String targetFilepath2= "./bin/sec01/dog1-copy.jpg";
		FileInputStream bis = new FileInputStream(originalFilePath2);
		FileOutputStream bos = new FileOutputStream(originalFilePath2);
		
		long nonBufferElaspTime2 = copy(bis, bos);
		System.out.println("버퍼를 사용하지 않았을 때:\t" + nonBufferElaspTime + "ns");
		
		
		fis.close();
		fos.close();
		bis.close();
		bos.close();
		
		
	}
	
	/**
	 * 
	 * @param is
	 * @param out
	 * @return 걸린시간
	 * @throws Exception
	 */
	public static long copy(InputStream is, OutputStream out) throws Exception {
		int data = -1;
		
		long start = System.nanoTime(); 
		while(true) {
			data = is.read();
			if (data == -1) break;
			out.write(data);
		}
		out.flush();
		
		return System.nanoTime() - start;
		}
	}

