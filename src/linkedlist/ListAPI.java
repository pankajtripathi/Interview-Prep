package com.practice.linkedlist;

/**
 * Created by pankajtripathi on 11/29/16.
 */
class Node{
    int val;
    Node next;
    Node(int key){
        val = key;
    }
}

public class ListAPI {
    Node head = null;
    public void append(int key){
        if(head == null){
            head = new Node(key);
            head.next = null;
        }
        else{
            Node p = head;
            while(p.next != null) p = p.next;
            Node n = new Node(key);
            p.next = n;
            n.next = null;
        }
    }

    public void addAtBegin(int key){
        if(head == null){
            head = new Node(key);
            head.next = null;
        }
        else{
            Node n = new Node(key);
            n.next = head;
            head = n;
        }
    }

    public void insertAt(int key, int pos){
        Node p = head;
        for (int i = 1; i < pos-1; i++) p = p.next;
        Node n = new Node(key);
        n.next = p.next;
        p.next = n;
    }

    public int getLengeth(){
        Node p = head;
        int c = 0;
        while (p != null){
            c++;
            p = p.next;
        }
        return c;
    }

    public void delete(int key){
        Node p = head, prev = null;
        while(p != null){
            if(p.val == key){
                if(p == head) head = p.next;
                else prev.next = p.next;
            }
            prev = p;
            p = p.next;
        }
    }

    public void deleteDuplicates(){
        Node p = head, prev = null;
        while(p != null){
            if(prev != null && prev.val == p.val)
                prev.next = p.next;
            prev = p;
            p = p.next;
        }
    }

    public void print(){
        Node p = head;
        while(p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    private void reverse() {
        if(head == null || head.next == null) return;
        Node p = head;
        Node q = p.next;
        head.next = null;

        while(p != null && q != null){
            Node t = q.next;
            q.next = p;
            p = q;
            q = t;
        }

        head = p;
    }

    private void deleteFromEnd(int n) {
        Node start = new Node(0);
        Node slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<= n+1; i++){
            fast = fast.next;
        }

        //Move fast to the end, maintaining the gap
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        //Skip the desired node
        slow.next = slow.next.next;
        head = start.next;
    }

    public static void main(String[] args) {
        ListAPI obj = new ListAPI();
        obj.addAtBegin(1);
        obj.append(1);
        obj.append(3);
        obj.append(4);
        obj.append(5);
        obj.append(5);
        obj.insertAt(2, 2);

        System.out.println("Length of List: " + obj.getLengeth());
        obj.print();

        obj.delete(1);
        System.out.println("Length of List: " + obj.getLengeth());
        obj.print();

        obj.deleteDuplicates();
        System.out.println("Length of List: " + obj.getLengeth());
        obj.print();

        /*
        obj.head = null;
        obj.append(1);
        obj.append(1);
        obj.append(1);
        System.out.println("Length of List: " + obj.getLengeth());
        obj.print();

        obj.deleteDuplicates();
        System.out.println("Length of List: " + obj.getLengeth());
        obj.print();
        */
        System.out.println("Delete 2nd from last: ");
        obj.deleteFromEnd(2);
        obj.print();

        System.out.println("Reverse: ");
        obj.reverse();
        obj.print();
    }

}
