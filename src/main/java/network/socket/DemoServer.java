package network.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoServer {
	public static void main(String[] args) throws IOException {
		int port = 5050;

		// ���� ���� ����
		ServerSocket ssk = new ServerSocket(port);

		System.out.println("���� �����");

		while (true) {
			Socket sock = ssk.accept();
			System.out.println("����ڰ� �����߽��ϴ�.");
			System.out.println("Client IP : " + sock.getInetAddress());
		}
	}

}
