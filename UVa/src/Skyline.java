/**
 * <center><h1>105 - The Skyline Problem</h1></center><br>
 * 
 * <p>Problem taken from <a href="http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=3&page=show_problem&problem=41" target="_blank"><i>UVa</i></a>,
 * in which one is given three coordinates written as (a, b, c). a is the starting point of the rectangle, 
 * b is the height of the rectangle, and c is the ending point of the rectangle.</p>
 * 
 * <p>Each rectangle represents an individual building, which each make up one ultimate &#39;Skyline&#39; 
 * </p>
 * 
 * <p><em>SAMPLE INPUT:</em><br>
 * (1, 11, 5),(2, 6, 7),(3, 13, 9),(12, 7, 16),(14, 3, 25),(19, 18, 22),(23, 13, 29),(24, 4, 28)</p><br>
 *
 * <p><em>SAMPLE OUTPUT:</em><br>
 * (1, 11, 3, 13, 9, 0, 12, 7, 16, 3, 19, 18, 22, 3, 23, 13, 29, 0)</p>
 * 
 * @author Kiran B.
 * @category 105 - Skyline Problem
 */

import java.awt.Color;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Skyline extends VisualSkyline {
	public static String getOutput(int[] starting, int[] height, int[] end) {
		ArrayList<String> lul = new ArrayList<String>();
		lul.add(starting[0] + "");
		lul.add(starting[1] + "");
		String[] h = new String[lul.size()];
		return Arrays.toString(h);
	}
	
    @SuppressWarnings({ "deprecation", "unused" })
	public static void main(String[] args) throws IOException {
        int smallestStart = smallestNum(starting());
        int largestStart = largestNum(starting());
        int smallestHeight = smallestNum(heights());
        int largestHeight = largestNum(heights());
        int smallestEnd = smallestNum(end());
        int largestEnd = largestNum(end());
        
		JFrame frame = new JFrame();
		frame.setTitle("Rectangle");
		frame.pack();
		frame.setVisible(true);
		frame.setBackground(Color.GRAY);
		int sums = 0;
		
		for(int i = 0; i < end().length; i++) {
			sums += ((end()[i] - starting()[i]) * 7);
		}
		
		frame.setSize(sums, largestNum(heights()) * 14);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				}
			});
		
		Container contentPane = frame.getContentPane();
		contentPane.add(new VisualSkyline());
		
		frame.show();
		
		System.out.println(getOutput(starting(), heights(), end()));
        
        //System.out.println("Starting points: " + Arrays.toString(starting()) + "\n" +
        					//"Heights: " + Arrays.toString(heights()) + "\n" +
        					//"Ending points: " + Arrays.toString(end()));
    }
}