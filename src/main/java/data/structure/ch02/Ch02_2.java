package data.structure.ch02;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Ch02_2 {
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = new int[6];
		int[] arr3 = new int[6];

		copyArray(arr1, arr2);
		for (int i = 0; i < arr2.length; i++)
			System.out.print(arr2[i]+" ");
		
		System.out.println();
		
		rcopyArray(arr1, arr3);
		for (int i = 0; i < arr3.length; i++)
			System.out.print(arr3[i]+" ");
	}

	// copy Array
	static void copyArray(int[] arr1, int[] arr2) {
		int len = arr1.length < arr2.length ? arr1.length : arr2.length;

		for (int i = 0; i < len; i++) {
			arr2[i] = arr1[i];
		}
	}

	// reversedly copy Array
	static void rcopyArray(int[] arr1, int[] arr2) {
		int len = arr1.length < arr2.length ? arr1.length : arr2.length;

		for (int i = 0; i < len; i++) {
			arr2[i] = arr1[len - i - 1];
		}
	}
}
