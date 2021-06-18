import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomBoardParameters extends JFrame {

	/**
	 * Create the panel.
	 */
	// safeye bazi
	public static	JSlider slider_2 = new JSlider();
	public static JSlider slider_1 = new JSlider();
	public static 	JSlider slider = new JSlider();
	public static int length = 0 ;
	public static int width = 0;
	public static int mines;
	public CustomBoardParameters() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(255, 255, 102));
		setTitle("Custom Board Parameters");
		setSize(562, 357);
		getContentPane().setLayout(null);
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("mineSweeper.jpeg"));
		label.setBounds(333, 13, 200, 200);
		getContentPane().add(label);
		JLabel lblHight = new JLabel("width\r\n");
		lblHight.setForeground(new Color(51, 102, 0));
		lblHight.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		lblHight.setBounds(31, 102, 56, 26);
		getContentPane().add(lblHight);
		JLabel lblWidth = new JLabel("Length \r\n\r\n");
		lblWidth.setForeground(new Color(51, 102, 0));
		lblWidth.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		lblWidth.setBounds(31, 21, 56, 26);
		getContentPane().add(lblWidth);
		JLabel lblBombs = new JLabel("mines");
		lblBombs.setForeground(new Color(51, 102, 0));
		lblBombs.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		lblBombs.setBounds(31, 186, 56, 26);
		getContentPane().add(lblBombs);
		
		JLabel label_1 = new JLabel("5");
		label_1.setBackground(new Color(255, 51, 0));
		label_1.setBounds(311, 21, 56, 26);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("5");
		label_2.setBounds(311, 102, 56, 26);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("3");
		label_3.setBounds(311, 186, 56, 26);
		getContentPane().add(label_3);
		
		
	
		slider.setValue(0);
		slider.setBounds(99, 21, 200, 26);
		getContentPane().add(slider);
		slider.setMinimum(5);
		slider.setMaximum(20);
		
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				
				label_1.setText(String.valueOf(slider.getValue()));
			}
		});
		
	
		
		slider_1.setValue(0);
		slider_1.setBounds(99, 102, 200, 26);
		getContentPane().add(slider_1);
		slider_1.setMinimum(5);
		slider_1.setMaximum(20);
		slider_1.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				
				label_2.setText(String.valueOf(slider_1.getValue()));
			}
		});

		slider_2.setValue(0);
		slider_2.setBounds(99, 186, 200, 26);
		getContentPane().add(slider_2);
		slider_2.setMinimum(3);
		slider_2.setMaximum(100);
		
		JButton btnLetsPlay = new JButton("Let's play !!!");
		btnLetsPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 	length = slider.getValue();
				width = slider_1.getValue();
				mines = slider_2.getValue();
				dispose();
				new GamePage().setVisible(true);
				
			}
		});
		btnLetsPlay.setForeground(new Color(0, 51, 204));
		btnLetsPlay.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		btnLetsPlay.setBounds(280, 254, 253, 43);
		getContentPane().add(btnLetsPlay);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Profile().setVisible(true);
			}
		});
		btnBack.setForeground(new Color(255, 51, 0));
		btnBack.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		btnBack.setBounds(12, 254, 253, 43);
		getContentPane().add(btnBack);
		slider_2.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				label_3.setText(String.valueOf(slider_2.getValue()));
				
			}
		});
		
		
		
	}
}
