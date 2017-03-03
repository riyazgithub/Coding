package com.hack.designpattern;

/**
 * Created by rafthab on 3/2/17.
 */
class singleton {
    private static singleton instance;
    private singleton() {
    }
    public static singleton getInstance() {
        if(instance == null) {
            synchronized(singleton.class) {
             if(instance ==null) {
                 instance = new singleton();
             }
            }
        }
        return instance;
    }
}
public class SingletonPattern {
    public static void main(String[] args) {
        System.out.println(singleton.getInstance());
    }
}
