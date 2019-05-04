package tennisDatabase;

public class TennisPlayer implements TennisPlayerInterface {

	private String id, firstName, lastName, country;
	private int year;
	
	private int wins; //Read-only
    private int losses;//Read-only

	public TennisPlayer(String id, String firstName, String lastName, int year, String country) {

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.year = year;
		this.country = country;
	}

	@Override
	public int compareTo(TennisPlayer arg0) {//arg0 is left from original interfaces
			
		return this.id.compareTo(arg0.id);
	}

	@Override
	public String getId() {

		return id;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public int getBirthYear() {
		return year;
	}

	@Override
	public String getCountry() {
		return country;
	}

	public int getWins() {
	    return wins;
	}

	public int getLosses() {
		return losses;
	}
	    
	public void addWin() {//increments wins by 1
        wins += 1;
    } 

    public void addLoss() {//increments losses by 1 
        losses += 1;
    } 

}
