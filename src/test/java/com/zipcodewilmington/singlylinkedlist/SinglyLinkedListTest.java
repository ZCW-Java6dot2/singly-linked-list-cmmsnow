package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

    @Test
    public void testAdd1(){
        Object expected = "Mary";
        singlyLinkedList.add(expected);
        Assert.assertTrue(singlyLinkedList.contains(expected));
    }

    @Test
    public void testAdd2(){
        int expected = 0;
        singlyLinkedList.add("June", expected);
        int actual = singlyLinkedList.find("June");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCounter(){  // NOT WORKING!!******************
        singlyLinkedList.add("Mary");
        singlyLinkedList.add("June");
        int expected = 2;
        int actual = singlyLinkedList.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGet(){
        Object expected = "June";
        singlyLinkedList.add(expected);
        singlyLinkedList.add("Mary");
        Object actual = singlyLinkedList.get(0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemove(){  // NOT WORKING!***************************
        singlyLinkedList.add("Mary");
        singlyLinkedList.add("June");
        int original = singlyLinkedList.size();
        singlyLinkedList.remove(1);
        int actual = singlyLinkedList.size();
        Assert.assertNotEquals(original, actual);
    }

    @Test
    public void testContains(){
        singlyLinkedList.add("Mary");
        Assert.assertTrue(singlyLinkedList.contains("Mary"));
    }

    @Test
    public void testFind(){  // NOT WORKING!**************************
        singlyLinkedList.add("Mary");
        singlyLinkedList.add("June");
        singlyLinkedList.add("Stef");
        int expected = 1;
        int actual = singlyLinkedList.find("June");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSize(){  // NOT WORKING!***********************
        singlyLinkedList.add("Mary");
        singlyLinkedList.add("June");
        singlyLinkedList.add("Stef");
        int expected = 3;
        int actual = singlyLinkedList.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCopy(){
        //given
        //when
        //then
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
