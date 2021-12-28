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
        //Arrays to contain bit index values
        List<Integer> bitOne = new ArrayList<Integer>();
        List<Integer> bitTwo = new ArrayList<Integer>();
        List<Integer> bitThree = new ArrayList<Integer>();
        List<Integer> bitFour = new ArrayList<Integer>();
        List<Integer> bitFive = new ArrayList<Integer>();
        List<Integer> bitSix = new ArrayList<Integer>();
        List<Integer> bitSeven = new ArrayList<Integer>();
        List<Integer> bitEight = new ArrayList<Integer>();
        List<Integer> bitNine = new ArrayList<Integer>();
        List<Integer> bitTen = new ArrayList<Integer>();
        List<Integer> bitEleven = new ArrayList<Integer>();
        List<Integer> bitTwelve = new ArrayList<Integer>();
        //Array to contain Arrays
        List<List> arrayList = new ArrayList<>();
        arrayList.add(0, bitOne);
        arrayList.add(1, bitTwo);
        arrayList.add(2, bitThree);
        arrayList.add(3, bitFour);
        arrayList.add(4, bitFive);
        arrayList.add(5, bitSix);
        arrayList.add(6, bitSeven);
        arrayList.add(7, bitEight);
        arrayList.add(8, bitNine);
        arrayList.add(9, bitTen);
        arrayList.add(10, bitEleven);
        arrayList.add(11, bitTwelve);
        //Gamma and Epsilon arrays
        List<String> gamma = new ArrayList<String>();
        List<String> epsilon = new ArrayList<String>();

        try {
            scanner = new Scanner(new File("src/com/company/data.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found, please make sure path is correct.");
        }
        while (scanner.hasNext()) {
           String binaryNum = scanner.next();
           /*
           Places bits of binary nums in data into appropriate arrays (first bit goes into first array,
           second to second, et cetera) to determine dominant bit per position more easily
            */
           for (int i = 0; i < binaryNum.length() - 1; i++) {
               Character bitChar = binaryNum.charAt(i);
               Integer bitInt = Integer.parseInt(bitChar.toString());
               arrayList.get(i).add(bitInt);
           }
        }

        //Determine gamma and epsilon bit numbers
        for (int i = 0; i < arrayList.size(); i++) {
            List<Integer> bitArray = arrayList.get(i);
            int sumOfBits = bitArray.stream().mapToInt(Integer::intValue).sum();
            //If sum of bits is more than half the size, the dominant bit has to be 1
            if (sumOfBits > (bitArray.size() / 2)) {
                gamma.add("1");
                epsilon.add("0");
            } else {
                gamma.add("0");
                epsilon.add("1");
            }
        }

        //Create unified string from arrays
        String gammaString = String.join("", gamma);
        String epsilonString = String.join("", epsilon);
        //Convert from Binary String to Decimal int
        int gammaInt = Integer.parseInt(gammaString, 2);
        int epsilonInt = Integer.parseInt(epsilonString, 2);

        //Solution is 741950
        System.out.println(gammaInt * epsilonInt);
    }
}
