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
   public TennisMatch(String player1, String player2, String date, String location, String scores)
   {
      this.player1 = player1;
      this.player2 = player2;
      this.date = date;
      this.location = location;
      this.scores = scores;
   }
}