import java.util.Arrays;

public class NumberPrograms {
    public static void main(String[] args) {
//        System.out.println(reverseNum(12345));
//        Peterson number
     /*   for (int i = 0; i < 500; i++) {
            if (isPeterson(i))
                System.out.print(i + ", ");
        }*/
//        Sunny number
/*        for (int i = 1; i < 100; i++) {
//            System.out.println(i + ": " + numberToWord(i));
            if (isSunnyNum(i))
                System.out.println(i);
        }*/

//        Tech number
       /* for (int i = 0; i < 10000; i++) {
            if (isTechNumber(i))
                System.out.println(i);
        }*/
//        System.out.println(isTechNumber(1312));
/*        for (int i = 0; i < 100; i++) {
            System.out.println("Sqrt: " + i + " - " + sqrtNearest(i));
        }*/
        for (int i = 0; i < 9999; i++)
        System.out.println(i + ": " + numberToWord(i));
//        System.out.println(GCD(3, 6));
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
        int[] nArr = new int[digits + 1];
        int temp = n;
        int i;
        for (i = digits; i > 0; i--) {
            nArr[i] = temp % 10;
            temp /= 10;
        }
        temp = n;
        i = 1;
        if (digits == 4) {
            inWords = inWords + onedigit[nArr[i++]] + " " + poweroftens[digits--] + " ";
        }
        if (digits == 3)
//            have to fix....
//            if (nArr[nArr.length - 3] == 0)
//                inWords = inWords + " ";
            inWords = inWords + onedigit[nArr[i++]] + " " + poweroftens[digits--] + " ";
        if (digits == 2){
            temp %= 100;
//            System.out.println(temp);
            if (temp % 100 == 0)
                inWords = inWords;
            else if (temp % 10 == 0)
                inWords = inWords + multipleoftens[temp / 10];
            else if (temp / 10 == 0)
                inWords = inWords + "and " + onedigit[temp % 10];
            else if (temp / 10 == 1)
                inWords = inWords + twodigits[temp % 10];
            else
                inWords = inWords + multipleoftens[temp / 10] + " " + onedigit[temp % 10];
        }
        if (digits == 1)
            inWords = inWords + onedigit[nArr[i++]];

//        System.out.println(Arrays.toString(nArr));
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
    public static boolean isTechNumber(int n){
        var temp = n;
        int digits = Integer.toString(n).length();

        if (digits % 2 == 0){
            int tenMulti = 1;
            for (int i = 0; i < digits / 2; i++)
                tenMulti *= 10;

            var leftPart = temp / tenMulti;
            var rightPart = temp % tenMulti;
            var isTechNum = Math.pow((leftPart + rightPart), 2);
            return isTechNum == n;
        }
        return false;
    }
//    pending...
    public static int sqrtNearest(int n){
        int sqrt;
        int i = 0;

        while (i*i <= n){
            i++;
        }
      sqrt = i - 1;
        return sqrt;
    }
    public static int GCD(int n1, int n2){
        int GCD = 1;
        int i = 1;
        while (i <= n1 && i <= n2){
            if ((n1 % i == 0 && n2 % i == 0))
                GCD = i;
            i++;
        }
        return GCD;
    }

    private static int factorialOf(int n) {
        if (n == 0)
            return 1;
        return n*factorialOf(n - 1);
    }
}
