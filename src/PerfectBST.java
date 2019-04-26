
/**
 * This program produces a report from a perfect binary tree.
 * 
 * @author Rainier Sarreal and Andrew Hossack
 */

import java.math.BigInteger;

public class PerfectBST<T extends Comparable<T>> {

	public static void main(String[] args) {
		// main goes here

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

	// Node class
	public class Node<T> {
		private final T key;
		Node<T> leftChild;
		Node<T> rightChild;
		Node<T> parent;

		Node(T key) {
			this.key = key;
			rightChild = leftChild = null;
		}

		public T getValue() {
			return key;
		}

		public Node<T> getLeftChild() {
			return leftChild;
		}

		public Node<T> getRightChild() {
			return rightChild;
		}

		public void setParent(Node<T> parent) {
			this.parent = parent;
		}

	}


}
