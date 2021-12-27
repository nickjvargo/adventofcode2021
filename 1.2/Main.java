package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Boring set-up, using Scanner to read data.txt file and create ArrayList
        Scanner scanner = null;
        List<Integer> data = new ArrayList<Integer>();
        try {
            scanner = new Scanner(new File("src/com/company/data.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found, please make sure path is correct.");
        }
        while (scanner.hasNext()) {
            Integer integer = Integer.parseInt(scanner.next());
            data.add(integer);
        }
        //To see solution
        System.out.println(solution(data));
    }

    //Meat and potatoes!
    public static Integer solution(List<Integer> data) {
        Integer solution = 0;
        Integer currentThree = 0;
        Integer nextThree = 0;
        int placeInArray = 0;
        //While placeInArray is 3 away from last data point
        while (placeInArray < data.size() - 3) {
            //Sum currentThree
            currentThree = data.get(placeInArray) + data.get(placeInArray + 1) + data.get(placeInArray + 2);
            //Increment by one to start new set of three
            placeInArray += 1;
            //Sum nextThree
            nextThree = data.get(placeInArray) + data.get(placeInArray + 1) + data.get(placeInArray + 2);
            if (nextThree > currentThree) {
                solution++;
            }
        }
        //Solution is 1706
        return solution;
    }
}
