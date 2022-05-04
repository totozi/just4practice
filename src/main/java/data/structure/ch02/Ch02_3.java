package data.structure.ch02;

import java.util.Scanner;

public class Ch02_3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int no; // 변환할 정수
		int cd; // 기수
		int dno; // 변환후 자릿수
		int retry; // again?
		char[] cno = new char[32]; // 변환 후 각 자리의 숫자를 넣어두는 문자열

		System.out.println("10진수를 기수 변환합니다.");
		do {
			do {
				System.out.println("변환하는 음이 아닌 정수 : ");
				no = scan.nextInt();
			} while (no < 0);

			do {
				System.out.println("어떤 진수로 변환할까요? (2~36) : ");
				cd = scan.nextInt();
			} while (cd < 2 || cd > 36);
//			dno = cardConvR(no, cd, cno);
			dno = cardConv(no, cd, cno);

			System.out.print(cd + "진수로는 ");
//			for (int i = dno - 1; i >= 0; i--)
			for (int i = 0; i <= dno; i++)
				System.out.print(cno[i]);
			System.out.println("입니다.");

			System.out.println("한 번 더 할까요? (1.Y / 2.N) : ");
			retry = scan.nextInt();
		} while (retry == 1);
		if (retry == 2) {
			System.out.println("종료되었습니다.");
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

	private static int cardConv(int no, int cd, char[] cno) {
		int orgNo = no;
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		int rem =0;
		do {

			cno[digits++] = dchar.charAt(no % cd);
			if (no != orgNo) {
				System.out.println(no +" ... " + rem);
				rem = no % cd;
				no /= cd;
			}
			else {
				System.out.println(no);
				rem = no % cd;
				no /= cd;
			}
			System.out.println("======");
			
		} while (no != 0);
		System.out.println(no +" ... " + rem);
		System.out.println("======");
		char tmp;
		for (int i = 0; i <= digits / 2; i++) {
			tmp = cno[i];
			cno[i] = cno[digits - i];
			cno[digits - i] = tmp;
		}
		//TODO 12를 13진수로 하는 경우에 잘 안됨 원인파악 하고 수정할 것
		return digits;
	}
}
