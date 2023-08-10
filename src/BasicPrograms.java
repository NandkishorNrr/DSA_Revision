import java.util.Arrays;

public class BasicPrograms {
    public static void main(String[] args) {
//        int[] arr = new int[0];
//        System.out.println();
//        System.out.println(Arrays.toString(fibonacciSeries(10)) + "\n");
//        fibonacciSeries2(10);
//        int rowChng = 1;
//        for (int i = 2; i < 1000; i++) {
//            if (isPrime(i)) {
//                System.out.print(i + ", ");
//                rowChng++;
//            }
//            if (rowChng == 10) {
//                System.out.println();
//                rowChng = 1;
//            }
//        }
//        System.out.println(isPalindrome("4554"));
//        System.out.println(factorial(6));
        int count = 1;
        for (int i = 1; i < 1000; i++) {
            if (isArmstrong(i)) {
                System.out.print(i + ", ");
                count++;
            }
            if (count == 10) {
                System.out.println();
                count = 1;
            }
        }
    }

    //    Fibonacci series
    public static int[] fibonacciSeries(int count) {
        int[] series = new int[count];
        if (count == 1)
            series[0] = 0;
        else if (count >= 2) {
            series[0] = 0;
            series[1] = 1;
            for (int i = 2; i < count; i++)
                series[i] = series[i - 2] + series[i - 1];
        }
        return series;
    }
    public static void fibonacciSeries2(int count){
        int n1 = 0;
        int n2 = 1;
        int ni;

        System.out.print(n1 + ", ");
        for (int i = 0; i < count; i++) {
            ni = n1 + n2;
            System.out.print(ni + ", ");
            n1 = n2;
            n2 = ni;
        }
    }
    //    Prime number
    public static boolean isPrime(int n){
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false;
        for (int i = 3; i < n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    //Palindrome
    public static boolean isPalindrome(int n){
        var arr = String.valueOf(n).toCharArray();
        int l = arr.length;
        for (int i = 0; i < l / 2; i++)
            if(arr[i] != arr[l - (i + 1)])
                return false;
        return true;
    }
    public static boolean isPalindrome(String s){
        var arr = s.toCharArray();
        int l = arr.length;
        for (int i = 0; i < l / 2; i++)
            if(arr[i] != arr[l - (i + 1)])
                return false;
        return true;
    }
    //    Factorial Program
    public static int factorial(int n){
        if (n == 1)
            return 1;
        return n*factorial(n - 1);
    }
//    Armstrong number
    public static boolean isArmstrong(int n){
        int armsNum = 0;
        int temp = n;
        int l = Integer.toString(n).length();
//        System.out.println(l);
        while (temp != 0){
            armsNum += Math.pow(temp % 10, l);
//            System.out.print(temp % 10 + ", ");
            temp /= 10;
        }
        return n == armsNum;
    }
}
