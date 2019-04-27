
/**
 * This program produces a report from a perfect binary tree.
 * 
 * @author Rainier Sarreal and Andrew Hossack
 * @param <T>
 */

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import com.google.common.math.BigIntegerMath;


public class PerfectBST<T extends Comparable<T>> {

	public static void main(String[] args) {
		// convert n and key to BigInteger types
		BigInteger n = new BigInteger(args[0].toString());
		BigInteger key = new BigInteger(args[1].toString());

		// error checking for n, key
		double n1 = BigIntegerMath.log2(n.add(BigInteger.ONE),RoundingMode.FLOOR) / Math.log(2) + 1;
		double n2 = BigIntegerMath.log2(n.add(BigInteger.ONE),RoundingMode.CEILING) / Math.log(2) + 1;
		
		if (n1!=n2 || key.compareTo(BigInteger.ONE) < 0 || key.compareTo(n) > 0) {
			System.err.println("Invalid input");
			return;
		}

		// begin output
		System.out.printf("Tree size n = %s\n", n.toString());
		System.out.printf("\t%8s = %s\n", "Key", key.toString());
		System.out.printf("\t%8s = %s\n", "Type", nodeAttribues(n, key).get(4));
		System.out.printf("\t%8s = %s\n", "Depth", nodeAttribues(n, key).get(0));
		System.out.printf("\t%8s = %s\n", "Height", getHeight(n, key));
		System.out.printf("\t%8s = %s\n", "Parent", nodeAttribues(n, key).get(3));
		System.out.printf("\t%8s = %s\n", "Left", nodeAttribues(n, key).get(2));
		System.out.printf("\t%8s = %s\n", "Right", nodeAttribues(n, key).get(1));

		return;
	}

	// Computes different attributes of the key node, returns
	// ArrayList<String> type containing all data
	public static ArrayList<String> nodeAttribues(BigInteger n, BigInteger key) {
		ArrayList<String> results = new ArrayList<String>();
		int depth = 1;
		BigInteger currentNode = n.add(BigInteger.ONE).divide(new BigInteger("2"));
		BigInteger root = n.add(BigInteger.ONE).divide(new BigInteger("2"));
		BigInteger parent = null;

		// continues to compute until theoretical node is found
		while (currentNode.compareTo(key) != 0) {
			// set parent of key, increment depth
			// if key is greater than current node, go to current node's right child
			if (key.compareTo(currentNode) > 0) {
				parent = currentNode;
				// add currentnode's value to root / 2^depth
				currentNode = currentNode.add(root.divide(BigDecimal.valueOf(Math.pow(2, depth)).toBigInteger()));
				depth++;
			}
			// if key is less than current node, go to current node's left child
			if (key.compareTo(currentNode) < 0) {
				parent = currentNode;
				// currentnode's value to root / 2^depth
				currentNode = currentNode.subtract(root.divide(BigDecimal.valueOf(Math.pow(2, depth)).toBigInteger()));
				depth++;
			}
		}
		// add depth to index 0 of result array
		results.add(Integer.toString(depth - 1));

		// check if currentNode is a leaf node or not based on being even, odd
		if (currentNode.mod(new BigInteger("2")) == BigInteger.ZERO) {
			// key is not a lead node
			// add right child
			results.add(currentNode.add(root.divide(BigDecimal.valueOf(Math.pow(2, depth)).toBigInteger())).toString());
			;
			results.add(currentNode.subtract(root.divide(BigDecimal.valueOf(Math.pow(2, depth)).toBigInteger()))
					.toString());
			;
		} else {
			// key is a leaf node, added twice to make printing results easier
			results.add("- (leaf)");
			results.add("- (leaf)");
		}

		// add parent value to result
		if (parent == null) {
			results.add("- (root)");
		} else {
			results.add(parent.toString());
		}

		// check if key is left, right child of parent, or root, add to result
		if (parent == null) {
			results.add("ROOT");
		} else if (key.compareTo(parent) < 0) {
			results.add("LEFT");
		} else {
			results.add("RIGHT");
		}
		return results;
	}

	// compute height of tree based on equation
	public static int getHeight(BigInteger n, BigInteger key) {
		double totalDepth = Math.log(n.add(BigInteger.ONE).doubleValue()) / Math.log(2) - 1;
		return (int) (totalDepth - Integer.parseInt(nodeAttribues(n, key).get(0)));
	}

}