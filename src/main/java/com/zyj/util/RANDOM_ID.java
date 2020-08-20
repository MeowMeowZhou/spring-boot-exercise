package com.zyj.util;

import java.security.SecureRandom;
import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RANDOM_ID {

    /*获取16位不重复的ID*/
    public static String getRandomID() {
        StringBuilder uid = new StringBuilder();
        //产生16位的强随机数
        Random rd = new SecureRandom();
        for (int i = 0; i < 16; i++) {
            //产生0-2的3位随机数
            int type = rd.nextInt(3);
            switch (type){
                case 0:
                    //0-9的随机数
                    uid.append(rd.nextInt(10));
                    break;
                case 1:
                    //ASCII在65-90之间为大写,获取大写随机
                    uid.append((char)(rd.nextInt(25)+65));
                    break;
                case 2:
                    //ASCII在97-122之间为小写，获取小写随机
                    uid.append((char)(rd.nextInt(25)+97));
                    break;
                default:
                    break;
            }
        }
        return uid.toString();
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i <100 ; i++) {
            set.add("MA6NNDH83"+getRandomID()+"KM");
//            System.out.println("MA6NNDH83"+getRandomID()+"KM");
        }
        System.out.println(set.size());
    }

}
