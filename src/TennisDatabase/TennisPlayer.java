// Steven Causley
// CS-102, Spring 2019
// Assignment 1

package TennisDatabase;

public class TennisPlayer implements TennisPlayerInterface
{
    private String id;
    private String firstName;
    private String lastName;
    private int year;
    private String country;

    private int wins; //Read-only
    private int losses;//Read-only

    public TennisPlayer(String id, String firstName, String lastName, int year, String country)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.country = country;
    }

    @Override
    public String getId()
    {
        return id;
    }

    @Override
    public String getFirstName()
    {
        return firstName;
    }

    @Override
    public String getLastName()
    {
        return lastName;
    }

    @Override
    public int getBirthYear()
    {
        return year;
    }

    @Override
    public String getCountry()
    {
        return country;
    }


    @Override
    public int compareTo(TennisPlayer o)
    {
        return this.id.compareTo(o.id);
    }

    public void addWin()
    {
        wins += 1;
    } //increments wins by 1

    public void addLoss()
    {
        losses += 1;
    } //increments losses by 1

    public int getWins()
    {
        return wins;
    }

    public int getLosses()
    {
        return losses;
    }
}
