package com.company;

public class TwoStacks {
    private int[] items;
    private int top1;
    private int top2;

    public TwoStacks(int capacity){
        if(capacity <= 0)
            throw new IllegalArgumentException();

        items = new int[capacity];
        top1 = -1;
        top2 = capacity;
    }

    public void push1(int item){
        if(isFull1())
            throw new IllegalStateException();

        items[++top1] = item;
    }

    public int pop1(){
        if(isEmpty1())
            throw new IllegalStateException();

        return items[top1--];
    }

    public boolean isEmpty1(){
        return top1 == -1;
    }
    public boolean isFull1(){
        return top1 + 1 == top2;
    }

}
