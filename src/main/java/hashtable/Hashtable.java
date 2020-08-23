package hashtable;

public class Hashtable {

    private static final String sExceptionNoSpaceFree = "No free space in hash table for key '%d'!";

    private HashArray hashArray;
    private int size;
    private int prime;

    public Hashtable(int size, int prime) {
        this.size = size;
        this.prime = prime;
        this.hashArray = new HashArray(size);
    }

    public void insert(int key) throws Exception {

        int j = 0;
        do {
            int idx = calculateIndex(key, j);
            if (hashArray.isFree(idx) || hashArray.isMarkAsDeleted(idx) || hashArray.compareKeys(idx, key)) {
                hashArray.set(idx, key);
                return;
            }

            j++;
        } while (j < size);

        throw new Exception(String.format(sExceptionNoSpaceFree, key));
    }

    public int get(int key) throws Exception {
        return search(key);
    }

    public int search(int key) throws Exception {

        int j = 0;
        do {
            int idx = calculateIndex(key, j);
            if (hashArray.isFree(idx)) {
                break;
            }
            if (hashArray.compareKeys(idx, key)) {
                return hashArray.get(idx);
            }
            j++;
        } while (j < size);

        throw new Exception("Key not found");
    }

    public void remove(int key) throws Exception {

        int j = 0;
        do {
            int idx = calculateIndex(key, j);
            if (hashArray.isFree(idx)) {
                break;
            }

            if (hashArray.compareKeys(idx, key)) {
                hashArray.markAsDeleted(idx);
                return;
            }

            j++;
        } while (j < size);

        throw new Exception("Key not found");
    }

    public void clear() {
        this.hashArray.clear();
    }

    private int hash1(int key) {
        return Math.floorMod(key, size);
    }

    private int hash2(int key) {
        return prime - Math.floorMod(key, prime);
    }

    private int calculateIndex(int key, int j) {
        return Math.floorMod(hash1(key) + (j * hash2(key)), size);
    }
}
