package com.assignment.assignment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class OTP {

    //for OTP
    public static char[] otp(int len)
    {
        String numbers = "0123456789";
        Random random = new Random();
        char[] otp = new char[len];

        for(int i = 0;i<len;i++)
        {
            otp[i] = numbers.charAt(random.nextInt(numbers.length()));
        }
        return otp;
    }

    @RequestMapping( value ="/otp",method = RequestMethod.GET)
    public static char[]  Callotp(){
        int length = 4;
        return otp(length);
    }



    //for countcharacter of string

    public static void countEachCharacter(String str){
        String s= "";
        int count[] = new int[256];
        int len  = str.length();

        for(int i = 0;i<len;i++)
            count[str.charAt(i)]++;

        char array[] = new char[str.length()];
        for (int i= 0;i<len;i++) {
            array[i] = str.charAt(i);
            int num = 0;
            for (int j = 0; j <= i; j++) {
                if (str.charAt(i) == array[j])
                    num++;
            }
            if (num == 1) {
                System.out.println("Occurence of char " + str.charAt(i) + " in the string is:" + count[str.charAt(i)]);

            }
        }

    }
    @RequestMapping(value = "/countcharacter",method = RequestMethod.GET)
    public static void callMethod(){
        String string = "shrutishikha";
       countEachCharacter(string);

    }


}
