
// Player Class


public class Player {

	    private int level;	// Data member declaration of Level (integer)
	    private int score;	// Data member declaration of score (integer)
	    private int Round;	// Data member declaration of Round (integer)
	    
	    public Player( int tempLevel, int tempScore ) {	// Constructor for player class
	        this.level = tempLevel;		// Assigning the variable level to a temporary integer variable (tempLevel)
	        this.score = tempScore;		// Assigning the variable score to a temporary integer variable (tempScore)
	    }

	    public int getLevel() {
	    	// Getter for the Level data member
	    	return level;		// return statement	for level
	    }

	    public void setLevel(int level) {
	    	// Setter for the level data memeber
	    	this.level = level;		// Assigning the variable level to a temporary integer variable (level)
	    }

	    public int getScore() {
	    	// Getter for the score data member
	    	return score;		// return statement for score
	    }

	    public void setScore(int score) {
	    	// Setter for the score data memeber
	    	this.score = score;		// Assigning the variable score to a temporary integer variable (score)
	    }
		
	    public int getRound() {
	    	// Getter for the Round data member
	        return Round;		// return statement for Round
	    }
	
	    public void setRound(int Round) {
	    	// Setter for the Round data memeber
	    	this.Round = Round;		// Assigning the variable Round to a temporary integer variable (Round)
	    }
}
