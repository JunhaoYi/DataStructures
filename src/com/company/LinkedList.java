package com.company;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    //addFirst
    public void addFirst(int item) {
        var node = new Node(item);
        //itFirst
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            var tempNode = first;
            first = node;
            node.next = tempNode;
        }
        size++;
    }

    private boolean isEmpty() {
        return first == null;
    }

    //addLast
    public void addLast(int item) {
        var node = new Node(item);

        if (first == null) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    //deleteFirst
    public void deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = last = null;
        } else {
            var secondNode = first.next;
            first.next = null;
            first = secondNode;
        }
        size--;
    }

    //deleteLast
    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = last = null;
        } else {
            var previous = getPreviousNode(last);
            last = previous;
            previous.next = null;
        }

        size--;
    }

    private Node getPreviousNode(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    //contains
    public boolean contains(int item) {
        if (indexOf(item) >= 0) {
            return true;
        }
        return false;
    }

    //indexOf
    public int indexOf(int item) {
        var index = 0;
        var currentNode = first;

        while (currentNode != null) {
            if (currentNode.value == item) {
                return index;
            }
            currentNode = currentNode.next;
            index++;
        }

        return -1;
    }

    //size
    public int size() {
        return size;
    }

    public int[] toArray() {
        var result = new int[size];
        var current = first;
        var index = 0;
        while (current != null) {
            result[index++] = current.value;
            current = current.next;
        }

        return result;
    }

    public void reverse() {
        // 1 -> 2 -> 3 -> null
        //null<- 1 <- 2 <- 3
        // p    c    n
        Node previous = null;
        var current = first;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        first = previous;
    }

    public int getKthFromTheEnd(int k) {
        // 1 - 2
        var distance = k - 1;
        var pointer1 = first;
        var pointer2 = first;
        for (int i = 0; i < distance; i++) {
            if(pointer2 == null){
                throw new IllegalArgumentException();
            }
            pointer2 = pointer2.next;
        }
        while (pointer2 != last) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer1.value;
    }
}
