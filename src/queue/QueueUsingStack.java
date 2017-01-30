package com.practice.queueandstack;

import java.util.Stack;

/**
 * Created by pankajtripathi on 11/30/16.
 */
class MyQueue{
    int front;
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();

    public void push(int key){
        if(st1.isEmpty()) front = key;
        st1.push(key);
    }

    public void pop(){
        if(st2.isEmpty()){
            while (!st1.isEmpty()) st2.push(st1.pop());
        }
        st2.pop();
    }

    public int peek(){
        if(st2.isEmpty()) return front;
        return st2.pop();
    }

    public boolean isEmpty(){
        return st1.isEmpty() && st2.isEmpty();
    }
}

public class QueueUsingStack {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.pop();
        System.out.println("Peek: " + q.peek());
        System.out.println(q.isEmpty());
    }
}

