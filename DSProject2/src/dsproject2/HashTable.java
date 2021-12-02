package dsproject2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class HashTable<T> {
    public static int size = 0;
    public static LinkedList[] arr;
    public static int p = 0;
    public static int col = 0;
    public HashTable(String inPath, int c, int s, int prime) throws FileNotFoundException,IOException {
        col = c;
        size = s;
        p = prime;
        arr = new LinkedList[size];
        readFile(inPath);
       

       
    }

    public static void put(Node n){
        int x = 0;
        switch (col){
        
            case 1:
               x = (int) hash(n.name); 
            case 2:
               x = (int) hash(n.CCode);
            case 3:
               x = (int) hash(n.year); 
        }       
        if(arr[x] == null)
            arr[x] = new LinkedList();
        arr[x].insertLast(n);

    }
    /*
    public long hash(T t){
        switch(col){
        
            case 1:
         
        }
                

        }
*/
    public static long hash(String s){
        int n = s.length();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + (s.charAt(i) * (int)Math.pow(31, n-1-i));
        }

        return sum % p; // better to make p a variable
    }
    public static long hash(int d){   
        return d % p; // 
    }

    public static void readFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner inFile = new Scanner(file);

        while (inFile.hasNextLine()) {
            String line = inFile.nextLine();
            String[] col = line.split(Character.toString(','));
          //  if(col.length > )

            Node temp= new Node(col[0],col[1],Integer.parseInt(col[2]),Double.parseDouble(col[3]));
            put(temp);
        }
        inFile.close();
    }
    public static void writeFile(String outPath) throws IOException {
        FileWriter myWriter = new FileWriter(outPath);
        int b = 1;
        for (int i = 0; i < size; i++) {
           // myWriter.write(" "); // we have a problem here :)
            if (arr[i]!= null) {
           //  myWriter.write("end of iteration " + i + "\n");
                
            Node cur = arr[i].head;
            while(cur!=null){
            myWriter.write(cur.name + ", "+cur.CCode + ", "+cur.year + ", "+ cur.value+"\n");
               System.out.println(b+" "+cur.name + ", "+cur.CCode + ", "+cur.year + ", "+ cur.value+"\n");
               b++;
            cur = cur.next;
            }
            }
             
        }
       
    }


    public void removeData(String s){
        // if(year < 0 )
        //  throw new IllegalArgumentException("Year cannot be negative!");

        outer: for (int i = 0; i < size; i++) {
            if(arr[i]!= null){ // it has a linked list in it
                while(arr[i].head.CCode.equals(s) || arr[i].head.name.equals(s)){
                    arr[i].head = arr[i].head.next;
                }
                Node prev = arr[i].head;
                Node cur = arr[i].head.next;
                // continue; // because every year has only one data

                inner: while(cur!=null){ // size > 2
                    if(cur.CCode.equals(s) || cur.name.equals(s)){
                        cur = cur.next;
                        prev.next = cur;

                        //   prev = prev.next;
                        continue inner; // go to the next element in the array
                    }
                    prev = prev.next; // traverse
                    cur = cur.next;   // traverse
                }
            }
        }             }

    public void removeData(int year){
        if(year < 0 )
            throw new IllegalArgumentException("Year cannot be negative!");

        outer: for (int i = 0; i < size; i++) {
            if(arr[i]!= null){ // it has a linked list in it
                while(arr[i].head.year == year){
                    arr[i].head = arr[i].head.next;
                }
                Node prev = arr[i].head;
                Node cur = arr[i].head.next;
                // continue; // because every year has only one data

                inner: while(cur!=null){ // size > 2
                    if(cur.year == year){
                        cur = cur.next;
                        prev.next = cur;

                        //   prev = prev.next;
                        continue inner; // go to the next element in the array
                    }
                    prev = prev.next; // traverse
                    cur = cur.next;   // traverse
                }
            }
        }             }

    public void Print(){
        for (int i =0 ; i < size ; i++){
            if (arr[i] != null) {
                arr[i].printList();
            }

        }

    }
}

