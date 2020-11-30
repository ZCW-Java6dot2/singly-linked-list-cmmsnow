package com.zipcodewilmington.singlylinkedlist;


/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<Object> {
    //  ONLY "SORT" NOT WORKING ************************************
    private static int counter;

    class Node {
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
    private Node current;
    //private int listCount;

    public SinglyLinkedList(){
        head = new Node(null);
        //listCount = 0;
        counter = 0;
    }

    public void add(Object data){
        Node temp = new Node(data);
        Node current = head;
        while (current.getNext() != null){
            current = current.getNext();
        }
        current.setNext(temp);
        //listCount++;
        counter++;
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
        return current.getData();
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

    public boolean contains(Object data){
        Node current = head;
        if (current.getData() == data){
            return true;
        } else {
            while (current.getNext() != null){
                current = current.getNext();
                if (current.getData() == data) return true;
            }
        }
        return false;
    }

    public int find(Object data){
        int indexOfData = 0;
        Node current = head;
        if (contains(data)){
            if (current.getData() == data){
                return indexOfData;
            } else {
                while (current.getData() != data && current.getNext() != null){
                    current = current.getNext();
                    if (current.getData() == data){
                        indexOfData++;
                        return indexOfData;
                    }
                }
            }
        } else indexOfData = -1;
        return indexOfData;
    }

    public int size(){return getCounter();}

    public SinglyLinkedList copy(){
        SinglyLinkedList singlyLinkedList2 = new SinglyLinkedList();
        Node current = head;
        singlyLinkedList2.add(current.getData());
        while (current.getNext() != null){
            current = current.getNext();
            singlyLinkedList2.add(current.getData());
        }
        return singlyLinkedList2;
    }

    public SinglyLinkedList reverse(){
        int size = size();
        int finalIndex = size-1;
        SinglyLinkedList reversedList = new SinglyLinkedList();
        for (int i=finalIndex; i>=0; i--){
            reversedList.add(get(finalIndex));
        }
        return reversedList;
    }

    public SinglyLinkedList sort(){
        //USE BUBBLE SORT FOR THIS************************************************THIS IS GRUMPY
        Node previous = null;
        Node current = head;
        Node next = current.getNext();
        while (next != null){
            if ((current.getData()).compareTo(next.getData()) >= 0){
                // tried to use >= instead. Wont allow it on Objects. "compareTo" unhappy due to lack of interface?
                previous = current;
                current = next;
            } else {
                previous = next;
            }
        }
        return null;
    }

    //optional
    //public SinglyLinkedList slice(){return null;}

    //optional: can make this list a generic class that can store any kind of object
}
