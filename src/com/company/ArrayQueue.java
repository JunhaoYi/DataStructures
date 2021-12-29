package com.company;

import java.util.Arrays;

public class ArrayQueue {
    private int[] items;
    private int rear;
    private int count;
    private int front;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
    }

    //ArrayDeque
    //enqueue
    private void enqueue(int item) {
        if (count == items.length){
            throw new StackOverflowError();
        }

        items[rear++] = item;
        count++;
    }
    //dequeue
    private int dequeue() {
        if (count == 0){
            throw new IllegalArgumentException();
        }
        var item = items[front];
        items[front++] = 0;
        count--;
        return item;

    }
    //peek
    //isEmpty()
    //isFull

    @Override
    public String toString(){
        return Arrays.toString(items);
    }
}
