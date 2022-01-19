package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(reverseString("word"));
    }

    public static String reverseString(String str) {
	// write your code here
        String reverse = "";
        for(int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }
        return reverse;
    }

}
