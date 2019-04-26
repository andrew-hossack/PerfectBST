
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
		System.out.println("\tType = ");
		System.out.println("\tDepth = " + getDepth(n, key));
		System.out.println("\tHeight = " + getHeight(n, key));
		System.out.println("\tParent = ");
		System.out.println("\tLeft = ");
		System.out.println("\tRight = ");
		getChildren(n,key);

		return;
	}

	public static int getDepthChildren(BigInteger n, BigInteger key) {
		ArrayList<BigInteger> children = new ArrayList<BigInteger>();
		int depth = 1;
		BigInteger currentN = n.add(BigInteger.ONE).divide(new BigInteger("2"));
		BigInteger x = n.add(BigInteger.ONE).divide(new BigInteger("2"));

		if (n.compareTo(key) == 0) {
			return 0;
		}
		while (currentN.compareTo(key) != 0) {
			if (key.compareTo(currentN) > 0) {
				currentN = currentN.add(x.divide(BigDecimal.valueOf(Math.pow(2, depth)).toBigInteger()));
				depth++;
			}

			if (key.compareTo(currentN) < 0) {
				currentN = currentN.subtract(x.divide(BigDecimal.valueOf(Math.pow(2, depth)).toBigInteger()));
				depth++;
			}
		}
		children.add(new BigInteger(depth));
		children.add(currentN.add(x.divide(BigDecimal.valueOf(Math.pow(2, depth)).toBigInteger())));;
		children.add(currentN.subtract(x.divide(BigDecimal.valueOf(Math.pow(2, depth)).toBigInteger())));;
		return depth - 1;
	}
	

	public static int getHeight(BigInteger n, BigInteger key) {
		double totalDepth = Math.log(n.add(BigInteger.ONE).doubleValue()) / Math.log(2) - 1;
		int depthOfKey = getDepth(n, key);
		return (int) (totalDepth - depthOfKey);
	}

}