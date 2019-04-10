package TennisDatabase;

public class TennisMatch
{
   //Class Properties
   private String player1;
   private String player2;
   private String date;
   private String location;
   private String scores;
   
   //constructor
   public TennisMatch(String[] matchData)
   {
      player1 = matchData[1];
      player2 = matchData[2];
      date = matchData[3];
      location = matchData[4];
      scores = matchData[5];
   }
}