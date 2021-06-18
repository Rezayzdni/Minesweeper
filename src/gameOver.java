import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.awt.event.ActionEvent;

public class gameOver extends JFrame {

	/**
	 * Create the panel.
	 */
	public static	boolean soundStop = false;
	public gameOver() {
		getContentPane().setBackground(new Color(204, 0, 102));
		setSize(400, 484);
		setTitle("Game Over");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 0));
		panel.setBounds(0, 0, 382, 101);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblGameOver = new JLabel("game over");
		lblGameOver.setBackground(new Color(211, 211, 211));
		lblGameOver.setForeground(new Color(255, 0, 0));
		lblGameOver.setFont(new Font("Showcard Gothic", Font.PLAIN, 70));
		lblGameOver.setBounds(0, 0, 382, 101);
		panel.add(lblGameOver);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 114, 382, 239);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 382, 239);
		panel_1.add(label);
		label.setIcon(new ImageIcon("skull0.jpeg"));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 0, 102));
		panel_2.setBounds(0, 366, 382, 56);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnOkeyDudeMy = new JButton("okey dude my bad !!");
		btnOkeyDudeMy.setBackground(new Color(220, 220, 220));
		btnOkeyDudeMy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Sound.clip.stop();
				
			}
		});
		btnOkeyDudeMy.setForeground(Color.BLUE);
		btnOkeyDudeMy.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		btnOkeyDudeMy.setBounds(12, 0, 358, 56);
		panel_2.add(btnOkeyDudeMy);
		

	}
	
		
}
