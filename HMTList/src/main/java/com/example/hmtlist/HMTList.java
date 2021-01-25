package com.example.hmtlist;

import java.util.Objects;

public class HMTList {
    class Item {
        Object value;
        Item next;
        Item previous;

        Item(Object setValue, Item item, char decider) {
            value = setValue;
            if(decider == 'f')
                next = item;
            else if(decider == 'b')
                previous = item;
        }
    }

    int left = 0;
    int right = 0;
    int foundLeft = 0;
    int foundRight = 0;
    int fromHead = 0;
    int fromTail = 0;
    int Mid_Head = 0;
    int Mid_Tail = 0;
    private Item head;
    private Item mid;
    private Item tail;

    HMTList(){}

    HMTList(Object[] array){
        for(int i = array.length - 1; i>=0 ; i--){
            this.insertFront(array[i]);
        }
    }

    public void insertFront(Object value){
        Item item = new Item(value,head,'f');
        if(head!=null){
            left++;
            head.previous = item;
        }
        else
            tail = mid = item;
        head = item;

        if(left+right % 2 != 0)
            setMid();
    }

    private void setMid(){
        if(left > right){
            mid = mid.previous;
            left--;
            right++;
        }
        else if (left < right){
            mid = mid.next;
            left++;
            right--;
        }
    }

    public void insertBack(Object value){
        Item item = new Item(value,tail,'b');
        if(tail != null){
            right++;
            tail.next = item;
        }
        else
            head = mid = item;
        tail = item;

        if(left+right % 2 != 0)
            setMid();
    }

    public boolean search(Object value){
        boolean found = false;
        int count = 0;

        if (head==null)
            return false;
            // we can use 2 more variables to determine left or right part to search for the item
            // ex: leftFound = 0; rightFound = 0;
            // leftFound++ as we found the item in the left part and leftFound-- as we didn't find it
            boolean leftPart = false;
            boolean rightPart = false;
            do {
                if ( (!leftPart && foundLeft >= foundRight) || rightPart) {
                    leftPart = true;

                    if(fromHead >= Mid_Head) {
                        for (Item cur = head; cur != Objects.requireNonNull(mid).next && !found; cur = cur.next) {
                            //System.out.print(cur.value);
                            count++;
                            if (value.equals(cur.value)) {
                                found = true;
                                fromHead++;
                                Mid_Head--;
                            }
                        }
                        if (!found)
                            fromHead--;
                    }
                    else {
                        for (Item cur = mid; cur != null && !found; cur = cur.previous) {
                            //System.out.print(cur.value);
                            count++;
                            if (value.equals(cur.value)) {
                                found = true;
                                Mid_Head++;
                                fromHead--;
                            }
                        }
                        if(!found)
                            Mid_Head--;
                    }

                    if (!found)
                        foundLeft--;
                    else {
                        foundRight--;
                        foundLeft++;
                    }

                } else {
                    rightPart = true;
                    if(fromTail >= Mid_Tail){
                        for (Item cur = tail; cur != Objects.requireNonNull(mid).previous && !found; cur = cur.previous) {
                            //System.out.print(cur.value);
                            count++;
                            if (value.equals(cur.value)) {
                                found = true;
                                fromTail++;
                                Mid_Tail--;
                            }
                        }
                        if(!found)
                            fromTail--;
                    }
                    else {
                        for (Item cur = mid; cur != null && !found; cur = cur.next) {
                            //System.out.print(cur.value);
                            count++;
                            if (value.equals(cur.value)) {
                                found = true;
                                Mid_Tail++;
                                fromTail--;
                            }
                        }
                        if(!found)
                            Mid_Tail--;
                    }

                    if (!found)
                        foundRight--;
                    else {
                        foundLeft--;
                        foundRight++;
                    }
                }
                if(rightPart && leftPart)
                    break;
            } while (!found);

        System.out.println("-----------------");
        System.out.println("Running search");
        System.out.println("# iterations to find " + value + " = " + count);
        System.out.println("-----------------");
        return found;
    }

    public boolean contains(Object value) {
        boolean found = false;
        int count = 0;

        if (head == null)
            found = false;
        else {
            for (Item cur = head; cur != null && !found; cur = cur.next) {
                count++;
                if (value.equals(cur.value))
                    found = true;
            }
        }
        System.out.println("*****************");
        System.out.println("Running contains");
        System.out.println("# iterations to find " + value + " = " + count);
        System.out.println("*****************");
        return found;
    }

    public Item getHead(){
        return head;
    }

    public Item getMid(){
        return mid;
    }

    public Item getTail(){
        return tail;
    }

    public void printList(){
        for(Item cur = head; cur != null; cur = cur.next){
            System.out.print(cur.value + " ");
        }
        System.out.println();
        System.out.println("head = " + head.value.toString());
        System.out.println("mid = " + mid.value.toString());
        System.out.println("tail = " + tail.value.toString());
        System.out.println("left = " + left);
        System.out.println("right = " + right);
    }


    public static void main(String[] args){
    }
}
