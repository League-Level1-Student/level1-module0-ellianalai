package _04_gui_from_scratch._3_sound_effects_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sound_effect implements ActionListener{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	public void sound() {
		frame.setVisible(true);
		frame.add(panel);
		button.setText("Doorbell");
		button1.setText("Elevator Ping");
		button2.setText("Wind Chimes");
		panel.add(button);
		panel.add(button1);
		panel.add(button2);
		frame.pack();
		button.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			playSound("doorbell.wav");
		}
		else if (e.getSource() == button1) {
			playSound("elevator_ping.wav");
		}
		else if (e.getSource() == button2) {
			playSound("wind_chimes.wav");
		}
		
	}
	private void playSound(String soundFile) {
		String path = "src/_04_gui_from_scratch/_3_sound_effects_machine/";
			File sound = new File(path+soundFile);
			if (sound.exists()) {
				new Thread(() -> {
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(sound));
					clip.start();
					Thread.sleep(clip.getMicrosecondLength()/1000);
				}
				catch (Exception e) {
					System.out.println("Could not play this sound");
				}}).start();
	 		}
			else {
				System.out.println("File does not exist");
			}
		
	}
    


}
