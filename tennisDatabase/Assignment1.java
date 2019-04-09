import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Assignment1 {
	//Console UI & File input/Loading
	public static void main(String[] args) {
		
		String data;
		String fileName = "C:\\\\Users\\\\jcsan_000\\\\Desktop\\\\Java_Files\\\\CS102_A1_Turini_Giuseppe\\\\cs102__assignment_01__example_data_file.txt";
		
		Scanner scan = new Scanner (System.in); 
		
		System.out.println("CS-102 Tennis Manager - Available commands:\n");
		
		System.out.println("1 --> print all tennis players"); 
		
		TennisDatabase data1 = new TennisDatabase();
		
		int commandInput = scan.nextInt();
		
		if (commandInput == 1) {
			try {
				data1.loadFromFile(fileName);
			} catch (TennisDatabaseRuntimeException | TennisDatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Done with program"); //temp solution
		}
		
		
		
	}

}
