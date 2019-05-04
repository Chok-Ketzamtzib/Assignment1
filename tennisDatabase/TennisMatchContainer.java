package tennisDatabase;

class TennisMatchContainer implements TennisMatchContainerInterface {

	private TennisMatch[] matchArray;
	private int matchCount; // # matches
	private int maxMatches = 2; // max # matches

	
	public TennisMatchContainer() {// constructor

		this.matchArray = new TennisMatch[2];
		this.matchCount = 0;
	}

	@Override
	public void insertMatch(TennisMatch m) throws TennisDatabaseException {

		if (this.matchCount == maxMatches) { // array full
			
			TennisMatch[] newArray = new TennisMatch[this.matchArray.length + 100]; // doubles size of original
																					// TennisMatch array object

			for (int i = 0; i < this.matchCount; i++) {

				newArray[i] = this.matchArray[i];

			}

			this.matchArray = newArray; // from for loop which created the new array with doubled length. set new array
										// as matchArray
			this.maxMatches = this.matchArray.length; // Now max number of matches is set to new length

		}

		else { // if array is not full
			int point = 0;
	        while ((point < this.matchCount) && (this.matchArray[point].compareTo(m) > 0)) {
	            point++;
	        }
	        if (point < this.matchCount) {
	            for (int i = this.matchCount - 1; i >= point; i--) {
	                this.matchArray[i + 1] = this.matchArray[i];
	            }
	        }
	        this.matchArray[point] = m;
	        this.matchCount++;
		}
	}

	@Override
	public TennisMatch[] getAllMatches() throws TennisDatabaseRuntimeException {
		return matchArray;
	}

	@Override
	public TennisMatch[] getMatchesOfPlayer(String playerId) throws TennisDatabaseException {
		 int matches = 0;
	        for (int i = 0; i< this.matchCount; i++) {
	        	TennisMatch array = matchArray[i]; //goes directly to reference in virtual machine rather than actual machine i.e. does not search through array but the reference
	            if (array.getIdPlayer1().equals(playerId) || array.getIdPlayer2().equals(playerId)) {
	                matches++;
	            }
	        }
	        
	        TennisMatch[] output = new TennisMatch[matches];
	        int outputIndex = 0;
	        for (int i =0; i < matchArray.length; i++) {
	        	TennisMatch array = matchArray[i]; 
	            if (array.getIdPlayer1().equals(playerId) || array.getIdPlayer2().equals(playerId)) {
	                output[outputIndex] = matchArray[i];
	                outputIndex++;
	            }
	        }

	        return output;
	}
	
	public int getMatchCount() {
		
		return matchCount;
	
	}
}
