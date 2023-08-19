import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Sorting {
    public static void main(String[] args) {
        int [] arr = {205, 448, 322, 109, 232};
        int[] sortedArr = new int[0];

//        sortedArr = bubbleSort(arr);
//        sortedArr = selectionSort(arr);
//        sortedArr = insertionSort(arr);
//        sortedArr = mergeSort(arr);
//        sortedArr = countingSort(arr);
        sortedArr = bucketSort(arr);
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
    public static int[] countingSort(int[] arr){
        int max = -1;

        for (int i = 1; i < arr.length; i++)
            if (max < arr[i])
                max = arr[i];

//        System.out.println(max);

        int[] indexArr = new int[max + 1];

        for (int value : arr)
            indexArr[value]++;

//        System.out.println(Arrays.toString(indexArr));

        int count = 0;
        for (int i = 0; i <= max; i++)
            if (indexArr[i] !=0)
                while (indexArr[i] != 0) {
                    arr[count++] = i;
                    indexArr[i]--;
                }
        return arr;
    }
    public static int[] bucketSort(int[] arr){
        if (arr.length == 0) {
            int[] empty = new int[0];
            return empty;
        }

        int max  = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (max < arr[i])
                max = arr[i];

        int maxDigits = Integer.toString(max).length();

        Queue<Integer>[] buckets = new Queue[10];
        for (int i = 0; i < 10; i++)
            buckets[i] = new ArrayDeque<>();

        int mod = 1;
        int div = 1;
        for (int i = 0; i < maxDigits; i++) {
            mod *= 10;
            for (int j = 0; j < arr.length; j++) {
                buckets[(arr[j] % mod) / div].add(arr[j]);
            }
            int insertIndex = 0;
            for (int j = 0; j < 10; j++) {
                while (!buckets[j].isEmpty())
                    arr[insertIndex++] = buckets[j].remove();
            }
            div *= 10;
        }

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
