package com.practice.queueandstack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pankajtripathi on 11/30/16.
 */
class MyStack{
    Queue<Integer> queue = new LinkedList<>();

    public void push(int key){
        queue.add(key);
        int size = queue.size();
        while(size > 1){
            queue.add(queue.remove());
            size--;
        }
    }

    public void pop(){
        queue.poll();
    }

    public int top(){
        return queue.peek();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }
}

public class StackUsingQueue {
    public static void main(String[] args) {
        MyStack st = new MyStack();
        st.push(3);
        st.push(2);
        st.push(1);
        System.out.println(st.top());
        st.pop();
        System.out.println(st.top());
        System.out.println(st.isEmpty());
    }
}
