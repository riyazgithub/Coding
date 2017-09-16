package com.hack;

import org.springframework.util.FileCopyUtils;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by rafthab on 6/16/17.
 */
public class FileManipulations {
// /Users/rafthab/Stuff_Work/appDel/TestResultLogs/testpicked

    private static final String FILENAME = "/Users/rafthab/Stuff_Work/appDel/TestResultLogs/testresults/TestOutput %d/%s";
    private static final String TARGETDirectories = "/Users/rafthab/Stuff_Work/appDel/TestResultLogs/testpicked/TestOutput %d";
    private static final int TOTAL = 1;
    private static  ArrayList<String> TestCaseFailures = new ArrayList();

    public static void main(String[] args) throws IOException {
        for(int i = 1; i<=TOTAL; i++) {
            String file = String.format(FILENAME, i, "tafresults.txt");
            printLine(file, i);
            new File(String.format(TARGETDirectories, i)).mkdir();
        }
        System.out.println(" Failures " + TestCaseFailures.size());

        copyingFiles();
    }

    public static void copyingFiles() throws IOException {
        for(String fileName : TestCaseFailures) {
            File src = new File(fileName);
            File dest = new File(fileName.replace("testresults","testpicked"));
            FileCopyUtils.copy(src,dest);
        }
    }

    public static void printLine(String fileName, int round) {
        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            System.out.println("File Name "+ fileName);

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                if(sCurrentLine.contains("FAILED")) {
//                    String[] splitString = sCurrentLine.split("*");
                    sCurrentLine = sCurrentLine.replace("|*", "##");
                    String[] splitString = sCurrentLine.split("##");
                    String failedTestsLocation = String.format(FILENAME, round, splitString[3]);
                    TestCaseFailures.add(failedTestsLocation);
                }
//                System.out.println(sCurrentLine);
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
    }
}
