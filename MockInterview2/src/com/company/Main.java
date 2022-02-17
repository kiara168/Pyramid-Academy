package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }

    public static List<String> fizzBuzz(int n) {
        List < String> answer = new ArrayList<>();
        for(int i = 1; i <= n; i ++) {
            answer.add(String.valueOf(i));
            if(i % 3 == 0 && i % 5 == 0){
                answer.set(i-1,"Fizz Buzz");
            }
            else if(i % 3 == 0){
                answer.set(i-1,"Fizz");
            }
            else if(i % 5 ==0){
                answer.set(i - 1,"Buzz");
            }else{
                answer = answer;
            }
        }
        return answer;
    }
}
