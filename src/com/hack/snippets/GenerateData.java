package com.hack.snippets;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by rafthab on 1/29/17.
 */
public class GenerateData {
    private static String singleQuote = "\'";
    private static String comma = ",";
    public static void main(String[] args) {
        GenerateData generateData = new GenerateData();
        List<String> locations = generateData.generateLocations(10);
        List<String> courses = generateData.generateCourses(50);
        generateData.printList(courses);

    }

    public List generateCourses(int count) {
        List<String> courses = new ArrayList<String>();
        for(int i=0; i<count; i++) {
            String data = new String();
            data += GenerateData.singleQuote + "COURSE-ID-" + String.valueOf(i) + GenerateData.singleQuote + GenerateData.comma;
            data += GenerateData.singleQuote + "course-" + String.valueOf(i) + GenerateData.singleQuote + GenerateData.comma;
            data += GenerateData.singleQuote + "course-name-" + String.valueOf(i) + GenerateData.singleQuote + GenerateData.comma;
            data += GenerateData.singleQuote + "LOC-ID-" + getRandomNum(0, 5) + GenerateData.singleQuote + GenerateData.comma;
            data += GenerateData.singleQuote + generateSource() + GenerateData.singleQuote + GenerateData.comma;
            data += GenerateData.singleQuote + "INSTCOURSEID"+ String.valueOf(i) + GenerateData.singleQuote;
            courses.add(data);
        }
        return courses;

    }

    public List generateLocations(int count) {
        List<String> locations = new ArrayList<String>();
        for(int i =0; i<count; i++) {
            String data = new String();
            data += GenerateData.singleQuote + "LOC-ID-" + String.valueOf(i) + GenerateData.singleQuote + GenerateData.comma;
            data += GenerateData.singleQuote + "LOC NAME "+ String.valueOf(i) + GenerateData.singleQuote + GenerateData.comma;
            data += GenerateData.singleQuote + generateSource() + GenerateData.singleQuote + GenerateData.comma;
            data += GenerateData.singleQuote + "INSTLOCID"+ String.valueOf(i) + GenerateData.singleQuote;
            locations.add(data);
        }
        return locations;
    }

    private String generateSource() {
        String[] source = {"Manual","CSV"};
        int index;
        index = getRandomNum(0,2);
        return source[index];
    }

    private int getRandomNum(int start, int end) {
        Random rn = new Random();
        return Math.abs(rn.nextInt()) % (end - start);
    }

    private void printList(List<String> toBePrinted) {
        for (String printLine: toBePrinted
                )
            System.out.println(printLine);
    }
}
