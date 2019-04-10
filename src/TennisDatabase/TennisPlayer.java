package TennisDatabase;

import java.lang.Exception;

public class TennisPlayer //implements TennisPlayerInterface
{
   //class Properties
   private String id;
   private String firstName;
   private String lastName;
   private int birthYear;
   private String country;
   
   //constructor
   public TennisPlayer(String id, String firstName, String lastName, int birthYear, String country)
   {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.birthYear = birthYear;
      this.country = country;
   }
   
   //debug
   
   /*
   public String getFirstName()
   {
      return firstName;
   }
   */
/*

   ***This block is in case setters are needed for the constructor***

   //constructor
   public TennisPlayer(String[] playerData)
   {
      id = setId(playerData[1]);
      firstName = setFirstName(playerData[2]);
      lastName = setLastName(playerData[3]);
      birthYear = setBirthYear(Integer.parseInt(playerData[4]));
      country = setCountry(playerData[5]);
   }
   
   //setters
   
   private void setId(String id)
   {
      this.id = id;
   }//setId
   
   private void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }//setFirstName
   
   private void setLastName(String lastName)
   {
      this.lastName = lastName;
   }//setLastName
   
   private void setBirthYear(int birthYear)
   {
      this.birthYear = birthYear;
   }//setBirthYear
   
   private void setCountry(String country)
   {
      this.country = country;
   }//setCountry
*/
}