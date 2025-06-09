public class SortAlgorithms {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 5, 4, 1 };
        printArray("Unsorted Array", arr);

        mergeSort(arr);

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

    private static void insertionSort(int[] arr, int gap) {
        for (int i = gap; i < arr.length; i++) {
            int newElement = arr[i];
            int j;

            for (j = i; j >= gap && newElement < arr[j - gap]; j -= gap) {
                arr[j] = arr[j - gap];
            }

            arr[j] = newElement;
        }
    }

    private static void insertionSort(int[] arr) {
        insertionSort(arr, 1);
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
                if (arr[i] > arr[largestIndex]) { // change to >= to make it stable
                    largestIndex = i;
                }
            }

            swap(arr, largestIndex, unsortedIndex);
        }
    }

    private static void shellSort(int[] arr) {
        for (int gap = arr.length; gap > 0; gap /= 2) {
            insertionSort(arr, gap);
        }
    }

    private static void mergeSort(int[] arr) {
        mergeSort(arr, 0 ,arr.length);
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        if (arr[mid - 1] < arr[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] tempArray = new int[end - start];
        while(i < mid && j < end) {
            tempArray[tempIndex++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        System.arraycopy(arr, i, arr, start + tempIndex, mid - i);
        System.arraycopy(tempArray, 0, arr, start, tempIndex);
    }
}
