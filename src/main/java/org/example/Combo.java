package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.FileNotFoundException;
import java.util.Queue;




public class Combo {

    public static class combo{
        private String attack1;
        private String attack2;
        private String attack3;
        private String comboattack;
        private int comboDamage;

        public void Combocheck(Queue <String> Combo){
            
        }
        public int getComboDamage() {
            return comboDamage;
        }
        public String getComboattack() {
            return comboattack;
        }
        public String getAttack1() {
            return attack1;
        }
        public String getAttack2() {
            return attack2;
        }
        public String getAttack3() {
            return attack3;
        }
    }
};



