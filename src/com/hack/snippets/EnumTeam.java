package com.hack.snippets;

/**
 * Created by rafthab on 1/10/17.
 */
public enum EnumTeam {

    RED("red"),
    BLUE("blue"),
    ORANGE("orange"),
    WHITE("white"),
    BLACK("black"),
    GOLD("gold");


    public final String value;
    EnumTeam(String name) {
        this.value = name;
    }
    public String value() {
        return value;
    }
}
