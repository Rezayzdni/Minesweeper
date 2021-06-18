import java.awt.image.ImageFilter;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ProfilePhoto extends JFrame {

	/**
	 * Create the panel.
	 */
	JFileChooser jc = new JFileChooser();
	public static String fileAddress = "";
	// inja baraye entekhabe akse profile ast
	public ProfilePhoto() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
       setTitle("Profile Photo");
       setSize(645,1031);
       getContentPane().setLayout(null);
       
       JPanel panel = new JPanel();
       panel.setBounds(0, 63, 625, 868);
       getContentPane().add(panel);
       panel.setLayout(null);
       
       JButton button = new JButton("");
       button.setIcon(new ImageIcon("proPic1.jpeg"));
       button.addMouseListener(new MouseAdapter() {
       	@Override
       	public void mouseClicked(MouseEvent e) {
       		fileAddress = "proPic1 - Copy.jpeg";
       	}
       });
       button.setBounds(0, 0, 200, 200);
       panel.add(button);
       
       JButton button_1 = new JButton("");
       button_1.setIcon(new ImageIcon("proPic2.jpeg"));
       button_1.addMouseListener(new MouseAdapter() {
       	@Override
       	public void mouseClicked(MouseEvent e) {
       		fileAddress = "proPic2 - Copy.jpeg";
       	}
       });
       button_1.setBounds(212, 0, 200, 200);
       panel.add(button_1);
       
       JButton button_2 = new JButton("");
       button_2.setIcon(new ImageIcon("proPic4.jpeg"));
       button_2.addMouseListener(new MouseAdapter() {
       	@Override
       	public void mouseClicked(MouseEvent e) {
       		fileAddress = "proPic4 - Copy.jpeg";
       	}
       });
       button_2.setBounds(424, 0, 200, 200);
       panel.add(button_2);
       
       JButton button_3 = new JButton("");
       button_3.setIcon(new ImageIcon("proPic5.jpeg"));
       button_3.addMouseListener(new MouseAdapter() {
       	@Override
       	public void mouseClicked(MouseEvent e) {
       		fileAddress = "proPic5 - Copy.jpeg";
       	}
       });
       button_3.setBounds(0, 213, 200, 200);
       panel.add(button_3);
       
       JButton button_4 = new JButton("");
       button_4.setIcon(new ImageIcon("proPic6.jpeg"));
       button_4.addMouseListener(new MouseAdapter() {
       	@Override
       	public void mouseClicked(MouseEvent e) {
       		fileAddress = "proPic6 - Copy.jpeg";
       	}
       });
       button_4.setBounds(212, 213, 200, 200);
       panel.add(button_4);
       
       JButton button_5 = new JButton("");
       button_5.setIcon(new ImageIcon("proPic7.jpeg"));
       button_5.addMouseListener(new MouseAdapter() {
       	@Override
       	public void mouseClicked(MouseEvent e) {
       		fileAddress = "proPic7 - Copy.jpeg";
       	}
       });
       button_5.setBounds(424, 213, 200, 200);
       panel.add(button_5);
       
       JButton button_6 = new JButton("");
       button_6.setIcon(new ImageIcon("proPic16resize.png"));
       button_6.addMouseListener(new MouseAdapter() {
       	@Override
       	public void mouseClicked(MouseEvent e) {
       		fileAddress = "proPic16resize - Copy.png";
       	}
       });
       button_6.setBounds(0, 426, 200, 200);
       panel.add(button_6);
       
       JButton button_7 = new JButton("");
       button_7.setIcon(new ImageIcon("proPic14resize.png"));
       button_7.addMouseListener(new MouseAdapter() {
       	@Override
       	public void mouseClicked(MouseEvent e) {
       		fileAddress = "proPic14resize - Copy.png";
       	}
       });
       button_7.setBounds(212, 426, 200, 200);
       panel.add(button_7);
       
       JButton button_8 = new JButton("");
       button_8.setIcon(new ImageIcon("proPic15resize.png"));
       button_8.addMouseListener(new MouseAdapter() {
       	@Override
       	public void mouseClicked(MouseEvent e) {
       		fileAddress = "proPic15resize - Copy.png";
       	}
       });
       button_8.setBounds(424, 426, 200, 200);
       panel.add(button_8);
       
       JButton button_9 = new JButton("");
       button_9.setIcon(new ImageIcon("proPic13re.png"));
       button_9.addMouseListener(new MouseAdapter() {
       	@Override
       	public void mouseClicked(MouseEvent e) {
       		fileAddress = "proPic13re - Copy.png";
       	}
       });
       button_9.setBounds(0, 639, 200, 200);
       panel.add(button_9);
       
       JButton button_10 = new JButton("");
       button_10.setIcon(new ImageIcon("proPic9resize.jpeg"));
       button_10.addMouseListener(new MouseAdapter() {
       	@Override
       	public void mouseClicked(MouseEvent e) {
       		fileAddress = "proPic9resize - Copy.jpeg";
       	}
       });
       button_10.setBounds(212, 639, 200, 200);
       panel.add(button_10);
       
       JButton button_11 = new JButton("");
       button_11.setIcon(new ImageIcon("proPic10resize.jpeg"));
       button_11.addMouseListener(new MouseAdapter() {
       	@Override
       	public void mouseClicked(MouseEvent e) {
       		fileAddress = "proPic10resize - Copy.jpeg";
       	}
       });
       button_11.setBounds(424, 639, 200, 200);
       panel.add(button_11);
       
   // ba zadan bar roye dokme ha aks entekhab mishavad
       JLabel lblHereYouCan = new JLabel("                                      here you can choose your favorite profile photo");
       lblHereYouCan.setForeground(new Color(204, 0, 204));
       lblHereYouCan.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
       lblHereYouCan.setBounds(12, 13, 603, 37);
       getContentPane().add(lblHereYouCan);
       
       JButton btnDone = new JButton("Done");
       btnDone.setForeground(new Color(0, 0, 0));
       btnDone.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent arg0) {
       		dispose();
       	}
       });
       btnDone.setBounds(437, 944, 178, 27);
       getContentPane().add(btnDone);
      
       
       
	}
}
