import java.util.Scanner;
import java.lang.String;

/* MorseConverter.java 
 * 
 * http://acm.cs.virginia.edu/data/2013-contest.pdf
 * */
public class MorseConverter {
    public static String[] dotsToArray(String dots) {
        String[] newdots = dots.split("\\s+");
        
        for(int i = 0; i < newdots.length; i++) {
            newdots[i] = newdots[i].replaceAll("[^\\W]", "");
        }

        return newdots;
    }
    
    public static String[] dotsToLetter(String[] sweg) {
        String[] ayylmao = sweg;
        
        for(int i = 0; i < sweg.length; i++) {
            if(sweg[i].equals(".-")) {
                ayylmao[i] = "A";
            }
            
            if(sweg[i].equals("-...")) {
                ayylmao[i] = "B";
            }
            
            if(sweg[i].equals("-.-.")) {
                ayylmao[i] = "C";
            }
            
            if(sweg[i].equals("-..")) {
                ayylmao[i] = "D";
            }
            
            if(sweg[i].equals(".")) {
                ayylmao[i] = "E";
            }
            
            if(sweg[i].equals("..-.")) {
                ayylmao[i] = "F";
            }
            
            if(sweg[i].equals("--.")) {
                ayylmao[i] = "G";
            }
            
            if(sweg[i].equals("....")) {
                ayylmao[i] = "H";
            }
            
            if(sweg[i].equals("..")) {
                ayylmao[i] = "I";
            }
            
            if(sweg[i].equals(".---")) {
                ayylmao[i] = "J";
            }
            
            if(sweg[i].equals("-.-")) {
                ayylmao[i] = "K";
            }
            
            if(sweg[i].equals(".-..")) {
                ayylmao[i] = "L";
            }
            
            if(sweg[i].equals("--")) {
                ayylmao[i] = "M";
            }
            
            if(sweg[i].equals("-.")) {
                ayylmao[i] = "N";
            }
            
            if(sweg[i].equals("---")) {
                ayylmao[i] = "O";
            }
            
            if(sweg[i].equals(".--.")) {
                ayylmao[i] = "P";
            }
            
            if(sweg[i].equals("--.-")) {
                ayylmao[i] = "Q";
            }
            
            if(sweg[i].equals(".-.")) {
                ayylmao[i] = "R";
            }
            
            if(sweg[i].equals("...")) {
                ayylmao[i] = "S";
            }
            
            if(sweg[i].equals("-")) {
                ayylmao[i] = "T";
            }
            
            if(sweg[i].equals("..-")) {
                ayylmao[i] = "U";
            }
            
            if(sweg[i].equals("...-")) {
                ayylmao[i] = "V";
            }
            
            if(sweg[i].equals(".--")) {
                ayylmao[i] = "W";
            }
            
            if(sweg[i].equals("-..-")) {
                ayylmao[i] = "X";
            }
            
            if(sweg[i].equals("-.--")) {
                ayylmao[i] = "Y";
            }
            
            if(sweg[i].equals("--..")) {
                ayylmao[i] = "Z";
            }            
        }
        
        return ayylmao;        
    }
    
    public static String ArrayToString(String[] sweg) {
		StringBuffer swegToSweg = new StringBuffer();
		for (int i = 0; i < sweg.length; i++) {
			swegToSweg.append(sweg[i]);
		   // result.append(optional separator);
		}
		String mySwegString = swegToSweg.toString();
		return mySwegString;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int line1 = scan.nextInt(); // Total number of cases
        String[] sweg = new String[line1+1];
        int count = 1;
        
        for(int i = 0; i <= line1; i++) {
        	sweg[i] = scan.nextLine();
        }
        
        String[] heyy = sweg;
        
        for(int j = 1; j <= line1; j++) {
        	heyy[j] = ArrayToString(dotsToLetter(dotsToArray(heyy[j])));
        	System.out.println("Case " + count + ": " + heyy[j]);
        	count++;
        }
    }
}