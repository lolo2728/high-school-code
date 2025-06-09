import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
	public static boolean contains(String[] array, String key) {
	    return Arrays.asList(array).contains(key);
	}
	
	public static String tileList(String given) {
		int plusPos = new Scanner(given).useDelimiter("\\D+").nextInt(); // Plus position
		int crossPos = Integer.parseInt(given.substring(given.indexOf(",") + 1, given.indexOf("," + 1))); // Cross position
		String removedTiles = given.replace(crossPos + ",", ""); // All the tiles that have been removed
		List<String> items = Arrays.asList(removedTiles.split("\\s*,\\s*"));
		String[] array = items.toArray(new String[items.size()]); // Convert removedTiles to array
		int up = crossPos, down = crossPos, left = crossPos, right = crossPos, ru = crossPos, rd = crossPos, lu = crossPos, ld = crossPos;
		
		int countUp = 0;
		int countDown = 0;
		int countLeft = 0;
		int countRight = 0;
		int countRightUp = 0;
		int countRightDown = 0;
		int countLeftUp = 0;
		int countLeftDown = 0;
		
		// Find up moves
		while(!(up >= 43)) {
			up += 7;
			
			if(contains(array, up + "") == false) {
				countUp++;
			}
		}
		
		// Find down moves
		while(!(down <= 7)) {
			down -= 7;
			
			if(contains(array, down + "") == false) {
				countDown++;
			}
		}
		
		// Find left moves
		while(contains(array, left + "") == false) {
			left -= 1;
			countLeft++;
		}
		
		// Find right moves
		while(contains(array, right + "") == false) {
			right += 1;
			countRight++;
		}


		return countRight + "";
	}

	public static void main(String[] args) {
		String what = "40,42,10,49,0";
		
		System.out.println(tileList(what));
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