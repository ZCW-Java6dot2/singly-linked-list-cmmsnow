package com.zipcodewilmington.singlylinkedlist;


import java.util.Comparator;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T extends Comparable<T>> {
    //  ONLY "SORT" NOT WORKING ************************************
    private static int counter;

    class Node<T extends Comparable<T>> implements Comparator<T> {
        Node<T> next;
        T data;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return this.next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(T dataValue) {
            this.next = null;
            this.data = dataValue;
        }

        public Node(T dataValue, Node nextValue) {
            this.next = nextValue;
            this.data = dataValue;
        }

        public int compare(T o1, T o2) {
            return o1.compareTo(o2);
        }
    }

    private Node<T> head;
    private Node<T> current;
    //private int listCount;

    public SinglyLinkedList() {
        head = new Node<T>(null);
        //listCount = 0;
        counter = 0;
    }

    public void add(T data) {
        Node<T> temp = new Node(data);
        Node<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(temp);
        //listCount++;
        counter++;
    }

    private static int getCounter() {
        return counter;
    }

    public void add(T data, int index) {
        Node<T> temp = new Node(data);
        Node<T> current = head;

        if (current != null) {
            for (int i = 0; i < index && current.getNext() != null; i++) {
                current = current.getNext();
            }
        }
        temp.setNext(current.getNext());
        current.setNext(temp);
        counter++;
    }

    public T get(int index) {
        if (index < 0) return null;
        Node<T> current = null;
        if (head != null) {
            current = head.getNext();
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null) return null;
                current = current.getNext();
            }
            return (T) current.getData();
        }
        return (T) current.getData();
    }

    public boolean remove(int index) {
        if (index < 1 || index > size()) return false;

        Node<T> current = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null) return false;
                current = current.getNext();
            }
            current.setNext(current.getNext());
            counter--;
            return true;
        }
        return false;
    }

    public boolean contains(T data) {
        Node<T> current = head;
        if (current.getData() == data) {
            return true;
        } else {
            while (current.getNext() != null) {
                current = current.getNext();
                if (current.getData() == data) return true;
            }
        }
        return false;
    }

    public int find(T data) {
        int indexOfData = 0;
        Node<T> current = head;
        if (contains(data)) {
            if (current.getData() == data) {
                return indexOfData;
            } else {
                while (current.getData() != data && current.getNext() != null) {
                    current = current.getNext();
                    if (current.getData() == data) {
                        indexOfData++;
                        return indexOfData;
                    }
                }
            }
        } else indexOfData = -1;
        return indexOfData;
    }

    public int size() {
        return getCounter();
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> singlyLinkedList2 = new SinglyLinkedList<T>();
        Node<T> current = head;
        singlyLinkedList2.add(current.getData());
        while (current.getNext() != null) {
            current = current.getNext();
            singlyLinkedList2.add(current.getData());
        }
        return singlyLinkedList2;
    }

    public SinglyLinkedList<T> reverse() {
        int size = size();
        int finalIndex = size - 1;
        SinglyLinkedList<T> reversedList = new SinglyLinkedList<T>();
        for (int i = finalIndex; i >= 0; i--) {
            reversedList.add(get(finalIndex));
        }
        return reversedList;
    }

    public void sort() {
        Node<T> previous = null;
        Node<T> current = head;
        Node<T> next = current.getNext();
        while (next != null){
            if ((current.getData()).compareTo(next.getData()) >= 0){
                // null pointer for line 179.
                previous = current;
                current = next;
            } else {
                previous = next;
            }
        }
    }

        //optional //public SinglyLinkedList slice(){return null;}
        //optional: can make this list a generic class that can store any kind of object
    }

