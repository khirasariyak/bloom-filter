import java.util.BitSet;

public class BloomFilter {
    private final BitSet bitSet;
    private final int numHashes;

    public BloomFilter(int size, int numHashes) {
        this.bitSet = new BitSet(size);
        this.numHashes = numHashes;
    }

    public void add(String element) {
        for (int i = 0; i < numHashes; i++) {
            bitSet.set(hash(element, i), true);
        }
    }

    public boolean mightContain(String element) {
        for (int i = 0; i < numHashes; i++) {
            if (!bitSet.get(hash(element, i))) {
                return false;
            }
        }
        return true;
    }

    private int hash(String element, int seed) {
        // Implement your hash function here
    }
}
