package com.hack.snippets;

import com.sun.java.browser.plugin2.DOM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by rafthab on 1/16/17.
 */
public class identifyStringGroups {
    private static final String SIMPLE = "/Users/rafthab/Documents/Coding/resource/Simpleldap.txt";
    private static final String DOMINO = "/Users/rafthab/Documents/Coding/resource/Dominoldap.txt";
    private static final String FOREST = "/Users/rafthab/Documents/Coding/resource/Forestldap.txt";

    public static void main(String[] args) {

        List<String> simpleList = getFileContetnt(SIMPLE);
        List<String > dominoList = getFileContetnt(DOMINO);
        List<String> forestList = getFileContetnt(FOREST);
        HashMap <String, List<String>> hm =  new HashMap<>();

        populateHM(simpleList, hm, "simpleldap");
        populateHM(dominoList, hm, "dominoldao");
        populateHM(forestList, hm, "forestldap");


        for (String key : hm.keySet()) {
            System.out.println("key: " + key + " value: " + hm.get(key));
        }

    }

    private static void populateHM(List<String> simpleList, HashMap<String, List<String>> hm, String key) {
        for(String pkg : simpleList) {
            if(hm.get(pkg) == null) {
                List<String> newElem = new ArrayList<String>();
                newElem.add(key);
                hm.put(pkg, newElem);
            } else {
                List<String> oldElem = hm.get(pkg);
                oldElem.add(key);
                hm.put(pkg, oldElem);
            }
        }
    }

    private static List getFileContetnt(String FILENAME) {
        List ret = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                if(sCurrentLine.length() > 4) {
                    sCurrentLine = sCurrentLine.substring(sCurrentLine.indexOf('\"'), sCurrentLine.lastIndexOf('\"'));
                    ret.add(sCurrentLine);
//                    System.out.println(sCurrentLine);

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
