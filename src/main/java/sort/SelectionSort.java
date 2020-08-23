package sort;


public class SelectionSort<T> extends Swapper<T> implements Sortable<T> {

    public SelectionSort() {
    }

    public void sort(T[] arr, Comparator<T> comparator) {
        int size = arr.length;
        int minimun = 0;
        for (int i = 0; i < size; i++) {
            minimun = i;
            for (int e = i + 1; e < size; e++) {
                if (comparator.compare(arr[e], arr[minimun]) < 0) {
                    minimun = e;
                }
            }
            swap(arr, i, minimun);
        }
    }

    @Override
    public String toString() {
        return "Selection Sort.";
    }
}
