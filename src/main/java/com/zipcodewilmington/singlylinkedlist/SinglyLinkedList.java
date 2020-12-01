package com.zipcodewilmington.singlylinkedlist;


import java.util.Comparator;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T extends Comparable<T>> {
    //  ONLY "SORT" NOT WORKING ************************************
    private static int counter;

    class Node<T extends Comparable<T>> implements Comparator<T> {
        Node next;
        T data;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
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

    private Node head;
    private Node current;
    //private int listCount;

    public SinglyLinkedList() {
        head = new Node(null);
        //listCount = 0;
        counter = 0;
    }

    public void add(T data) {
        Node temp = new Node(data);
        Node current = head;
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
        Node temp = new Node(data);
        Node current = head;

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
        Node current = null;
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

        Node current = head;
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
        Node current = head;
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
        Node current = head;
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

    public SinglyLinkedList copy() {
        SinglyLinkedList singlyLinkedList2 = new SinglyLinkedList();
        Node current = head;
        singlyLinkedList2.add(current.getData());
        while (current.getNext() != null) {
            current = current.getNext();
            singlyLinkedList2.add(current.getData());
        }
        return singlyLinkedList2;
    }

    public SinglyLinkedList reverse() {
        int size = size();
        int finalIndex = size - 1;
        SinglyLinkedList reversedList = new SinglyLinkedList();
        for (int i = finalIndex; i >= 0; i--) {
            reversedList.add(get(finalIndex));
        }
        return reversedList;
    }

    public void sort(SinglyLinkedList passedList) {
        int currentSize = passedList.size();
        Node tempNode = null;
        int temp;
        for (int i = 0; i < currentSize - 1; i++) {
            T currentAtI = get(i);
            for (int j = i + 1; j < currentSize; j++) {
                T currentAtJ = get(j);
                if (currentAtI.compareTo(currentAtJ) > 0) {
                    swap(currentAtI, currentAtJ);
                    currentAtI = currentAtJ;
                }
            }
//        Node previous = null;
//        Node current = head;
//        Node next = current.getNext();
//        while (next != null){
//            if ((current.getData()).compareTo(next.getData()) >= 0){
//                // tried to use >= instead. Wont allow it on Objects. "compareTo" unhappy due to lack of interface?
//                previous = current;
//                current = next;
//            } else {
//                previous = next;
//            }
//        }
//        return null;
        }
    }
        public void swap(T obj1, T obj2){
            Node<T> tempNode = head;
            Node<T> tempNodePrev = null;
            Node<T> tempNodeNext = null;
            Node<T> tempNodeNextNext = null;

            tempNodePrev=tempNode;
            Boolean swapped=false;
            while (tempNode != null && !swapped){
                if (tempNode.getData().equals(obj1))
                {
                    tempNodeNext=tempNode.getNext(); // Save the Next Node after current Node
                    tempNodeNextNext=tempNodeNext.getNext(); // save the Next , Next's node after current node.
                    tempNodePrev.setNext(tempNodeNext); //set the previous node tempNode's next
                    tempNodeNext.setNext(tempNode); // set to NodeNext to current Node
                    tempNode.setNext(tempNodeNextNext); // set current node to next /next

                    swapped=true;
                }
                else {
                    tempNodePrev=tempNode;
                    tempNode = tempNode.getNext();
                }
            }

        }
        //optional //public SinglyLinkedList slice(){return null;}
        //optional: can make this list a generic class that can store any kind of object
    }

