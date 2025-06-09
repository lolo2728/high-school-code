/** @author Kiran B.
 * 
 * http://www.acsl.org/acsl/sample_ques/c_3_palindrome_jr.pdf
 * 
 * Get palindrome of number and add it to the original
 * Until you get a palindrome
 * 
 * If the addition of the first 10 numbers isn't a palindrome,
 * Return the "NONE, " and the last number to be added
 * */

import java.util.Scanner;

public class Palindrome {	  
	public static int reverseNum(int num) {
		 int reverse = 0;
		 
		 while(num != 0) {
			 reverse = reverse * 10;
			 reverse = reverse + num % 10;
			 num = num / 10;
		 }
		 return reverse;
	 }
	 
	public static int addReverse(int orig) {
		for(int i = 0; i < 10; i++) {
			orig += reverseNum(orig);
			
			if(orig == reverseNum(orig)) {
				return orig;
			}			
		}
		
		return orig;
	}
	
	public static String setNone(int num) {
		if(num != reverseNum(num)) {
			return "NONE, " + num;
		}
		
		return "" + num;
	}
	
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    int line1 = scan.nextInt();
	    int line2 = scan.nextInt();
	    int line3 = scan.nextInt();
	    int line4 = scan.nextInt();
	    int line5 = scan.nextInt();
	    int line6 = addReverse(line1);
	    int line7 = addReverse(line2);
	    int line8 = addReverse(line3);
	    int line9 = addReverse(line4);
	    int line10 = addReverse(line5);
	    
	    System.out.println(setNone(line6));
	    System.out.println(setNone(line7));
	    System.out.println(setNone(line8));
	    System.out.println(setNone(line9));
	    System.out.println(setNone(line10));
	}
}