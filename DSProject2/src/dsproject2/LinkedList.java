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

    public void insertFirst(Node n){ // A method to insert a block into to the beginning of a list.

        n.next = head;
        head= n;
       // if(head!=null)
         //   head.prev = tmp;
       // head = tmp;
        if (size == 0)
            tail = head; 
        size++;
    }
    public void insertLast(Node n){ // A method to insert a block into to the end of a list.
        
       // tmp.prev = tail;
        n.next = null;
        if(tail != null)
            tail.next = n;
        tail = n;
        if (size==0)
          head = tail;
        size++;
    }

    public void printList(){ // A method to print the list and show it's blocks in order from head to tail.
        System.out.println("country: "+ (head.name==null?null:head.name)); // +(head==null?null:head.item)
        System.out.println("country code: "+(head.CCode==null?"No CCOde":head.CCode));
        System.out.println(" year: "+(head.year==0?null:head.year));
        System.out.println(" value: "+(head.value==0?null:head.value));
    }
}
