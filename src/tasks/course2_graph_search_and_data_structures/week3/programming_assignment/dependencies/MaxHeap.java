package tasks.course2_graph_search_and_data_structures.week3.programming_assignment.dependencies;

import java.util.Arrays;

public class MaxHeap<T extends Comparable> implements Heap<T> {

    private int size = 0;
    private int initialSize = 10;
    private T[] array = Heap.newArray(initialSize);


    public T max() {
        return array[0];
    }

    @Override
    public void insert(T object) {
        if (size + 1 == array.length) {
            T[] newArray = Heap.newArray(initialSize *= 1.5);
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size++] = object;
        checkRule(array, size);
    }

    @Override
    public int size() {
        return size;
    }

    public T extractMax() {
        if (size == 0) {
            throw new RuntimeException();
        }
        T returnedValue = array[0];
        array[0] = array[--size];

        if (size > 1) {
            checkRule(array, 1);
        }
        return returnedValue;
    }

    private void checkRule(T[] array, int checkingValue) {
        if (checkingValue / 2 - 1 >= 0 && checkingValue <= size) {
            if (array[checkingValue - 1].compareTo(array[checkingValue / 2 - 1]) > 0) {
                T temp = array[checkingValue - 1];
                array[checkingValue - 1] = array[checkingValue / 2 - 1];
                array[checkingValue / 2 - 1] = temp;

                checkRule(array, checkingValue / 2);
            }
        }
        if ((checkingValue *= 2) <= size) {
            if (array[checkingValue - 1].compareTo(array[checkingValue / 2 - 1]) > 0) {
                bubble(checkingValue / 2 - 1, checkingValue - 1);

                checkRule(array, checkingValue);
                checkRule(array, checkingValue * 2);
                checkRule(array, checkingValue * 2 + 1);
            }
        }
        if (++checkingValue <= size) {
            if (array[checkingValue - 1].compareTo(array[checkingValue / 2 - 1]) > 0) {
                bubble(checkingValue / 2 - 1, checkingValue - 1);

                checkRule(array, checkingValue / 2);
                checkRule(array, checkingValue * 2);
                checkRule(array, checkingValue * 2 + 1);
            }
        }
    }

    private void bubble(int lowestIndex, int greatestIndex) {
        T temp = array[lowestIndex];
        array[lowestIndex] = array[greatestIndex];
        array[greatestIndex] = temp;
    }
}
