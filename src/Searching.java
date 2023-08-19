import java.util.Arrays;

public class Searching {
    public static void main(String[] args) {
        int[] arr = {1, 2,3, 4, 5};

        boolean isFound = false;
//        isFound = linearSearch(arr, 15);
//        array must be sorted
        Arrays.sort(arr);
//        isFound = binarySearch(arr, 5);
//        isFound = ternarySearch(arr, 15);
//        isFound = jumpSearch(arr, 1);
        isFound = exponentialSearch(arr, 15);
        System.out.println(isFound);
    }
    public static boolean linearSearch(int[] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i])
                return true;
        }
        return false;
    }
    public static boolean binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left <= right){
            mid = (left + right) / 2;

            if (target == arr[mid])
                return true;
            else if (target < arr[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }
    public static boolean ternarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        int partitionSize = (right - left) / 3;
        int mid1 = left + partitionSize;
        int mid2 = right - partitionSize;

        while (mid1 <= mid2){
            if (target == arr[mid1] || target == arr[mid2])
                return true;
            else if(target < arr[mid1])
                right = mid1 - 1;
            else if (target > arr[mid2])
                left = mid2 + 1;
            else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
            partitionSize = (right - left)  / 3;
            mid1 = left + partitionSize;
            mid2 = right - partitionSize;
        }
        return false;
    }
    public static boolean jumpSearch(int[] arr, int target){
        int length = arr.length;
        if (length == 0)
            return false;
        int jumpBy = (int) Math.sqrt(length);
        int ptr = 0;
        int next = ptr + jumpBy;

        while (next <= length){
            if (target == arr[next - 1])
                return true;
            else if(target < arr[next - 1]){
                for (int i = ptr; i < next; i++)
                    if (target == arr[i])
                        return true;
                return false;
                }
            ptr = next;
            next += next;
        }
        return false;
    }
    public static boolean exponentialSearch(int[] arr, int target){
        int bound = 1;
        while (bound < arr.length){
            if (target == arr[bound])
                return true;
            else if (target < arr[bound]) {
                for (int i = bound / 2; i < bound; i++)
                    if (target == arr[i])
                        return true;
                return false;
            }
            bound *= 2;
        }
        return false;
    }
}
