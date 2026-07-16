package Leetcode705;

import java.util.LinkedList;

public class HashSet {
    private LinkedList<Integer>[] buckets;
    private int size = 1000;
    public HashSet(){
        buckets = new LinkedList[size];
        for(int i = 0; i < size; i++){
            buckets[i] = new LinkedList<>();
        }
    }
    public void add(int key){
        int index = key % size;
        if(!buckets[index].contains(key)){
            buckets[index].add(key);
        }
    }

    public void remove(int key){
        int index = key % size;
        buckets[index].remove(Integer.valueOf(key));
    }

    public boolean contains(int key){
        int index = key % size;
        return buckets[index].contains(key);
    }
}
