package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.FileReader;
import java.io.FileNotFoundException;





public class Combo {

    public static class combo{
        private String attack1;
        private String age;
        private String email;
    
        public String getName(){
            return attack1;
        }
        public String getAge(){
            return age;
        }
        public String getEmail(){
            return email;
        }
        public String getAll(){
            return "Name: "+getName()+" age: "+age+" Email: "+email+"\n";
        }
    }
};



