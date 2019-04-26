
/**
 * This program produces a report from a perfect binary tree.
 * 
 * @author Rainier Sarreal and Andrew Hossack
 */

import java.math.BigInteger;

public class PerfectBST<T extends Comparable<T>> {

	public static void main(String[] args) {

		// number of elements
		BigInteger n = new BigInteger("31");
		// key value k
		BigInteger key = new BigInteger("15");

		// verify input n to be in right form
		if ((Math.log(n.intValue() + 1) / Math.log(2)) - 1 != (int) (Math.log(n.intValue() + 1) / Math.log(2)) - 1) {
			System.err.println("Invalid entry for n");
			return;
		}

		PerfectBST<BigInteger> tree = new PerfectBST<BigInteger>();
		// add values recursively to tree
		for (int i = 1; i <= n.intValue(); i++) {
			tree.insert(BigInteger.valueOf(i));
		}

		// print in order tree
		tree.inOrder();

		BigInteger depth = tree.getDepth(tree.root, key);
		System.out.println("Depth = " + depth);

	}

	// root of tree
	TreeNode<T> root;

	// constructor methods
	PerfectBST(T key) {
		root = new TreeNode<T>(key);
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
			root = new TreeNode<T>(key);
			return root;
		}
		/* Otherwise, recurse down the tree */
		if (key.compareTo(root.getKey()) < 0)
			root.leftChild = insertRec(root.leftChild, key);
		else if (key.compareTo(root.getKey()) > 0)
			root.rightChild = insertRec(root.rightChild, key);
		/* return the (unchanged) node pointer */
		return root;
	}

	public void inOrder() {
		printInorder(root);
	}
	private void printInorder(TreeNode<T> node) {
		if (node == null)
			return;

		/* first recur on left child */
		printInorder(node.leftChild);

		/* then print the data of node */
		System.out.print(node.key + " ");

		/* now recur on right child */
		printInorder(node.rightChild);
	}

	void postOrder() {
		printPostorder(root);
	}
	void printPostorder(TreeNode<T> node) {
		if (node == null)
			return;

		// first recur on left subtree
		printPostorder(node.leftChild);

		// then recur on right subtree
		printPostorder(node.rightChild);

		// now deal with the node
		System.out.print(node.getKey() + " ");
	}

	void preOrder() {
		printPreorder(root);
	}
	private void printPreorder(TreeNode<T> node) {
		if (node == null)
			return;

		/* first print data of node */
		System.out.print(node.getKey() + " ");

		/* then recur on left sutree */
		printPreorder(node.leftChild);

		/* now recur on right subtree */
		printPreorder(node.rightChild);
	}

	public BigInteger getDepth(TreeNode<T> root, T key) {
		BigInteger count = BigInteger.ZERO;
		TreeNode<T> currentNode = root;
		if (root.getKey().compareTo(key) == 0) {
			return BigInteger.ZERO;
		}
		while (currentNode.getKey().compareTo(key) != 0) {
			if (currentNode.getKey().compareTo(key) < 0) {
				currentNode = currentNode.rightChild;
				count = count.add(BigInteger.ONE);
			} else if (currentNode.getKey().compareTo(key) > 0) {
				currentNode = currentNode.leftChild;
				count = count.add(BigInteger.ONE);
			}
		}
		return count;
	}

	// Node class
	public static class TreeNode<T> {
		// node attributes
		private T key;
		TreeNode<T> leftChild;
		TreeNode<T> rightChild;

		// constructor, getters & setters
		TreeNode(T key) {
			this.key = key;
			rightChild = leftChild = null;
		}

		public T getKey() {
			return key;
		}

	}

}
