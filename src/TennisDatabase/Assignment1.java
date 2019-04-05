package TennisDatabase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Assignment1 {
	//Console UI & File input/Loading
	public static void main(String[] args) {
		
		String data;
		
		Scanner scan = new Scanner (System.in); //not used atm
		
		System.out.println("Press any key to print file output\n"); //might implement key-event later
		
		
		BufferedReader in; // Reads text from a character-input stream from File 
		try { 
			
			in = new BufferedReader(new FileReader(
			"C:\\Users\\jcsan_000\\Desktop\\Java_Files"
			+ "\\CS102_A1_Turini_Giuseppe\\cs102__assignment_01__example_data_file.txt"));
		
			while((data = in.readLine()) != null) { //while each line in the file has text
			    System.out.println(data);
			}
			
			in.close();
		
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} 
	}

}
