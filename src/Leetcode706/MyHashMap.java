package Leetcode706;

import java.util.Iterator;
import java.util.LinkedList;


public class MyHashMap {
    class Node{
        int key;
        int value;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private int size = 1000;
    private LinkedList<Node>[] buckets;
    public MyHashMap(){
        buckets = new LinkedList[size];
        for(int i = 0; i < size; i++){
            buckets[i] = new LinkedList<>();
        }
    }
    public void put(int key, int value){
        int index = key % size;
        for(Node node : buckets[index]){
            if(node.key == key){
                node.value = value;
                return;
            }
        }
        buckets[index].add(new Node(key, value));
    }
    public int get(int key){
        int index = key % size;
        for(Node node : buckets[index]){
            if(node.key == key){
                return node.value;
            }
        }
        return -1;
    }
    public void remove(int key){
        int index = key % size;
        Iterator<Node> iterator = buckets[index].iterator();
        while (iterator.hasNext()){
            Node node = iterator.next();
            if(node.key == key){
                iterator.remove();
                return;
            }
        }
    }
}
