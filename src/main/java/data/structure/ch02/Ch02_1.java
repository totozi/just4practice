package data.structure.ch02;

import java.util.Random;
import java.util.Scanner;

public class Ch02_1 {
	public static void main(String[] args) {
		int[] a = { 3, 5, 8, 4, 12, -2, 6 };

		int tmp;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] < a[j + 1]) {
					tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}

		}
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
			sum +=a[i];
		}
		System.out.println("sum : " + sum);
	}
}
