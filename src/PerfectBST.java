
public class PerfectBST {
	

	Node root;

	// add nodes recursively
	private Node addRecursive(Node currentNode, int value) {
		if (currentNode == null) {
			return new Node(value);
		}
		if (value < currentNode.getValue()) {
			currentNode.leftChild = addRecursive(currentNode.leftChild, value);
		} else if (value > currentNode.getValue()) {
			currentNode.rightChild = addRecursive(currentNode.rightChild, value);
		} else {
			return currentNode;
		}
		return currentNode;
	}

	// constructor methods
	PerfectBST(int key) {
		root = new Node(key);
	}

	PerfectBST() {
		root = null;
	}

	PerfectBST generateTree(int n) {
		//has to validate n based on the given equation 2^(n+1) -1


		PerfectBST tree = new PerfectBST();

		tree.root = new Node(1);

		for (int i = 2; i <= n; i++) {
			tree.addRecursive(tree.root, i);
		}

		return tree;
	}

}
