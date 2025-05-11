public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 5, 4, 1 };
        printArray("Unsorted Array", arr);

        bubbleSort(arr);
        printArray("Sorted Array", arr);
    }

    private static void bubbleSort(int[] arr) {
        for (int unsortedIndex = arr.length - 1; unsortedIndex > 0; unsortedIndex--) {
            for (int i = 0; i < unsortedIndex; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    private static void printArray(String string, int[] arr) {
        System.out.println(string);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}
