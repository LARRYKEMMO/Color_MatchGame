import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.security.PublicKey;
import java.awt.event.ActionEvent;
import java.awt.Color;

	/*DATA MEMBER DECLERATION*/


public class MatchGame extends JFrame implements ActionListener{  // MatchGame Implements ActionListener, Required for the use of the Timer

	private JPanel contentPane;
	
	private static final Integer FRAMETIME = 1000;			// Data member declaration (FRAMETIME)
	
	private Timer tickTock = new Timer(FRAMETIME,this);		// Time declaration and instantiation (tickTock) based on the frame time
	
	private static JLabel lblPlayerName;					// Data member declaration lblPlayerName (JLabel)
	private static JButton btnPlay;							// Data member declaration btnPlay (JButton)
	private static JButton btnGenerate;						// Data member declaration btnGenerate
	public static JButton btnRestart;						// Data member declaration btnGenerate
	private static JLabel lblRedSection;					// Data member declaration lblRedSection (JLabel)
	private static JLabel lblYellowSection;					// Data member declaration lblYellowSection (JLabel)
	private static JLabel lblGreenSection;					// Data member declaration lblGreenSection (JLabel)
	private static JLabel lblBlueSection;					// Data member declaration lblBlueSection (JLabel)
	private static JButton btnRed;							// Data member declaration JButton btnRed (JButton)
	private static JButton btnGreen;						// Data member declaration JButton btnGreen (JButton)
	private static JButton btnBlue;							// Data member declaration JButton btnBlue (JButton)
	private static JButton btnYellow;						// Data member declaration JButton btnYellow (JButton)
	private static JLabel lblPointsFinal;					// Data member declaration JButton lblPointsFinal (JLabel)
	private static JLabel lblLevel;							// Data member declaration JLabel lblLevel (JLabel)
	private static int Counter = 0;							// Data member declaration and instantiation of Counter to 0 (integer)
	private static int counter = 0;							// Data member declaration  and instantiation of counter to 0 (integer)
	public static Clip dingSound;
	public static JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new MatchGame();
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
	public MatchGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 10, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		btnRestart = new JButton("Restart");
		btnRestart.setEnabled(false);
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		/* Methods executed when the Generate button is activated */		
				ClickSound();
				ResetLevel();
				ResetPoints();
				MatchGameMechanics.GameRestart();
			}
		});
		btnRestart.setFont(new Font("Cooper Black", Font.BOLD, 14));
		btnRestart.setBounds(455, 466, 106, 30);
		contentPane.add(btnRestart);
		
		
		btnGenerate = new JButton("Generate");
		btnGenerate.setEnabled(false);
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		/* Methods executed when the Generate button is activated */		
				
				ClickSound();
				MatchGameMechanics.DisplayColors();		// Calls the Display Method found in the MatchGame Mechanics
				JOptionPane.showMessageDialog(null, "Enter the correct color pattern");		// System Displays Enter the correct color pattern

				tickTock.start();      // Timer is activated

			}
		});
		btnGenerate.setFont(new Font("Cooper Black", Font.BOLD, 14));
		btnGenerate.setBounds(455, 396, 106, 30);
		contentPane.add(btnGenerate);
		
		 btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		/* Methods executed when the Generate button is activated */
				ClickSound();
				MatchGameMechanics.ArrayDeclaration();		// Calls the ArrayDeclaration method in the MatchGame Mechanics
				MatchGameMechanics.WelcomeMessage();		// Calls the WelcomeMessage method in the MatchGame Mechanics
			 	MatchGameMechanics.GetName();				// Calls the GetName method in the MatchGame Mechanics
				btnGenerate.setEnabled(true);

			}
		});
		btnPlay.setFont(new Font("Cooper Black", Font.BOLD, 14));
		btnPlay.setBounds(455, 324, 106, 30);
		contentPane.add(btnPlay);
		
		 btnRed = new JButton(Assets.RedButton);
		 btnRed.setEnabled(false);
		 btnRed.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		ClickSound();
		 		MatchGameMechanics.Red();	// Calls the Red method in the MatchGame Mechanics

		 	}
		 });
		btnRed.setBounds(444, 591, 30, 30);
		contentPane.add(btnRed);
		
		 btnBlue = new JButton(Assets.BlueButton);
		 btnBlue.setEnabled(false);
		 btnBlue.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		ClickSound();
		 		MatchGameMechanics.Blue();    // Calls the Blue method in the MatchGame Mechanics
		 	}
		 });
		btnBlue.setBounds(370, 591, 30, 30);
		contentPane.add(btnBlue);
		
		 btnYellow = new JButton(Assets.YellowButton);
		 btnYellow.setEnabled(false);
		 btnYellow.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		ClickSound();
		 		MatchGameMechanics.Yellow();    // Calls the Yellow method in the MatchGame Mechanics

		 	}
		 });
		btnYellow.setBounds(512, 591, 30, 30);
		contentPane.add(btnYellow);
		
		 btnGreen = new JButton(Assets.GreenButton);
		 btnGreen.setEnabled(false);
		 btnGreen.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		ClickSound();
		 		MatchGameMechanics.Green();		// Calls the Green method in the MatchGame Mechanics

		 	}
		 });
		btnGreen.setBounds(581, 591, 30, 30);
		contentPane.add(btnGreen);
		
		lblPlayerName = new JLabel("");			// Initializing lblPlayerName to void while waiting for the player to enter his name
		lblPlayerName.setFont(new Font("Cooper Black", Font.BOLD, 18));
		lblPlayerName.setBounds(740, 186, 199, 30);
		contentPane.add(lblPlayerName);
		
		lblBlueSection = new JLabel(Assets.BlueSection);		// Initializing lblBlueSection to the instantiated image BlueSection in the Assets class
		lblBlueSection.setBounds(379, 173, 55, 65);
		contentPane.add(lblBlueSection);
		
		lblGreenSection = new JLabel(Assets.GreenSection);		// Initializing lblGreenSection to the instantiated image GreenSection in the Assets class
		lblGreenSection.setBounds(450, 173, 55, 65);
		contentPane.add(lblGreenSection);
		
		lblYellowSection = new JLabel(Assets.YellowSection);		// Initializing lblYellowSection to the instantiated image YellowSection in the Assets class
		lblYellowSection.setBounds(520, 173, 55, 65);
		contentPane.add(lblYellowSection);
		
		 lblRedSection = new JLabel(Assets.RedSection);			// Initializing lblRedSection to the instantiated image RedSection in the Assets class
		lblRedSection.setBounds(585, 173, 55, 65);
		contentPane.add(lblRedSection);
		
		lblPointsFinal = new JLabel("");
		lblPointsFinal.setForeground(Color.RED);
		lblPointsFinal.setFont(new Font("Cooper Black", Font.BOLD, 20));			// Initializing lblPointsFinal to 0 while waiting for the Points to Increment
		lblPointsFinal.setBounds(139, 87, 70, 30);
		contentPane.add(lblPointsFinal);
		
		lblLevel = new JLabel("");
		lblLevel.setForeground(Color.RED);
		lblLevel.setFont(new Font("Cooper Black", Font.BOLD, 20));				// Initializing lblLevel to 1 while waiting for the level to Increment
		lblLevel.setBounds(822, 87, 75, 30);
		contentPane.add(lblLevel);
		
		JLabel lblBackgroundImage = new JLabel(Assets.Background);			// Initializing lblBackground to the instantiated Background image in the Assets class 
		lblBackgroundImage.setBounds(0, 0, 990, 795);
		contentPane.add(lblBackgroundImage);
		

		
	}
	
	// Setter method
	public static void SetLblPlayerName(String TempName) {
		/* METHOD THAT SETS THE PLAYER NAME IN THE GAME*/
		lblPlayerName.setText(TempName);
	}
	// Setter method
	public static void PlayEnabled(boolean TempDecision) {
		/* METHOD THAT ENABLES PLAY BUTTON IN THE GAME*/
		btnPlay.setEnabled(TempDecision);
	}
	// Setter method
	public static void GenerateEnabled(boolean TempDecision) {
		/* METHOD THAT ENABLES GENERATE BUTTON IN THE GAME*/
		btnGenerate.setEnabled(TempDecision);
	}
	// Setter method
	public static void RedEnabled(boolean TempDecision) {
		/* METHOD THAT ENABLES RED BUTTON IN THE GAME*/
		btnRed.setEnabled(TempDecision);
	}
	// Setter method
	public static void GreenEnabled(boolean TempDecision) {
		/* METHOD THAT ENABLES GREEN BUTTON IN THE GAME*/
		btnGreen.setEnabled(TempDecision);
	}
	// Setter method
	public static void BlueEnabled(boolean TempDecision) {
		/* METHOD THAT ENABLES BLUE BUTTON IN THE GAME*/
		btnBlue.setEnabled(TempDecision);
	}
	// Setter method
	public static void YellowEnabled(boolean TempDecision) {
		/* METHOD THAT ENABLES YELLOW BUTTON IN THE GAME*/
		btnYellow.setEnabled(TempDecision);
	}
	// Setter method
	public static void SetRedSection(ImageIcon TempColor) {
		/* METHOD THAT SETS RED SECTION TO TempColor IN THE GAME*/
		lblRedSection.setIcon(TempColor);
	}
	// Setter method
	public static void SetGreenSection(ImageIcon TempColor) {
		/* METHOD THAT SETS GREEN SECTION TO TempColor IN THE GAME*/
		lblGreenSection.setIcon(TempColor);
	}
	// Setter method
	public static void SetBlueSection(ImageIcon TempColor) {
		/* METHOD THAT SETS BLUE SECTION TO TempColor IN THE GAME*/
		lblBlueSection.setIcon(TempColor);
	}
	// Setter method
	public static void SetYellowSection(ImageIcon TempColor) {
		/* METHOD THAT SETS YELLOW SECTION TO TempColor IN THE GAME*/
		lblYellowSection.setIcon(TempColor);
	}
	// Setter method
	public static void SetPoints(Integer TempPoints) {
		/* METHOD THAT SETS Points TO TempPoints IN THE GAME*/
		String tempPoint;
		tempPoint = TempPoints.toString();
		lblPointsFinal.setText(tempPoint);
	}
	// Setter method
	public static void SetLevel(Integer TempLevel) {
		/* METHOD THAT SETS LEVEL TO TempLevel IN THE GAME*/
		String tempLevel;
		tempLevel = TempLevel.toString();
		lblLevel.setText(tempLevel);
	}

	public static void ResetLevel() {
		lblLevel.setText(null);
	}
	
	public static void ResetPoints() {
		lblPointsFinal.setText(null);
	}
	
	
	
	public static void WinSound() {
		
		/*METHOD THAT PLAYS WINNING SOUND ON THE GAME*/
		
		String dingLocation = "Audio/Win.wav"; // Local data member declaration and instantiation of String "Audio/Win.wav" (Winning Sound directory)
		
		/*CONDITION THAT INSTANTIATES THE SOUND INTO THE COMPUTER AND IF DONE SUCCESSFULLY, SOUND IS ACTIVATED*/
		
		try {
			File dingFile = new File(dingLocation);
			
			AudioInputStream dingAudioFile = AudioSystem.getAudioInputStream(dingFile);
			
			Clip dingSound = AudioSystem.getClip();
			
			dingSound.open(dingAudioFile);		// Open audio File loaded from Assets class
			dingSound.start();					// Start (Play) Audio file
		
		/*IF SOUND WAS NOT SUCCESFULLY INSTIANTIATED, SOUND NOT ACTIVATED, SYSTEM DISPLAYS Problem playing sound */
			
			} catch (Exception e1) {
				
			JOptionPane.showMessageDialog(null, "Problem playing sound");		// System displays Problem playing sound
			
			}
	}
	
	
	public static void LoseSound() {
		
		/*METHOD THAT PLAYS WINNING SOUND ON THE GAME*/

		String dingLocation = "Audio/Fail.wav";		// Local data member declaration and instantiation of String "Audio/Fail.wav" (Winning Sound directory)
		
		/*CONDITION THAT INSTANTIATES THE SOUND INTO THE COMPUTER AND IF DONE SUCCESSFULLY, SOUND IS ACTIVATED*/

		try {
			File dingFile = new File(dingLocation);
			
			AudioInputStream dingAudioFile = AudioSystem.getAudioInputStream(dingFile);
			
			Clip dingSound = AudioSystem.getClip();
			
			dingSound.open(dingAudioFile);		// Open audio File loaded from Assets class
			dingSound.start();				// Start (Play) Audio file
		
			/*IF SOUND WAS NOT SUCCESFULLY INSTIANTIATED, SOUND NOT ACTIVATED, SYSTEM DISPLAYS Problem playing sound */
			
		} catch (Exception e1) {
			
			JOptionPane.showMessageDialog(null, "Problem playing sound");		// System displays Problem playing sound
		}
	}
	
	public static void LevelWinSound() {
		/*METHOD THAT PLAYS WINNING SOUND ON THE GAME*/
		
		String dingLocation = "Audio/LevelWin.wav";		// Local data member declaration and instantiation of String "Audio/LevelWin.wav" (Winning Sound directory)
		
		/*CONDITION THAT INSTANTIATES THE SOUND INTO THE COMPUTER AND IF DONE SUCCESSFULLY, SOUND IS ACTIVATED*/

		try {
			File dingFile = new File(dingLocation);
			
			AudioInputStream dingAudioFile = AudioSystem.getAudioInputStream(dingFile);
			
			Clip dingSound = AudioSystem.getClip();
			
			dingSound.open(dingAudioFile);		// Open audio File loaded from Assets class
			dingSound.start();			// Start (Play) Audio file
		
			/*IF SOUND WAS NOT SUCCESFULLY INSTIANTIATED, SOUND NOT ACTIVATED, SYSTEM DISPLAYS Problem playing sound */
			
		} catch (Exception e1) {
			
			JOptionPane.showMessageDialog(null, "Problem playing sound");		// System displays Problem playing sound
		}
	}
	
	
	public static void DisplaySound() {
		/*METHOD THAT PLAYS SOUND UPON THE DISPLAY OF COLORS IN THE GAME*/

		String dingLocation = "Audio/ding.wav";		// Local data member declaration and instantiation of String "Audio/ding.wav" (Winning Sound directory)
		
		/*CONDITION THAT INSTANTIATES THE SOUND INTO THE COMPUTER AND IF DONE SUCCESSFULLY, SOUND IS ACTIVATED*/

		try {
			File dingFile = new File(dingLocation);
			
			AudioInputStream dingAudioFile = AudioSystem.getAudioInputStream(dingFile);
			
			Clip dingSound = AudioSystem.getClip();
			
			dingSound.open(dingAudioFile);		// Open audio File loaded from Assets class
			dingSound.start();				// Start (Play) Audio file
		
			/*IF SOUND WAS NOT SUCCESFULLY INSTIANTIATED, SOUND NOT ACTIVATED, SYSTEM DISPLAYS Problem playing sound */
			
		} catch (Exception e1) {
			
			JOptionPane.showMessageDialog(null, "Problem playing sound");		// System displays Problem playing sound
		}
	}
	
	public static void ClickSound() {
		/*METHOD THAT PLAYS WELCOMING SOUND ON THE GAME*/

		String dingLocation = "Audio/Click.wav";		// Local data member declaration and instantiation of String "Audio/Opener.wav" (Winning Sound directory)
		
		/*CONDITION THAT INSTANTIATES THE SOUND INTO THE COMPUTER AND IF DONE SUCCESSFULLY, SOUND IS ACTIVATED*/

		try {
			File dingFile = new File(dingLocation);
			
			AudioInputStream dingAudioFile = AudioSystem.getAudioInputStream(dingFile);
			
			Clip ClickSound = AudioSystem.getClip();
			
			ClickSound.open(dingAudioFile);		// Open audio File loaded from Assets class
			ClickSound.start();				// Start (Play) Audio file
		
			/*IF SOUND WAS NOT SUCCESFULLY INSTIANTIATED, SOUND NOT ACTIVATED, SYSTEM DISPLAYS Problem playing sound */
			
		} catch (Exception e1) {
			
			JOptionPane.showMessageDialog(null, "Problem playing sound");		// System displays Problem playing sound
		}
//		OpenSound();
	}
	
	
	public static void OpenSound() {
		/*METHOD THAT PLAYS WELCOMING SOUND ON THE GAME*/

		String dingLocation = "Audio/Opener.wav";		// Local data member declaration and instantiation of String "Audio/Opener.wav" (Winning Sound directory)
		
		/*CONDITION THAT INSTANTIATES THE SOUND INTO THE COMPUTER AND IF DONE SUCCESSFULLY, SOUND IS ACTIVATED*/

		try {
			File dingFile = new File(dingLocation);
			
			AudioInputStream dingAudioFile = AudioSystem.getAudioInputStream(dingFile);
			
			 dingSound = AudioSystem.getClip();
			
			dingSound.open(dingAudioFile);		// Open audio File loaded from Assets class
			dingSound.start();				// Start (Play) Audio file
		
			/*IF SOUND WAS NOT SUCCESFULLY INSTIANTIATED, SOUND NOT ACTIVATED, SYSTEM DISPLAYS Problem playing sound */
			
		} catch (Exception e1) {
			
			JOptionPane.showMessageDialog(null, "Problem playing sound");		// System displays Problem playing sound
		}
//		OpenSound();
	}
	public static void GameOverSound() {
		
		/*METHOD THAT PLAYS WINNING SOUND ON THE GAME*/
		
		String dingLocation = "Audio/GameOver.wav";		// Local data member declaration and instantiation of String "Audio/LevelWin.wav" (Winning Sound directory)
		
		/*CONDITION THAT INSTANTIATES THE SOUND INTO THE COMPUTER AND IF DONE SUCCESSFULLY, SOUND IS ACTIVATED*/
		
		try {
			File dingFile = new File(dingLocation);
			
			AudioInputStream dingAudioFile = AudioSystem.getAudioInputStream(dingFile);
			
			Clip dingSound = AudioSystem.getClip();
			
			dingSound.open(dingAudioFile);		// Open audio File loaded from Assets class
			dingSound.start();		// Start (Play) Audio file
			
			/*IF SOUND WAS NOT SUCCESFULLY INSTIANTIATED, SOUND NOT ACTIVATED, SYSTEM DISPLAYS Problem playing sound */
			
		} catch (Exception e1) {
			
			JOptionPane.showMessageDialog(null, "Problem playing sound");		// System displays Problem playing sound
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
				// *******************************************************************************************************************************************************************
				// Method                  :   	actionPerformed
				//
				// Method  parameters      :    ActionEvent e
				// 
				// Method return           :    void
				//
				// Synopsis                :    This method manages the timer in the display of colors
				//
				// Modifications           :    
				//                              Date           Developer              Notes
				//                             ------         -----------            -------
				//                  		  2022-05-09      Larry Kemmo  		Initial setup and commenting
		        //
				//******************************************************************************************************************************************************************

		
		
//		System.out.println(MatchGameMechanics.PointPatternArray.get(Counter));
		

		
		if (Counter < MatchGameMechanics.PointPatternArray.size()) {	// Condition that checks if Counter is less than PointPatternArray size
			
		
			
			if (MatchGameMechanics.PointPatternArray.get(Counter) == 1) {	// Condition that checks if the first element of the PointPatternArray is equal to 1
				if (counter == 0) {		// Condition that checks if counter equal to 0
					lblRedSection.setIcon(Assets.RedBSection);	// Set Red Section to Bright Red color in the GUI - version
					DisplaySound();
					counter ++;		// increment counter by 1
				}
				
				
				else if(counter == 1) {		// Condition that checks if counter equal to 1
					lblRedSection.setIcon(Assets.RedSection);	// Set Red Section to Dim Red color in the GUI - version
					Counter ++;		// increment counter by 1
					counter = 0;	// set counter to 0
				}

			}
			
			
			else if (MatchGameMechanics.PointPatternArray.get(Counter) == 2) {	// Condition that checks if the second element of the PointPatternArray is equal to 2
				if (counter == 0) {		// Condition that checks if counter equal to 0
					lblGreenSection.setIcon(Assets.GreenBSection);		// Set Green Section to Bright Green color in the GUI - version
					DisplaySound();
					counter ++;		// increment counter by 1
				}
				
				else if(counter == 1) {		// Condition that checks if counter equal to 1
					lblGreenSection.setIcon(Assets.GreenSection);		// Set Green Section to Dim Green color in the GUI - version
					Counter ++;		// increment counter by 1
					counter = 0;	// set counter to 0
				}

			}
			
			
			else if (MatchGameMechanics.PointPatternArray.get(Counter) == 3){	// Condition that checks if the third element of the PointPatternArray is equal to 3
				if (counter == 0) {		// Condition that checks if counter equal to 0
					lblBlueSection.setIcon(Assets.BlueBSection);	// Set Blue Section to Bright Blue color in the GUI - version
					DisplaySound();
					counter ++;		// increment counter by 1
				}
				
				else if(counter == 1) {		// Condition that checks if counter equal to 1
					lblBlueSection.setIcon(Assets.BlueSection);		// Set Green Section to Dim Blue color in the GUI - version
					Counter ++;		// increment counter by 1
					counter = 0;	// set counter to 0
				}

			}
			
			
			else if(MatchGameMechanics.PointPatternArray.get(Counter) == 4) {	// Condition that checks if the fourth element of the PointPatternArray is equal to 4
				if (counter == 0) {		// Condition that checks if counter equal to 0
					lblYellowSection.setIcon(Assets.YellowBSection);	// Set Yellow Section to Bright Blue color in the GUI - version
					DisplaySound();
					counter ++;		// increment counter by 1
				}
				else if(counter == 1) {		// Condition that checks if counter equal to 1
					lblYellowSection.setIcon(Assets.YellowSection);		// Set Yellow Section to Dim Blue color in the GUI - version
					Counter ++;		// increment counter by 1
					counter = 0;	// set counter to 0
				}

			}

			
			if (Counter == MatchGameMechanics.PointPatternArray.size()) {	// Condition that checks if the first element of the PointPatternArray is equal to the PointPatternArray size
				Counter = 0;	// set Counter to 0
				counter =0;		// set counter to 0
				tickTock.stop();	// Stop Timer (tickTock)
				
				btnRed.setEnabled(true); 	// Enable Red button
				btnGreen.setEnabled(true);	// Enable Green button
				btnBlue.setEnabled(true);	// Enable Blue button
				btnYellow.setEnabled(true);	// Enable Yellow button
				
			}
			
			}
		
		}
		
			
		
	}

	
	
	


