package TennisDatabase;

import java.io.*;
import java.util.*;

public class Assignment1
{
   public static void main(String[] args) throws Exception
   {
      //not used currently
      //TennisDatabase tbd = new TennisDatabase(); //create a new TennisDatabase object 
      
      String fileName = args[0]; //stores the file name in a local string
      
      loadFile(fileName); //read the file
      
      
      
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
         
         switch (dataArray[0])
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