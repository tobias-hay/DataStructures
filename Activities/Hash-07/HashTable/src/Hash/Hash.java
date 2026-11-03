package Hash;

import java.util.Iterator;
import java.util.LinkedList;

public class Hash<K, V> implements HashI<K, V>, Iterable<K> {

	// GLOB
	private int tableSize;
	private int numElements;
	private double loadFactor;
	private LinkedList<HashElement<K, V>>[] table;
	private final boolean DEBUG = true;

	private int hash(int hashVal) {
		// Force the number to be positive
		hashVal &= 0x7FFF_FFFF;

		// Force the number to be a valid subscript
		hashVal %= tableSize;

		return hashVal;
	}

	// PRIV INNER CLASS
	class HashElement<HeK, HeV> implements Comparable<HashElement<HeK, HeV>> {
		public HeK key;
		public HeV value;

		public HashElement(HeK key, HeV value) {
			this.key = key;
			this.value = value;
		}

		// Wrapper to call the K key compareTo method
		@Override
		public int compareTo(HashElement<HeK, HeV> obj) {
			return ((Comparable) key).compareTo(obj.key);
		}

		@Override
		public String toString() {
			return "[" + key + " : " + value + "]";
		}
	}

	// ALLOWS US TO ITERATE THROUGH ALL KEYS IN THE MAP
	class IteratorHelper<T> implements Iterator<T> {
		// hold all the keys
		T[] keys;
		int position;// points to the item in the iterator

		public IteratorHelper() {
			keys = (T[]) new Object[numElements];

			// get everything out of the hash and put into an array of keys
			int p = 0;
			for (int i = 0; i < tableSize; i++) {
				LinkedList<HashElement<K, V>> list = table[i];

				for (HashElement<K, V> h : list) {
					keys[p++] = (T) h.key;
				}
			}

			// init position
			position = 0;
		}

		@Override
		public boolean hasNext() {
			return position < keys.length;
		}

		@Override
		public T next() {
			if (!hasNext())
				return null;

			return keys[position++];
		}

	}

	@Override
	public Iterator<K> iterator() {
		return new IteratorHelper<K>();
	}

	@Override
	public boolean add(K key, V value) {
	}

	@Override
	public boolean remove(K key, V value) {
	}

	@Override
	public V getValue(K key) {
	}

	@Override
	public void resize(int newSize) {
	}

	@Override
	public double loadFactor() {
	}

}
