package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ReadData{
        //int test;
	private int numberOfSets;
	// the whole sets we used U={Ahmed, Akram , Rana , Ayman}
	private ArrayList<String> universe;
	// the sets generator to make our ArrayList set
	private ArrayList<ArrayList<String>> sets;

	// constructor
	public ReadData() {
		this.universe = new ArrayList<String>();
		this.numberOfSets = 0;
		this.sets = new ArrayList<ArrayList<String>>();
	}

	/*
	 * CreateSet method asks user for a list of strings (Universe or Subset of it)
	 * and stores it in an ArrayList. parameter Universe to differentiate between
	 * creation of universe set and subset of it true means creating universe set
	 * but false means creating subset.
	 */
	public ArrayList<String> CreateSet(boolean UniverseCheck) {
		System.out.println("Enter elements to be added to the set in one line format >> a,b,c,...");
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		String[] inputs = line.split("[\\s,]+");
		ArrayList<String> list = new ArrayList<String>();
		for (String str : inputs) {

			// check duplication or invalid elements.
			if (!list.contains(str) && !str.equals("")) {
				if (UniverseCheck) {
					list.add(str);
				} else {
					// check if element is in universe or not.
					if (universe.contains(str)) {
						list.add(str);
					} else {
						System.out.println("\"" + str + "\" is not exist in the universe so it won't be added! "
								+ "\nNote: You cannot add element that not exist in universe to a subsets");
					}
				}
			}
		}
		Collections.sort(list);
		return list;
	}

	/*
	 * addUniverse method gets universe from user and stores it in an Arraylist
	 * using CreateSet Method.
	 */
	public ArrayList<String> addUniverse() {
		System.out.println("Enter the universe set");
		universe = CreateSet(true);
		System.out.println("Universe set you added is :: " + universe);
		return universe;
	}

	/*
	 * addInputSets method gets number of subsets from user and stores them in an
	 * Arraylist of ArrayLists using CreateSet Method.
	 */
	public ArrayList<ArrayList<String>> addInputSets(int NumOfSets) {
		numberOfSets = NumOfSets;
		for (int i = 0; i < numberOfSets; i++) {
			System.out.println("Set number " + (i + 1) + " ::");
			sets.add(CreateSet(false));
		}
		System.out.println("Sets you added are :: ");
		for (ArrayList<String> list : sets) {
			System.out.println(list);
		}
		return sets;
	}
}
