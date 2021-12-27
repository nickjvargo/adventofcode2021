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
        //Start at one as this is first comparison
        for (int i = 1; i < data.size(); i++) {
            //If depth is greater than depth before it, increment solution
            if (data.get(i) > data.get(i-1)) {
                solution++;
            }
        }
        return solution;
    }
}
