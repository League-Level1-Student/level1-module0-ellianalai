package _04_gui_from_scratch._1_fortune_cookie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Fortune_cookie implements ActionListener {
    public void showButton() {
    	JFrame frame = new JFrame();
    	frame.setVisible(true);
        
    	JButton button = new JButton();	
    	button.setText("Click for fortune");
    	frame.add(button);
    	
    	frame.pack();
    	
    	button.addActionListener(this);
   }

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Woohoo");
		int rand = new Random().nextInt(5);
		
		if(rand == 0) {
			JOptionPane.showMessageDialog(null, "You will have a good day");
		}
		else if(rand == 1) {
			JOptionPane.showMessageDialog(null, "You will have a bad day");
		}
		else if(rand == 2) {
			JOptionPane.showMessageDialog(null, "Good fortune will befall on you");
		}
		else if(rand == 3) {
			JOptionPane.showMessageDialog(null, "Bad fortune will befall on you");
		}
		else if(rand == 4) {
			JOptionPane.showMessageDialog(null, "You will win the lottery");
		}
		
	}
}

