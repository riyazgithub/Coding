package com.hack.javaBasics;

/**
 * Created by rafthab on 1/7/18.
 */
class foo {
    final int limit;
    foo() {
        limit = 10;
    }
}
public class useofFinal {
    public static void main(String[] args) {
        foo f = new foo();
        System.out.println("Here " + f.limit);
    }

}
