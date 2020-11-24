package com.zipcodewilmington.singlylinkedlist;

import java.util.LinkedList;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<String> {
    private static int counter;

    class Node{
        Node next;
        Object data;

        public Object getData(){
            return data;
        }

        public void setData(Object data){
            this.data = data;
        }

        public Node getNext(){
            return this.next;
        }

        public void setNext(Node next){
            this.next = next;
        }

        public Node(Object dataValue){
            this.next = null;
            this.data = dataValue;
        }

        public Node(Object dataValue, Node nextValue){
            this.next = nextValue;
            this.data = dataValue;
        }
    }

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
            for (int i=0; i<index && current.getNext() != null; i++){
                current = current.getNext();
            }
        }
        temp.setNext(current.getNext());
        current.setNext(temp);
        counter++;
    }

    public Object get(int index){
        if (index < 0) return null;
        Node current = null;
        if (head != null){
            current = head.getNext();
            for (int i=0; i<index; i++){
                if (current.getNext() == null) return null;
                current = current.getNext();
            }
            return current.getData();
        }
        return current;
    }

    public boolean remove(int index){
        if (index<1 || index>size()) return false;

        Node current = head;
        if (head != null){
            for (int i=0; i<index; i++){
                if (current.getNext() == null) return false;
                current = current.getNext();
            }
            current.setNext(current.getNext());
            counter--;
            return true;
        }
        return false;
    }

    public boolean contains(){return true;}

    public int find(){return -1;}

    public int size(){return getCounter();}

    public LinkedList copy(){return null;}

    public LinkedList sort(){return null;}
}
