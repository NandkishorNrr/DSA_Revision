import java.util.ArrayList;
import java.util.Arrays;

public class Heap {
    public static void main(String[] args){
        Heap heap1 = new Heap();
        heap1.insert(15);
        heap1.insert(10);
        heap1.insert(3);
        heap1.insert(8);
        heap1.insert(12);
        heap1.insert(9);
        heap1.insert(4);
        heap1.insert(1);
        heap1.insert(24);

        System.out.println(heap1);
    }
//    private ArrayList<Integer> heap = new ArrayList<>();
    private int[] heap = new int[10];
    private int size = 0;

    public void insert(int value){
        if (isFull())
            throw new IllegalStateException();
        heap[size++] = value;
        bubbleUp();
    }
    public void remove(int value){
        if (isEmpty())
            throw new IllegalStateException();
        heap[0] = heap[--size];
        bubbleDown();
    }
    private boolean isFull() {
        return size == heap.length;
    }
    private boolean isEmpty(){
        return size == 0;
    }
    private void bubbleUp() {
        int index = size - 1;
        while (index > 0 && heap[index] >  heap[parentIndex(index)]){
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }
    private void bubbleDown(){
        int index = 0;
        while (index <= size &&  !isValidParent(index)){
            var largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
        }
    }
    private int largerChildIndex(int index){
        if (!hasLeftChild(index))
            return index;

        if (!hasRightChild(index))
            return leftChildIndex(index);

        return (leftChild(index) > rightChild(index) ?
                leftChildIndex(index):
                rightChildIndex(index));
    }
    boolean hasLeftChild(int index){
        return leftChildIndex(index) <= size;
    }

    boolean hasRightChild(int index){
        return rightChildIndex(index) <= size;
    }

    private boolean isValidParent(int index) {
        return heap[index] >= leftChild(index) &&
                heap[index] >= rightChild(index);
    }

    private int rightChild(int index) {
        return heap[rightChildIndex(index)];
    }

    private int leftChild(int index) {
        return heap[leftChildIndex(index)];
    }

    private int leftChildIndex(int parentIndex){
        return parentIndex * 2 + 1;
    }
    private int rightChildIndex(int parentIndex){
        return parentIndex * 2 + 2;
    }
    private int parentIndex(int index){
        return (index - 1) / 2;
    }
    private void swap(int index, int parentIndex) {
        int temp = heap[index];
        heap[index] = heap[parentIndex];
        heap[parentIndex] = temp;
    }
    @Override
    public String toString() {
        return Arrays.toString(heap);
    }
}
