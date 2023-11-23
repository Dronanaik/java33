package hardik;

import java.util.Arrays;
import java.util.Random;

public class HEAP {

    public static void main(String[] args) {
        Random rand = new Random();
        int n = rand.nextInt(100) + 1; // Random size between 1 and 100
        int[] arr = new int[n];

        System.out.println("Original Array:");
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(1000); // Random integers between 0 and 999
            System.out.print(arr[i] + " ");
        }

        long startTime = System.nanoTime();
        heapSort(arr);
        long endTime = System.nanoTime();

        System.out.println("\nSorted Array:");
        for (int value : arr) {
            System.out.print(value + " ");
        }

        double elapsedTime = (endTime - startTime) / 1e6; // Convert to milliseconds
        System.out.println("\nTime taken for sorting: " + elapsedTime + " milliseconds");
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build a max-heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}
