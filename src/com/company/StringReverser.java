package com.company;

import java.util.Stack;

public class StringReverser {
    public String reverseString(String str){
        if(str == null)
            throw new NullPointerException();

        var stack = new Stack<Character>();
        var sb = new StringBuffer();
        for(int i = 0; i< str.length(); i++){
            stack.push(str.charAt(i));
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }

}
