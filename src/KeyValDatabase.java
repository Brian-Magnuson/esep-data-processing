import java.util.ArrayList;
import java.util.HashMap;

/**
 * A Pair class to store key-value pairs
 */
class Pair<K, V> {
    public K key;
    public V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * A simple in-memory key-value database with transaction support
 */
public class KeyValDatabase implements InMemoryDB {

    private HashMap<String, Integer> map = new HashMap<>();
    private ArrayList<Pair<String, Integer>> staged = new ArrayList<>();
    private boolean inTransaction = false;

    /**
     * Get the value for a key. Does not include changes made in the current
     * transaction.
     *
     * @param key The key to get the value for
     * @return The value for the key. Null if the key does not exist
     */
    @Override
    public Integer get(String key) {
        return map.get(key);
    }

    /**
     * Put a key-value pair in the database. The change is staged until the
     * transaction is committed.
     *
     * @param key The key to put
     * @param val The value to put
     * @throws IllegalStateException If no transaction is in progress
     */
    @Override
    public void put(String key, int val) throws IllegalStateException {
        if (inTransaction) {
            staged.add(new Pair<>(key, val));
        } else {
            throw new IllegalStateException("No transaction in progress");
        }
    }

    /**
     * Begin a transaction.
     *
     * @throws IllegalStateException If a transaction is already in progress
     */
    @Override
    public void begin_transaction() throws IllegalStateException {
        if (inTransaction) {
            throw new IllegalStateException("Transaction already in progress");
        }
        inTransaction = true;
    }

    /**
     * Commit the changes made in the current transaction and ends the current
     * transaction.
     *
     * @throws IllegalStateException If no transaction is in progress
     */
    @Override
    public void commit() {
        if (!inTransaction) {
            throw new IllegalStateException("No transaction in progress");
        }
        for (Pair<String, Integer> pair : staged) {
            map.put(pair.key, pair.value);
        }
        staged.clear();
        inTransaction = false;
    }

    /**
     * Rollback the changes made in the current transaction and ends the current
     * transaction.
     *
     * @throws IllegalStateException If no transaction is in progress
     */
    @Override
    public void rollback() {
        if (!inTransaction) {
            throw new IllegalStateException("No transaction in progress");
        }
        staged.clear();
        inTransaction = false;
    }
}
