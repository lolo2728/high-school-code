package picoCTF2014;

import java.io.*;
import java.net.Socket;

public class Swaggot {
	public static void main(String[] args) {
		Socket theSocket;
		try {
		    theSocket = new Socket("vuln2014.picoctf.com", 4547);
		    BufferedReader inFile = new BufferedReader(new InputStreamReader(theSocket.getInputStream()));

		    String strGreet = inFile.readLine();
		    String strData = inFile.readLine();
		    
			System.out.println(strGreet + "\n" + strData);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
}
