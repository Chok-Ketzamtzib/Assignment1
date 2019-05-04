package tennisDatabase;

public class TennisMatch implements TennisMatchInterface {
	
	private String idPlayer1, idPlayer2, tournament, score;
	private int year, month, day, winner; 
	
	public TennisMatch(String idPlayer1, String idPlayer2, int year,
						int month, int day, String tournament, String score) { 
		
		this.idPlayer1 = idPlayer1;
		this.idPlayer2 = idPlayer2;
		this.year = year;
		this.month = month;
		this.day = day;
		this.tournament = tournament;
		this.score = score;
		
		try {
			
            this.winner = TennisMatchInterface.processMatchScore(this.score);

        } catch (TennisDatabaseRuntimeException e) {
            
        	throw new TennisDatabaseRuntimeException("Match creation failed: score invalid");
        
        }
	
	}
	
	//copy constructor from TennisPlayerContainerNode
    public TennisMatch(TennisMatch match) {
    	
        this.idPlayer1 = match.idPlayer1;
        this.idPlayer2 = match.idPlayer2;
        this.year = match.year;
        this.month = match.month;
        this.day = match.day;
        this.tournament = match.tournament;
        this.score = match.score;
        this.winner = match.winner;
    }
	
	
	@Override
	public int compareTo(TennisMatch inMatch) {
		 if (this.year > inMatch.year){
			 
	            return 1;
	            
	        } else if (this.year < inMatch.year) {
	            
	        	return -1;
	        
	        } else {
	            if (this.month > inMatch.month) {
	                
	            	return 1;
	            
	            } else if (this.month < inMatch.month) {
	            
	            	return -1;
	            
	            } else {
	            
	            	if (this.day > inMatch.day) {
	                
	            		return 1;
	                
	            	}
	                
	            	if (this.day < inMatch.day) {
	                
	            		return -1;
	                
	            	} else {
	                
	            		return 1;
	                
	            	}
	            }
	        }
	}
		 

	@Override
	public String getIdPlayer1() {

		return idPlayer1;
	}

	@Override
	public String getIdPlayer2() {
		
		return idPlayer2;
	}

	@Override
	public int getDateYear() {
		
		return year;
	}

	@Override
	public int getDateMonth() {

		return month;
	}

	@Override
	public int getDateDay() {

		return day;
	}

	@Override
	public String getTournament() {

		return tournament;
	}

	@Override
	public String getMatchScore() {

		return score;
	}

	@Override
	public int getWinner() {

		return winner;
	}

	public String printMatch() {
		
		return (String.format("%02d", year) + "/" + String.format("%02d", month) + "/" + String.format("%02d", day) + "," + " "
                + idPlayer1 + "-" + idPlayer2 + "," + " " + tournament + "," + " " + score);
	
	}
	
	

}
