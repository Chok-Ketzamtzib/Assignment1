/** 
* This file has the main method for executing the Tennis Database Program
* @project CS-102 Assignment 1
* @author William Wakefield
* @date 27 April 2019
*/

import java.util.Scanner;
import tennisDatabase.TennisDatabase;
import tennisDatabase.TennisDatabaseException;
import tennisDatabase.TennisDatabaseRuntimeException;
import tennisDatabase.TennisMatch;

public class Assignment1 {
	// Console UI & File input/Loading
	public static void main(String[] args) {

		Scanner command = new Scanner(System.in);

		TennisDatabase database = new TennisDatabase();

		int commandInput;

		try {
			database.loadFromFile(args[0]);
		} catch (TennisDatabaseRuntimeException e) {
			System.out.println("Argument 0 is not configured correctly in your IDE or File is misplaced in worong directory");
		} catch (TennisDatabaseException e) {
			System.out.println("Argument 0 is not configured correctly in your IDE or File is misplaced in worong directory");
		}
		do {
			System.out.println();
			System.out.println("---------------------------------------------");
			System.out.println("	CS 102-01 Tennis Manager 	 ");
			System.out.println("---------------------------------------------\n");
			System.out.println("Available Commands:\n");
			System.out.println("1 --> Print all tennis players");
			System.out.println("2 --> Print all tennis matches of a player");
			System.out.println("3 --> Print all tennis matches.");
			System.out.println("4 --> Insert a tennis player.");
			System.out.println("5 --> Insert a tennis match.");
			System.out.println("9 --> Exit\n");
			

			commandInput = safeIntCommandLine(command);

			switch (commandInput) // Has methods for Tennis Program
			{
			case 1:
				System.out.println("You selected \"Print all tennis players.\"");
				try {
					String[] playerOutputArray = database.getPlayerStringArray(); //array of tennis play strings
                    for (int i = 0; i < playerOutputArray.length; i++)
                    {
                        System.out.println(playerOutputArray[i]);
                    }
				} catch (TennisDatabaseRuntimeException e1) {
					e1.printStackTrace();
				}
				break;
			case 2:
				System.out.println("You selected \"Print all tennis matches of a player.\"");
				System.out.println("Enter player id:");
				String idInput = command.next();
				 try {
                     String[] playerMatchStringArray = database.getMatchesOfPlayerString(idInput); //array of match strings

                     for (int i = 0; i < playerMatchStringArray.length; i++) {
                         System.out.println(playerMatchStringArray[i]);
                     }

                 } catch (TennisDatabaseRuntimeException e) {
                     System.out.println("Could not print matches for id: " + idInput);
                 }
				break;
			case 3:
				System.out.println("You selected \"Print all tennis matches.\"");
				TennisMatch[] matchArray = database.getAllMatches(); //array of match strings
                try {
                    if (database.getMatchCount() == 0) {
                        System.out.println("No Matches in System");
                    } else {
                        for (int i = 0; i < matchArray.length; i++) {
                            System.out.println(matchArray[i].printMatch());
                        }
                    }
                } catch (NullPointerException e) { 
                	//do nothing with empty array spaces
                }
				break;
			case 4:
				System.out.println("You selected \"Insert a tennis player.\"");
				System.out.println("Input player id:");
                String newId = command.next();
                System.out.println("Input first name:");
                String newFirstName = command.next();
                System.out.println("Input last name:");
                String newLastName = command.next();
                int newBirthYear = safeInt(command);
                System.out.println("Input country:");
                String newCountry = command.next();
                System.out.println("Adding player...");
                
                try {
					database.insertPlayer(newId, newFirstName, newLastName, newBirthYear, newCountry);
				} catch (TennisDatabaseException e1) {
					e1.printStackTrace();
				}
                
				break;
			case 5:
				System.out.println("You selected \"Insert a tennis match.\"");
				System.out.println("Input player 1 id:");
                String newId1 = command.next();
                System.out.println("Input player 2 id:");
                String newId2 = command.next();
                System.out.println("Input year of match");
                int newYear = safeYear(command);
                System.out.println("Input month of match");
                int newMonth = safeMonth(command);
                System.out.println("Input day of match");
                int newDay = safeDay(command);
                System.out.println("Input tournament name:");
                String newName = command.nextLine();
                System.out.println("Input scores, separated by commas:");
                String newScore = command.next();
                System.out.println("Adding match...");
                
                try {
					database.insertMatch(newId1, newId2, newYear, newMonth, newDay, newName, newScore);
				} catch (TennisDatabaseException e) {
					e.printStackTrace();
				}
                
                System.out.println("Match Added Successfully");
				break;
			case 9:
				System.out.println("Exiting...");
				command.close();
				break;
			default:
				System.out.println("command not found. Please try again or refer to \"ReadMe.txt\" for help");
			}
		} while (commandInput != 9);

	}
	
	public static int safeDay(Scanner sc) {
		int rtrn = 0;
		boolean searching = true;
		while(searching) {
			try{
				rtrn = Integer.parseInt(sc.nextLine());
				searching = false;
			} catch(NumberFormatException e) {
				System.out.println("Invalid input: Day must be a one or two digit number\n" + "Input day of match: ");
			}
		}
		return rtrn;
	}
	
	public static int safeMonth(Scanner sc) {
		int rtrn = 0;
		boolean searching = true;
		while(searching) {
			try{
				rtrn = Integer.parseInt(sc.nextLine());
				searching = false;
			} catch(NumberFormatException e) {
				System.out.println("Invalid input: month must be a one or two digit number\n" + "Input month of match: ");
			}
		}
		return rtrn;
	}
	
	public static int safeYear(Scanner sc) {
		int rtrn = 0;
		boolean searching = true;
		while(searching) {
			try{
				rtrn = Integer.parseInt(sc.nextLine());
				searching = false;
			} catch(NumberFormatException e) {
				System.out.println("Invalid input: year must be a 4-digit number\n" + "Input year of match: ");
			}
		}
		return rtrn;
	}
	
	public static int safeInt(Scanner sc) {
		System.out.println("Input birth year: ");
		sc.nextLine();
		int rtrn = 0;
		boolean searching = true;
		while(searching) {
			try{
				rtrn = Integer.parseInt(sc.nextLine());
				searching = false;
			} catch(NumberFormatException e) {
				System.out.println("Invalid input: birth year mus be a number\n" + "Input birth year");
			}
		}
		return rtrn;

	}
	
	public static int safeIntCommandLine(Scanner sc) {
		System.out.println("Enter your selection:");
		int rtrn = 0;
		boolean searching = true;
		while(searching) {
			try{
				rtrn = Integer.parseInt(sc.nextLine());
				searching = false;
			} catch(NumberFormatException e) {
				System.out.println("Invalid input: Please select one of the listed commands\n" + "Enter your selection: ");
			}
		}
		return rtrn;

	}
	

}
