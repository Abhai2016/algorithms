import java.util.Arrays;

public class SearchAlgorithms {
    public static void main(String[] args) {
        int[] arr = { -22, -15, 1, 7, 20, 35, 55 };

        System.out.println(recursiveBinarySearch(arr, 35));
        System.out.println(recursiveBinarySearch(arr, 5));
        System.out.println(recursiveBinarySearch(arr, 20));
        System.out.println(recursiveBinarySearch(arr, -15));
        System.out.println(recursiveBinarySearch(arr, -7));
        System.out.println(recursiveBinarySearch(arr, 1));
    }

    private static int linearSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value)
                return arr[i];
        }

        return -1;
    }

    private static int iterativeBinarySearch(int[] arr, int value) {
        int start = 0;
        int end = arr.length;

        while (start < end) {
            int mid = (start + end) / 2;
            if  (arr[mid] == value)
                return mid;
            if (arr[mid] < value)
                start = mid + 1;
            if (arr[mid] > value)
                end = mid;
        }

        return -1;
    }

    private static int recursiveBinarySearch(int[] arr, int value) {
        return recursiveBinarySearch(arr, 0, arr.length, value);
    }

    private static int recursiveBinarySearch(int[] arr, int start, int end, int value) {
        if (start >= end)
            return -1;

        int mid = (start + end) / 2;
        if (arr[mid] == value)
            return mid;

        if (arr[mid] < value)
            return recursiveBinarySearch(arr, mid + 1, end, value);
        else
            return recursiveBinarySearch(arr, start, mid, value);
    }
}
