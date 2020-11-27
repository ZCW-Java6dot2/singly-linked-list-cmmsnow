package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void testAdd1(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        Object expected = "Mary";
        singlyLinkedList.add(expected);
        Assert.assertTrue(singlyLinkedList.contains(expected));
    }

    @Test
    public void testAdd2(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add("Mary");
        singlyLinkedList.add("Sally");
        int expected = 1;
        singlyLinkedList.add("June", expected);
        int actual = singlyLinkedList.find("June");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCounter(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add("Mary");
        singlyLinkedList.add("June");
        int expected = 2;
        int actual = singlyLinkedList.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGet(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        Object expected = "June";
        singlyLinkedList.add(expected);
        singlyLinkedList.add("Mary");
        Object actual = singlyLinkedList.get(0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemove(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add("Mary");
        singlyLinkedList.add("June");
        int original = singlyLinkedList.size();
        singlyLinkedList.remove(1);
        int actual = singlyLinkedList.size();
        Assert.assertNotEquals(original, actual);
    }

    @Test
    public void testContains(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add("Mary");
        Assert.assertTrue(singlyLinkedList.contains("Mary"));
    }

    @Test
    public void testFind(){  // NOT WORKING!**************************
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add("Mary");
        singlyLinkedList.add("June");
        singlyLinkedList.add("Stef");
        int expected = 1;
        int actual = singlyLinkedList.find("June");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSize(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add("Mary");
        singlyLinkedList.add("June");
        singlyLinkedList.add("Stef");
        int expected = 3;
        int actual = singlyLinkedList.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCopy(){
        SinglyLinkedList singlyLinkedList1 = new SinglyLinkedList();
        singlyLinkedList1.add("Mary");
        singlyLinkedList1.add("June");
        singlyLinkedList1.add("Stef");
        SinglyLinkedList singlyLinkedList2 = singlyLinkedList1.copy();
        Object expected = singlyLinkedList1.contains("Stef");
        Object actual = singlyLinkedList2.contains("Stef");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReverse(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add("Mary");
        singlyLinkedList.add("June");
        singlyLinkedList.add("Stef");
        SinglyLinkedList reversedList = singlyLinkedList.reverse();
        int expected = singlyLinkedList.find("Mary");
        int actual = reversedList.find("Mary");
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void testSort(){
        //given
        //when
        //then
    }

    @Test
    public void testNodeGetData(){
        //given
        //Node node = new Node();
        //when
        //then
    }

    @Test
    public void testNodeSetData(){
        //given
        //when
        //then
    }

    @Test
    public void testNodeGetNext(){
        //given
        //when
        //then
    }

    @Test
    public void testNodeSetNext(){
        //given
        //when
        //then
    }
}
