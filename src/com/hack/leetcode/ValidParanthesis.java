package com.hack.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;
import sun.invoke.util.VerifyAccess;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Stack;

/**
 * Created by rafthab on 2/27/17.
 */
public class ValidParanthesis {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char[] strArr = s.toCharArray();
        HashMap<Character, Character> hm = new HashMap<>();
        hm.put('(',')');hm.put('[',']');hm.put('{','}');
        for(char c :strArr) {
            if(hm.get(c)!=null) {
                st.push(c);
            } else {
                if (st.size() == 0)
                    return false;
                char pop = st.pop();
                if (hm.get(pop) != c) {
                    return false;
                }
        }
    }
    if(st.size() == 0)
        return true;

        return false;
    }

    @Test
    public void verifyValidParanthesis(){
        ValidParanthesis validParanthesis = new ValidParanthesis();
        boolean ret = validParanthesis.isValid("(){}[]");
        Assert.assertTrue(ret);
        ret = validParanthesis.isValid("({}[])");
        Assert.assertTrue(ret);
        ret = validParanthesis.isValid("({()}[])");
        Assert.assertTrue(ret);
        ret = validParanthesis.isValid("({}[)]");
        Assert.assertFalse(ret);
        ret = validParanthesis.isValid("{(){}[]}}");
        Assert.assertFalse(ret);
        ret = validParanthesis.isValid("{(){}[]}{}");
        Assert.assertTrue(ret);
    }
}
