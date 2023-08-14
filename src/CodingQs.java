import java.util.Scanner;
import java.util.Stack;

public class CodingQs {
    public static void main(String[] arg){
        CodingQs cdQs = new CodingQs();
        Scanner in = new Scanner(System.in);
//        String s = "12";
//        System.out.println("Enter an string.");
//        s = in.next();
////        s = "saveChangesInTheEditor";
//        System.out.println(cdQs.convertCaseNprintInNewEachWord2(s));
//        int[] arr = {3, 4, 5, 1, 6, 10, 9, 7, 8};
//        int s = arg.length;
//        System.out.println(cdQs.isStrictlySmall(arr, s));
//        int[] arr = {1, 2, 6, 6, 4, 5};
//        int s = arr.length;
//        System.out.println(Arrays.toString(cdQs.repeated_MissNum(arr , s)));
//        System.out.println(cdQs.randomNumGenerator(10, 20));
//        ptrnRTStr(5);
//        ptrnLTStr(5);
//        ptrnPyramidBtmUpStr(10);
//        ptrnPyramidBtmUpAndUpDownStr(5);
//        downWrdT(3);

    }
//    1) convertCaseNprintInNewEachWord
    /*public String convertCaseNprintInNewEachWord(String s){
        String convS = "";
        String sAdd = "";

        var sArr = s.toCharArray();
        for(char ch : sArr){
            if ('A' <= ch && ch < 'Z') {
                sAdd = Character.toString(ch + ('a' - 'A'));
                convS += "\n" + sAdd;
            }
            else if ('a' <= ch && ch <= 'z') {
                sAdd = Character.toString(ch - ('a' - 'A'));
                convS += sAdd;
            }
        }
//        System.out.println(convS);
        return convS;
    }*/
  /*  public String convertCaseNprintInNewEachWord2(String s){
        String convS = "";
        for (char ch: s.toCharArray()) {
            if ('a' <= ch && ch <= 'z'){
                ch = (char) (ch - ('a' - 'A'));
                convS += Character.toString(ch);
            } else if ('A' <= ch && ch <= 'Z') {
                ch = (char) (ch + ('a' - 'A'));
                convS += "\n" + Character.toString(ch);
            }
        }
        return convS;
    }*/
    /*2) Given an integer array arr of size s. Now, check whether there exists at least one element which is strictly smaller than all the elements on the right of it and greater than all the elements on the left of it. If it exists, return true; otherwise, return false. Ignore the corner elements of the given array.*/
    public boolean isStrictlySmall(int[] arr, int s){
        boolean lTrue = false;
        boolean rTrue = false;

        for (int i = 1; i < s; i++) {
            int p = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < p)
                    lTrue = true;
                else {
                    lTrue = false;
                    break;
                }
            }
            if (!lTrue)
                continue;
            for (int k = i + 1; k < s; k++) {
                if (p < arr[k])
                    rTrue = true;
                else {
                    rTrue = false;
                    break;
                }
            }
            if (lTrue && rTrue ){
                System.out.println(arr[i]);
                return true;
            }
        }
        return false;
    }
    /*3. Given a read-only array arr of size s, such that each element of the array can not exceed the value s. Also, in the array, each element occurs only once except a1, which is occurring twice, and therefore, a2 is missing. Find out the value of a1 and a2. Note that read-only means any modification in the input array is not allowed.*/
    public int[] repeated_MissNum(int[] arr, int s){
        int[] repeated_MissNum = new int[2];
        int duplicate = 0;
        int elementsSum = 0;
        int actualSum;
        Stack<Integer> unique = new Stack<>();

        for (int i = 0; i < s; i++) {
            if (unique.contains(arr[i]))
                duplicate = arr[i];
            unique.add(arr[i]);

            elementsSum += arr[i];
        }
        actualSum = s*(s + 1) / 2;
        repeated_MissNum[0] = duplicate;
        repeated_MissNum[1] = actualSum - (elementsSum - duplicate);

        return repeated_MissNum;
    }

}
