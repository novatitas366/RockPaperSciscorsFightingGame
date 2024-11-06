package org.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class test {
    public static void main(String[] args){
        HashMap<String, Integer> statistic = new HashMap<>();
        statistic.put("Fire", 0);
        

        for(int i = 0; i<100; i++){
            statistic.put("Fire", statistic.get("Fire")+1);
            
        }
        System.out.println(statistic);
    }
}
