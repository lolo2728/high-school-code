import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QuadraticEquation {
    public static void main(String[] args) throws IOException {
        double geoff = ((double)-2)/((double)2);
        System.out.println(geoff);
        
        JTextField a = new JTextField(10);
        JTextField b = new JTextField(10);
        JTextField c = new JTextField(10);

        JPanel swagon = new JPanel();
                
        swagon.add(a);
        swagon.add(new JLabel("x² + "));
        swagon.add(b);
        swagon.add(new JLabel("x + "));
        swagon.add(c);
        
        int result = JOptionPane.showConfirmDialog(null, swagon, "We're swag-a-lackin\'. Give us dem digits...", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String aSweg = a.getText();
            String bSweg = b.getText();
            String cSweg = c.getText();
            
            double dSweg = Double.parseDouble(aSweg);
            double eSweg = Double.parseDouble(bSweg);
            double fSweg = Double.parseDouble(cSweg);
            
            JPanel swagoff = new JPanel();
            
            String output = "No real roots";
            
            double wa = 0;
            double wb = 0;
            double wc = 0;
            double wd = 0;
            
            if(!((eSweg*eSweg - 4*dSweg*fSweg) < 0)) {        
                if(eSweg != 0) {
                    wa = ((-1*eSweg) + Math.sqrt((eSweg*eSweg) - (4*dSweg*fSweg)));
                    wb = ((-1*eSweg) - Math.sqrt((eSweg*eSweg) - (4*dSweg*fSweg)));
                } else {
                    wa = (Math.sqrt(((double)(-1)*(4*dSweg*fSweg))));
                    wb = (-1 * Math.sqrt(((double)-1)*(4*dSweg*fSweg)));
                }
                
                System.out.println(wa);
                System.out.println(wb);
                
                wc = wa/((double)2*dSweg);
                wd = wb/((double)2*eSweg);
                
                System.out.println(wc);
                System.out.println(wd);
                
                if(!Double.isNaN(wd))
                    output = "Da r00ts be: (" + wc + ") & (" + wd + ")";
                else
                    output = "Da r00ts be: (" + wc + ")";
            }
                        
            swagoff.add(new JLabel(output));
            
            int otherResult = JOptionPane.showConfirmDialog(null, swagoff, "Ayy lmao", JOptionPane.OK_CANCEL_OPTION);
            if(otherResult == JOptionPane.OK_OPTION) {
                
            }
            
        } else {
            
        }
    }
}