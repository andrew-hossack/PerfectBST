
/**
 * This program produces a report from a perfect binary tree.
 * 
 * @author Rainier Sarreal and Andrew Hossack
 * @param <T>
 */

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class PerfectBST<T extends Comparable<T>> {

	public static void main(String[] args) {
		// convert n and key to biginteger types
		BigInteger n = new BigInteger(args[0].toString());
		BigInteger key = new BigInteger(args[1].toString());

		// error checking for n, key
		if ((Math.log(n.add(new BigInteger("1")).doubleValue()) / Math.log(2))
				- 1 != (int) (Math.log(n.add(new BigInteger("1")).doubleValue()) / Math.log(2)) - 1) {
			System.err.println("Invalid entry for n");
			System.out.println((Math.log(n.add(new BigInteger("1")).doubleValue()) / Math.log(2))
				- 1);
			return;
		}
		if (key.compareTo(new BigInteger("1")) < 0 || key.compareTo(n) > 0) {
			System.err.println("Invalid entry for key: " + key + " value = " + n);
			return;
		}

		// begin output
		System.out.println("Tree size n = " + n.toString());
		System.out.println("\tKey = " + key.toString());
		System.out.println("\tType = " + nodeAttribues(n,key).get(4));
		System.out.println("\tDepth = " + nodeAttribues(n,key).get(0));
		System.out.println("\tHeight = " + getHeight(n, key));
		System.out.println("\tParent = " + nodeAttribues(n,key).get(3));
		System.out.println("\tLeft = " + nodeAttribues(n,key).get(2));
		System.out.println("\tRight = " + nodeAttribues(n,key).get(1));

		return;
	}

	public static ArrayList<String> nodeAttribues(BigInteger n, BigInteger key) {
		ArrayList<String> children = new ArrayList<String>();
		int depth = 1;
		BigInteger currentN = n.add(BigInteger.ONE).divide(new BigInteger("2"));
		BigInteger root = n.add(BigInteger.ONE).divide(new BigInteger("2"));
		BigInteger parent = null;
		
		while (currentN.compareTo(key) != 0) {
			if (key.compareTo(currentN) > 0) {
				parent = currentN;
				currentN = currentN.add(root.divide(BigDecimal.valueOf(Math.pow(2, depth)).toBigInteger()));
				depth++;
			}

			if (key.compareTo(currentN) < 0) {
				parent = currentN;
				currentN = currentN.subtract(root.divide(BigDecimal.valueOf(Math.pow(2, depth)).toBigInteger()));
				depth++;
			}
		}
		children.add(Integer.toString(depth-1));
		if(currentN.mod(new BigInteger("2"))==BigInteger.ZERO) {
			children.add(currentN.add(root.divide(BigDecimal.valueOf(Math.pow(2, depth)).toBigInteger())).toString());;
			children.add(currentN.subtract(root.divide(BigDecimal.valueOf(Math.pow(2, depth)).toBigInteger())).toString());;			
		}else {
			children.add("- (leaf)");
			children.add("- (leaf)");
		}

		children.add(parent.toString());
		
		if(key.compareTo(parent)<0) {
			children.add("LEFT");
		}else {
			children.add("RIGHT");
		}
		return children;
	}
	

	public static int getHeight(BigInteger n, BigInteger key) {
		double totalDepth = Math.log(n.add(BigInteger.ONE).doubleValue()) / Math.log(2) - 1;
		
		return (int) (totalDepth - Integer.parseInt(nodeAttribues(n,key).get(0)));
	}

}