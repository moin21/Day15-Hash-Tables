package com.hashtables;

/**
 * Generic class for the LinkedList implementation
 *
 * @param <K> : Generic type of key for the LinkedKist
 */
public class LinkedList<K> {

	/**
	 * Initialized 2 variable of generic type
	 */
	private Node<K> head;
	private Node<K> tail;

	/**
	 * Method to search for a specific key in the HashTable. 1. declare a variable
	 * of type node and assign it to head 2. Traverse the list till it is not null
	 * to match every element with input key 3. If matched return node. If key not
	 * return null
	 * 
	 * @param key - key to search for a specific key in the LinkedList
	 * @return - Node of that specific key
	 */
	public Node<K> search(K key) {

		Node<K> temp = head;
		while (temp != null) {
			if (temp.getKey().equals(key)) {
				return temp;
			}

			temp = temp.getNext();
		}
		return null;
	}

	/**
	 * 1. Check if head or tail is null(empty linked list) 2. If not add the element
	 * to the tail and make the newNode as tail
	 * 
	 * @param myNode - Node to append at last
	 */
	public void append(Node<K> myNode) {

		if (this.head == null) {
			this.head = myNode;
		}
		if (this.tail == null) {
			this.tail = myNode;
		} else {
			this.tail.setNext(myNode);
			this.tail = myNode;
		}
	}

	/**
	 * [3] Method to remove the node from the LinkedList 1. First we assign the head
	 * to temp and prev as null 2. Check if the temp key matches the imput key 3.
	 * Increment the temp and prev till we get the key 4. If key matches make the
	 * prev as temp and assign the temp next to the prev i.e temp
	 * 
	 * @param key - key to remove the node
	 * @return - return true if we find the node and found and deleted it and we
	 *         return false
	 */
	public boolean remove(K key) {

		Node<K> temp = head;
		Node<K> prev = null;
		while (temp != null) {
			if (temp.getKey() == key) {
				prev.setNext(temp.getNext());
				return true;
			}
			prev = temp;
			temp = temp.getNext();
		}
		return false;
	}

	@Override
	public String toString() {
		return "\n MyLinkedListNodes{" + head + "}";
	}

	public void printMyNodes() {
		System.out.println(" My Nodes :" + head);
	}

}
