import java.awt.Font;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=3&page=show_problem&problem=130
 * */

public class Triangle {	
	public static int[] findIndexesOf(double[] ray, int wot) {
    	int[] indexes = new int[ray.length];
    	int count = 0;
    	
    	for(int i = 0; i < ray.length; i++) {
    		if(ray[i] == wot) {
    			indexes[count] = i;
    			count++;
    		}
    	}
    	
    	return indexes;
	}
	public static void main(String[] args) throws IOException {
			/**
			 * Where the user is going to input what is to be converted
			 * */
			JTextField angleAinput = new JTextField(10);
			JTextField angleBinput = new JTextField(10);
			JTextField angleCinput = new JTextField(10);
			JTextField lenAinput = new JTextField(10);
			JTextField lenBinput = new JTextField(10);
			JTextField lenCinput = new JTextField(10);

			/**
			 * The pencil, check, and X icons. Merely for aesthetic purposes
			 * */
			ImageIcon triangle = new ImageIcon("icons/Triangle.png");
			ImageIcon check = new ImageIcon("icons/Check.png");
			ImageIcon nope = new ImageIcon("icons/Nope.png");
					
			/**
			 * Creates and initialises the first pop-up box (JPanel).
			 * Arranges the input box and text present
			 * //And background and border too
			 * */
			JPanel sweg = new JPanel();
			//sweg.setBackground(Color.WHITE);
			//sweg.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        Font font = new Font("Monaco", Font.PLAIN, 16);
			lenAinput.setFont(font);
	        angleAinput.setFont(font);
			lenBinput.setFont(font);
			angleBinput.setFont(font);
			lenCinput.setFont(font);
			angleCinput.setFont(font);
			JLabel l1 = new JLabel("α:");
			l1.setFont(new Font("Times New Roman", Font.ITALIC, 16));
			JLabel l2 = new JLabel("β:");
			l2.setFont(new Font("Times New Roman", Font.ITALIC, 16));
			JLabel l3 = new JLabel("γ:");
			l3.setFont(new Font("Times New Roman", Font.ITALIC, 16));
			JLabel l4 = new JLabel("a:");
			l4.setFont(new Font("Times New Roman", Font.ITALIC, 16));
			JLabel l5 = new JLabel("b:");
			l5.setFont(new Font("Times New Roman", Font.ITALIC, 16));
			JLabel l6 = new JLabel("c:");
			l6.setFont(new Font("Times New Roman", Font.ITALIC, 16));
			
			GroupLayout layout = new GroupLayout(sweg);
			sweg.setLayout(layout);
			layout.setAutoCreateGaps(true);
			layout.setAutoCreateContainerGaps(true);
			GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
			hGroup.addGroup(layout.createParallelGroup().addComponent(l1).addComponent(l2).addComponent(l3));
			hGroup.addGroup(layout.createParallelGroup().addComponent(angleAinput).addComponent(angleBinput).addComponent(angleCinput));
			hGroup.addGroup(layout.createParallelGroup().addComponent(l4).addComponent(l5).addComponent(l6));
			hGroup.addGroup(layout.createParallelGroup().addComponent(lenAinput).addComponent(lenBinput).addComponent(lenCinput));
			layout.setHorizontalGroup(hGroup);
			GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
			vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(l1).addComponent(angleAinput).addComponent(l4).addComponent(lenAinput));
			vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(l2).addComponent(angleBinput).addComponent(l5).addComponent(lenBinput));
			vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(l3).addComponent(angleCinput).addComponent(l6).addComponent(lenCinput));
			layout.setVerticalGroup(vGroup);
		    
		    /**
		     * Creates and shows the JPanel made
		     * */
	        int result = JOptionPane.showConfirmDialog(null, sweg, "Enter Value(s)", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, triangle);
	        if(result == JOptionPane.OK_OPTION) {
	        	/**
	        	 * Gets user input and creates a new JPanel
	        	 * */
	        	String a1 = angleAinput.getText();
	        	String a2 = angleBinput.getText();
	        	String a3 = angleCinput.getText();
	        	String ln1 = lenAinput.getText();
	        	String ln2 = lenBinput.getText();
	        	String ln3 = lenCinput.getText();
	        	String[] inputs = {
	        			angleAinput.getText(), angleBinput.getText(), angleCinput.getText(), lenAinput.getText(), lenBinput.getText(), lenCinput.getText()
	        			};
	        		        	
	        	int ayy = 0;
	        	int numn1 = 0;
	        	double[] nums = new double[6];
	        	for(int j = 0; j < inputs.length; j++) {
	        		 if(inputs[j].equals("")) {
	        			 nums[ayy] = -1;
	        			 ayy++;
	        			 numn1++;
	        		 }
	        		 
	        		 if(!inputs[j].equals("")) {
	        			 nums[ayy] = Double.parseDouble(inputs[j]);
	        			 ayy++;
	        		 }
	        	}
 	        	
	        	/*double angleA = Double.parseDouble(a1);
	        	double angleB = Double.parseDouble(a2);
	        	double angleC = Double.parseDouble(a3);
	        	double lenA = Double.parseDouble(ln1);
	        	double lenB = Double.parseDouble(ln2);
	        	double lenC = Double.parseDouble(ln3);*/
	        	
	        	//System.out.println(Arrays.toString(findIndexesOf(nums, -1)));
	        	
	        	if(numn1 <= 3) {
	        		int[] solve4 = findIndexesOf(nums, -1);
	        		
	        		for(int k = 0; k < solve4.length; k++) {
	        			if(solve4[k] <= 2) {
	        				if(solve4[k] == 0) {
	        					nums[solve4[k]] = Math.acos((-1*((nums[solve4[k] + 3])*nums[solve4[k] + 3]) + nums[1] * nums[1] + nums[2] * nums[2]) / 2 * nums[1] * nums[2]);
	        				}
	        				
	        				if(solve4[k] == 1) {
	        					nums[solve4[k]] = Math.acos((-1*((nums[solve4[k] + 3])*nums[solve4[k] + 3]) + nums[0] * nums[0] + nums[2] * nums[2]) / 2 * nums[0] * nums[2]);
	        				}

	        				if(solve4[k] == 2) {
	        					nums[solve4[k]] = Math.acos((-1*((nums[solve4[k] + 3])*nums[solve4[k] + 3]) + nums[1] * nums[1] + nums[0] * nums[0]) / 2 * nums[1] * nums[0]);
	        				}
	        			}
	        			
	        			if(solve4[k] > 2) {
	        				if(solve4[k] == 3) {
		        				nums[solve4[k]] = Math.sqrt(nums[4] * nums[4] + nums[5] * nums[5] - 2 * nums[4] * nums[5] * Math.cos(nums[solve4[k] - 3]));
	        				}
	        				
	        				if(solve4[k] == 4) {
		        				nums[solve4[k]] = Math.sqrt(nums[3] * nums[3] + nums[5] * nums[5] - 2 * nums[3] * nums[5] * Math.cos(nums[solve4[k] - 3]));
	        				}

	        				if(solve4[k] == 5) {
		        				nums[solve4[k]] = Math.sqrt(nums[4] * nums[4] + nums[3] * nums[3] - 2 * nums[4] * nums[3] * Math.cos(nums[solve4[k] - 3]));
	        				}
	        			}
	        		}
	        	}
	        	
	        	System.out.println(Math.sqrt((nums[4] * nums[4]) + (nums[5] * nums[5]) - (2 * nums[4] * nums[5] * Math.cos(nums[0]))));
	        	
	        	JPanel swiggity = new JPanel();
	        	
            	JOptionPane.showConfirmDialog(null, Arrays.toString(nums), "yee", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, check);
	        	
	        	if(numn1 > 3) {
	        		JOptionPane.showConfirmDialog(null, "Not enough information given to solve.", "404 ERROR!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, nope);
	        	}
	        }
	}
}