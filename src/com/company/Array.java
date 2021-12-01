package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        //if full, resize
        if (items.length == count) {
            var temp = new int[count * 2];

            for (int i = 0; i < count; i++) {
                temp[i] = items[i];
            }
            items = temp;
        }
        //add new item at the end
        items[count] = item;
        count++;
    }

    public void removeAt(int index) {
        //validate index
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }
        //right -> left at index
        for (int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }
        count--;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (items[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public int max() {
        int max = items[0];
        for (int i = 1; i < count; i++) {
            if (items[i] > max) {
                max = items[i];
            }
        }
        return max;
    }

    public int[] interset(int[] input) {
        var temp = new HashSet<Integer>();
        for (int i = 0; i < input.length; i++) {
            if (indexOf(input[i]) != -1) {
                temp.add(input[i]);
            }
        }
        return temp.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] reverse() {
        var result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = items[count - 1 - i];
        }
        return result;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }


}
