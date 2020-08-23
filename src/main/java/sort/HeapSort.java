package sort;

public class HeapSort<T> extends Swapper<T> implements Sortable<T> {

    public HeapSort() {
    }

    public void sort(T[] arr, Comparator<T> comparator) {
        int length = arr.length;

        int lastNotLeaf = length / 2 - 1;
        // construct max heap
        for (int i = lastNotLeaf; i >= 0; i --) {
            heapify(arr, length, i, comparator);
        }

        for (int i = length - 1; i > 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0, comparator);
        }
    }

    @Override
    public String toString() {
        return "Heap sort.";
    }

    private void heapify(T[] arr, int n, int i, Comparator<T> comparator) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && comparator.compare(arr[left], arr[largest]) > 0) {
            largest = left;
        }

        if (right < n && comparator.compare(arr[right], arr[largest]) > 0) {
            largest = right;
        }

        if (i != largest) {
            swap(arr, largest, i);
            heapify(arr, n, largest, comparator);
        }
    }
}
