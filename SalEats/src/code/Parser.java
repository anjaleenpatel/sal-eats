package anjaleep_CSCI201_Assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;


public class Parser {
	public static void main(String[] args) {
		
		Gson gson = new Gson();
		double lon;
		double lat;
		double distance;
		
		
		Scanner inputo = new Scanner(System.in);
		
		System.out.print("What is your latitude?");
		lat = inputo.nextDouble();
		System.out.println();
		System.out.print("What is your longitude?");
		lon = inputo.nextDouble();
		System.out.println(); 
		
		//opening the file 
		Scanner input1 = new Scanner(System.in);
		String filename = " ";
		FileReader fr = null;
		Data data = null;
		String filename1 = " ";
		Scanner fr1 = null;

		while(true) {
			try { 
				System.out.print("What is the name of the restaurant file?");
				filename = input1.nextLine();
				fr = new FileReader(filename);
				data = gson.fromJson(fr, Data.class);
				break;
			} catch (FileNotFoundException e) { //not found
				// TODO Auto-generated catch block
				System.out.println("The file " + filename + " could not be found.");
				System.out.println();
				//e.printStackTrace();
			} catch (JsonParseException p) {
				System.out.println("The file " + filename + " is not formatted properly");
				System.out.println();
			}
			
		}
		
		for (int i = 0; i < data.getData().size(); i++) {
			data.getIndex(i).setSem();
		}
		
		//checking lat and long
	
		
		
		//System.out.println("The file has been properly read");
		System.out.println();
		
		while(true) {
			try {
				System.out.print("What is the name of the file containing the schedule information?");
				filename1 = input1.nextLine();
				fr1 = new Scanner(new File(filename1));
				
				while(fr1.hasNextLine()) {
					String input = fr1.nextLine();
					String[] parts = input.split(",");
					double dist = 0;
					Semaphore s = null;
					
					int r = Integer.parseInt(parts[0]); 
					String n = parts[1];
					String m = parts[2];
					
					for (int i = 0; i < data.getData().size(); i++) {
						if (data.getIndex(i).getName().trim().equals(n.trim())) {
							 dist = data.getIndex(i).calcDistance(lat, lon);
							 s = data.getIndex(i).getSem();
							 break;
						}
					}

					Order o = new Order(r, n, m, dist, s);
					o.start();
				}
				
				System.out.println();
				break;
			} catch (FileNotFoundException e) { //not found
				// TODO Auto-generated catch block
				System.out.println("The file " + filename1 + " could not be found.");
				System.out.println();
				//e.printStackTrace();
			} 
		}
		
	}	
}
