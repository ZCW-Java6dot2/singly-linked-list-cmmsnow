package com.zipcodewilmington.singlylinkedlist;

import sun.jvm.hotspot.opto.Node;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<String> {
    private static int counter;
    private Node head;
    private int listCount;

    public SinglyLinkedList(){
        head = new Node(null);
        listCount = 0;
    }

    public void add(Object data){
        Node temp = new Node(data);
        Node current = head;
        while (current.getNext() != null){
            current = current.getNext();
        }
        current.setNext(temp);
        listCount++;
    }

    private static int getCounter(){
        return counter;
    }

    public void add(Object data, int index){
        Node temp = new Node(data);
        Node current = head;

        if (current != null){
            for
        }
    }

    public Object get(int index){
        if (index < 0) return null;
        if (head != null){
            cur
        }
    }
}
