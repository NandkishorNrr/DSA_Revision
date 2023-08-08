import java.util.ArrayList;
import java.util.Arrays;

public class Array {
    private int[] array;
    private int count = 0;

    public Array(int length){
        array = new int[length];
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public void insert(int item){
        if (count == array.length){
            int[] newArray = new int[count*2];

            for (int i = 0; i < count; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[count++] = item;
    }
    public int removeAt(int index){
        int deleted = array[index];
        if (0 <= index && index < count) {
            for (int j = index; j < count - 1; j++) {
                array[j] = array[j + 1];
            }
            array[--count] = 0;
            return deleted;
        }
        return -1;
    }
    public int indexOf(int item){
        for (int i = 0; i < count; i++)
            if (item == array[i])
                return i;
        return -1;
    }


    public static void main(String[] args) {
//        Array ar = new Array(3);
//        ar.insert(1);
//        ar.insert(2);
//        ar.insert(3);
//        ar.insert(4);
//        ar.insert(5);
//        ar.insert(6);
//        ar.insert(5);
//        System.out.println(ar);
//        System.out.println(ar.removeAt(3));
//        System.out.println(ar);
//        System.out.println(ar.indexOf(6));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        System.out.println(list.size());
    }
}
