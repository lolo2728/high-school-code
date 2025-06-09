import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * Your Name Grade ??
 * Doral Academy #5157 INTERMEDIATE-5 Division
 * 2014-2015 American Computer Science League
 * Contest #3 "ACSL Isola" DUE DATE 03/05/15
 * PROJECT NAME: "ACSL Isola Project"
 * CLASS NAME: "ACSLIsola"
 * INPUT FILENAME: "ACSLISOLA.IN"
 * 
 * On my honor I have neither given nor received help,
 * nor will I give help on this program
 */
public class ACSLIsola {
	public static String tileList(String given) {
		int plusPos = new Scanner(given).useDelimiter("\\D+").nextInt(); // Plus position
		int crossPos = Integer.parseInt(given.substring(given.indexOf(",") + 1, given.indexOf("," + 1))); // Cross position
		String removedTiles = given.replace(plusPos + "," + crossPos + ",", ""); // All the tiles that have been removed
		List<String> items = Arrays.asList(removedTiles.split("\\s*,\\s*"));
		String[] array = items.toArray(new String[items.size()]); // Convert removedTiles to array
		
		int countUp = 0;
		int countDown = 0;
		int countLeft = 0;
		int countRight = 0;
		int countRightUp = 0;
		int countRightDown = 0;
		int countLeftUp = 0;
		int countLeftDown = 0;

		return removedTiles;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("/Users/visitor/Desktop/ACSLISOLA.txt"));
	    List<String> moves = new ArrayList<String>();
	    while (in.hasNext()) {
	    	moves.add(in.next());
	    }
	    in.close();
	    
	    String[] movesArray = moves.toArray(new String[0]);
	    
	    for(int i = 0; i < 5; i++) {
	    	//movesArray[i];
	    }
	}
}

/*
 * Subtract or add by 8 to move diagonally (to the right).
 * Subtract or add by 6 to move diagonally (to the left).
 * 
 *  If num + 6 > 49 OR num + 8 > 49, not it
 *  count++ till it gets greater than 49
 *  
 *  Subtract or add by 7 to move up or down.
 *  Subtract or add by 1 to move left or right.
 *  
 *  Boundaries L to R are 1-7, and 43-49
 *  Boundaries up to down are 1 += 7, till 43
 *  Boundaries up to down are 7 += 7, till 49
 *  
 *  But first check if it's not surrounded
 */