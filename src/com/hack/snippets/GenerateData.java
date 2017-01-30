package com.hack.snippets;

import com.hack.snippets.pjo.AbstractRosterEntity;
import com.hack.snippets.pjo.Course;
import com.hack.snippets.pjo.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by rafthab on 1/29/17.
 */
public class GenerateData {
    public static String singleQuote = "\'";
    public static String comma = ",";
    public static void main(String[] args) {
        GenerateData generateData = new GenerateData();
        List<AbstractRosterEntity> locations = generateData.generateLocations(10);
        List<AbstractRosterEntity> courses = generateData.generateCourses(50);
//        generateData.printList(locations);
        generateData.printList(courses);

    }

    public List generateCourses(int count) {
        List<AbstractRosterEntity> courses = new ArrayList<AbstractRosterEntity>();
        for(int i=0; i<count; i++) {
            Course course = new Course("COURSE-ID-" + String.valueOf(i), "course-" + String.valueOf(i), "course-name-" + String.valueOf(i), "LOC-ID-" + getRandomNum(0, 5), generateSource(), "INSTCOURSEID"+ String.valueOf(i));
            courses.add(course);
        }
        return courses;

    }

    public List generateLocations(int count) {
        List<Location> locations = new ArrayList<Location>();
        for(int i =0; i<count; i++) {
            Location location = new Location("LOC NAME "+ String.valueOf(i), generateSource(), "LOC-ID-" + String.valueOf(i), "INSTLOCID"+ String.valueOf(i));
            locations.add(location);
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

    private void printList(List<AbstractRosterEntity> toBePrinted) {
        for (AbstractRosterEntity printLine: toBePrinted
                )
            System.out.println(printLine.toSqlString());
    }
}
