/*IMPORTING NECESSARY UTILITIES FOR THE GOOD RUNNING OF THE PROGRAM*/

import java.util.ArrayList;		// Imports ArrayList Utility for the use of ArrayList and related functionality to it
import java.util.Random;		// Imports Random Utility for the use of a sort Random method into the Program

import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;		// Imports ImageIcon Utility for the use of Images in the Assets class (png type)
import javax.swing.JOptionPane;		// Imports JOptionPane Utility for Input and output to and by the system

public class MatchGameMechanics  {

	
	// *******************************************************************************************************************************************************
	// Class                   :   	MatchGameMechanics.Java
	//
	// Method  parameters      :    void
	// 
	// Method return           :    void
	//
	// Synopsis                :    This class is responsible for the mechanics behind the Match Game 
	//								All data members found in this class are declared and some are instantiated in this section
	//                              
	// Modifications           :    
	//                              Date           Developer              Notes
	//                             ------         -----------            -------
	//                            2022-05-09      Larry Kemmo        Initial setup and commenting   
    //                                              
	//                                            
	//                                            
    //
	//*********************************************************************************************************************************************************
	
	private static String UserChoice;		// Data member declaration of UserChoice (String) 
	public static String ColorDisplay;		// Data member declaration ColorDisplay
	public static String ArrayColors[];		// static Array declaration ArrayColors[]
	public static ArrayList<Integer> PointPatternArray;		// Dynamic Array declaration PointPattternArray
	public static ArrayList<String> ColorDisplayed;		// Dynamic Array declaration ColorDisplayed
	public static ArrayList<String> PlayerChoice;		// Dynamic Array declaration PlayerChoice
	private static String PlayerName;		// Data member declaration PlayerName
	private static int Points = 10;		// Data member declaration Points (integer) instantiated to 10
	private static int PointsFinal = 0;		// Data member declaration PointsFinal (integer) instantiated to 0
	private static int CorrectPattern = 0;		// Data member declaration CorrectPattern (integer) instantiated to 0
	private static int Level = 1;			// Data member declaration Level (integer) instantiated to 1
	public static int NumberOfColorsDisplayed = 3;		// Data member declaration NumberOfColorsDisplayed (integer) instantiated to 3
	public static int Round = 1;		// Data member declaration Round (integer) instantiated to 1
//	private static int Counter = 2;
	public static int PointPattern = 0;  // Data member declaration PointPattern (integer) instantiated to 0
	private static int ButtonCounter = 0;		// Data member declaration ButtonCounter (integer) instantiated to 0
	

	private static Player playerObject = new PlayerAdvanced(1, 0, 1);
	
	public static void main(String[] args) {
	
		ArrayDeclaration();
		WelcomeMessage();
		GetName();
		DisplayColors();
//		PlayerInputPattern();
		Verification();
	}

	
	public static void ArrayDeclaration() {
		
		// *******************************************************************************************************************************************************
		// Method                  :    ArrayDeclartion
		//
		// Method  parameters      :    None
		// 
		// Method return           :    void
		//
		// Synopsis                :    This method Declares the Color Array, Color Displayed Array and the Player Choice Array
		//
		// Modifications           :    
		//                              Date           Developer              Notes
		//                             ------         -----------            -------
		//                  		  2022-05-09      Larry Kemmo  		Initial setup and commenting
        //
		//*********************************************************************************************************************************************************
		
		ArrayColors = new String[] {"Red", "Yellow", "Green", "Blue"};		// Instantiation of Array of colors
		ColorDisplayed = new ArrayList<String> ();							// Instantiation of Array of Color Displayed
		PlayerChoice = new ArrayList<String> ();							// Instantiation of Player Choice Array 
	}
	
	public static void WelcomeMessage() {
		
		//*******************************************************************************************************************************************************
		// Method                  :   	WelcomeMessage
		//
		// Method  parameters      :    None
		// 
		// Method return           :    void
		//
		// Synopsis                :    This method Displays Welcome Message
		//
		// Modifications           :    
		//                              Date           Developer              Notes
		//                             ------         -----------            -------
		//                  		  2022-05-09      Larry Kemmo  		Initial setup and commenting
        //
		//*********************************************************************************************************************************************************
	
		
		JOptionPane.showMessageDialog(null, "WELCOME TO MATCH GAME Version 1.0");		// System displays WELCOME TO MATCH GAME Version 1.0

		PointsFinal = playerObject.getScore();
		Level = playerObject.getLevel();
		Round = playerObject.getRound();
	}
	
	public static void GetName() {
		
		
				// *******************************************************************************************************************************************************
				// Method                  :    GetName
				//
				// Method  parameters      :    None
				// 
				// Method return           :    void
				//
				// Synopsis                :    This method Gets Player Name
				//
				// Modifications           :    
				//                              Date           Developer              Notes
				//                             ------         -----------            -------
				//                  		  2022-05-09      Larry Kemmo  		Initial setup and commenting
		        //
				//*********************************************************************************************************************************************************
				
		/*DO WHILE CONDITION ENSURING PLAYER NAME RESPECTS CONDITION BEFORE LEAVING THE METHOD*/
		do {
			
			PlayerName = JOptionPane.showInputDialog(null, "Please enter a less than 10 character Name");	//System Displays Please enter a less than 10 character Name and leaves room for Player to be able to enter his name
			
			if (PlayerName.length() > 10) { // Condition that ensures the Player name is not too long
				JOptionPane.showMessageDialog(null, "Error - Name too long");		// System displays Error - Name too long
			}
				
			if (PlayerName.length() > 1) {
				JOptionPane.showMessageDialog(null, "Nice!");		// System displays Nice
			//	MatchGame.dingSound.stop();
			}
			
		}while (PlayerName.length() > 10 ||  PlayerName.length() < 1);		// Condition that ensures that the length of the Name is between 1 and 10 before leaving the loop
		
		MatchGame.SetLblPlayerName(PlayerName);		// Set PlayerName to be visible in the MatchGame (GUI - version)
		MatchGame.PlayEnabled(false);		// Disables Play button at the end of the run of this method 
		
	}
	
	public static void DisplayColors() {
	
				// *******************************************************************************************************************************************************
				// Method                  :    DisplayColors
				//
				// Method  parameters      :    None
				// 
				// Method return           :    void
				//
				// Synopsis                :    This method Displays random colors between red, green, blue and yellow
				//
				// Modifications           :    
				//                              Date           Developer              Notes
				//                             ------         -----------            -------
				//                  		  2022-05-09      Larry Kemmo  		Initial setup and commenting
		        //
				//*********************************************************************************************************************************************************
				
        
		
		MatchGame.SetLevel(Level);		// Sets the level in which the Player is found in the MatchGame (GUI - Version)
		
		PointPatternArray = new ArrayList<>();		// Instantiation of Point Pattern Array
		
		int TempColor;			// declaration of variable TempColor
		int counter = 0;		// declaration of variable counter and instantiation to 0
		
		
		/*CONDITION WHICH ENSURES THAT THE NUMBER OF COLORS TO BE DISPLAYED PER LEVEL IS RESPECTED*/
		do {
			PointPattern = 0;		// Point Pattern instantiation to 0
			
			Random rand = new Random();			// Instantiates the random method
			TempColor = rand.nextInt(4);		// Randomizes the numbers between 0 to 4
			ColorDisplay = ArrayColors[TempColor];		// Instantiates ColorDisplay to the Color name stored under that index in the array
//			System.out.println(ColorDisplay);
			
			if (ColorDisplay == "Red") {		// Condition that checks if color displayed is Red

				PointPattern = 1;	// Setting of Point Pattern to 1
				
			}
			else if (ColorDisplay == "Green") {		// Condition that checks if color displayed is Green

				PointPattern = 2;	// Setting of Point Pattern to 2

			}
			else if (ColorDisplay == "Blue") {		// Condition that checks if color displayed is Blue

				PointPattern = 3;		// Setting of Point Pattern to 3

			}
			else if (ColorDisplay == "Yellow") {		// Condition that checks if color displayed is Yellow

				PointPattern = 4;			// Setting of Point Pattern to 4

			}
			
			PointPatternArray.add(PointPattern);	// For each color displayed, Stores Point Pattern in an array (PointPatternArray)		

			ColorDisplayed.add(ColorDisplay);		// For each color displayed, stores ColorDisplay in an array (ColorDisplayed)
			
			counter++;			//  increments counter that is used to keep track of number times color have been displayed
			
		} while (counter < NumberOfColorsDisplayed);		//  Condition that ensures that the Number of colors Displayed should not be more than required
	
		MatchGame.GenerateEnabled(false);			// Disable Generate button after displaying required number of colors
		

	}

	
	public static void Verification() {
		
		// *******************************************************************************************************************************************************
		// Method                  :   	Verification
		//
		// Method  parameters      :    None
		// 
		// Method return           :    void
		//
		// Synopsis                :    This method verifies if Color pattern input by the player is similar to the color pattern displayed on the screen
		//
		// Modifications           :    
		//                              Date           Developer              Notes
		//                             ------         -----------            -------
		//                  		  2022-05-09      Larry Kemmo  		Initial setup and commenting
        //
		//*********************************************************************************************************************************************************

		
		
		int counter;		// declaration of variable counter 
		
		for(counter = 0; counter < ColorDisplayed.size(); counter ++ ) {		// For loop that checks if the content of the ColorDisplayed Array is equal to that of the PlayerChoice Array
			
			if (PlayerChoice.get(counter) == ColorDisplayed.get(counter)) {		// Condition which ensures that if content of the ColorDisplayed Array is equal to that of the PlayerChoice Array CorrectPattern variable should be incremented by 1
				CorrectPattern += 1;	// CorrectPattern variable increment by 1
			}

		}
		
		
		if (CorrectPattern == ColorDisplayed.size()) {		// Condition that checks if the value of the CorrectPattern Variable is equal to the ColorDisplayed Array size
			JOptionPane.showMessageDialog(null, "The Color Pattern Entered is correct");		// System displays The Color Pattern Entered is correct
			PointsFinal += Points;		// PointsFinal is increased by the Value of Points
			MatchGame.WinSound();		// System plays win sound 
			Round ++;		// Round variable increments by 1
			playerObject.setRound(Round);
			JOptionPane.showMessageDialog(null, "Your points are " + PointsFinal);		// System displays Players Final points
			MatchGame.SetPoints(PointsFinal);		// System sets Player points visible in the (GUI - version) 
			
			if (Round > 1 && Round < 5) {		// Condition that checks if Round variable is between 1 and 5 exclusive
				Initialization2();		// System runs Initialization2 method

			}
			
			if (Round == 5) {		// Condition that checks if Round Variable is equal to 5
				Initialization();		// System runs Initialization method
				MatchGame.GenerateEnabled(true);	// Enables Generate button

			}

			
		}
		else {
			
			if (Level == 1) {		// Condition that checks if Level found  is equal to 1 
				
				JOptionPane.showMessageDialog(null, "Wrong Pattern");		// System displays Wrong Pattern
				PointsFinal -= Points * 2;	// PointsFinal decrements by the value of points * 2
				MatchGame.LoseSound();		// System calls Loss Sound

			}
			else {
				
				JOptionPane.showMessageDialog(null, "Wrong Pattern");		// System displays Wrong Pattern
				PointsFinal -= Points * 2;	// PointsFinal decrements by the value of points * 2
				MatchGame.LoseSound();		// System calls Loss Sound

			}

			JOptionPane.showMessageDialog(null, "Your points are " + PointsFinal);	// System displays Players Points
			MatchGame.SetPoints(PointsFinal);	// System sets player's points visible in the GUI - Version
			

			if (PointsFinal >= 0) {		// Condition that checks if Player points is greater than 0
				Initialization2();		// System runs Initialization method

			}
			
			else {
				MatchGame.GameOverSound();		// System plays GameOver sound
				JOptionPane.showMessageDialog(null, "GAMEOVER!!!");	// System displays GameOver
				MatchGame.GenerateEnabled(false);	// Disable Generate button
				JOptionPane.showMessageDialog(null, "Press the Restart button to Start new game");
				MatchGame.btnRestart.setEnabled(true);
				
			}

		}
		
	}
	
	public static void GameRestart() {
		Round = 1;		// Set Round to 1
		Level = 1;
		Points = 10;
		PointsFinal = 0;
		NumberOfColorsDisplayed = 3;	// Increment NumberOfColorsDisplayed variable
		CorrectPattern = 0;		// Set the Correct Pattern variable to 0
		PointPattern = 0;	// Set the Point Pattern variable to 0	
		Initialization2();		// System runs Initialization2 method
		MatchGame.btnRestart.setEnabled(false);
	}
	
	public static void Initialization() {
		
				// *******************************************************************************************************************************************************************
				// Method                  :   	Initialization
				//
				// Method  parameters      :    None
				// 
				// Method return           :    void
				//
				// Synopsis                :    This method sets ButtonCounter, ColorDisplayed Array, PlayerChoice Array, PointPattern Array, CorrectPattern and PointPattern to 0
				//
				// Modifications           :    
				//                              Date           Developer              Notes
				//                             ------         -----------            -------
				//                  		  2022-05-09      Larry Kemmo  		Initial setup and commenting
		        //
				//******************************************************************************************************************************************************************

		
		
		ButtonCounter = 0;	// reset ButtonCounter to 0

		do {
			ColorDisplayed.remove(0);		// Remove the first element in the ColorDisplayedArray
		}while(ColorDisplayed.size() > 0);		// Condition that ensures the action is performed (remove the first element of the ColorDisplayed Array ) so far as the Array size is greater than 0
		

		
		do {
			PlayerChoice.remove(0);			// Remove the first element in the PlayerChoiceArray
		}while(PlayerChoice.size() > 0);		// Condition that ensures the action is performed (remove the first element of the PlayerChoice Array ) so far as the Array size is greater than 0
	
		do {
			PointPatternArray.remove(0);	// Remove the first element in the PointPatternArray
		}while(PointPatternArray.size() > 0);	// Condition that ensures the action is performed (remove the first element of the PointPattern Array ) so far as the Array size is greater than 0
		
		
		Round = 1;		// Set Round to 1
		Level += 1;		
		MatchGame.SetLevel(Level);		// Sets the level in which the Player is found in the MatchGame (GUI - Version)
		playerObject.setLevel(Level);
		MatchGame.LevelWinSound();
		Points = Points * 2; // set the Points variable to the previous point value * 2   (COMMENTING IT OUT JUST FOR ASSIGNMENT 1B)
		playerObject.setScore(Points);
		NumberOfColorsDisplayed += 1;	// Increment NumberOfColorsDisplayed variable
		CorrectPattern = 0;		// Set the Correct Pattern variable to 0
		PointPattern = 0;	// Set the Point Pattern variable to 0	
	}
	
	public static void Initialization2() {
		
		// *******************************************************************************************************************************************************************
		// Method                  :   	Initialization2
		//
		// Method  parameters      :    None
		// 
		// Method return           :    void
		//
		// Synopsis                :    This method sets ButtonCounter, ColorDisplayed Array, PlayerChoice Array, PointPattern Array, CorrectPattern and PointPattern to 0
		//
		// Modifications           :    
		//                              Date           Developer              Notes
		//                             ------         -----------            -------
		//                  		  2022-05-09      Larry Kemmo  		Initial setup and commenting
        //
		//******************************************************************************************************************************************************************

		
		ButtonCounter = 0;		// reset ButtonCounter to 0
	
		do {
			ColorDisplayed.remove(0);		// Remove the first element in the ColorDisplayedArray
		}while(ColorDisplayed.size() > 0);		// Condition that ensures the action is performed (remove the first element of the ColorDisplayed Array ) so far as the Array size is greater than 0
		
		do {
			PlayerChoice.remove(0);			// Remove the first element in the PlayerChoiceArray
		}while(PlayerChoice.size() > 0);		// Condition that ensures the action is performed (remove the first element of the PlayerChoice Array ) so far as the Array size is greater than 0
		
		do {
			PointPatternArray.remove(0);	// Remove the first element in the PointPatternArray
		}while(PointPatternArray.size() > 0);	// Condition that ensures the action is performed (remove the first element of the PointPattern Array ) so far as the Array size is greater than 0

		
		CorrectPattern = 0;			// Set the Correct Pattern variable to 0
		PointPattern = 0;		// Set the Point Pattern variable to 0
		MatchGame.GenerateEnabled(true);	// Enable Generate button 

	}
	

	
	public static void Red() {
		
		// *******************************************************************************************************************************************************************
		// Method                  :   	Red
		//
		// Method  parameters      :    None
		// 
		// Method return           :    void
		//
		// Synopsis                :    This method increments ButtonCounter by 1 and disables Red, Green, Blue and Yellow button
		//
		// Modifications           :    
		//                              Date           Developer              Notes
		//                             ------         -----------            -------
		//                  		  2022-05-09      Larry Kemmo  		Initial setup and commenting
        //
		//******************************************************************************************************************************************************************

		
		ButtonCounter += 1;		// Increment ButtonCounter by 1
		
		UserChoice = "Red";		// set UserChoice variable to Red
		PlayerChoice.add(UserChoice);	// add UserChoice (Red) to the PlayerChoice Array
		
		if (ButtonCounter == NumberOfColorsDisplayed) {		// Condition that checks if ButtonCounter equals to NumberOfColorsDisplayed
			MatchGame.RedEnabled(false);			// Disable Red button
			MatchGame.GreenEnabled(false);			// Disable Green button
			MatchGame.BlueEnabled(false);			// Disable Blue button
			MatchGame.YellowEnabled(false);			// Disable Yellow button
			Verification();		// System runs the verification method

		}
	}
	public static void Green() {
		
				// *******************************************************************************************************************************************************************
				// Method                  :   	Green
				//
				// Method  parameters      :    None
				// 
				// Method return           :    void
				//
				// Synopsis                :    This method increments ButtonCounter by 1 and disables Red, Green, Blue and Yellow button
				//
				// Modifications           :    
				//                              Date           Developer              Notes
				//                             ------         -----------            -------
				//                  		  2022-05-09      Larry Kemmo  		Initial setup and commenting
		        //
				//******************************************************************************************************************************************************************

		
		ButtonCounter += 1;		// Increment ButtonCounter by 1
		
		UserChoice = "Green";		// set UserChoice variable to Green
		PlayerChoice.add(UserChoice);		// add UserChoice (Green) to the PlayerChoice Array
		
		if (ButtonCounter == NumberOfColorsDisplayed) {		// Condition that checks if ButtonCounter equals to NumberOfColorsDisplayed
			MatchGame.RedEnabled(false);		// Disable Red button
			MatchGame.GreenEnabled(false);		// Disable Green button
			MatchGame.BlueEnabled(false);		// Disable Blue button
			MatchGame.YellowEnabled(false);		// Disable Yellow button
			Verification();		// System runs the verification method

		}
	
	}
	public static void Blue() {
		
				// *******************************************************************************************************************************************************************
				// Method                  :   	Blue
				//
				// Method  parameters      :    None
				// 
				// Method return           :    void
				//
				// Synopsis                :    This method increments ButtonCounter by 1 and disables Red, Green, Blue and Yellow button
				//
				// Modifications           :    
				//                              Date           Developer              Notes
				//                             ------         -----------            -------
				//                  		  2022-05-09      Larry Kemmo  		Initial setup and commenting
		        //
				//******************************************************************************************************************************************************************

		
		ButtonCounter += 1;	 // Increment ButtonCounter by 1
		
		UserChoice = "Blue";	// set UserChoice variable to Blue
		PlayerChoice.add(UserChoice);	// add UserChoice (Blue) to the PlayerChoice Array
		
		if (ButtonCounter == NumberOfColorsDisplayed) {		// Condition that checks if ButtonCounter equals to NumberOfColorsDisplayed
			MatchGame.RedEnabled(false);		// Disable Red button
			MatchGame.GreenEnabled(false);		// Disable Green button
			MatchGame.BlueEnabled(false);		// Disable Blue button
			MatchGame.YellowEnabled(false);		// Disable Yellow button
			Verification();		// System runs the verification method
		}
	}
	public static void Yellow() {
		
				// *******************************************************************************************************************************************************************
				// Method                  :   	Yellow
				//
				// Method  parameters      :    None
				// 
				// Method return           :    void
				//
				// Synopsis                :    This method increments ButtonCounter by 1 and disables Red, Green, Blue and Yellow button
				//
				// Modifications           :    
				//                              Date           Developer              Notes
				//                             ------         -----------            -------
				//                  		  2022-05-09      Larry Kemmo  		Initial setup and commenting
		        //
				//******************************************************************************************************************************************************************

		
		ButtonCounter +=1;		// Increment ButtonCounter by 1
		
		UserChoice = "Yellow";		// set UserChoice variable to Yellow
		PlayerChoice.add(UserChoice);		// add UserChoice (Yellow) to the PlayerChoice Array
		
		if (ButtonCounter == NumberOfColorsDisplayed) {		// Condition that checks if ButtonCounter equals to NumberOfColorsDisplayed
			MatchGame.RedEnabled(false);	// Disable Red button
			MatchGame.GreenEnabled(false);	// Disable Green button
			MatchGame.BlueEnabled(false);	// Disable Blue button
			MatchGame.YellowEnabled(false);	// Disable Yellow button
			Verification();		// System runs the verification method

		}
	}
	
	
}	
