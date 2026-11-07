package Hash;

import java.util.Iterator;
import java.util.LinkedList;

public class Hash<K, V> implements HashI<K, V>, Iterable<K> {

	// GLOB
	private int tableSize;
	private int numElements;
	private double maxLoadFactor; // lambda
	private LinkedList<HashElement<K, V>>[] table;

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

	public Hash(int tableSize) {
		this.tableSize = tableSize;

		table = (LinkedList<HashElement<K, V>>[]) new LinkedList[tableSize];

		// Init a LL at each spot of table.
		for (int i = 0; i < tableSize; i++) {
			table[i] = new LinkedList<HashElement<K, V>>();
		}

		this.maxLoadFactor = 0.5;
		this.numElements = 0;
	}

	/**
	 * Measure of how full the hasmap is
	 * e.g. elements divided by space we have in the map.
	 * 
	 * @returns double representing the load factor
	 */
	@Override
	public double loadFactor() {
		return (double) numElements / tableSize;
	}

	@Override
	public boolean add(K key, V value) {
		if (loadFactor() > maxLoadFactor) {
			resize(tableSize * 2);
		}

		// Create the hash element
		HashElement<K, V> element = new HashElement<>(key, value);

		int hashVal = key.hashCode();
		hashVal = hash(hashVal);

		table[hashVal].addFirst(element);
		numElements++;

		return true;
	}

	@Override
	public boolean remove(K key, V value) {
		int index = hash(key.hashCode());

		// walk through linked list
		int num = 0;
		for (HashElement<K, V> element : table[index]) {
			if (((Comparable) element.key).compareTo(key) == 0) {
				break;
			}
			num++;
		}

		table[index].remove(num);
		numElements--;
		return true;
	}

	@Override
	public V getValue(K key) {
		int index = hash(key.hashCode());
		for (HashElement<K, V> element : table[index]) {
			if (((Comparable) element.key).compareTo(key) == 0) {
				return element.value;
			}
		}

		return null;
	}

	@Override
	public void resize(int newSize) {
		LinkedList<HashElement<K, V>>[] newTable = (LinkedList<HashElement<K, V>>[]) new LinkedList[newSize];
		tableSize = newSize;

		// init the LL at all pos
		for (int i = 0; i < newSize; i++) {
			newTable[i] = new LinkedList<HashElement<K, V>>();
		}

		for (K key : this) {
			V value = getValue(key);

			HashElement<K, V> element = new HashElement(key, value);

			int index = hash(key.hashCode());
			newTable[index].addFirst(element);
		}

		table = newTable;
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
}
