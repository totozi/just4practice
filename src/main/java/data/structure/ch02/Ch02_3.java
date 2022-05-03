package data.structure.ch02;

import java.util.Scanner;

public class Ch02_3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int no; // ��ȯ�� ����
		int cd; // ���
		int dno; // ��ȯ�� �ڸ���
		int retry; // again?
		char[] cno = new char[32]; // ��ȯ �� �� �ڸ��� ���ڸ� �־�δ� ���ڿ�

		System.out.println("10������ ��� ��ȯ�մϴ�.");
		do {
			do {
				System.out.println("��ȯ�ϴ� ���� �ƴ� ���� : ");
				no = scan.nextInt();
			} while (no < 0);

			do {
				System.out.println("� ������ ��ȯ�ұ��? (2~36) : ");
				cd = scan.nextInt();
			} while (cd < 2 || cd > 36);
			dno = cardConvR(no, cd, cno);

			System.out.print(cd + "�����δ� ");
			for (int i = dno - 1; i >= 0; i--)
				System.out.print(cno[i]);
			System.out.println("�Դϴ�.");

			System.out.println("�� �� �� �ұ��? (1.Y / 2.N) : ");
			retry = scan.nextInt();
		} while (retry == 1);
		if(retry == 2) {
			System.out.println("����Ǿ����ϴ�.");
		}

	}

	private static int cardConvR(int no, int cd, char[] cno) {
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		do {
			cno[digits++] = dchar.charAt(no % cd);
			no /= cd;
		} while (no != 0);
		return digits;
	}

}
