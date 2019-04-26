
/**
 * This program produces a report from a perfect binary tree.
 * 
 * @author Rainier Sarreal and Andrew Hossack
 */

import java.math.BigInteger;

public class PerfectBST<T extends Comparable<T>> {

	public static void main(String[] args) {

		// number of elements
		BigInteger n = new BigInteger("15");
		// key value k
		BigInteger key = null;
		// verify input n to be in right form
		if ((Math.log(n.intValue() + 1) / Math.log(2)) - 1 != (int) (Math.log(n.intValue() + 1) / Math.log(2)) - 1) {
			System.err.println("Invalid entry for n");
			return;
		}

		PerfectBST<BigInteger> tree = new PerfectBST<BigInteger>();

		for (int i = 1; i <= n.intValue(); i++) {
			tree.insert(BigInteger.valueOf(i));
		}

		tree.printInorder(tree.root);
	}

	// root of tree
	TreeNode root;

	// constructor methods
	<T> PerfectBST(T key) {
		root = new TreeNode(key);
	}

	PerfectBST() {
		root = null;
	}

	// This method mainly calls insertRec()
	void insert(T key) {
		root = insertRec(root, key);
	}

	// recursively insert a new key
	private TreeNode<T> insertRec(TreeNode<T> root, T key) {
		/* If the tree is empty, return a new node */
		if (root == null) {
			root = new TreeNode(key);
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

	void printInorder(TreeNode node) {
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
	public class TreeNode<T> {
		// node attributes
		private final T key;
		TreeNode<T> leftChild;
		TreeNode<T> rightChild;
//		Node<T> parent;

		public boolean hasLeftChild() {
			return leftChild != null;
		}

		public boolean hasRightChild() {
			return rightChild != null;
		}

		// constructor, getters & setters
		TreeNode(T key) {
			this.key = key;
			rightChild = leftChild = null;
		}

		public T getKey() {
			return key;
		}

	}

	String getType(TreeNode currentNode) {
		if (currentNode.hasLeftChild() && currentNode.hasRightChild()) {
			return "ROOT";
		} else if (currentNode.hasLeftChild() && !currentNode.hasRightChild()) {
			return "LEFT";
		} else if (!currentNode.hasLeftChild() && currentNode.hasRightChild()) {
			return "RIGHT";
		} else {
			return null;
		}
	}

}
