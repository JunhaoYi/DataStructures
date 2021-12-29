package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {


    }

    public static int factorial(int n) {
        //base condition
        if(n == 0){
            return 1;
        }
        return n * factorial(n-1);
    }


}
