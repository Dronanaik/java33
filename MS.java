package hardik;
import java.util.Arrays;
import java.util.Random;

public class MS {

    public static void main(String[] args) {
        int[] ns = {1000, 5000, 10000, 20000};

        for (int n : ns) {
            int[] arr = new Random().ints(n, 0, 1000).toArray();
            long startTime = System.nanoTime();
            mergeSort(arr, 0, arr.length - 1);
            long endTime = System.nanoTime();
            System.out.println("Time taken to sort " + n + " elements: " + (endTime - startTime) / 1000000 + " milliseconds");
        }
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = Arrays.copyOfRange(arr, left, right + 1);
        int i = 0, j = mid - left + 1, k = left;

        while (i < mid - left + 1 && j < temp.length) {
            arr[k++] = (temp[i] <= temp[j]) ? temp[i++] : temp[j++];
        }

        while (i < mid - left + 1) {
            arr[k++] = temp[i++];
        }
    }
}
