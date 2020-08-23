package sort;

public class Swapper<T> {
    public Swapper() {
    }

    protected void swap(T[] list, int i, int j) {
        T memorizedObject = list[i];
        list[i] = list[j];
        list[j] = memorizedObject;
    }
}