import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AyyLmao {
	public static void main(String[] args) {
		String[] buttons = {"👽 Ayy Lmao 👽", "¯\\_(ツ)_/¯", "🏀 Ball Is Life 🏀"};
		String[] buttons2 = {"Cancel", "Fuck No", "No", "Perhaps", "Yeah, OK"};
		ImageIcon icon = new ImageIcon("resources/ayy.png");
		
	     JOptionPane.showOptionDialog(null, "🔮🍵✨ ¿What is life even? ✨🌱💿", "👽 Ayy Lmao 👽",
	         JOptionPane.INFORMATION_MESSAGE, 0, icon, buttons, null);
	     
	     JOptionPane.showOptionDialog(null, "I need to go sleep. Also, Stats homework.", "",
		         JOptionPane.INFORMATION_MESSAGE, 0, null, buttons2, null);
	}
}