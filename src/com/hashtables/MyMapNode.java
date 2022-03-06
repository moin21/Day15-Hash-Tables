package com.hashtables;

public class MyMapNode<K, V> implements Node<K> {
	K key;
	V value;
	Node<K> next;

	/**
	 * constructor
	 * 
	 * @param key   - generic type key
	 * @param value - generic type value assigned to key
	 */
	public MyMapNode(K key, V value) {
		super();
		this.key = key;
		this.value = value;
		this.next = null;
	}

	/**
	 * getters and setters
	 */
	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	@Override
	public Node<K> getNext() {
		return next;
	}

	@Override
	public void setNext(Node<K> next) {

		this.next = next;

	}

	@Override
	/**
	 * Method to display the output of the MapNode
	 */
	public String toString() {
		StringBuilder myMapNodeString = new StringBuilder();
		myMapNodeString.append("MyMapNode{" + "K=").append(key).append(" V=").append(value).append('}');
		if (next != null)
			myMapNodeString.append("->").append(next);
		return myMapNodeString.toString();
	}

}