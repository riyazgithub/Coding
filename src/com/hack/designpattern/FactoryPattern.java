package com.hack.designpattern;

/**
 * Created by rafthab on 3/2/17.
 */

interface employee {
    public String role();
}

class developer implements employee {
    public String role() {
        return "Writes Code";
    }
}

class tester implements employee {
    public String role() {
        return "Writes Code to test dev code";
    }
}

class sales implements employee {
    public String role() {
        return "Sells software built by engineers";
    }
}

class Factory {
    public employee getEmployeeByType(String type) {
        employee retEmployee = null;
        if (type.equals("Dev")) {
            retEmployee = new developer();
        } else if (type.equals("QA")) {
            retEmployee = new tester();
        } else if (type.equals("Sales")) {
            retEmployee = new sales();
        }

        return retEmployee;
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        Factory factory = new Factory();
        employee getEmp =  factory.getEmployeeByType("Dev");
        System.out.println(String.format("So Dev do this : %s", getEmp.role()));
        getEmp =  factory.getEmployeeByType("QA");
        System.out.println(String.format("So QA do this : %s", getEmp.role()));
    }
}
