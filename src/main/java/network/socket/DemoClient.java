package network.socket;

import java.io.IOException;
import java.net.Socket;

public class DemoClient {
	public static void main(String[] args) throws IOException {
		// ����� ���� ����, �ȵǸ� ���� �߻�
		Socket sk = new Socket("127.0.0.1", 5050);
		System.out.println("������ ������ �Ǿ����ϴ�.");
		
/*
* ���� �����
* ����ڰ� �����߽��ϴ�.
* Client IP : /127.0.0.1
*/
	}

}
