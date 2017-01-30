package com.practice.interview;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Created by pankajtripathi on 1/16/17.
 */
public class LRU<K, V> {
    int capacity;
    LinkedHashMap<K, V> map;

    public LRU(int capacity){
        this.capacity = capacity;
        this.map = new LinkedHashMap<K, V>();
    }

    public V get(K key){
        V value = this.map.get(key);
        if(value == null) return null;
        else this.set(key, value);
        return value;
    }

    public void set(K key, V value){
        if(this.map.containsKey(key))
            this.map.remove(key);
        else if(this.map.size() == this.capacity){
            Iterator<K> it = this.map.keySet().iterator();
            it.next();
            it.remove();
        }
        map.put(key, value);
    }

    public static void main(String[] args) {
        LRU cache = new LRU(6);
        cache.set("A", 1);
        cache.set("B", 2);
        cache.set("C", 3);
        cache.set("D", 4);

        cache.get("A");
        System.out.println(cache.map);

        cache.set("E", 5);
        cache.set("F", 6);

        cache.get("D");
        System.out.println(cache.map);
    }
}
