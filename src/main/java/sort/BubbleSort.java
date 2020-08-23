package sort;

public class BubbleSort<T> extends Swapper<T> implements Sortable<T> {


    public BubbleSort() {
    }

    public void sort(T[] arr, Comparator<T> comparator) {
        int size = arr.length;
        for(int i = 1; i < size; ++i) {
            for(int e = 0; e < size - i; ++e) {
                if (comparator.compare(arr[e], arr[e + 1]) > 0) {
                    this.swap(arr, e, e + 1);
                }
            }
        }

    }

    @Override
    public String toString() {
        return "Bubble Sort.";

    }
}