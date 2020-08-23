package sort;

public class QuickSort<T> extends Swapper<T> implements Sortable<T> {

    public QuickSort() {
    }

    public void sort(T[] arr, Comparator<T> comparator) {
        quicksort(arr, 0, arr.length - 1, comparator);


    }

    private void quicksort(T[] arr, int low, int high, Comparator<T> comparator) {
        int partition = partition(arr, low, high, comparator);

        if (partition - 1 > low) {
            quicksort(arr, low, partition - 1, comparator);
        }
        if (partition + 1 < high)
            quicksort(arr, partition + 1, high, comparator);
    }


    private int partition(T[] arr, int low, int high, Comparator<T> comparator) {

        T pivot = arr[high];

        for (int i = low; i < high; i++) {
            if (comparator.compare(arr[i], pivot) < 0) {
                swap(arr, low, i);
                low++;

            }


        }

        swap(arr, low, high);
        return low;
    }

    @Override
    public String toString() {
        return "Quick sort.";
    }
}
