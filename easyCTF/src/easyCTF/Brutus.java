package easyCTF;

import java.io.*;
import java.math.*;
import java.security.*;
import java.util.*;

/*
 * FORMAT:
 * [number][adjective][color][animal]
 * 
 * f54f10fd6e38929084d505d0c2e9c997
 * */

public class Brutus {
    public static int numLines(String filename) throws IOException {
        LineNumberReader lnr = new LineNumberReader(new FileReader(new File(filename)));
        lnr.skip(Long.MAX_VALUE);
        lnr.close();
        return lnr.getLineNumber() + 1;
    }
    
    public static String toMD5(String txt) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(txt.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1, digest);
        String hashtext = bigInt.toString(16);
        while(hashtext.length() < 32 ){
          hashtext = "0" + hashtext;
        }
        return hashtext;
    }
    
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        String adjf = "files/adjectives.txt";
        String anmf = "files/animals.txt";
        String clrf = "files/colors.txt";
        String numf = "files/numbers.txt";
        Scanner adj = new Scanner(new File(adjf));
        Scanner anm = new Scanner(new File(anmf));
        Scanner clr = new Scanner(new File(clrf));
        Scanner num = new Scanner(new File(numf));
        String[] adja = new String[numLines(adjf)];
        String[] anma = new String[numLines(anmf)];
        String[] clra = new String[numLines(clrf)];
        String[] numa = new String[numLines(numf)];
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        
        while(adj.hasNextLine() != false) {
            adja[a] = adj.nextLine();
            a++;
        }
        
        while(anm.hasNextLine() != false) {
            anma[b] = anm.nextLine();
            b++;
        }

        while(clr.hasNextLine() != false) {
            clra[c] = clr.nextLine();
            c++;
        }

        while(num.hasNextLine() != false) {
            numa[d] = num.nextLine();
            d++;
        }
                        
        for(int i = 0; i < numa.length; i++) {
            for(int j = 0; j < adja.length; j++) {
                for(int k = 0; k < clra.length; k++) {
                    for(int l = 0; l < anma.length; l++) {
                        if((toMD5(numa[i] + adja[j] + clra[k] + anma[l])).equals("f54f10fd6e38929084d505d0c2e9c997")) {
                        	System.out.println(numa[i] + adja[j] + clra[k] + anma[l]);
                        }
                    }
                }
            }
        }
                        
        adj.close();
        anm.close();
        clr.close();
        num.close();
    }
}