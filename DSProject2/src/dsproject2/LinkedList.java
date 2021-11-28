/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject2;

/**
 *
 * @author HP
 */
public class LinkedList {
    Node head;
    Node tail;
    public int size;
//

    public void insertFirst(String name, String CCode, int year, double value){ // A method to insert a block into to the beginning of a list.
        Node tmp = new Node(name, CCode, year, value);
        tmp.next = head;
        head= tmp;
       // if(head!=null)
         //   head.prev = tmp;
       // head = tmp;
        if (size == 0)
            tail = head; 
        size++;
    }
    public void insertLast(String name, String CCode, int year, double value){ // A method to insert a block into to the end of a list.
        Node tmp = new Node(name, CCode, year, value);
       // tmp.prev = tail;
        tmp.next = null;
        if(tail != null)
            tail.next = tmp;
        tail = tmp;
        if (size==0)
          head = tail;
        size++;
    }
    /*
    public void printList(){ // A method to print the list and show it's blocks in order from head to tail.
        System.out.println("Current head = "+(head==null?null:head.num));
        System.out.println("Current tail = "+(tail==null?null:tail.num));
        //System.out.println("Current size = "+size);
        Node current = head;
        System.out.print("List: ");
        while (current != null){
            System.out.print(current.num+" --> ");
            current = current.next;
        }
        System.out.println("null");
        System.out.println("==============");
    }*/
}
