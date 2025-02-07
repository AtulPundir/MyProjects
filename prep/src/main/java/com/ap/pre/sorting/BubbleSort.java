package com.ap.pre.sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = { 40, 30, 10, 20, 70, 50, 60 };

		System.out.println("Before Sorting  " + Arrays.toString(arr));
		int arr1[] = bubbleSort(arr);
		System.out.println("After Sorting  " + Arrays.toString(arr1));
		int ar[] = { 40, 30, 10, 20, 70, 50, 60 };
		int arr2[] = bubbleSort2(ar);
		System.out.println("After Sorting  " + Arrays.toString(arr2));

		int arr3[] = bubbleSort3(ar);
		System.out.println("After Sorting  " + Arrays.toString(arr3));
	}

	static int[] bubbleSort(int arr[]) {
		boolean isTrue = true;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j - 1] > arr[j]) {
					isTrue = false;
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;

				}

			}
			if (isTrue) {
				return arr;
			}
		}
		return arr;

	}

	static int[] bubbleSort2(int arr[]) {

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j - 1] > arr[j]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}

			}
		}

		return arr;

	}



	static int[] bubbleSort3(int arr[]) {

		for (int i = 0; i <arr.length;i++){
			for (int j = 0; j < arr.length-i -1; j++) {

				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
 				}

			}
		}

		return arr;

	}
}

//Alternative for loop

/*
 * int len = arr.length-1; for (int j = 0; j < len; j++) { if (arr[j + 1] <
 * arr[j]) { isTrue = false; int temp = arr[j]; arr[j] = arr[j+1]; arr[j+1] =
 * temp; len--;
 * 
 * }
 */