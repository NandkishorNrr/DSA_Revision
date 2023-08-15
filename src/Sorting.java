import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int [] arr = {7, 5, 6, 3, 1, 4, 2};
        int[] sortedArr = new int[0];

//        sortedArr = bubbleSort(arr);
//        sortedArr = selectionSort(arr);
        sortedArr = insertionSort(arr);
        System.out.println(Arrays.toString(sortedArr));

    }
//    O(n^2)
    public static int[] bubbleSort(int[] arr){
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - (i + 1); j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
        return arr;
    }
//    O(n^2)
    public static int[] selectionSort(int[] arr){
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int minIndex = minIndex(arr, i, length);
            swap(arr, minIndex, i);
        }
        return arr;
    }
//    O(n^2)
    public static int[] insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current){
                arr[j + 1] = arr[j--];
            }
            arr[++j] = current;
        }
        return arr;
    }

    private static void swap(int[] arr, int minIndex, int j) {
        int temp = arr[j];
        arr[j] = arr[minIndex];
        arr[minIndex] = temp;
    }
    private static int minIndex(int[] arr, int i, int length) {
        int minIndex = i;
        for (int j = i; j < length; j++)
            if (arr[j] < arr[minIndex])
                minIndex = j;
        return minIndex;
    }

}
