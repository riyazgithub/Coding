package com.hack.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;
import sun.invoke.util.VerifyAccess;

import java.util.Stack;

/**
 * Created by rafthab on 2/27/17.
 */
public class ValidParanthesis {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char[] strArr = s.toCharArray();
        if(strArr.length % 2 == 1) {
            return false;
        }
        for(char ch : strArr) {
            if ( ch=='(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else  {
                // check for closing bracket
                if( ch== ')') {
                    char tmp = st.pop();
                    if (tmp != '(') {
                        return false;
                    }
                } else if( ch== ']') {
                    char tmp = st.pop();
                    if (tmp != '[') {
                        return false;
                    }
                } if( ch== '}') {
                    char tmp = st.pop();
                    if (tmp != '{') {
                        return false;
                    }
                }
            }
        }
        return true;
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
        Assert.assertTrue(ret);
    }
}
