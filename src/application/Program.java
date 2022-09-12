package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Log;

public class Program {

	public static void main(String[] args) {
		List <Log> list = new ArrayList<>();
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter file full path: ");
			String path = sc.nextLine();
			try (BufferedReader br = new BufferedReader(new FileReader(path))) {
				String line = br.readLine();
				while (line != null) {
					String [] fields = line.split(" ");
					System.out.println(line);
					line = br.readLine();
				}
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
}