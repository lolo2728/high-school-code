package hsCTF;

import java.math.BigInteger;

public class CountChars {
	public static void main(String[] args) {
		String hey = "v         v       \\<" +
">&:32p&1-\\>32g*\\1-:|" +
"                   $" +
"                   ." +
"                   @";
		System.out.println(hey.replace(" ", "").length());

	}
}