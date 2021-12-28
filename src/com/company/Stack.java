package com.company;

import java.util.Arrays;

public class Stack {
    //Array to stack
    private int[] items = new int[5];
    private int count = 0;

    //push
    public void push(int item) {
        if (count == items.length) {
            throw new StackOverflowError();
        }
        items[count] = item;
        count++;
    }

    //pop
    public int pop() {
        if (count == 0) {
            throw new NullPointerException();
        }
        return items[--count];
    }

    //peek
    public int peek() {
        if (count == 0) {
            throw new IllegalArgumentException();
        }
        return items[count - 1];
    }

    //isEmpty
    public boolean isEmpty() {
        return count == 0;
    }
    //int[]

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(content);
    }
}
