import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Box.Filler;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import org.omg.CORBA.PUBLIC_MEMBER;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Label;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.LongToDoubleFunction;
import java.util.zip.Checksum;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.awt.event.ActionEvent;
import java.lang.Math;;

public class GamePage extends JFrame {

	/**
	 * Create the panel.
	 */
	private  int length = CustomBoardParameters.slider.getValue();
	private  int width = CustomBoardParameters.slider_1.getValue();
	private  int numberOfBombs = CustomBoardParameters.slider_2.getValue();
	private  JButton[][] buttons = new JButton[width][length];
	private  String checkBomb[][] = new String[width][length];
	private  String checkNumber[][] = new String[width][length];
	private  String checkEmpty[][] = new String[width][length];
	private  String starForCheckEmpty[][] = new String[width][length];
	private String starForCheckNumber[][] = new String[width][length];
	private  String starForCheckFlag[][] = new String[width][length];
	private  String starForCheckFlagRight[][] = new String[width][length];
	public  String checkVictory[][] = new String[width][length];
	private int second = 0;
	private  Random rnd = new Random();
	private  int remainSquers = 0;
	private  int numberOfNumberSquere = 0;
	private  int numberOfEmptySquere = 0;
	private  int rndlength = 0;
	private  int rndwidth = 0;
	private  int ifCounter = 0;
	public  int maxPanelSize = length * width * 40 * 40;
	private  int maxlength;
	private  int maxwidth;
	private  String factor_s;
	private  boolean startTime = false;
	private  boolean victory = false;
	private  String[][] keepTheNumberOfNeibourBombs = new String[width][length];
	private  int flagCounter = 0;
	private  int starCounter = 0;
	private  int emptyCounter = 0;
	private  int numberCounter = 0;
	private  int F = 0;
	private  long countToVictory = 0;

	public GamePage() {
		pack();
		getContentPane().setForeground(new Color(230, 230, 250));
		factor_s = calculateTheMAxFactorsOfNumber(maxPanelSize);
		if (factor_s.contains("/")) {
			String[] parts = factor_s.split("/");
			maxlength = Integer.valueOf(parts[0]);
			maxwidth = Integer.valueOf(parts[1]);
		} else {
			maxlength = Integer.valueOf(factor_s);
			maxwidth = Integer.valueOf(factor_s);
		}
		remainSquers = length * width - numberOfBombs;
		numberOfNumberSquere = remainSquers / 2;
		numberOfEmptySquere = remainSquers - numberOfNumberSquere;
		// dar in qesmat dade ha intialize mishavand
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < length; j++) {
				starForCheckEmpty[i][j] = "";
			}
		}
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < length; j++) {
				starForCheckFlagRight[i][j] = "";
			}
		}
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < length; j++) {
				keepTheNumberOfNeibourBombs[i][j] = "";
			}
		}
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < length; j++) {
				starForCheckNumber[i][j] = "";
			}
		}
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < length; j++) {
				checkBomb[i][j] = "no";
			}
		}
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < length; j++) {
				starForCheckFlag[i][j] = "";
			}
		}
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < length; j++) {
				checkNumber[i][j] = "";
			}
		}
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < length; j++) {
				checkEmpty[i][j] = "";
			}
		}
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < length; j++) {
				checkVictory[i][j] = "";
			}
		}
		// dar inja bomb ha be sorate random pakhsh mishavand va kalame ye "yes" be
		// onvane neshane ye bomb dar khane haye randome araye jaygozari mishavand
		while (true) {
			rndlength = rnd.nextInt(length);
			rndwidth = rnd.nextInt(width);
			if ((checkBomb[rndwidth][rndlength].equals("no"))) {
				checkBomb[rndwidth][rndlength] = "yes";
				ifCounter++;
			}

			if (ifCounter == numberOfBombs) {
				ifCounter = 0;
				break;
			}
		}

		FlowLayout fl = new FlowLayout();

		getContentPane().setBackground(new Color(255, 255, 102));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Game Page");
		setSize(837, 914);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 255, 153));
		panel.setBounds(12, 13, 800, 80);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(499, 27, 40, 40);
		panel.add(label);
		label.setIcon(new ImageIcon("timer.png"));

		JLabel label_6 = new JLabel("");
		label_6.setForeground(new Color(153, 0, 0));
		label_6.setFont(new Font("Showcard Gothic", Font.PLAIN, 25));
		label_6.setBounds(564, 21, 46, 46);
		panel.add(label_6);

		JLabel label_8 = new JLabel("result");
		label_8.setForeground(new Color(204, 0, 51));
		label_8.setFont(new Font("Showcard Gothic", Font.PLAIN, 25));
		label_8.setBounds(381, 37, 98, 22);
		panel.add(label_8);
		Timer update = new Timer();
		update.schedule(new TimerTask() {

			@Override
			public void run() {
				F = numberOfBombs - flagCounter;
				label_8.setText(String.valueOf(F));

			}
		}, 1, 1);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override

			public void run() {
				if (startTime == true)
					second++;

				label_6.setText(String.valueOf(second));

			}
		}, 1000, 1000);
		JLabel label_7 = new JLabel("");
		label_7.setBounds(12, 13, 54, 54);
		panel.add(label_7);
		// in qesmat baraye upload kardane akse profil dar safheye bazi ast
		if (Profile.signIn == true) {
			label_7.setIcon(new ImageIcon(ProfilePhoto.fileAddress));
		} else {
			int index = 0;
			for (int i = 0; i < Profile.etcInformation.size(); i++) {
				if (Profile.etcInformation.get(i).getTmpUserName().equals(Profile.inform0)) {
					index = i;
					break;
				}
			}
			label_7.setIcon(new ImageIcon(Profile.etcInformation.get(index).getPhotoAdrress()));
		}

		JLabel label_1 = new JLabel("");
		label_1.setBounds(171, 25, 40, 40);
		panel.add(label_1);
		label_1.setIcon(new ImageIcon("tmp4.jpeg"));

		JLabel label_3 = new JLabel("");
		label_3.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		label_3.setBounds(70, 31, 89, 22);
		panel.add(label_3);
		label_3.setText(Profile.inform0);

		JLabel label_2 = new JLabel("");
		label_2.setBounds(225, 27, 40, 40);
		panel.add(label_2);
		label_2.setIcon(new ImageIcon("sub.png"));

		JLabel label_4 = new JLabel("");
		label_4.setBounds(277, 27, 40, 40);
		panel.add(label_4);
		label_4.setIcon(new ImageIcon("filled-flag.png"));

		JLabel label_5 = new JLabel("");
		label_5.setBounds(329, 27, 40, 40);
		panel.add(label_5);
		label_5.setIcon(new ImageIcon("eq.png"));

		JLabel label_9 = new JLabel(":");
		label_9.setFont(new Font("Showcard Gothic", Font.BOLD, 19));
		label_9.setBounds(546, 38, 17, 15);
		panel.add(label_9);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 204));
		panel_1.setBounds(12, 106, maxwidth, maxlength);
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(width, length, 0, 0));

		JButton btnHome = new JButton("home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Profile.loadEtcInformaion();
				Profile.fillTheBlank();
				dispose();
				new Profile().setVisible(true);
			}
		});
		btnHome.setBackground(new Color(255, 255, 255));
		btnHome.setForeground(Color.RED);
		btnHome.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		btnHome.setBounds(12, 825, 146, 34);
		getContentPane().add(btnHome);

		JButton btnNewGame = new JButton("new game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile.saveEtcInformaion();
				Profile.loadEtcInformaion();
				if (Profile.signIn == true) {
					Profile.signIn = false;
				}
				dispose();
				new CustomBoardParameters().setVisible(true);
			}
		});
		btnNewGame.setForeground(new Color(0, 0, 204));
		btnNewGame.setFont(new Font("Showcard Gothic", Font.PLAIN, 13));
		btnNewGame.setBackground(Color.WHITE);
		btnNewGame.setBounds(174, 825, 146, 34);
		getContentPane().add(btnNewGame);
		// dar in qesmat dokme ha be safeye bazi ezafe mishavand
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < length; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].setBackground(new Color(153, 204, 204));
				panel_1.add(buttons[i][j]);
			}
		}
		// inja tedad bom haye atraf shomorde mishavand
		for (int x = 0; x < width; x++)
			for (int y = 0; y < length; y++) {

				int neibourBombCount = 0;

				if (checkBomb[x][y].equals("no")) {

					if ((y - 1 >= 0)) {

						if (checkBomb[x][y - 1].equals("yes")) {

							neibourBombCount++;

						}
					}
					// rast
					if ((y + 1 < length)) {

						if (checkBomb[x][y + 1].equals("yes")) {
							neibourBombCount++;
						}
					}
					// bala
					if ((x - 1 >= 0)) {
						if (checkBomb[x - 1][y].equals("yes")) {
							neibourBombCount++;
						}
					}
					// pa in
					if ((x + 1 < width)) {
						// System.out.println("pa in");
						// System.out.println("x :" +x +" y :"+y);

						if (checkBomb[x + 1][y].equals("yes")) {
							neibourBombCount++;
						}
					}
					// jonobe qarbi
					if ((x + 1 < width) && (y - 1 >= 0)) {

						if (checkBomb[x + 1][y - 1].equals("yes")) {
							neibourBombCount++;
						}
					}
					// shomale qarbi
					if ((x - 1 >= 0) && (y - 1 >= 0)) {

						if (checkBomb[x - 1][y - 1].equals("yes")) {
							neibourBombCount++;
						}
					}
					// jonobe sharqi
					if ((x + 1 < width) && (y + 1 < length)) {

						if (checkBomb[x + 1][y + 1].equals("yes")) {

							neibourBombCount++;
						}
					}
					// shomale sharqi
					if ((x - 1 >= 0) && (y + 1 < length)) {

						if (checkBomb[x - 1][y + 1].equals("yes")) {
							neibourBombCount++;
						}
					}
					if (neibourBombCount == 0) {
						checkEmpty[x][y] = "yes";
					} else {
						switch (String.valueOf(neibourBombCount)) {
						case "1":
							keepTheNumberOfNeibourBombs[x][y] = "11.png";
							break;
						case "2":
							keepTheNumberOfNeibourBombs[x][y] = "22.png";
							break;
						case "3":
							keepTheNumberOfNeibourBombs[x][y] = "33.png";
							break;
						case "4":
							keepTheNumberOfNeibourBombs[x][y] = "44.png";
							break;
						case "5":
							keepTheNumberOfNeibourBombs[x][y] = "55.png";
							break;
						case "6":
							keepTheNumberOfNeibourBombs[x][y] = "66.png";
							break;
						case "7":
							keepTheNumberOfNeibourBombs[x][y] = "77.png";
							break;
						case "8":
							keepTheNumberOfNeibourBombs[x][y] = "88.png";
							break;
						default:
							break;
						}
					}

				}
			}
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < length; j++) {
				final int tmpI = i;
				final int tmpJ = j;

				buttons[i][j].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						startTime = true;

						if ((SwingUtilities.isRightMouseButton(e))) {
							try {
								Sound.playSound("clickR.WAV");
							} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

							if ((starForCheckFlag[tmpI][tmpJ].equals(""))
									&& starForCheckFlagRight[tmpI][tmpJ].equals("")) {
								flagCounter++;
								System.out.println("gozasht");
								// checkVictory[tmpI][tmpJ] = "v";
								countToVictory++;
								buttons[tmpI][tmpJ].setIcon(new ImageIcon("filled-flag.png"));
								starForCheckFlagRight[tmpI][tmpJ] = "*";
								// star for flg right
							} else if ((starForCheckFlagRight[tmpI][tmpJ].equals("*"))) {
								flagCounter--;
								countToVictory--;
								starForCheckFlagRight[tmpI][tmpJ] = "";
								// checkVictory[tmpI][tmpJ] = "";
								buttons[tmpI][tmpJ].setIcon(null);
								buttons[tmpI][tmpJ].setBackground(new Color(153, 204, 204));
							}
						} else if ((SwingUtilities.isLeftMouseButton(e))) {
							try {

								Sound.playSound("clickR.WAV");
							} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}

							if (checkBomb[tmpI][tmpJ].equals("yes") && starForCheckFlagRight[tmpI][tmpJ].equals("")) {
								startTime = false;
								countToVictory = 0;
								try {
									Sound.playSound("explosion-01.WAV");
									Sound.playSound("gameover.WAV");
								} catch (MalformedURLException e1) {

									e1.printStackTrace();
								} catch (LineUnavailableException e1) {

									e1.printStackTrace();
								} catch (UnsupportedAudioFileException e1) {

									e1.printStackTrace();
								} catch (IOException e1) {

									e1.printStackTrace();
								}
								buttons[tmpI][tmpJ].setIcon(new ImageIcon("explosion.png"));
								checkBomb[tmpI][tmpJ] = "";
								starForCheckFlag[tmpI][tmpJ] = "*";
								for (int i = 0; i < width; i++) {
									for (int j = 0; j < length; j++) {
										if ((checkBomb[i][j].equals("yes"))
												&& (starForCheckFlagRight[i][j].equals("*"))) {
											buttons[i][j].setIcon(new ImageIcon("blackflg.png"));
										}
									}
								}
								for (int i = 0; i < width; i++) {
									for (int j = 0; j < length; j++) {
										if ((checkBomb[i][j].equals("yes"))
												&& (starForCheckFlagRight[i][j].equals(""))) {
											buttons[i][j].setIcon(new ImageIcon("tmp4.jpeg"));
											// inja araye ha alamat gozari mishavand ta eshtebah pish nayayad
											checkBomb[i][j] = "no";
											starForCheckFlag[i][j] = "*";
										}
									}
								}
								for (int i = 0; i < width; i++) {
									for (int j = 0; j < length; j++) {
										if ((checkEmpty[i][j].equals("yes"))
												&& (starForCheckFlagRight[i][j].equals(""))) {
											buttons[i][j].setBackground(Color.WHITE);

											// inja araye ha alamat gozari mishavand ta eshtebah pish nayayad
											checkEmpty[i][j] = "";
											starForCheckFlag[i][j] = "*";
										}
									}
								}
								for (int i = 0; i < width; i++) {
									for (int j = 0; j < length; j++) {
										if ((keepTheNumberOfNeibourBombs[i][j].contains("png"))
												&& (starForCheckFlagRight[i][j].equals(""))) {
											buttons[i][j].setIcon(new ImageIcon(keepTheNumberOfNeibourBombs[i][j]));
											keepTheNumberOfNeibourBombs[i][j] = "";
											starForCheckFlag[i][j] = "*";
											// inja araye ha alamat gozari mishavand ta eshtebah pish nayayad
										}
									}
								}

								if (Profile.signIn == true) {

									new Profile(Profile.inform0, Profile.inform1,
											score(F, second, emptyCounter, numberCounter), "0", "1",
											String.valueOf(second), ProfilePhoto.fileAddress);
									

								} else {
									
									updateTheInformationOfAOldPlayer(Profile.inform0,
											score(F, second, emptyCounter, numberCounter), "0", "1",
											String.valueOf(second));
								}
								second = 0;
								F = 0;
								flagCounter = 0;
								numberCounter = 0;
								emptyCounter = 0;
								new gameOver().setVisible(true);
							} else if ((checkEmpty[tmpI][tmpJ].equals("yes"))
									&& (starForCheckFlagRight[tmpI][tmpJ].equals(""))
									&& starForCheckEmpty[tmpI][tmpJ].equals("")) {
							

								buttons[tmpI][tmpJ].setBackground(Color.WHITE);
								countToVictory++;
								emptyCounter++;
								// checkVictory[tmpI][tmpJ] = "v";
								starForCheckEmpty[tmpI][tmpJ] = "*";
								starForCheckFlag[tmpI][tmpJ] = "*";
								// inja araye ha alamat gozari mishavand ta eshtebah pish nayayad
								recursiveCheckEmpty(tmpI, tmpJ, length, width);

							} else if (keepTheNumberOfNeibourBombs[tmpI][tmpJ].contains("png")
									&& (starForCheckFlagRight[tmpI][tmpJ].equals(""))
									&& starForCheckNumber[tmpI][tmpJ].equals("")) {
								
								buttons[tmpI][tmpJ].setIcon(new ImageIcon(keepTheNumberOfNeibourBombs[tmpI][tmpJ]));
								numberCounter++;
								countToVictory++;
								// checkVictory[tmpI][tmpJ] = "v";
								starForCheckNumber[tmpI][tmpJ] = "*";
								starForCheckFlag[tmpI][tmpJ] = "*";
								// inja araye ha alamat gozari mishavand ta eshtebah pish nayayad

							}
						}
						/*
						 * for (int i = 0; i < width; i++) { for (int j = 0; j < length; j++) {
						 * System.out.print(checkVictory[i][j] + "   "); } System.out.println(); }
						 * System.out.println();
						 */
						/**
						 * 
						 */
						if (countToVictory == width * length) {
							startTime = false;
							countToVictory = 0;
							try {
								Sound.playSound("victory.WAV");
							} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(GamePage.this, "You are the Victorious!!!!!!", "Information",
									JOptionPane.INFORMATION_MESSAGE);
							for (int i = 0; i < width; i++) {
								for (int j = 0; j < length; j++) {
									buttons[i][j].setEnabled(false);
								}
							}
							
							if (Profile.signIn == true) {
								new Profile(Profile.inform0, Profile.inform1,
										score(F, second, emptyCounter, numberCounter), "1", "0", String.valueOf(second),
										ProfilePhoto.fileAddress);
							} else {
								updateTheInformationOfAOldPlayer(Profile.inform0,
										score(F, second, emptyCounter, numberCounter), "1", "0",
										String.valueOf(second));

							}
							second = 0;
							F = 0;
							flagCounter = 0;
							numberCounter = 0;
							emptyCounter = 0;

						}

					}

				});
			}

		}

	}

	public String calculateTheMAxFactorsOfNumber(long number) {
		ArrayList<String> maxes = new ArrayList<>();
		String result = "";

		for (long i = number / 2; i >= 1; i--) {
			if (number % i == 0) {
				maxes.add(String.valueOf(number / i));
			}

		}
		for (int i = 0; i < maxes.size() - 1; i++) {
			if (((Long.valueOf(maxes.get(i))) * (Long.valueOf(maxes.get(i + 1))) == number)) {

				result = maxes.get(i) + "/" + maxes.get(i + 1);
				break;
			} else if ((((Long.valueOf(maxes.get(i))) * (Long.valueOf(maxes.get(i))) == number))) {

				result = maxes.get(i);
				break;
			}
		}
		return result;
	}

	public void recursiveCheckEmpty(int x, int y, int length, int width) {
		// x dar inja arz(width) ast
		// y dar in ja tool(length) ast
		// chap

		if ((y - 1 >= 0) && (starForCheckEmpty[x][y - 1].equals("")) && (starForCheckFlagRight[x][y - 1].equals(""))) {

			if (checkEmpty[x][y].equals(checkEmpty[x][y - 1])) {

				// System.out.println("dakhele chap");
				buttons[x][y - 1].setBackground(Color.WHITE);
				countToVictory++;
				emptyCounter++;
				starForCheckEmpty[x][y - 1] = "*";
				starForCheckFlag[x][y - 1] = "*";
				// inja araye ha alamat gozari mishavand ta eshtebah pish nayayad
				// checkVictory[x][y - 1] = "v";
				recursiveCheckEmpty(x, y - 1, length, width);
				non_RecursiveCheckNumber(x, y - 1, length, width);

			}

		}
		// rast
		if ((y + 1 < length) && (starForCheckEmpty[x][y + 1].equals(""))
				&& (starForCheckFlagRight[x][y + 1].equals(""))) {

			if (checkEmpty[x][y].equals(checkEmpty[x][y + 1])) {

				buttons[x][y + 1].setBackground(Color.WHITE);
				countToVictory++;
				emptyCounter++;
				starForCheckEmpty[x][y + 1] = "*";
				starForCheckFlag[x][y + 1] = "*";
				// inja araye ha alamat gozari mishavand ta eshtebah pish nayayad
				// checkVictory[x][y + 1] = "v";
				recursiveCheckEmpty(x, y + 1, length, width);
				non_RecursiveCheckNumber(x, y + 1, length, width);

			}
		}
		// bala
		if ((x - 1 >= 0) && (starForCheckEmpty[x - 1][y].equals("")) && (starForCheckFlagRight[x - 1][y].equals(""))) {

			if (checkEmpty[x][y].equals(checkEmpty[x - 1][y])) {

				buttons[x - 1][y].setBackground(Color.WHITE);
				countToVictory++;
				emptyCounter++;
				starForCheckEmpty[x - 1][y] = "*";
				starForCheckFlag[x - 1][y] = "*";
				// inja araye ha alamat gozari mishavand ta eshtebah pish nayayad
				// checkVictory[x - 1][y] = "v";
				recursiveCheckEmpty(x - 1, y, length, width);
				non_RecursiveCheckNumber(x - 1, y, length, width);

			}
		}
		// pa in
		if ((x + 1 < width) && (starForCheckEmpty[x + 1][y].equals(""))
				&& (starForCheckFlagRight[x + 1][y].equals(""))) {

			if (checkEmpty[x][y].equals(checkEmpty[x + 1][y])) {

				buttons[x + 1][y].setBackground(Color.WHITE);
				countToVictory++;
				emptyCounter++;
				starForCheckEmpty[x + 1][y] = "*";
				starForCheckFlag[x + 1][y] = "*";
				// checkVictory[x + 1][y] = "v";
				recursiveCheckEmpty(x + 1, y, length, width);
				non_RecursiveCheckNumber(x + 1, y, length, width);

			}
		}
		// jonobe qarbi
		if ((x + 1 < width) && (y - 1 >= 0) && (starForCheckEmpty[x + 1][y - 1].equals(""))
				&& (starForCheckFlagRight[x + 1][y - 1].equals(""))) {

			if (checkEmpty[x][y].equals(checkEmpty[x + 1][y - 1])) {
				// System.out.println("dakhele jonobe qarbi");
				buttons[x + 1][y - 1].setBackground(Color.WHITE);
				countToVictory++;
				emptyCounter++;
				starForCheckEmpty[x + 1][y - 1] = "*";
				starForCheckFlag[x + 1][y - 1] = "*";
				// checkVictory[x + 1][y - 1] = "v";
				recursiveCheckEmpty(x + 1, y - 1, length, width);
				non_RecursiveCheckNumber(x + 1, y - 1, length, width);

			}
		}
		// shomale qarbi
		if ((x - 1 >= 0) && (y - 1 >= 0) && (starForCheckEmpty[x - 1][y - 1].equals(""))
				&& (starForCheckFlagRight[x - 1][y - 1].equals(""))) {

			if (checkEmpty[x][y].equals(checkEmpty[x - 1][y - 1])) {
				// System.out.println("dakhele shomale qarbi");
				buttons[x - 1][y - 1].setBackground(Color.WHITE);
				countToVictory++;
				emptyCounter++;
				starForCheckEmpty[x - 1][y - 1] = "*";
				starForCheckFlag[x - 1][y - 1] = "*";
				// checkVictory[x - 1][y - 1] = "v";
				recursiveCheckEmpty(x - 1, y - 1, length, width);
				non_RecursiveCheckNumber(x - 1, y - 1, length, width);

			}
		}
		// jonobe sharqi
		if ((x + 1 < width) && (y + 1 < length) && (starForCheckEmpty[x + 1][y + 1].equals(""))
				&& (starForCheckFlagRight[x + 1][y + 1].equals(""))) {

			if (checkEmpty[x][y].equals(checkEmpty[x + 1][y + 1])) {

				buttons[x + 1][y + 1].setBackground(Color.WHITE);
				countToVictory++;
				emptyCounter++;
				starForCheckEmpty[x + 1][y + 1] = "*";
				starForCheckFlag[x + 1][y + 1] = "*";
				// checkVictory[x + 1][y + 1] = "v";
				recursiveCheckEmpty(x + 1, y + 1, length, width);
				non_RecursiveCheckNumber(x + 1, y + 1, length, width);

			}
		}
		// shomale sharqi
		if ((x - 1 >= 0) && (y + 1 < length) && (starForCheckEmpty[x - 1][y + 1].equals(""))
				&& (starForCheckFlagRight[x - 1][y + 1].equals(""))) {
			if (checkEmpty[x][y].equals(checkEmpty[x - 1][y + 1])) {

				buttons[x - 1][y + 1].setBackground(Color.WHITE);
				countToVictory++;
				emptyCounter++;
				starForCheckEmpty[x - 1][y + 1] = "*";
				starForCheckFlag[x - 1][y + 1] = "*";
				// checkVictory[x - 1][y + 1] = "v";
				recursiveCheckEmpty(x - 1, y + 1, length, width);
				non_RecursiveCheckNumber(x - 1, y + 1, length, width);

			}
		}

	}

	public void non_RecursiveCheckNumber(int x, int y, int length, int width) {
		if ((y - 1 >= 0) && (starForCheckNumber[x][y - 1].equals("")) && (starForCheckFlagRight[x][y - 1].equals(""))) {

			if (keepTheNumberOfNeibourBombs[x][y - 1].contains("png")) {

				buttons[x][y - 1].setIcon(new ImageIcon(keepTheNumberOfNeibourBombs[x][y - 1]));
				countToVictory++;
				numberCounter++;
				starForCheckNumber[x][y - 1] = "*";
				starForCheckFlag[x][y - 1] = "*";

				// checkVictory[x][y - 1] = "v";

			}
		}
		// rast
		if ((y + 1 < length) && (starForCheckNumber[x][y + 1].equals(""))
				&& (starForCheckFlagRight[x][y + 1].equals(""))) {
			// System.out.println("rast");
			// System.out.println("x :" +x +" y :"+y);

			if (keepTheNumberOfNeibourBombs[x][y + 1].contains("png")) {

				buttons[x][y + 1].setIcon(new ImageIcon(keepTheNumberOfNeibourBombs[x][y + 1]));
				countToVictory++;
				numberCounter++;
				starForCheckNumber[x][y + 1] = "*";
				starForCheckFlag[x][y + 1] = "*";

				// checkVictory[x][y + 1] = "v";

			}
		}
		// bala
		if ((x - 1 >= 0) && (starForCheckNumber[x - 1][y].equals("")) && (starForCheckFlagRight[x - 1][y].equals(""))) {

			if (keepTheNumberOfNeibourBombs[x - 1][y].contains("png")) {

				buttons[x - 1][y].setIcon(new ImageIcon(keepTheNumberOfNeibourBombs[x - 1][y]));
				countToVictory++;
				numberCounter++;
				starForCheckNumber[x - 1][y] = "*";
				starForCheckFlag[x - 1][y] = "*";
				// inja araye ha alamat gozari mishavand ta eshtebah pish nayayad

				// checkVictory[x - 1][y] = "v";

			}
		}
		// pa in
		if ((x + 1 < width) && (starForCheckNumber[x + 1][y].equals(""))
				&& (starForCheckFlagRight[x + 1][y].equals(""))) {

			if (keepTheNumberOfNeibourBombs[x + 1][y].contains("png")) {

				buttons[x + 1][y].setIcon(new ImageIcon(keepTheNumberOfNeibourBombs[x + 1][y]));
				countToVictory++;
				numberCounter++;
				starForCheckNumber[x + 1][y] = "*";
				starForCheckFlag[x + 1][y] = "*";

				// checkVictory[x + 1][y] = "v";

			}
		}
		// jonobe qarbi
		if ((x + 1 < width) && (y - 1 >= 0) && (starForCheckNumber[x + 1][y - 1].equals(""))
				&& (starForCheckFlagRight[x + 1][y - 1].equals(""))) {

			if (keepTheNumberOfNeibourBombs[x + 1][y - 1].contains("png")) {

				buttons[x + 1][y - 1].setIcon(new ImageIcon(keepTheNumberOfNeibourBombs[x + 1][y - 1]));
				countToVictory++;
				numberCounter++;
				starForCheckNumber[x + 1][y - 1] = "*";
				starForCheckFlag[x + 1][y - 1] = "*";
				// inja araye ha alamat gozari mishavand ta eshtebah pish nayayad

				// checkVictory[x + 1][y - 1] = "v";

			}
		}
		// shomale qarbi
		if ((x - 1 >= 0) && (y - 1 >= 0) && (starForCheckNumber[x - 1][y - 1].equals(""))
				&& (starForCheckFlagRight[x - 1][y - 1].equals(""))) {

			if (keepTheNumberOfNeibourBombs[x - 1][y - 1].contains("png")) {

				buttons[x - 1][y - 1].setIcon(new ImageIcon(keepTheNumberOfNeibourBombs[x - 1][y - 1]));
				countToVictory++;
				numberCounter++;
				starForCheckNumber[x - 1][y - 1] = "*";
				starForCheckFlag[x - 1][y - 1] = "*";
				// checkVictory[x - 1][y - 1] = "v";

			}
		}
		// jonobe sharqi
		if ((x + 1 < width) && (y + 1 < length) && (starForCheckNumber[x + 1][y + 1].equals(""))
				&& (starForCheckFlagRight[x + 1][y + 1].equals(""))) {

			if (keepTheNumberOfNeibourBombs[x + 1][y + 1].contains("png")) {

				buttons[x + 1][y + 1].setIcon(new ImageIcon(keepTheNumberOfNeibourBombs[x + 1][y + 1]));
				countToVictory++;
				numberCounter++;
				starForCheckNumber[x + 1][y + 1] = "*";
				starForCheckFlag[x + 1][y + 1] = "*";
				// inja araye ha alamat gozari mishavand ta eshtebah pish nayayad
				// checkVictory[x + 1][y + 1] = "v";

			}
		}
		// shomale sharqi
		if ((x - 1 >= 0) && (y + 1 < length) && (starForCheckNumber[x - 1][y + 1].equals(""))
				&& (starForCheckFlagRight[x - 1][y + 1].equals(""))) {

			if (keepTheNumberOfNeibourBombs[x - 1][y + 1].contains("png")) {

				buttons[x - 1][y + 1].setIcon(new ImageIcon(keepTheNumberOfNeibourBombs[x - 1][y + 1]));
				countToVictory++;
				numberCounter++;
				starForCheckNumber[x - 1][y + 1] = "*";
				starForCheckFlag[x - 1][y + 1] = "*";

				// checkVictory[x - 1][y + 1] = "v";

			}
		}

	}

	public static String score(int F, int T, int emptyCounter, int numberCounter) {
		return String.valueOf(((1000 - 10 * (F * F)) * (emptyCounter + numberCounter)) / (Math.pow(T * 1000, 1 / 3)));
	}

	public static void updateTheInformationOfAOldPlayer(String userName, String score, String wins, String loses,
			String time) {
		int index = 0;
		for (int i = 0; i < Profile.etcInformation.size(); i++) {
			if (Profile.etcInformation.get(i).getTmpUserName().equals(userName)) {
				index = i;
				break;
			}
		}
		Profile.etcInformation.get(index).setScore(
				String.valueOf(Float.valueOf(Profile.etcInformation.get(index).getScore()) + Float.valueOf(score)));
		Profile.etcInformation.get(index).setWins(
				String.valueOf(Integer.valueOf(Profile.etcInformation.get(index).getWins()) + Integer.valueOf(wins)));
		Profile.etcInformation.get(index).setLoses(
				String.valueOf(Integer.valueOf(Profile.etcInformation.get(index).getLoses()) + Integer.valueOf(loses)));
		Profile.etcInformation.get(index).setGameDuration(String
				.valueOf(Integer.valueOf(Profile.etcInformation.get(index).getGameDuration()) + Integer.valueOf(time)));
		Profile.saveEtcInformaion();

	}

}
