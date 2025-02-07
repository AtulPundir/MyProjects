package com.ap.pre.sorting;

public class QuickSort {

    // Method to perform quick sort on an array
    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(arr, start, end);
            // Recursively sort the sub-arrays
            quickSort(arr, start, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, end);
        }
    }

    // Partition the array using the last element as pivot
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // choose the pivot as the last element
        int i = low - 1;        // index of the smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot, swap it with the element at i
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        // Place the pivot in the correct position
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Utility method to swap elements in the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main method to test quick sort
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}