/*
CS-102
Winter 2019
Tyler Barnes
Assignment1
*/




//import TennisDatabase.TennisDatabase;
//import TennisDatabase.TennisDatabaseException;
//import TennisDatabase.TennisDatabaseRuntimeException;
import TennisDatabase.TennisPlayer;
import TennisDatabase.TennisMatch;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Assignment1
{
   public static void main(String[] args)
   {
      //not used currently
      //TennisDatabase tbd = new TennisDatabase(); //create a new TennisDatabase object 
      
      try
      {
         String fileName = args[0]; //stores the file name in a local string
      }
      catch (ArrayIndexOutOfBoundsException e)
      {
         System.out.println("ERROR: Please enter a File in the command arguments.");
         System.exit(0);
      }
      //try
      //{
         loadFile(fileName); //read the file
      //}
      //catch ( FileNotFoundException e)
      //{
      //   System.out.println("ERROR: File not found. Please enter a valid file name");
      //   System.exit(0);
      //}
      
      
   } //main
   
   //This function reads the input file and creates objects to hold the data
   static void loadFile(String fileName) throws Exception
   {
      File inFile = new File(fileName); //create a File object
      
      Scanner in = new Scanner(inFile); //Create scanner to read file
      
      while (in.hasNextLine())
      {
         String textLine = in.nextLine(); //read a line from the file
         
         String[] dataArray = textLine.split("/"); //split the data into an array
         
         switch (dataArray[0].toUpperCase())
         {
            case("PLAYER"):
            
               //object currently stored in a temporary location
               TennisPlayer tempPlayer = new TennisPlayer(dataArray);
               
            case("MATCH"):
               
               //object currently stored in a temporary location
               TennisMatch tempMatch = new TennisMatch(dataArray);
            
            default:
               
         }
      }
      
   } //loadFile
}