
/**
 * This program produces a report from a perfect binary tree.
 * 
 * @author Rainier Sarreal and Andrew Hossack
 */

import java.math.BigInteger;

public class PerfectBST<T extends Comparable<T>> {
	

	public static void main(String[] args) {
		// main goes here
		PerfectBST<BigInteger> tree = new PerfectBST<BigInteger>();

		for (int i = 0; i < 10; i++) {
			tree.insert(BigInteger.valueOf(i));
		}

		tree.printInorder(tree.root);
	}

	
	
	
	
	
	// root of tree
	Node root;

	// constructor methods
	<T> PerfectBST(T key) {
		root = new Node(key);
	}

	PerfectBST() {
		root = null;
	}

	// This method mainly calls insertRec()
	void insert(T key) {
		root = insertRec(root, key);
	}

	// recursively insert a new key
	private Node<T> insertRec(Node<T> root, T key) {
		/* If the tree is empty, return a new node */
		if (root == null) {
			root = new Node(key);
			return root;
		}
		/* Otherwise, recur down the tree */
		if (key.compareTo(root.getKey()) < 0)
			root.leftChild = insertRec(root.leftChild, key);
		else if (key.compareTo(root.getKey()) > 0)
			root.rightChild = insertRec(root.rightChild, key);

		/* return the (unchanged) node pointer */
		return root;
	}

	void printInorder(Node node) {
		if (node == null)
			return;

		/* first recur on left child */
		printInorder(node.leftChild);

		/* then print the data of node */
		System.out.print(node.key + " ");

		/* now recur on right child */
		printInorder(node.rightChild);
	}

	// Node class
	public class Node<T> {
		// node attributes
		private final T key;
		Node<T> leftChild;
		Node<T> rightChild;
		Node<T> parent;

		// constructor, getters & setters
		Node(T key) {
			this.key = key;
			rightChild = leftChild = null;
		}

		public T getKey() {
			return key;
		}

	}

}
