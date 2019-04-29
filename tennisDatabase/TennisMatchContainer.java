package tennisDatabase;

public class TennisMatchContainer implements TennisMatchContainerInterface {

	private TennisMatch[] matchArray;
	private int matchCount; // # matches
	private int maxMatches = 2; // max # matches

	// constructor
	public TennisMatchContainer() {

		this.matchArray = new TennisMatch[2];
		this.matchCount = 0;
	}

	@Override
	// TODO: Get Match container integrated with TennisMatch
	public void insertMatch(TennisMatch m) throws TennisDatabaseException {

		if (this.matchCount == maxMatches) { // array full

			// throw new TennisDatabaseException("ERROR: Container full, cannot insert
			// match.");
			TennisMatch[] newArray = new TennisMatch[this.matchArray.length * 2]; // doubles size of original
																					// TennisMatch array object

			for (int i = 0; i < this.matchCount; i++) {

				newArray[i] = this.matchArray[i];

			}

			this.matchArray = newArray; // from for loop which created the new array with doubled length. set new array
										// as matchArray
			this.maxMatches = this.matchArray.length; // Now max number of matches is set to new length

		}

		else { // if array is not full

			this.matchArray[this.matchCount] = m;
			this.matchCount++;
			System.out.println("MATCH LOADED");

		}
	}

	@Override
	public TennisMatch[] getAllMatches() throws TennisDatabaseRuntimeException {
		// TODO Auto-generated method stub
		return matchArray;
	}

	@Override
	public TennisMatch[] getMatchesOfPlayer(String playerId) throws TennisDatabaseException {
		// TODO Auto-generated method stub
		return new TennisMatch[0]; // new object of TennisMatch Array
	}

}
