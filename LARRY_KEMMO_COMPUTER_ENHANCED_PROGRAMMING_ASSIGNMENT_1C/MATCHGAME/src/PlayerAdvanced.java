// PlayerAdanced Class

public class PlayerAdvanced extends Player {

	private int Round;		// Data member declaration of Round (integer)

	
	public PlayerAdvanced(int tempLevel, int tempScore, int TempRound) {
		super(tempLevel, tempScore);	// Constructor for player advanced (Inheritance to the Player class)
		
		this.Round = TempRound;		// Assigning the variable Round to a temporary integer variable (TempRound)
		
	}

	public int getRound() {
	// Getter for the Round data member
		return Round;	// return statement Round
	}
	
	public void setRound(int Round) {
		// Setter for the Round data memeber
		this.Round = Round;		// Assigning the variable Round to a temporary integer variable (Round)
	}
}
