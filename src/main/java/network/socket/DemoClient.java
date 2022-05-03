package network.socket;

import java.io.IOException;
import java.net.Socket;

public class DemoClient {
	public static void main(String[] args) throws IOException {
		// 연결시 소켓 생성, 안되면 예외 발생
		Socket sk = new Socket("127.0.0.1", 5050);
		System.out.println("서버와 접속이 되었습니다.");
		
/*
* 접속 대기중
* 사용자가 접속했습니다.
* Client IP : /127.0.0.1
*/
	}

}
