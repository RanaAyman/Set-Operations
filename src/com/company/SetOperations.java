package com.company;

import java.util.ArrayList;
import java.util.Collections;


public class SetOperations {

    private int numberOfSets;
    // the whole sets we used U={Ahmed, Akram , Rana , Ayman}
    private ArrayList<String> universe;
    // the sets generator to make our ArrayList set
    private ArrayList<ArrayList<String>> sets;

    // constructor
    public SetOperations(ArrayList<String> universe, int numberOfSets, ArrayList<ArrayList<String>> sets){
        this.universe = universe;
        this.numberOfSets = numberOfSets;
        this.sets = sets;
    }

    // checker is boolean method checks that element is found in the required set or not
    private boolean checker(String element , ArrayList<String> set){
    	return set.contains(element);
    }

    // Union method return new set contains all strings in set1 and set2 without repetition
    public ArrayList<String> union(int a, int b){
        ArrayList<String> set1 = sets.get(a-1);
        ArrayList<String> set2 = sets.get(b-1);
        ArrayList<String> newSet = new ArrayList<>();
        for(String element : set1){
            newSet.add(element);
        }
        for(String element : set2){
            if(!checker(element,newSet)){
                newSet.add(element);
            }
        }
        Collections.sort(newSet);
        return newSet;
    }

    // Intersection method return new set that contains the common strings in the two sets
    public ArrayList<String> intersection(int a , int b){
        ArrayList<String> set1 = sets.get(a-1);
        ArrayList<String> set2 = sets.get(b-1);
        ArrayList<String> newSet = new ArrayList<>();
        for(String element : set1){
            if(checker(element,set2)){
                newSet.add(element);
            }
        }
        Collections.sort(newSet);
        return newSet;
    }

    // Complement return new set that contains all strings in universe except the strings in the provided set
    public ArrayList<String> complement(int a){
        ArrayList<String> set1 = sets.get(a-1);
        ArrayList<String> newSet = new ArrayList<>();
        for(String element : this.universe){
            if(!checker(element,set1)){
                newSet.add(element);
            }
        }
        Collections.sort(newSet);
        return newSet;
    }

}
