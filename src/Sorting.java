import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int [] arr = {4, 5, 6, 3, 1, 7, 2, 1};
        int[] sortedArr = new int[0];

//        sortedArr = bubbleSort(arr);
//        sortedArr = selectionSort(arr);
//        sortedArr = insertionSort(arr);
        sortedArr = mergeSort(arr);
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
            if (arr[i] < arr[i - 1]){
                int current = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > current){
                    arr[j + 1] = arr[j--];
                }
                arr[++j] = current;
            }
        }
        return arr;
    }

    public static int[] mergeSort(int[] arr){
        if (arr.length < 2)
            return arr;
        var mid = arr.length / 2;

        int[] leftArr = new int[mid];
        for (int i = 0; i < mid; i++)
            leftArr[i] = arr[i];

        int[] rightArr = new int[arr.length - mid];
        for (int i = mid; i < arr.length; i++)
            rightArr[i - mid] = arr[i];

        leftArr = mergeSort(leftArr);
        rightArr = mergeSort(rightArr);
        arr = merge(leftArr, rightArr, arr);
        return arr;
    }
    private static int[] merge(int[] leftArr, int[] rightArr, int[] arr){
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftArr.length && j < rightArr.length){
            if (leftArr[i] <= rightArr[j])
                arr[k++] = leftArr[i++];
            else
                arr[k++] = rightArr[j++];
        }

        while (i < leftArr.length)
            arr[k++] = leftArr[i++];

        while (j < rightArr.length)
            arr[k++] = rightArr[j++];

        return arr;
    }
    private static void swap(int[]  arr, int minIndex, int j) {
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
