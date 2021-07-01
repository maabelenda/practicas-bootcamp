package Utils.Algorithms;

import Utils.Sorter;

import java.util.Comparator;

public class HeapSortSorterImple<T> implements Sorter<T> {

    private int node;
    private int heapSize;
    private int left;
    private int right;

    @Override
    public void sort(T[] arr, Comparator<T> c) {
        buildHeap(arr, c);
        T temp;
        for (int i = arr.length - 1; i >= 0; i--) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapSize--;
            heapify(arr, 0, c);
        }
    }

    private void buildHeap(T [] array, Comparator<T> comp) {
        heapSize = array.length;
        for (int i = (int) Math.floor((array.length) / 2) - 1; i >= 0; i--) {
            heapify(array, i, comp);
        }
    }

    private void heapify(T[] array, int i, Comparator<T> comp) {
        left = getLeft(i);
        right = getRight(i);
        node = ((left <= heapSize - 1) && (comp.compare(array[left], array[i]) > 0))
                ? left
                : i;
        if ((right <= heapSize - 1) && (comp.compare(array[right], array[node]) > 0)) {
            node = right;
        }
        if (node != i) {
            T temp = array[i];
            array[i] = array[node];
            array[node] = temp;
            heapify(array, node, comp);
        }
    }

    private int getLeft(int i) {
        return (i * 2);
    }

    private int getRight(int i) {
        return (i * 2 + 1);
    }

    private int getParent(int i) {
        return (int) Math.floor((i / 2)) - 1;
    }
}
