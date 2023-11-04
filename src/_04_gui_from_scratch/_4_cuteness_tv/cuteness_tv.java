package _04_gui_from_scratch._4_cuteness_tv;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class cuteness_tv implements ActionListener{

JFrame frame = new JFrame();
JPanel panel = new JPanel();
JButton button = new JButton();
JButton button1 = new JButton();
JButton button2 = new JButton();

	public void cuteness() {
		frame.setVisible(true);
		frame.add(panel);
		panel.add(button);
		panel.add(button1);
		panel.add(button2);
		
		button.setText("Click for ducks");
		button1.setText("Click for frogs");
		button2.setText("Click for unicorns");
		frame.pack();
		button.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
;	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			showDucks();
		}
		if (e.getSource() == button1) {
			showFrog();
		}
		if (e.getSource() == button2) {
			showFluffyUnicorns();
		}
		
	}
	void showDucks() {
	     playVideo("https://www.youtube.com/watch?v=MtN1YnoL46Q");
	}

	void showFrog() {
	     playVideo("https://www.youtube.com/watch?v=cBkWhkAZ9ds");
	}

	void showFluffyUnicorns() {
	     playVideo("https://www.youtube.com/watch?v=qRC4Vk6kisY");
	}

	void playVideo(String videoID) {
	     
	     // Workaround for Linux because "Desktop.getDesktop().browse()" doesn't
	     //work on some Linux implementations
	     try {
	     if (System.getProperty("os.name").toLowerCase().contains("linux")) {
	     if (Runtime.getRuntime().exec(new String[] {
	      "which", "xdg- open" }).getInputStream().read() != -1) {
	     Runtime.getRuntime().exec(new String[] { "xdg-open", videoID });
	     }
	     } else {
	          URI uri = new URI(videoID);
	          java.awt.Desktop.getDesktop().browse(uri);
	     }      } catch (Exception e) {
	          e.printStackTrace();
	     }
	}
}

