package picoCTF;

import java.io.Console;
import java.io.PrintStream;

public class Authentication {
	public static char[] key;
	public static void main(String[] paramArrayOfString) {
		key = new char[10];
		key[0] = 'J';
		key[1] = 'R';
		key[2] = 'Z';
		key[3] = 'h';
		key[4] = 'H';
		key[5] = 'w';
		key[6] = 'Y';
		key[7] = 'e';
		key[8] = 'f';
		key[9] = 'J';
		
		//JRZhHwYefJ
		
		Console localConsole = System.console();
		String str = "";
		while (!str.equals("ThisIsth3mag1calString2477")) {
			str = localConsole.readLine("Enter password:" + new Object[0]);
			}
		
		for (int i = 0; i < key.length; i++) {
			System.out.print(key[i]);
			}
		
		System.out.println("");
		}
	}