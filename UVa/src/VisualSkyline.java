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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
 
@SuppressWarnings("serial")
public class VisualSkyline extends JPanel {    
	@SuppressWarnings("resource")
    /**
     * @param filename
     * @return Number of lines in a .txt file
     * */
    public static int countLines(String filename) throws IOException {
        LineNumberReader lnr = new LineNumberReader(new FileReader(new File(filename)));
        lnr.skip(Long.MAX_VALUE);
        return lnr.getLineNumber();
    }
	
	/**
	 * @param wotm8
	 * @return New array without duplicates
	 * */
	public static String[] removeDuplicate(String[] wotm8) {
	    Set<String> set = new HashSet<String>();
	    set.addAll((List<String>) Arrays.asList(wotm8));
	    return (String[]) set.toArray(new String[set.size()]);
	}
	
	/**
	 * @param filename
	 * @return A string array containing the values in the file, without duplicates
	 * */
	public static String[] fileToArray(String filename) throws IOException {
        Scanner in = new Scanner(new File(filename));
        int uwotm8 = countLines(filename) + 1;
        String[] initial = new String[uwotm8];
        int i = 0;
        
        while(in.hasNextLine() != false) {
            initial[i] = in.nextLine();
            i++;
        }
        
        String[] swag = removeDuplicate(initial);
        return swag;
	}
        
    /**
     * @param swiggity
     * @return Largest int in an int array
     * */
    public static int largestNum(int[] swiggity) {
        int largest = swiggity[0];
       
        for(int i = 1; i < swiggity.length; i++) {
        	if(swiggity[i] > largest)
        		largest = swiggity[i];
        	}
        return largest;
        }
    
    /**
     * @param swaggity
     * @return Smallest int in an int array
     * */
    public static int smallestNum(int[] swaggity) {
    	int smallest = swaggity[0];
       
        for(int i = 1; i < swaggity.length; i++) {
        	if (swaggity[i] < smallest)
        		smallest = swaggity[i];
        	}
        return smallest;
        }
        
    /**
     * @return Array containing starting points, heights, and ending points accessible outside of this particular class */
    public static String[] swag() throws IOException {
    	String[] swag = fileToArray("/Users/visitor/Desktop/Projects/Text/Skyline.txt"); // Change file path here
    	return swag;
    }
    
    /**
     * @return Starting points array accessible outside of this particular class */
    public static int[] starting() throws IOException {
    	int linenum = swag().length;
        int[] starting = new int[linenum];
                
        for(int j = 0; j < linenum; j++) {
        	starting[j] = Integer.parseInt(swag()[j].substring(0, swag()[j].indexOf(" ")));        	
        }
        return starting;
    }
    
    /**
     * @return Heights array accessible outside of this particular class */
    public static int[] heights() throws IOException {
    	int linenum = swag().length;
        int[] heights = new int[linenum];
                
        for(int j = 0; j < linenum; j++) {
        	heights[j] = Integer.parseInt(swag()[j].substring(swag()[j].indexOf(" ") + 1, swag()[j].indexOf(" ", swag()[j].indexOf(" ") + 1)));
        }
        
        return heights;
    }
    
    /**
     * @return End points array accessible outside of this particular class */
    public static int[] end() throws IOException {
    	int linenum = swag().length;
        int[] end = new int[linenum];
                
        for(int j = 0; j < linenum; j++) {
        	end[j] = Integer.parseInt(swag()[j].substring(swag()[j].indexOf(" ", swag()[j].indexOf(" ") + 1) + 1, swag()[j].length()));
        }
        return end;
    }
        
    /**
     * @param g
     * @return Nothing, but graphs out the Skyline for visual purposes */
	public void paint (Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		
		try {
	        int largestHeight = largestNum(heights());	        
	        //System.out.println("Dimensions:");
	        
			for(int i = 0; i < starting().length; i++) {
				g2.fillRect(starting()[i] * 10, (3 + (largestHeight - heights()[i])) * 10,
						(end()[i] - starting()[i]) * 10, heights()[i] * 10);  // Change to g2.draw(new Rectangle2D.Double( for outline
				//System.out.println("[" + (starting()[i] * 10 + ", " + (starting()[i] + (largestHeight - heights()[i])) * 10 + ", " +
						//(end()[i] - starting()[i]) * 10 + ", " + heights()[i] * 10) + "]");
			}
		} catch (IOException e) {
			e.printStackTrace();
			}
		}
		
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame();
		frame.setBackground(Color.GRAY);
		//frame.setLayout(new FlowLayout());
		//frame.setContentPane(new JLabel(new ImageIcon("/Users/visitor/Desktop/Projects/Backgrounds/floral.jpg")));
		frame.setTitle("Rectangle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
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
		}
	}