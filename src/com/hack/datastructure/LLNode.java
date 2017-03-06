package com.hack.datastructure;

/**
 * Created by rafthab on 3/5/17.
 */
public class LLNode {
    public LLNode next;
    public String value;
    public Integer intValue;

    public LLNode(String val) {
        this.value = val;
        this.intValue = Integer.parseInt(val);
        this.next = null;
    }

    public LLNode(Integer val) {
        this.value = String.valueOf(val);
        this.intValue = val;
        this.next = null;
    }
}
