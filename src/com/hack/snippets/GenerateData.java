package com.hack.snippets;

import com.hack.snippets.pjo.*;

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
        List<AbstractRosterEntity> locations = generateData.generateLocations(5);
        List<AbstractRosterEntity> courses = generateData.generateCourses(50);
        List<AbstractRosterEntity> persons = generateData.generatePersons(50, 10);

//        generateData.printList(locations);
//        generateData.printList(courses);
//        generateData.printList(persons);
        List<AbstractRosterEntity> classes = generateData.generateClasses( courses, persons, 50);
        List<AbstractRosterEntity> rosters = generateData.generateRosters(classes, persons.size(), classes.size()*3, classes.size());
        generateData.printList(rosters);
//        generateData.printList(classes);

    }

    public List generateRosters(List<AbstractRosterEntity> courses, int personSize, int count, int batch) {
        List<AbstractRosterEntity> rosters = new ArrayList<AbstractRosterEntity>();
        for(int i=0; i< count; i++) {
            for(int j=0; j<batch; j++) {
                Rosters roster = new Rosters("ROSTER-ID-"+String.valueOf(i), "CLASS-ID-" + String.valueOf(j), "PERSON-ID-"+String.valueOf(getRandomNum(1, personSize)), generateSource(),
                        "INSTROSTERID"+ String.valueOf(i));
                rosters.add(roster);
                i++;
            }
        }
        return rosters;
    }
    public List generateClasses(List<AbstractRosterEntity> courses, List<AbstractRosterEntity> persons, int count) {
        List<AbstractRosterEntity> classes = new ArrayList<AbstractRosterEntity>();
        for(int i = 0; i<count; i++) {
            int numberofInstructors = getRandomNum(1,3);
            List<String> instructors = new ArrayList<String>();
            for(int j=1; j<=numberofInstructors; j++) {
                instructors.add(persons.get(j-1).getUnique_identifier());
            }
            for(int j=numberofInstructors; j<3; j++) {
                instructors.add(null);
            }
            Course course = (Course) courses.get(i);
            com.hack.snippets.pjo.Class class1 = new com.hack.snippets.pjo.Class("CLASS-ID-"+String.valueOf(i), "class-" + String.valueOf(i), course, instructors, course.getLocation_id(),
                    generateSource(), "INSTCLASSID"+ String.valueOf(i));
            classes.add(class1);
        }
        return classes;
    }

    public List generatePersons(int count, int batch) {
        List<AbstractRosterEntity> persons = new ArrayList<AbstractRosterEntity>();
        for(int i=0; i< count; i++) {
            for(int j=0; j<batch; j++) {
                Person person;
                if(i % 10 < 3) {
                    person = new Person("PERSON-ID-"+String.valueOf(i), "person-" + String.valueOf(i), "person-name-" + String.valueOf(i), "person-middle-" + String.valueOf(i), "person-last-" + String.valueOf(i),
                            null, "person-name-" + String.valueOf(i)+ "@mitest.org", "person-name-" + String.valueOf(i) + "_student", String.valueOf(getRandomNum(0,9)+1),
                            "LOC-ID-" + getRandomNum(0, 5), generateSource(), "INSTPERSONID"+ String.valueOf(i));
                }else {
                    person = new Person("PERSON-ID-"+String.valueOf(i), "person-" + String.valueOf(i), "person-name-" + String.valueOf(i), "person-middle-" + String.valueOf(i), "person-last-" + String.valueOf(i),
                            String.valueOf(getRandomNum(0,9)+1), "person-name-" + String.valueOf(i)+ "@mitest.org", "person-name-" + String.valueOf(i) + "_student", String.valueOf(getRandomNum(0,9)+1),
                            "LOC-ID-" + getRandomNum(0, 5), generateSource(), "INSTPERSONID"+ String.valueOf(i));
                }
                persons.add(person);
                i++;
            }
        }
        return persons;
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
        return (Math.abs(rn.nextInt()) % (end)) + start;
    }

    private void printList(List<AbstractRosterEntity> toBePrinted) {
        for (AbstractRosterEntity printLine: toBePrinted
                )
            System.out.println(printLine.toSqlString());
    }
}
