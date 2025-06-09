import java.io.*;
import java.util.*;

public class BinaryIsTheBest {
	public static int toDec(String bin) {
		char[] nums = bin.toCharArray();
		int sum = 0;
		int pow = 0;
		for(int i = nums.length - 1; i >= 0; i--) {
			if(nums[i] == '1') {
				sum += Math.pow(2, pow);
			}
			pow++;
		}
		
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("/Users/visitor/Downloads/2015problemset/testdata/binary.judge.in.txt"));
		int num = in.nextInt();
		@SuppressWarnings("unused")
		String getLine = in.nextLine();
		String j, k;
		for(int i = 0; i < num; i++) {
			j = in.next();
			k = in.next();
			System.out.println(Integer.toString(toDec(k), Integer.parseInt(j)));
		}
				
		in.close();
	}
}