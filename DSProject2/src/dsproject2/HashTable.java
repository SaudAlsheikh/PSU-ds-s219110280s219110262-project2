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

    public HashTable(String inPath, int c, int s, int prime) throws FileNotFoundException, IOException {
        this.col = c;
        size = s;
        p = prime;
        arr = new LinkedList[size];
        readFile(inPath);


    }

    public static void put(Node n) {
        int x = 0;
        switch (col) {
            case 1:
                x = (int) hash(n.name);             
                break;
            case 2:
                x = (int) hash(n.CCode);
                break;
            case 3:
                x = (int) hash(n.year);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + col);
        }
        if (arr[x] == null)
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
    public static int Ascii(char c) {
        return c;
    }

    public static int hash(String s) {
        int n = s.length();
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + s.charAt(i) * Math.pow(31, s.length() - 1 - i);
        }
        sum = sum % p;
        return (int) sum; // better to make p a variable
    }

    public static long hash(int d) {
        return d % p; // 
    }

    public static void readFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner inFile = new Scanner(file);

        while (inFile.hasNextLine()) {
            String line = inFile.nextLine();
            String[] col = line.split(Character.toString(','));
            Node temp;
            // System.out.println(col.length);
            if (col.length <= 4) {

                temp = new Node(col[0], col[1], Integer.parseInt(col[2]), Double.parseDouble(col[3]));
                put(temp);
            } else {
                temp = new Node(col[0], col[1], Integer.parseInt(col[2]), Double.parseDouble(col[3]), Double.parseDouble(col[4])
                        , Double.parseDouble(col[5])
                        , Double.parseDouble(col[6]),
                        Double.parseDouble(col[7]),
                        Double.parseDouble(col[8]));
                put(temp);
            }

        }
        inFile.close();
    }

    public static void writeFile(String outPath) throws IOException {
        FileWriter myWriter = new FileWriter(outPath);
        int b = 1;
        for (int i = 0; i < size; i++) { // iterate through the array
            // myWriter.write(" "); // we have a problem here :)
            if (arr[i] != null){
                if (arr[i].head.values[0] == -1) {
                    Node cur = arr[i].head;
                    while (cur != null) { // iterate through the list
                        myWriter.write(cur.name + ", " + cur.CCode + ", " + cur.year + ", " + cur.value + "\n");
                        cur = cur.next;
                    }
                } else if (arr[i] != null && arr[i].head.values[0]!= -1) {
                    Node cur = arr[i].head;
                    while (cur != null) { // iterate through the list
                        myWriter.write(cur.name + ", " + cur.CCode + ", " + cur.year + ", " + cur.values[0] + ", " + cur.values[1] + ", " +
                                cur.values[2] + ", " + cur.values[3] + ", " + cur.values[4] + ", " + cur.values[5] + "\n");
                        
                        cur = cur.next;

                    }
                }
        }
        }
    }


    public void removeData(String s) {
        // if(year < 0 )
        //  throw new IllegalArgumentException("Year cannot be negative!");

        outer:
        for (int i = 0; i < size; i++) {
            if (arr[i] != null) { // it has a linked list in it
                while (arr[i].head.CCode.equals(s) || arr[i].head.name.equals(s)) {
                    arr[i].head = arr[i].head.next;
                }
                Node prev = arr[i].head;
                Node cur = arr[i].head.next;
                // continue; // because every year has only one data

                inner:
                while (cur != null) { // size > 2
                    if (cur.CCode.equals(s) || cur.name.equals(s)) {
                        cur = cur.next;
                        prev.next = cur;

                        //   prev = prev.next;
                        continue inner; // go to the next element in the array
                    }
                    prev = prev.next; // traverse
                    cur = cur.next;   // traverse
                }
            }
        }
    }

    public void removeData(int year) {
        if (year < 0)
            throw new IllegalArgumentException("Year cannot be negative!");

        outer:
        for (int i = 0; i < size; i++) {
            if (arr[i] != null) { // it has a linked list in it
                while (arr[i].head.year == year) {
                    arr[i].head = arr[i].head.next;
                }
                Node prev = arr[i].head;
                Node cur = arr[i].head.next;
                // continue; // because every year has only one data

                inner:
                while (cur != null) { // size > 2
                    if (cur.year == year) {
                        cur = cur.next;
                        prev.next = cur;

                        //   prev = prev.next;
                        continue inner; // go to the next element in the array
                    }
                    prev = prev.next; // traverse
                    cur = cur.next;   // traverse
                }
            }
        }
    }

    public void Print() {
        for (int i = 0; i < size; i++) {
            if (arr[i] != null) {
                arr[i].printList();
            }

        }

    }
}

