import java.util.Arrays;

public class NumberPrograms {
    public static void main(String[] args) {
//        System.out.println(reverseNum(12345));
     /*   for (int i = 0; i < 500; i++) {
            if (isPeterson(i))
                System.out.print(i + ", ");
        }*/
//        pending
        for (int i = 1; i < 100; i++) {
//            System.out.println(i + ": " + numberToWord(i));
            if (isSunnyNum(i))
                System.out.println(i);
        }
    }
    public static int reverseNum(int n){
        int reversedNum = 0;
        while(n != 0){
            reversedNum = reversedNum*10 + n % 10;
            n /= 10;
        }
        return reversedNum;
    }
//    pending...
    public static String numberToWord(int n){
        String inWords = "";
//string type array for one-digit numbers
        String[] onedigit = new String[] {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
//string type array for two digits numbers
//the first index is empty because it makes indexing easy
        String[] twodigits = new String[] {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
//string type array of tens multiples
//the first two indexes are empty because it makes indexing easy
        String[] multipleoftens = new String[] {"",  "Ten",  "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
//string type array of power of tens
        String[] poweroftens = new String[] {"", "", "", "Hundred", "Thousand"};



        int digits = Integer.toString(n).length();
        int[] arrDig = new int[digits + 1];
        int temp = n;
        for (int i = digits; i > 0; i--) {
            arrDig[i] = temp % 10;
            temp /= 10;
        }

        for (int i = 1; i <= digits; i++) {
            if (i < 3){
                inWords = inWords + " " + onedigit[arrDig[i]] + " " + poweroftens[digits - (i - 1)];
            } else if (i < 4 ) {
                if (arrDig[i] == 0) {
                    inWords += " and " + onedigit[arrDig[i + 1]];
                    return inWords;
                }
                else if (arrDig[i] == 1){
                    inWords += " " + " and " + twodigits[arrDig[i + 1] % 10];
                    return inWords;
                }
                else
                    inWords += " " + multipleoftens[arrDig[i]] + " " + onedigit[arrDig[i + 1]];
            }
        }
        System.out.println(Arrays.toString(arrDig));
        return inWords;
    }
    public static boolean isAutomorphic(int n){
        var sqr = n*n;
        return n == sqr % 100;
    }
    public static boolean isPeterson(int n){
        var factoSum = 0;
        var temp = n;
        int digits = Integer.toString(n).length();
        for (int i = 0; i < digits; i++) {
            factoSum += factorialOf(temp % 10);
            temp  /= 10;
        }
        return n == factoSum;
    }
    public static boolean isSunnyNum(int n){
        var isSquare = n + 1;
        var sqrt = Math.sqrt(isSquare);

        return (sqrt - Math.floor(sqrt)) == 0;
    }
    private static int factorialOf(int n) {
        if (n == 0)
            return 1;
        return n*factorialOf(n - 1);
    }
}
