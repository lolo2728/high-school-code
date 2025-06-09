package sCTF;

import java.math.*;

public class FibonacciNot {
	public static BigInteger G(int x) {
		if(x == 0)
			return BigInteger.ZERO;
		else if(x == 1)
			return BigInteger.ONE;
		else
			return (G(x - 1).add(G(x - 2))).pow(2);
	}
	
	public static BigInteger W(int x) {
		if(x == 0)
			return BigInteger.ZERO;
		else if(x == 1)
			return BigInteger.ONE;
		else
			return (W(x - 1).pow(2)).add(W(x - 2).pow(2));
	}
	
	public static BigInteger F(int x) {
		return G(x).subtract(W(x));
	}
		
	public static BigInteger addDigits(BigInteger f) {
		String digits = f.toString();
		BigInteger sum = BigInteger.ZERO;
				
		for(int i = 0; i < digits.length(); i++) {
			Integer digit = (int) (digits.charAt(i) - '0');
			sum = sum.add(BigInteger.valueOf(digit.intValue()));
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(addDigits(F(30)));
	}
}