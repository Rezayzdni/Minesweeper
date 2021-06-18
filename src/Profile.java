import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Profile extends JFrame implements Serializable {

	private JPanel contentPane;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static ArrayList<Profile> users = new ArrayList<>();
	public static ArrayList<Profile> etcInformation = new ArrayList<>();
	private JTextField textField;
	private JTextField textField_5;
	private String userName;
	private String pass1;
	private String pass2;
	private String score;
	private static String[][] data = new String[20][6];
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private String wins;
	private String loses;
	private String gameDuration;
	private String photoAdrress ;
	private String tmpUserName = "";
	private String tmpPassword = "";
	public static String inform0 = "";
	public static String inform1 = "";
	// dar in qesmat etelaate har bazikn sabt mishavad
	public String getTmpUserName() {
		return tmpUserName;
	}

	public void setTmpUserName(String tmpUserName) {
		this.tmpUserName = tmpUserName;
	}

	public String getTmpPassword() {
		return tmpPassword;
	}

	public void setTmpPassword(String tmpPassword) {
		this.tmpPassword = tmpPassword;
	}

	public static ArrayList<Profile> getUsers() {
		return users;
	}

	public static void setUsers(ArrayList<Profile> users) {
		Profile.users = users;
	}

	public String getPhotoAdrress() {
		return photoAdrress;
	}

	public void setPhotoAdrress(String photoAdrress) {
		this.photoAdrress = photoAdrress;
	}

	public static boolean signIn = false;
	public static String adress = "";
	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	
	public String getGameDuration() {
		return gameDuration;
	}

	public void setGameDuration(String gameDuration) {
		this.gameDuration = gameDuration;
	}



	public String getWins() {
		return wins;
	}

	public void setWins(String wins) {
		this.wins = wins;
	}

	public String getLoses() {
		return loses;
	}

	public void setLoses(String loses) {
		this.loses = loses;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JPasswordField getPasswordField_1() {
		return passwordField_1;
	}

	public void setPasswordField_1(JPasswordField passwordField_1) {
		this.passwordField_1 = passwordField_1;
	}

	public JPasswordField getPasswordField_2() {
		return passwordField_2;
	}

	public void setPasswordField_2(JPasswordField passwordField_2) {
		this.passwordField_2 = passwordField_2;
	}

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass1() {
		return pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}

	public static void main(String[] args) {
	 //	 new Profile("xix","222222");
	//	new Profile("xix","222222","20","2","0","70","proPic4 - Copy.jpeg");
	 
	  
	 	 
	 
	
		loadUsers();
		loadEtcInformaion();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public Profile(String userName, String password) {
		this.setUserName(userName);
		this.setPass1(password);
		users.add(this);
		saveUsers();
	}

	public Profile(String userName, String password,String score, String wins, String loses, String gameDuration,String photoAddress) {
		this.setTmpUserName(userName);
		this.setTmpPassword(password);
		this.setScore(score);
		this.setWins(wins);
		this.setLoses(loses);
		this.setGameDuration(gameDuration);
		this.setPhotoAdrress(photoAddress);
		etcInformation.add(this);
		saveEtcInformaion();
	}

	public Profile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 800);
		setTitle("Profile");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 153));
		panel.setBounds(12, 437, 434, 303);
		contentPane.add(panel);
		panel.setLayout(null);
		JLabel lblSignIn = new JLabel("                                                          Sign In");
		lblSignIn.setForeground(new Color(153, 153, 0));
		lblSignIn.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		lblSignIn.setBounds(12, 0, 410, 31);
		panel.add(lblSignIn);
		lblSignIn.setEnabled(false);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setForeground(new Color(102, 102, 204));
		lblUsername.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		lblUsername.setBounds(22, 42, 90, 31);
		panel.add(lblUsername);
		lblUsername.setEnabled(false);
		
		textField = new JTextField();
		textField.setBounds(190, 45, 187, 22);
		panel.add(textField);
		textField.setColumns(10);
		textField.setEnabled(false);
		
		JLabel lblPassword = new JLabel("Password :\r\n");
		lblPassword.setForeground(new Color(102, 102, 204));
		lblPassword.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		lblPassword.setBounds(22, 79, 90, 31);
		panel.add(lblPassword);
        lblPassword.setEnabled(false);
        
		JLabel lblConfirmPassword = new JLabel("Confirm Password :\r\n\r\n");
		lblConfirmPassword.setForeground(new Color(102, 102, 204));
		lblConfirmPassword.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		lblConfirmPassword.setBounds(22, 117, 153, 31);
		panel.add(lblConfirmPassword);
		lblConfirmPassword .setEnabled(false);
		
		JButton btnNewButton = new JButton("go to the Next part");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new CustomBoardParameters().setVisible(true);
				
			}
		});
		btnNewButton.setForeground(new Color(0, 51, 153));
		btnNewButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		btnNewButton.setBounds(12, 249, 410, 41);
		panel.add(btnNewButton);
		btnNewButton.setEnabled(false);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(190, 80, 187, 22);
		panel.add(passwordField_1);
		passwordField_1.setEnabled(false);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(190, 120, 187, 22);
		panel.add(passwordField_2);
		passwordField_2.setEnabled(false);
		// dar in qesmat akse profile az pc entekhab mishavad
		JButton btnChooseAProfile = new JButton("choose a profile photo");
		btnChooseAProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String returnVal = JOptionPane.showInputDialog(Profile.this, "1.recommended \n 2.from pc");
				if(returnVal.equals("1")) {
				new ProfilePhoto().setVisible(true);
				}
				else if(returnVal.equals("2")) {
					JFileChooser fc = new JFileChooser();
					 fc.showDialog(Profile.this, "Attach");
				adress = String.valueOf(fc.getSelectedFile());
				}
			}
		});
		btnChooseAProfile.setForeground(new Color(153, 51, 153));
		btnChooseAProfile.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		btnChooseAProfile.setBounds(12, 152, 410, 41);
		panel.add(btnChooseAProfile);
		btnChooseAProfile.setEnabled(false);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("Button.background"));
		panel_2.setBounds(12, 13, 908, 328);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblWelcomeToThe = new JLabel(
				"                                                                                                    Welcome to the Minesweeper Game!!!");
		lblWelcomeToThe.setForeground(new Color(102, 205, 170));
		lblWelcomeToThe.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		lblWelcomeToThe.setBounds(12, 13, 884, 40);
		panel_2.add(lblWelcomeToThe);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 51, 884, 264);
		panel_2.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(0, 204, 102));
		table.setForeground(new Color(255, 255, 255));
		table.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		// in qesmat marbot be neshan dadane etelaate bazikn ha ast
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"#Num", "Player Name", "Score", "Wins", "Loses", "Game Duration(sec)"
			}
		));
		scrollPane.setViewportView(table);

		fillTheBlank();

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 204));
		panel_1.setBounds(486, 437, 434, 303);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		JLabel lblLogin = new JLabel("                                                             Login");
		lblLogin.setForeground(new Color(51, 204, 102));
		lblLogin.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		lblLogin.setBounds(12, 0, 410, 31);
		panel_1.add(lblLogin);
        lblLogin.setEnabled(false);
        
		JLabel label = new JLabel("Username :");
		label.setForeground(new Color(102, 102, 204));
		label.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		label.setBounds(22, 88, 90, 31);
		panel_1.add(label);
		label.setEnabled(false);
		JLabel label_1 = new JLabel("Password :\r\n");
		label_1.setForeground(new Color(102, 102, 204));
		label_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		label_1.setBounds(22, 132, 90, 31);
		panel_1.add(label_1);
		label_1.setEnabled(false);
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(177, 91, 187, 22);
		panel_1.add(textField_5);
        textField_5.setEnabled(false);
        
        JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPass1(new String(passwordField_1.getPassword()));
				setPass2(new String(passwordField_2.getPassword()));
				if ((!(signUp(textField.getText()))) && (getPass1().length() > 4) && (getPass1().equals(getPass2()))) {
					inform0 = textField.getText();
					inform1 = getPass1();
					signIn  = true;
					new Profile(textField.getText(), getPass1());
					JOptionPane.showMessageDialog(Profile.this, textField.getText() + " signed up successfully !!",
							"Information", JOptionPane.INFORMATION_MESSAGE);
				} else {

					if (Profile.signUp(textField.getText())) {
						JOptionPane.showMessageDialog(Profile.this, "This username has already been taken !!",
								"Warning", JOptionPane.WARNING_MESSAGE);
						textField.setText("");
					} else if (!(getPass1().length() > 4)) {
						JOptionPane.showMessageDialog(Profile.this,
								"Your password is too short , please try more than 4 !!", "Warning",
								JOptionPane.WARNING_MESSAGE);
						passwordField_1.setText("");
						passwordField_2.setText("");
					}

					else if (!(getPass1().equals(getPass2()))) {
						JOptionPane.showMessageDialog(Profile.this, "Passwords do not match !!!", "Error",
								JOptionPane.ERROR_MESSAGE);
						passwordField_1.setText("");
						passwordField_2.setText("");
					}
				}
				
				if(signIn == true) {
					btnNewButton.setEnabled(true);
				}
			}
		});
		btnSignIn.setForeground(new Color(51, 153, 0));
		btnSignIn.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		btnSignIn.setEnabled(false);
		btnSignIn.setBounds(124, 196, 187, 51);
		panel.add(btnSignIn);
        
		JButton btnLetsPlay = new JButton("Login\r\n");
		btnLetsPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPass1(new String(passwordField.getPassword()));
				if ((login(textField_5.getText(), getPass1()))) {
					inform0  = textField_5.getText();
					dispose();
					new CustomBoardParameters().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(Profile.this,
							"Your username or password is incorrect !! , Please try agian ...", "Error",
							JOptionPane.ERROR_MESSAGE);
					textField_5.setText("");
					passwordField.setText("");
				}
			}
		});
		btnLetsPlay.setForeground(new Color(0, 153, 204));
		btnLetsPlay.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		btnLetsPlay.setBounds(12, 215, 410, 47);
		panel_1.add(btnLetsPlay);
		btnLetsPlay.setEnabled(false);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(177, 135, 187, 22);
		panel_1.add(passwordField);
		passwordField.setEnabled(false);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(12, 354, 908, 70);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JButton btnEnterAsNew = new JButton("Enter as a new palyer");
		btnEnterAsNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblLogin.setEnabled(false);
				textField_5.setEnabled(false);
				passwordField.setEnabled(false);
			    label.setEnabled(false);
			    label_1.setEnabled(false);
			    btnLetsPlay.setEnabled(false);
			    
				lblSignIn.setEnabled(true);
				textField.setEnabled(true);
				passwordField_1.setEnabled(true);
				passwordField_2.setEnabled(true);
				lblConfirmPassword.setEnabled(true);
				lblPassword.setEnabled(true);
				lblUsername.setEnabled(true);
				btnChooseAProfile.setEnabled(true);
				btnNewButton.setEnabled(false);
				btnSignIn.setEnabled(true);
			}
		});
		btnEnterAsNew.setForeground(Color.RED);
		btnEnterAsNew.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		btnEnterAsNew.setBounds(12, 13, 421, 44);
		panel_3.add(btnEnterAsNew);
		
		JButton btnEnterAsAn = new JButton("Enter as an old player");
		btnEnterAsAn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lblSignIn.setEnabled(false);
				textField.setEnabled(false);
				passwordField_1.setEnabled(false);
				passwordField_2.setEnabled(false);
				lblConfirmPassword.setEnabled(false);
				lblPassword.setEnabled(false);
				lblUsername.setEnabled(false);
				btnChooseAProfile.setEnabled(false);
				btnNewButton.setEnabled(false);
				btnSignIn.setEnabled(false);
				
				lblLogin.setEnabled(true);
				textField_5.setEnabled(true);
				passwordField.setEnabled(true);
			    label.setEnabled(true);
			    label_1.setEnabled(true);
			    btnLetsPlay.setEnabled(true);
			
			}
		});
		btnEnterAsAn.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		btnEnterAsAn.setForeground(new Color(0, 153, 153));
		btnEnterAsAn.setBounds(475, 13, 421, 44);
		panel_3.add(btnEnterAsAn);
	}

	public static boolean login(String userName, String password) {
		boolean ans = false;

		for (Profile user : users) {

			if (user.userName.equals(userName) && user.pass1.equals(password)) {
				ans = true;

				break;
			} else {
				ans = false;
			
			}
		}
		return ans;
	}

	public static boolean signUp(String userName) {
		boolean ans = false;

		for (Profile user : users) {

			if (user.userName.equals(userName)) {
				ans = true;
				break;
			}
		}
		return ans;
	}

	public static void saveUsers() {
		try {
			FileOutputStream fos = new FileOutputStream("users.xx");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(users);
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static void loadUsers() {
		try {
			FileInputStream fis = new FileInputStream("users.xx");
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
				users = (ArrayList<Profile>) ois.readObject();
			} catch (Exception e) {

				e.printStackTrace();
			}
			ois.close();
			fis.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static void saveEtcInformaion() {
		try {
			FileOutputStream fos = new FileOutputStream("etcInformation.xx");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(etcInformation);
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static void loadEtcInformaion() {
		try {
			FileInputStream fis = new FileInputStream("etcInformation.xx");
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
				etcInformation = (ArrayList<Profile>) ois.readObject();
			} catch (Exception e) {

				e.printStackTrace();
			}
			ois.close();
			fis.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static  void fillTheBlank() {
     loadEtcInformaion();
		int j = 0;
		for (int i = 0; i < etcInformation.size(); i++) {
			data[i][j] = String.valueOf(i + 1);

			j++;
			data[i][j] = etcInformation.get(i).getTmpUserName();
			j++;
			data[i][j] = etcInformation.get(i).getScore();
			j++;
			data[i][j] = etcInformation.get(i).getWins();

			j++;
			data[i][j] = etcInformation.get(i).getLoses();
            
			j++;
			data[i][j] = etcInformation.get(i).getGameDuration();

			j = 0;
		}
		
		for (int i = 0; i < users.size() ; i++) {
			for (int k = 0; k < 6; k++) {
				table.setValueAt(data[i][k], i, k);
			}
		}
	}
}
