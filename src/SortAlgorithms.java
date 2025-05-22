public class SortAlgorithms {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 5, 4, 1 };
        printArray("Unsorted Array", arr);

        //bubbleSort(arr);
        selectionSort(arr);

        printArray("Sorted Array", arr);
    }

    private static void printArray(String string, int[] arr) {
        System.out.println(string);

        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void bubbleSort(int[] arr) {
        for (int unsortedIndex = arr.length - 1; unsortedIndex > 0; unsortedIndex--) {
            for (int i = 0; i < unsortedIndex; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    private static void selectionSort(int[] arr) {
        for (int unsortedIndex = arr.length - 1; unsortedIndex > 0; unsortedIndex--) {
            int largestIndex = 0;

            for (int i = 0; i <= unsortedIndex; i++) {
                if (arr[i] > arr[largestIndex]) {
                    largestIndex = i;
                }
            }

            swap(arr, largestIndex, unsortedIndex);
        }
    }
}
