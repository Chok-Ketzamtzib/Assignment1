/** 
* This file has the main method for executing the Tennis Database Program
* @project CS-102 Assignment 1
* @author William Wakefield
* @date 27 April 2019
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import tennisDatabase.TennisDatabase;
import tennisDatabase.TennisDatabaseException;
import tennisDatabase.TennisDatabaseRuntimeException;
import tennisDatabase.TennisPlayerContainerNode;

public class Assignment1 {
	// Console UI & File input/Loading
	public static void main(String[] args) {

		String data;

		// String fileName =
		// "C:\\\\Users\\\\jcsan_000\\\\Desktop\\\\Java_Files\\\\CS102_A1_Turini_Giuseppe\\\\cs102__assignment_01__example_data_file.txt";

		Scanner command = new Scanner(System.in);

		System.out.println("CS-102 Tennis Manager - Available commands:\n");

		System.out.println("1 --> print all tennis players");

		TennisDatabase data1 = new TennisDatabase();

		int commandInput;
		/*
		 * try { String fileName = args[0]; } catch (ArrayIndexOutOfBoundsException e) {
		 * System.out.println("ERROR: Please specify an input file in the command line"
		 * ); }
		 */

		try {
			data1.loadFromFile(args[0]);
		} catch (TennisDatabaseRuntimeException e) {
			System.out.println("...");
		} catch (TennisDatabaseException e) {
			System.out.println("...");
		}
		do {
			System.out.println("---------------------------------------------");
			System.out.println("	CS 102-01 Tennis Manager		 ");
			System.out.println("---------------------------------------------");
			System.out.println("Available Commands:\n");
			System.out.println("1 --> Print all tennis players");
			System.out.println("2 --> Print all tennis matches of a player");
			System.out.println("3 --> Print all tennis matches.");
			System.out.println("4 --> Insert a tennis player.");
			System.out.println("4 --> Insert a tennis match.");
			System.out.println("9 --> Exit\n");
			System.out.println("Enter your selection:");

			commandInput = command.nextInt();

			switch (commandInput) // Has methods for Tennis Program
			{
			case 1:
				System.out.println("You selected \"Print all tennis players.\"");
				try {
					data1.loadFromFile(args[0]);
				} catch (TennisDatabaseRuntimeException | TennisDatabaseException e1) {
					e1.printStackTrace();
				}
				break;
			case 2:
				System.out.println("You selected \"Print all tennis matches of a player.\"");
				System.out.println("Enter player id:");
				String idInput = command.next();
				try {
					data1.getMatchesOfPlayer(idInput);
				} catch (TennisDatabaseException e) {
					System.out.println("...");
				}
				// TODO: print all matches
				break;
			case 3:
				System.out.println("You selected \"Print all tennis matches.\"");
				break;
			case 4:
				System.out.println("You selected \"Insert a tennis player.\"");
				// TODO: Insert code
				break;
			case 5:
				System.out.println("You selected \"Insert a tennis match.\"");
				// TODO: Insert code
				break;
			case 9:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid input detected. Exiting...");
			}
		} while (commandInput != 9);

	}

}
