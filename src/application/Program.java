package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.Log;

public class Program {

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter file full path: ");
			String path = sc.nextLine();
			try (BufferedReader br = new BufferedReader(new FileReader(path))) {
				Set <Log>set = new HashSet<>();
				String line = br.readLine();
				while (line != null) {
					String [] fields = line.split(" ");
					Date date = Date.from(Instant.parse(fields[1]));
							set.add(new Log (fields[0],date));
							line = br.readLine();
					}
				
					
					System.out.println("Total users: " + set.size());
				}
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
