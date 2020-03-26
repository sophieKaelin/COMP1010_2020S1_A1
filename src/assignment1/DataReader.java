//DO NOT MODIFY THIS FILE

package assignment1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class DataReader {	
	public static String[] readData(String filename) throws FileNotFoundException {
		System.out.println("Getting data from "+filename);//Pass 1: count records
		Scanner scanner = new Scanner(new FileReader(filename));
		scanner.nextLine(); //ignore the header
		int count = 0;
		while(scanner.hasNextLine()) {
			scanner.nextLine();
			count++;
		}

		//Pass 2: populate records
		String[] records = new String[count]; 
		scanner = new Scanner(new FileReader(filename));
		scanner.nextLine(); //ignore header
		for(int i=0; i < records.length; i++) { //since we ignored header row
			records[i] = scanner.nextLine();
		}
		scanner.close();
		//Arrays.stream(records).forEach(r -> System.out.println(r));
		return records;
	}
	
	public static int[] getWeights(String filename) throws FileNotFoundException {
		Scanner scanner = new Scanner(new FileReader(filename));
		String header = scanner.nextLine(); 
		String[] tokens = header.split(",+");
		int[] weights = new int[tokens.length - 4]; //first 4 columns  are not question details
		for(int i=4; i < tokens.length; i++) {
			String[] s = tokens[i].split("/");
			weights[i-4] = Integer.parseInt(s[1]);
		}
		scanner.close();
		return weights;
	}
}
