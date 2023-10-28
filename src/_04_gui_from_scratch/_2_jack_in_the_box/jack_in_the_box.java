package _04_gui_from_scratch._2_jack_in_the_box;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.DocFlavor.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class jack_in_the_box implements ActionListener{
	int clicked = 0;
	JLabel label = new JLabel();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	public void surprise() {
		
		frame.setVisible(true);
		
		JButton button = new JButton();
		frame.add(button);
		frame.pack();
		button.addActionListener(this);
		
		frame.add(panel);
		
		frame.pack();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		clicked+=1;
		if (clicked==5) {
			image();
		}
		
	}
	
	public void image() {
		showPicture("jackInTheBox.png");
		panel.add(label);
	}
	
	private void showPicture(String fileName) {
	     try {
	          JLabel imageLabel = createLabelImage(fileName);
	          JFrame frame = new JFrame();
	          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	          frame.add(imageLabel);
	          frame.setVisible(true);
	          frame.pack();
	     } catch (Exception e) {
	          e.printStackTrace();
	     }
	}
	
	private JLabel createLabelImage(String fileName) {
	     try {
	          java.net.URL imageURL = getClass().getResource(fileName);
	          if (imageURL == null) {
	               System.err.println("Could not find image " + fileName);
	               return new JLabel();
	          } else {
	               Icon icon = new ImageIcon(imageURL);
	               JLabel imageLabel = new JLabel(icon);
	               return imageLabel;
	          }
	     } catch (Exception e) {
	          System.err.println("Could not find image " + fileName);
	          return new JLabel();
	     }
	}

}
