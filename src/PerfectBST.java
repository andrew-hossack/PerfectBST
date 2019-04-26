import java.math.BigInteger;
import java.util.Comparator;

/**
 * This program produces a report from a perfect binary tree.
 * 
 * @author Rainier Sarreal and Andrew Hossack
 * @param <T>
 */

public class PerfectBST<T extends Comparable<T>>  {
	
	public class TreeNode<T> {
		private final T key;
		TreeNode<T> parent;
		TreeNode<T> leftChild;
		TreeNode<T> rightChild;

		TreeNode(T key, TreeNode<T> parent) {
			this.key = key;
			this.parent = parent;
			rightChild = leftChild = null;
		}
		
		public T getValue() {
			return key;
		}
		
		public void setParent(TreeNode<T> parent) {
			this.parent = parent;
		}
		
		public TreeNode<T> getParent() {
			return parent;
		}

		public void setLeftChild(TreeNode<T> leftChild) {
			this.leftChild = leftChild;
		}
		
		public TreeNode<T> getLeftChild() {
			return leftChild;
		}

		public void setRightChild(TreeNode<T> rightChild) {
			this.rightChild = rightChild;
		}

		public TreeNode<T> getRightChild() {
			return rightChild;
		}
	} 
	
	private TreeNode<T> root;
    private final Comparator<T> cmp;
    
    public PerfectBST(Comparator<T> cmp) {
        this.cmp = cmp;
    }
	
	public String getType(TreeNode<T> node) {
		TreeNode<T> parent = node.getParent();
		String type = null;
		if(node.getValue().compareTo(parent.getValue()) > 0) {
			type = "RIGHT";
		} else if(node.getValue().compareTo(parent.getValue()) < 0) {
			type = "LEFT";
		} else {
			type = "ROOT";
		}
		return type;
	}
	
	public BigInteger getDepth(TreeNode<T> node) {
		if(node == root) {
			return new BigInteger("0");
		}
		TreeNode<T> currentNode = node;
		BigInteger depthCount = BigInteger.ZERO;
		while(currentNode != root) {
			currentNode = currentNode.getParent();
			depthCount = depthCount.add(BigInteger.ONE);
		}
		return depthCount;
	}
	
}
