import java.util.Scanner;

/* http://www.acsl.org/acsl/sample_ques/c_1_code_jr.pdf
 * A = 1, B = 2, ... Z = 26
 * 
 * A-E ~~ Mult. by 2
 * F-J ~~ (Mod by 3) then Mult. by 5
 * K-O ~~ Divide by 4, then Mult. by 8
 * P-T ~~ Mult. sum of digits by 10
 * U-Z ~~ Largest int factor of numerical val < val, then Mult. by 12
 * 
 * E.g. B (2), 2 * 2 = 4; D (4)
 * E.g. G (7), 7 % 3, 1 * 5 = 5; E (5)
 * E.g. Z (26), 13 * 12
 * 
 * If end num == 0, print #
 * 
 * LETTERS THAT ARE INPUTTED MUST BE CAPS
 * */
public class Problem {
	public static int letterToNum(String a) {
		for(int i = 0; i < a.length(); ++i) {
	    	  if (a.charAt(i) >= 'A' && a.charAt(i) <= 'Z') {
	    	    return((int)a.charAt(i) - (int)'A' + 1);
	    	  }
	    }
		return 0;
	}
	
	public static int sumDigits(int digits) {
		int sum = 0;
		while (digits > 0) {
			sum += digits % 10;
			digits /= 10;
			}
		
		return sum;
	}
	
	public static int getFactor(int numFac) {
		int factorCount = 0;
		for(int i = 1; i < numFac; i++) {  
		    if(numFac % i == 0) {
		       factorCount++;
		    }
		}
		return factorCount;
	}
	
	public static int setFactorArray(int findfact) {
		int i = 1;
		int j = 0;
		int factors = getFactor(findfact);
		int[] sweg = new int[factors];
		
		while(i < findfact) {
			if(findfact % i == 0) {
				sweg[j] = i;
				j++;
				}
			i++;
			}
		return(sweg[sweg.length-1]); //get last num in array
	}
	
	public static int doProblem(int number) {		
		if(1 <= number && 5 >= number) {
			return number *2;
		}
		
		if(6 <= number && 10 >= number) {
			return ((number % 3) * 5);
		}
		
		if(11 <= number && 15 >= number) {
			return ((number / 4) * 8);
		}
		
		if(16 <= number && 20 >= number) {
			int mult = sumDigits(number) * 10;
			if(mult % 26 == 0) {
				return mult / 26;
			}
			return mult % 26;
		}
		
		if(21 <= number && 26 >= number) {
			int mult = setFactorArray(number) * 12;
			if((mult % 26 == 0) && mult != 0) {
				return 26;
			}
			
			if(mult % 26 == 0) {
				return mult / 26;
			}
			return mult % 26;
		}
		return number;
	}
	
	public static String numberToLetter(int nem) {
		 char[] charArray = new char[1];
		 charArray[0] = (char)(nem + 64);

		 return(new String(charArray));
	}
	
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    String line1 = scan.nextLine(); // First num
	    String line2 = scan.nextLine(); // Second num
	    String line3 = scan.nextLine(); // Third num
	    String line4 = scan.nextLine(); // Fourth num
	    String line5 = scan.nextLine(); // Fifth num
	    int num1 = letterToNum(line1);
	    int num2 = letterToNum(line2);
	    int num3 = letterToNum(line3);
	    int num4 = letterToNum(line4);
	    int num5 = letterToNum(line5);
	    int num6 = doProblem(num1);
	    int num7 = doProblem(num2);
	    int num8 = doProblem(num3);
	    int num9 = doProblem(num4);
	    int num10 = doProblem(num5);

	    System.out.println(numberToLetter(num6));
	    System.out.println(numberToLetter(num7));
	    System.out.println(numberToLetter(num8));
	    System.out.println(numberToLetter(num9));
	    System.out.println(numberToLetter(num10));
	}
}