import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StringManipulation {
    public static void main(String[] args) {
        String str = "abcccacdefggh";
//        var numOfVowels = numberOfVowels(str);
//        System.out.println(numOfVowels);

//        var revStr = reverseStr(str);
//        System.out.println(revStr);

//        var revWords = reverseWords(str);
//        System.out.println(revWords);

//        var isRotation = isRotation("bcdefa", "bcdefa");
//        System.out.println(isRotation);

//        var removeDuplicateChar = removeDuplicateChar(str);
//        System.out.println(removeDuplicateChar);

//        var mostRepeatedChar = mostRepeatedChar(str);
//        System.out.println(mostRepeatedChar);

//        var capitalizeEachWord = capitalizeEchWordRemoveSpace("trees are beautiful");
//        System.out.println(capitalizeEachWord);

//        var areAnagram = areAnagram("abcd", "badc");
//        System.out.println(areAnagram);

        var isPalindrome = isPalindrome("aba");
        System.out.println(isPalindrome);


    }
    public static int numberOfVowels(String str){
        Stack<Character> vowels = new Stack<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int numOfVowels = 0;

        for (char ch: str.toCharArray())
            if (vowels.contains(ch))
                numOfVowels++;

        return numOfVowels;
    }
    public static String reverseStr(String str){
        String revStr = "";
        int length = str.length();

        for (int i = length - 1; i >0 ; i--)
            revStr += str.charAt(i);

        return revStr;
    }
    public static String reverseWords(String str){
        str = str.trim();
        String revWords = "";
        var strArr = str.toCharArray();
        String tempWord = "";

        for (char ch: strArr) {
            tempWord += ch;
            if (ch == ' '){
                revWords =  tempWord + revWords;
                tempWord = " ";
            }
        }
        revWords = tempWord + revWords;
        return revWords.trim();
    }
    public static boolean isRotation(String str, String isRotate){
        ArrayList<String> rotateStr = new ArrayList<>();
        int length = str.length();
        String tempStr;
        int k;
        for (int i = 0; i < length; i++) {
            tempStr = "";
            for (int j = 0; j < length; j++) {
//                travers any size of in circular way
//                System.out.println(((i + j) % length*2)/2);
                k = ((i + j) % length*2)/2;
                tempStr += str.charAt(k);
            }
            rotateStr.add(tempStr);
//            System.out.println(rotateStr.get(i));
        }
        return rotateStr.contains(isRotate);
    }
    public static String removeDuplicateChar(String str){
        String newStr = "";
        ArrayList<Character> uniqueChar = new ArrayList<>();
        for(char ch : str.toCharArray()){
            if (!uniqueChar.contains(ch)){
                uniqueChar.add(ch);
                newStr += ch;
            }
        }
        return newStr;
    }
    public static char mostRepeatedChar(String str){
        int[] charsArr = new int[256];
        int repeatedCharAt = 0;
        int mostRepeatedChar =  charsArr[repeatedCharAt];
        for(char ch: str.toCharArray())
            charsArr[ch]++;

        for (int i = 0; i < charsArr.length; i++) {
            if (mostRepeatedChar < charsArr[i]){
                mostRepeatedChar = charsArr[i];
                repeatedCharAt = i;
            }
        }

//        System.out.println(Arrays.toString(charsArr) + "\n " + repeatedCharAt);
        return (char)repeatedCharAt;
    }
    public static String capitalizeEchWordRemoveSpace(String str){
        String newStr = "";
        ArrayList<String> strArr = new ArrayList<>();
        String tempWord = "";
        str = str.trim();

        for (char ch: str.toCharArray()) {
            if (ch == ' '){
                strArr.add(tempWord);
                tempWord = "";
            }
            else
                tempWord += ch;
        }
        strArr.add(tempWord);

        String uppercaseLtr;
        for (String word: strArr) {
            uppercaseLtr = String.valueOf(word.charAt(0)).toUpperCase();
            newStr = newStr + " " + uppercaseLtr;
            for (int i = 1; i < word.length(); i++) {
                newStr += word.charAt(i);
            }
        }

//        System.out.println(strArr.toString());
        return newStr.trim();
    }
    public static boolean areAnagram(String str1, String str2){
        if (str1.length() != str2.length())
            return false;
        else
            for (char ch: str1.toCharArray())
                if (!str2.contains(String.valueOf(ch)))
                    return false;

        return true;
    }
    public static boolean isPalindrome(String str){
        var strArr = str.toCharArray();
        int strLength = str.length();

        for (int i = 0; i < strLength / 2; i++)
            if (strArr[i] != strArr[strLength - (1 + i)])
                return false;

        return true;
    }
}
