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

enum command 
{
   Invalid,       //default command
   Command1,      //Temp command
   Command2,      //...
   Command3,      //...
   Exit;          //Exit program
}

public class Assignment1
{
   public static void main(String[] args)
   {
      //not used currently
      //TennisDatabase tbd = new TennisDatabase(); //create a new TennisDatabase object 
      
      
      //File Loading
      
      try
      {
         String fileName = args[0]; //stores the file name in a local string
      }
      catch (ArrayIndexOutOfBoundsException e)
      {
         System.out.println("ERROR: Please enter a File in the command arguments.");
         System.exit(0);
      }
      
      try
      {
         loadFile(args[0]); //read the file
      }
      catch ( Exception e)
      {
         System.out.println("ERROR: File not found. Please enter valid file name");
         System.exit(0);
      }
      
      
      //User Interface
      
      Scanner consoleIn = new Scanner(System.in);  //scanner of console input
      
      command reqCmd = command.Invalid; //initialize command variable
      
      while( reqCmd != command.Exit )
      {
         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
         System.out.println("~                 Tyler's Tennis Database                  ~");
         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
         System.out.println("What would you like to do?:");
         System.out.println("1 - Command1");
         System.out.println("2 - Command2");
         System.out.println("3 - Command3");
         System.out.println("0 - Exit");
         System.out.print("Please enter a command: ");
         reqCmd = processInput(consoleIn.nextLine());
         
         //debug
         System.out.println(reqCmd);
         
      }
      
   } //main
   
   //This function processes the user console input for the UI
   static command processInput(String input)
   {
      int intcmd = Integer.parseInt(input);
      switch (intcmd)
      {
         case (0): return command.Exit;
         case (1): return command.Command1;
         case (2): return command.Command2;
         case (3): return command.Command3;
         default: return command.Invalid;
      }
   }
   
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
            
               String id = dataArray[1];
               String firstName = dataArray[2];
               String lastName = dataArray[3];
               int birthYear = Integer.parseInt(dataArray[4]);
               String country = dataArray[5];
               
               //object currently stored in a temporary location
               TennisPlayer tempPlayer = new TennisPlayer(id, firstName, lastName, birthYear, country);
               
            case("MATCH"):
               
               String player1 = dataArray[1];
               String player2 = dataArray[2];
               String date = dataArray[3];
               String location = dataArray[4];
               String scores = dataArray[5];

               //object currently stored in a temporary location
               TennisMatch tempMatch = new TennisMatch(player1, player2, date, location, scores);
            
            default:
               
         }
      }
      
   } //loadFile
}