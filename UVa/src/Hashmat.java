/**Possibly the easiest problem I've been graced with in UVa.
 * Godbless.
 * 
 * @author Kiran B.
 * */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class Hashmat {
    @SuppressWarnings("resource")
	public static int countLines(String filename) throws IOException {
        LineNumberReader lnr = new LineNumberReader(new FileReader(new File(filename)));
        lnr.skip(Long.MAX_VALUE);
        return lnr.getLineNumber();
    }

	public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("resources/hashmat.txt"));
        int uwotm8 = (countLines("resources/hashmat.txt") + 1) * 2;
        int[] hashtaghashmat = new int[uwotm8];
        int j = 0;
        
        while(in.hasNextLine() != false) {
        	hashtaghashmat[j] = in.nextInt();
            j++;
        }
        
        for(int i = 0; i < hashtaghashmat.length; i += 2) {
        	System.out.println(hashtaghashmat[i + 1] - hashtaghashmat[i]);
        }
        
	}
}
