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
    
     public void deleteNodeNoDummy(Node n){

        if (head == n){ 
            head = head.next;
            // if head is the only element
            if (head == null)
                tail = null;
            return; // head is the node containing val, so terminate
        }
        
        
        Node prev = head;
        Node cur = head.next;
        
        while(cur!=null){
            if(cur == n){
                prev.next = cur.next;
                if (cur==tail)
                    tail = prev;
                return;
            }
            prev = prev.next;
            cur = cur.next;
        }
        
        System.out.println("No value found!");
        
    }

    public void printList(){ // A method to print the list and show it's blocks in order from head to tail.
        int c = 0;
        Node cur = head;
        while(cur!=null){
        System.out.println();
        System.out.print((cur.name==null?"name is null":cur.name)); // +(head==null?null:head.item)
        System.out.print(" --> "+(cur.CCode==null?"No CCOde":cur.CCode));
        System.out.print(" --> "+(cur.year==0?null:cur.year));
        System.out.print(" --> "+(cur.value==0?null:cur.value));
        cur = cur.next;c++;
        }
       
    }
}
