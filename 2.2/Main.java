package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Scanner to read data
        Scanner scanner = null;
        //Arrays to contain depth and horizontal numbers
        List<Integer> depth = new ArrayList<Integer>();
        List<Integer> horizontalDistance = new ArrayList<Integer>();
        //Chars to match if direction is forward, up, or down
        char forward = 'f';
        char up = 'u';
        char down = 'd';
        //Aim as defined in problem
        int aim = 0;

        try {
            scanner = new Scanner(new File("src/com/company/data.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found, please make sure path is correct.");
        }
        while (scanner.hasNext()) {
            String command = scanner.next();
            char direction = command.charAt(0);
            Integer units = scanner.nextInt();
            //Switch case to evaluate commands and add to appropriate arrays
            switch (direction) {
                case 'f':
                    horizontalDistance.add(units);
                    depth.add(aim*units);
                    break;
                case 'u':
                    aim -= units;
                    break;
                case 'd':
                    aim += units;
                    break;
                default:
                    System.out.println("Unknown command entered.");
                    break;
            }
        }

        int totalHorizontalDistance = horizontalDistance.stream().mapToInt(Integer::intValue).sum();
        int totalDepth = depth.stream().mapToInt(Integer::intValue).sum();

        //Solution is 2078985210
        System.out.println(totalDepth * totalHorizontalDistance);
    }
}
