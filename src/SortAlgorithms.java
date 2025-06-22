public class SortAlgorithms {
    public static void main(String[] args) {
        int[] arr = { 20, 35, -15, 7, 55, 1, -22 };
        printArray("Unsorted Array", arr);

        countingSort();

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
            int largestIndex = unsortedIndex;

            for (int i = 0; i < unsortedIndex; i++) {
                if (arr[largestIndex] < arr[i]) { // change to <= to make it stable
                    largestIndex = i;
                }
            }

            if (largestIndex != unsortedIndex) {
                swap(arr, largestIndex, unsortedIndex);
            }
        }
    }

    private static void insertionSort(int[] arr) {
        insertionSort(arr, 1);
    }

    private static void insertionSort(int[] arr, int gap) {
        for (int i = gap; i < arr.length; i++) {
            int elementToInsert = arr[i];
            int j;

            for (j = i; j >= gap && elementToInsert < arr[j - gap]; j -= gap) {
                arr[j] = arr[j - gap];
            }

            arr[j] = elementToInsert;
        }
    }

    private static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
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

      int[] tempArr = new int[end - start];
      while (i < mid && j < end) {
          tempArr[tempIndex++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
      }

      System.arraycopy(arr, i, arr, start + tempIndex, mid - i);
      System.arraycopy(tempArr, 0, arr, start, tempIndex);
    }

    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int pivotIndex = divideAndConquer(arr, start, end);
        quickSort(arr, start, pivotIndex);
        quickSort(arr, pivotIndex + 1, end);
    }

    private static int divideAndConquer(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;

        while (i < j) {
            while (i < j && arr[--j] >= pivot) {}
            if (i < j) {
                arr[i] = arr[j];
            }

            while (i < j && arr[++i] <= pivot) {}
            if (i < j) {
                arr[j] = arr[i];
            }
        }

        arr[i] = pivot;
        return i;
    }

    private static void countingSort() {
        int[] arr = new int[] { 25, 22, 27, 20, 23, 26, 26, 24, 28 };
        int start = 20;
        int end = 28;

        countingSort(arr, start, end);
        printArray("Sorted Array", arr);
    }

    private static void countingSort(int[] arr, int start, int end) {
        int[] tempArray = new int[(end - start) + 1];
        for (int i = 0; i < arr.length; i++) {
            tempArray[arr[i] - start]++;
        }

        int j = 0;
        for (int i = 0; i < tempArray.length; i++) {
            while (tempArray[i] > 0) {
                arr[j++] = i + start;
                tempArray[i]--;
            }
        }
    }
}
