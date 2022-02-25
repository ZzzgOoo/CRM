package com.example.crm;

import org.junit.jupiter.api.Test;


public class test {
        public static void main(String[] args){

                StringBuilder str=new StringBuilder("1246742752752752753727277278242711.1234");
                System.out.println(str.indexOf("."));
                for(int a=str.indexOf(".")-3;a>0;a-=3){

                   str.insert(a,",");

                }

                System.out.println(str);
            }


}
