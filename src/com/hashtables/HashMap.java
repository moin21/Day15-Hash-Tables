package com.hashtables;

import java.util.ArrayList;

public class HashMap<K, V> {

	/**
	 * The sizeOfArray is the total size of the array And we have created the
	 * arrayList of LinkedList
	 */
	private final int sizeOfArray;
	ArrayList<LinkedList<K>> arrayList;

	public HashMap() {
		/**
		 * Size of array defined 10 New ArrayList with null value assigned
		 */

		sizeOfArray = 10;
		arrayList = new ArrayList<>();
		for (int i = 0; i < sizeOfArray; i++) {
			arrayList.add(null);
		}
	}

	/**
	 * [1]- Method to find the value of a specific key 1. Find the indexNumber which
	 * will range in between the size of ArrayList. 2. Pass the index number to the
	 * arrayList to get the array's LinkedList & save this to the variable
	 * LinkedList 3. If LinkedList null return null 4. If not search the key in the
	 * LinkedList and save the value and key on the myMapNode 5. If mapNode null
	 * then return null if not return value
	 * 
	 * @param key - key param
	 * @return - Value assigned with key
	 */
	public V get(K key) {

		int indexNumber = this.getIndexNumber(key);
		LinkedList<K> linkedList = arrayList.get(indexNumber);

		if (linkedList == null) {
			return null;
		}
		MyMapNode<K, V> mapNode = (MyMapNode<K, V>) linkedList.search(key);
		return mapNode == null ? null : mapNode.getValue();
	}

	/**
	 * Method to find index of the arrayList Get hashcode int from Math.abs function
	 * than mod the hashCode with the size of the arrayList to get a no. in the
	 * range of arrayList
	 * 
	 * @param key - Key param to find the index
	 * @return - Index value
	 */
	private int getIndexNumber(K key) {

		int hashCode = Math.abs(key.hashCode());
		return hashCode % this.sizeOfArray;
	}

	/**
	 * Method to add the node with key & value to the MapNode 1. Find the
	 * indexNumber which will range in between the bucket number. 2. Then we pass
	 * the index number to the arrayList to get the array's LinkedList & save this
	 * to the variable LinkedList 3. If the arrayList is null then we create a new
	 * LinkedKist and set the LinkedList to that index 4. If LinkedList is preset
	 * then we search for that Key 5. If not preset then we make new node and append
	 * that to the LinkedList 6. If key is present then we just update the value
	 * 
	 * @param key   - Here we pass the key & value to add in the list
	 * @param value - Here we pass the key & value to add in the list
	 */
	public void add(K key, V value) {

		int index = this.getIndexNumber(key);
		LinkedList<K> linkedList = this.arrayList.get(index);
		if (linkedList == null) {
			linkedList = new LinkedList<>();
			this.arrayList.set(index, linkedList);
		}

		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) linkedList.search(key);
		if (myMapNode == null) {
			myMapNode = new MyMapNode<>(key, value);
			linkedList.append(myMapNode);
		} else {
			myMapNode.setValue(value);
		}
	}

	/**
	 * Method to delete the LinkList from array
	 * 1. Pass the key and find the index of the LinkedList
	 * 2. Check the arrayList and use the search to check the Node in the LinkedList
	 * 3. Remove the Node and arrayList
	 * @param key - key to remove the Mapnode
	 * @return - return true once it is deleted
	 */
	public boolean remove(K key) {

		int index = this.getIndexNumber(key);
		LinkedList<K> linkedList = this.arrayList.get(index);

		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) linkedList.search(key);

		linkedList.remove(key);
		arrayList.remove(index);
		return true;
	}

	@Override
	public String toString() {
		return "HashMap{" + arrayList + '}';
	}
}