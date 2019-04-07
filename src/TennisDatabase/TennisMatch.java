package TennisDatabase;

class TennisMatch implements TennisMatchInterface
{
    private String idPlayer1;
    private String idPlayer2;
    private int year;
    private int month;
    private int day;
    private String tournament;
    private String score;
    public TennisMatch (String idPlayer1, String idPlayer2, int year, int month, int day, String tournament, String score)
    {
        this.idPlayer1 = idPlayer1;
        this.idPlayer2 = idPlayer2;
        this.year = year;
        this.month = month;
        this.day = day;
        this.tournament = tournament;
        this.score = score;
    }

    @Override
    public String getIdPlayer1()
    {
        return idPlayer1;
    }

    @Override
    public String getIdPlayer2()
    {
        return idPlayer2;
    }

    @Override
    public int getDateYear()
    {
        return year;
    }

    @Override
    public int getDateMonth()
    {
        return month;
    }

    @Override
    public int getDateDay()
    {
        return day;
    }

    @Override
    public String getTournament()
    {
        return tournament;
    }

    @Override
    public String getMatchScore()
    {
        return score;
    }

    @Override
    public int getWinner()
    {
        return 0;
    }

    @Override
    public void print()
    {

    }

    @Override
    public int compareTo(TennisMatch o)
    {
        return 0;
    }
}
