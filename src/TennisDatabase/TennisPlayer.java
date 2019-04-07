package TennisDatabase;

class TennisPlayer implements TennisPlayerInterface
{
    private String id;
    private String firstName;
    private String lastName;
    private int year;
    private String country;
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
    public void print()
    {

    }

    @Override
    public int compareTo(TennisPlayer o)
    {
        return 0;
    }
}
