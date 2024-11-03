package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class test {
    public static void main(String[] args){
        Queue <Integer> eile = new LinkedList<>();

        eile.add(1);
        eile.add(2);
        eile.add(3);
        eile.add(4);
        eile.add(5);
        for(int x : eile){
            System.out.println(x);
        }
        eile.poll();
        for(int x : eile){
            System.out.println(x);
        }
        eile.add(6);
        for(int x : eile){
            System.out.println(x);
        }
    }
}
