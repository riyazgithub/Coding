package com.hack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by rafthab on 1/8/17.
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
public class LRUCache {
    int size;
    List <Integer> cacheKey;
    HashMap<Integer, Integer> hm = new HashMap<>();
    public LRUCache(int capacity) {

        this.size = capacity;
        cacheKey = new ArrayList(capacity);

    }

    public int get(int key) {
        updateCacheKey(key);
        if(hm.get(key) == null) {
            return -1;
        } else {
            return hm.get(key);
        }
    }

    public void set(int key, int value) {
        // update cache key
        updateCacheKey(key);
        hm.put(key,value);

    }
    private void updateCacheKey(int key) {
        // find if the key exists and delete if exists
        for(int i = 0 ;i<cacheKey.size(); i++) {
            if(cacheKey.get(i) == key) {
                cacheKey.remove(i);
            }
        }
        // insert key in the beginning
        cacheKey.add(0,key);
        // check if there aare overflows and delete the entry in hm
        if(cacheKey.size() > size) {
            int removeKey = cacheKey.get(size);
            hm.remove(removeKey);
            cacheKey.remove(size);
        }
    }

    public static void main(String[] args) {
        int capacity = 5;
        LRUCache lruCache = new LRUCache(capacity  );
        //lruCache.cacheKey.add(1); lruCache.cacheKey.add(2); lruCache.cacheKey.add(3); lruCache.cacheKey.add(0,4); lruCache.cacheKey.add(5);lruCache.cacheKey.add(6);
        for(int i =0 ; i<capacity; i++ ) {
            lruCache.set(i,i);
        }

        System.out.println("cachekey " + lruCache.cacheKey);
        lruCache.get(3);
        System.out.println("cachekey " + lruCache.cacheKey);
        lruCache.get(2);
        System.out.println("cachekey " + lruCache.cacheKey + lruCache.get(9));

    }
}
