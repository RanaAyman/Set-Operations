package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private int numberOfSets;
//int test;
	public static void main(String[] args) {
		Main m = new Main();
		ReadData read = new ReadData();
		System.out.println("\t\t\tWelcome to set operations !!\n");
		ArrayList<String> universe = read.addUniverse();
		System.out.println("Enter the number of sets");
		Scanner scan = new Scanner(System.in);
		while (!scan.hasNextInt()) {
			System.out.println("Error , Please Enter the number of sets");
			scan = new Scanner(System.in);
		}
		m.numberOfSets = scan.nextInt();
		ArrayList<ArrayList<String>> sets = read.addInputSets(m.numberOfSets);
		SetOperations operation = new SetOperations(universe, m.numberOfSets, sets);

		while (true) {
			System.out.println(
					"You can do the following operations >> \"Choose the number corresponds to the operation you want\"");
			System.out.println("1- Union of two sets.\n" + "2- Intersection of two sets.\n" + "3- Complement of a set");
			System.out.println("To Exit Enter -1");
			scan = new Scanner(System.in);
			while (!scan.hasNextInt()) {
				System.out.println(
						"Error , Invalid choice !\nPlease choose the number corresponds to the operation you want");
				scan = new Scanner(System.in);
			}
			int choice = scan.nextInt();
			if (choice == -1)
				break;
			switch (choice) {
			case 1:
				System.out.println("Enter the numbers of sets to get their union");
				scan = new Scanner(System.in);
				int order1 = m.checkNumOfSet(scan.nextInt());
				scan = new Scanner(System.in);
				int order2 = m.checkNumOfSet(scan.nextInt());
				System.out.println("Union :: " + operation.union(order1, order2));
				break;
			case 2:
				System.out.println("Enter the numbers of sets to get their intersection");
				scan = new Scanner(System.in);
				order1 = m.checkNumOfSet(scan.nextInt());
				scan = new Scanner(System.in);
				order2 = m.checkNumOfSet(scan.nextInt());
				System.out.println("Intersection :: " + operation.intersection(order1, order2));
				break;
			case 3:
				System.out.println("Enter the number of the set to get it's complement");
				scan = new Scanner(System.in);
				int order = m.checkNumOfSet(scan.nextInt());
				System.out.println("Complement :: " + operation.complement(order));
				break;
			default:
				System.out.println(
						"Error , Invalid choice !\n Please choose the number corresponds to the operation you want");
			}
		}

	}

	// checkNumOfSet method checks that number of the set is valid and returns it's
	// number.
	private int checkNumOfSet(int numOfSet) {
		while (numOfSet < 1 || numOfSet > numberOfSets) {
			System.out.println("Invalid Number of set , Please Enter the correct number of set");
			Scanner S = new Scanner(System.in);
			numOfSet = S.nextInt();
		}
		return numOfSet;
	}
}
