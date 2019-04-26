
public class Node {
	private int key;
	Node leftChild;
	Node rightChild;

	Node(int key) {
		this.key = key;
		rightChild = leftChild = null;
	}

	public int getValue() {
		return key;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

}
