package com.example.hmtlist;
import static org.junit.jupiter.api.Assertions.*;

class HMTListTest {

    @org.junit.jupiter.api.Test
    void emptySearchContains() {
        HMTList obj = new HMTList();
        assertFalse(obj.search(2));
        assertFalse(obj.contains(2));
    }

    @org.junit.jupiter.api.Test
    void oneElement() {
        String[] str = new String [] {"a"};
        HMTList obj = new HMTList(str);
        for (String s : str) {
            assertTrue(obj.search(s));
            assertTrue(obj.contains(s));
        }
    }

    @org.junit.jupiter.api.Test
    void twoElements() {
        String[] str = new String [] {"a","b"};
        HMTList obj = new HMTList(str);
        for (String s : str) {
            assertTrue(obj.search(s));
            assertTrue(obj.contains(s));
        }
    }

    @org.junit.jupiter.api.Test
    void threeElements() {
        String[] str = new String [] {"a","b","c"};
        HMTList obj = new HMTList(str);
        for (String s : str) {
            assertTrue(obj.search(s));
            assertTrue(obj.contains(s));
        }
    }

    @org.junit.jupiter.api.Test
    void fourElements() {
        String[] str = new String [] {"a","b","c","d"};
        HMTList obj = new HMTList(str);
        for (String s : str) {
            assertTrue(obj.search(s));
            assertTrue(obj.contains(s));
        }
    }

    @org.junit.jupiter.api.Test
    void five() {
        String[] str = new String [] {"a","b","c","d","e"};
        HMTList obj = new HMTList(str);
        for (String s : str) {
            assertTrue(obj.search(s));
            assertTrue(obj.contains(s));
        }
    }

    @org.junit.jupiter.api.Test
    void six() {
        String[] str = new String [] {"a","b","c","d","e","f"};
        HMTList obj = new HMTList(str);
        for (String s : str) {
            assertTrue(obj.search(s));
            assertTrue(obj.contains(s));
        }
    }

    @org.junit.jupiter.api.Test
    void five_find_a() {
        String[] str = new String [] {"a","b","c","d","e"};
        HMTList obj = new HMTList(str);
        obj.search("a");
        obj.contains("a");

        obj.search("a");
        obj.contains("a");
    }

    @org.junit.jupiter.api.Test
    void five_find_e() {
        String[] str = new String [] {"a","b","c","d","e"};
        HMTList obj = new HMTList(str);
        obj.search("e");
        obj.contains("e");

        obj.search("e");
        obj.contains("e");
    }

    @org.junit.jupiter.api.Test
    void five_find_a_e() {
        String[] str = new String [] {"a","b","c","d","e"};
        HMTList obj = new HMTList(str);
        obj.search("a");
        obj.contains("a");

        obj.search("a");
        obj.contains("a");

        obj.search("e");
        obj.contains("e");

        obj.search("e");
        obj.contains("e");

        assertFalse(obj.contains(2));
        assertFalse(obj.search(2));
        assertTrue(obj.search("c"));
    }

    @org.junit.jupiter.api.Test
    void getHead() {
        HMTList list = new HMTList();
        list.insertFront(9);
        assertEquals(9,list.getHead().value);
        list.insertBack(1);
        list.insertFront(1);
        assertEquals(1,list.getHead().value);
    }

    @org.junit.jupiter.api.Test
    void getMid() {
        HMTList list = new HMTList();
        // 1 <-> 2 <-> 3
        list.insertFront(1);
        list.insertBack(2);
        list.insertBack(3);
        assertEquals(2,list.getMid().value);
        // -1 <-> 1 <-> 2 <-> 3
        // left = 2 and right = 1, 2+1%2 !=0 => shift mid to the right 1 pos
        list.insertFront(-1);
        assertEquals(1,list.getMid().value);
    }

    @org.junit.jupiter.api.Test
    void getTail() {
        HMTList list = new HMTList();
        list.insertFront(1);
        list.insertBack(2);
        assertEquals(2,list.getTail().value);
    }


}