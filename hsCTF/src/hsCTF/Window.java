package hsCTF;

import java.math.*;

public class Window {
	public static BigDecimal sqrt(BigDecimal value) {
	    BigDecimal x = new BigDecimal(Math.sqrt(value.doubleValue()));
	    return x.add(new BigDecimal(value.subtract(x.multiply(x)).doubleValue() / (x.doubleValue() * 2.0)));
	}

	public static void main(String[] args) {
		BigDecimal max_val = new BigDecimal("9999999997");
		BigDecimal sqr, num;
		BigDecimal sum = BigDecimal.ZERO;
		
		for(BigDecimal i = BigDecimal.ONE; i.compareTo(max_val) == -1; i.add(BigDecimal.ONE)) {
			sqr = (i.multiply(i)).add(((i.add(BigDecimal.ONE)).multiply(i.add(BigDecimal.ONE))));
			num = (sqrt(sqr)).setScale(2, BigDecimal.ROUND_HALF_UP);
			if(num.multiply(num).equals(sqr)) {
				sum = sum.add(i);
			}
		}
		
		System.out.println(sum);
	}
}