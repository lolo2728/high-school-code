import java.io.*;
import java.util.*;

public class CountingVowels {
	public static String countVowels(String sent) {
		sent = sent.toLowerCase();
		int numA = sent.length() - sent.replace("a", "").length();
		int numE = sent.length() - sent.replace("e", "").length();
		int numI = sent.length() - sent.replace("i", "").length();
		int numO = sent.length() - sent.replace("o", "").length();
		int numU = sent.length() - sent.replace("u", "").length();
		return ("a=" + numA + " " + "e=" + numE + " " + "i=" + numI + " " + "o=" + numO + " " + "u=" + numU);
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("/Users/visitor/Downloads/2015problemset/testdata/counting.judge.in.txt"));
		int num = in.nextInt();
		@SuppressWarnings("unused")
		String nex = in.nextLine();
		int count = 1;
		for(int i = 0; i < num; i++) {
			System.out.println("Case " + count + ": " + countVowels(in.nextLine()));
			count++;
		}
		in.close();
	}
}