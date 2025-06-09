import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FontComboBox extends JFrame implements ActionListener {
  JLabel fontLabel = new JLabel("\t\t\t\t0x123456");

  public FontComboBox() {
    setTitle("Set Font");
    setSize(300, 200);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    JComboBox fontComboBox = new JComboBox();
    fontComboBox.setEditable(true);
    fontComboBox.addItem("Courier");
    fontComboBox.addItem("Andale Mono");
    fontComboBox.addItem("Monaco");
    fontComboBox.addItem("Consolas");
    fontComboBox.addItem("Inconsolata");
    fontComboBox.addActionListener(this);

    JPanel p = new JPanel();
    p.add(fontComboBox);
    getContentPane().add(p, "North");
    getContentPane().add(fontLabel, "Center");
  }

  public void actionPerformed(ActionEvent evt) {
    JComboBox source = (JComboBox) evt.getSource();
    String item = (String) source.getSelectedItem();
    fontLabel.setFont(new Font(item, Font.PLAIN, 12));
  }

  @SuppressWarnings("deprecation")
public static void main(String[] args) {
    JFrame frame = new FontComboBox();
    frame.show();
  }
}