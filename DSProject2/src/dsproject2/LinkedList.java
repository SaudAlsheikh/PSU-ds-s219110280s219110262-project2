/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject2;

/**
 * @author HP
 */
public class LinkedList<T> {
    Node head;
    Node tail;
    public int lSize;
//

    public void insertLast(Node n) { // A method to insert a node into to the end of a list.
        n.next = null;
        if (tail != null)
            tail.next = n;
        tail = n;
        if (lSize == 0)
            head = tail;
        lSize++;
    }


    public void printList() { // A method to print the list and show it's nodes in order from head to tail.
        int c = 0;
        Node cur = head;
        while (cur != null) {
            System.out.println();
            System.out.print((cur.name == null ? "name is null" : cur.name)); // +(head==null?null:head.item)
            System.out.print(" --> " + (cur.CCode == null ? "No CCOde" : cur.CCode));
            System.out.print(" --> " + (cur.year == 0 ? null : cur.year));
            System.out.print(" --> " + (cur.value == 0 ? null : cur.value));
            cur = cur.next;
            c++;
        }

    }

    public void deletePos(int pos) { // A method to delete a node from a certain position.
        if (pos == 0) deleteHead();
        if (pos == lSize - 1) deleteTail();
        if (pos <= 0 || pos >= lSize - 1) {
            System.out.println("Out of range");
        }
        Node prev = head;
        for (int i = 0; i < pos - 1; i++) {
            prev = prev.next;
        }

        prev.next = prev.next.next;
        lSize--;

    }

    public String deleteHead() {
        if (lSize == 0) {
            System.out.println("List is empty!");
            return "";
        }

        head = head.next;
        lSize--;
        if (lSize == 0)
            tail = null;
        return "";
    }

    public void deleteTail() {
        if (lSize == 0) {
            System.out.println("List is empty!");
        }

        if (lSize == 1)
            head = tail = null;
        else {
            Node prev = head;
            for (int i = 0; i < lSize - 2; i++)
                prev = prev.next;
            prev.next = null;
            tail = prev;
        }
        lSize--;

    }
}

