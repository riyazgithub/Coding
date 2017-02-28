package com.hack.snippets;

/**
 * Created by rafthab on 1/9/17.
 */
 class finalConsts {
    public static final String const1 = "Const1";
    public static final String const2 = "Const2";
    public static final String const3 = "Const3";
}

enum consts {Const1, Const2, Const3, Const4};

public class enumConsts {
    public static void main(String[] args) {
        System.out.println(finalConsts.const1);
        System.out.println(consts.Const1);
    }
}