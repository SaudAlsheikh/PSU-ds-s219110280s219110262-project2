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
    public static int capacity = 0;
   // public static String[] Rkeys= new String[5];

    public HashTable(String inPath,String outPath, int c, int s,int prime,String[] keys) throws IOException { // constructor
        System.out.println("Reading data...");
        this.col = c;
        size = s;
        p = prime;
        arr = new LinkedList[size];
        long start = System.currentTimeMillis();
        readFile(inPath);
        long end = System.currentTimeMillis();
        System.out.println("total time to read data: " + ((end - start) * Math.pow(10, -3)) + " s");
        isInteger(keys);
        writeFile(outPath);
        System.out.println(capacity);

    }

    public static void put(Node n) {
        int x = 0;
        switch (col) { // switch statement to determine which column to hash
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
        if (arr[x] == null){ // if there's no linked list in the cell then create one
            arr[x] = new LinkedList();
            capacity++;
        }
        arr[x].insertLast(n); //if there's a linkedlist then just insert

    }

    public static int hash(String s) { // this hash method is for country name and code
        int n = s.length(); // get length to know how many iteration we need
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + s.charAt(i) * Math.pow(31, s.length() - 1 - i); // here we take each letter then hash it and add it to sum
        }
        sum = sum % p; // p= prime number
        return (int) sum;
    }

    public static long hash(int d) { // this hash method is for year
        return d % p;
    }

    public static void readFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner inFile = new Scanner(file);
        while (inFile.hasNextLine()) { // loop to read the whole file
            String line = inFile.nextLine(); // takes the whole line name,ccode,year and value as a string
            String[] col = line.split(Character.toString(',')); // split the into an array of strings
            Node temp;
            if (col.length == 4 ) { // if there's less than 3 col use the following node constructor
                temp = new Node(col[0], col[1], Integer.parseInt(col[2]), Double.parseDouble(col[3]));
                put(temp);
            } else if(col.length ==9) { // if more than 4 use  the following node constructor
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
        System.out.println("Writing data to output file");
        double start = System.currentTimeMillis();
        FileWriter myWriter = new FileWriter(outPath);
        for (int i = 0; i < size; i++) { // iterate through the array
            if (arr[i] != null && arr[i].head != null) {
                if (arr[i].head.values[0] == -1) { // we put -1 as marker for us so that we know which node is it (multiple values or one value)
                    Node cur = arr[i].head;
                    while (cur != null) { // iterate through the list
                        myWriter.write(cur.name + ", " + cur.CCode + ", " + cur.year + ", " + cur.value + "\n");
                        cur = cur.next;
                    }
                } else if (arr[i] != null && arr[i].head.values[0] != -1) { // this indicates that we have multiple values
                    Node cur = arr[i].head;
                    while (cur != null) { // iterate through the list
                        myWriter.write(cur.name + ", " + cur.CCode + ", " + cur.year + ", " + cur.values[0] + ", " + cur.values[1] + ", " +
                                cur.values[2] + ", " + cur.values[3] + ", " + cur.values[4] + ", " + cur.values[5] + "\n");
                        cur = cur.next;
                    }
                }
            }
        }
        double end = System.currentTimeMillis();
        System.out.println("total time to write data: " + ((end - start) * Math.pow(10, -3)) + " seconds.");
    }


    public static void removeString(String[] s) {
        System.out.print("Searching and removing ");
        double start = System.currentTimeMillis();
        for(int a=0; a< s.length;a++){
            if(s[a]== null)
                continue;
            System.out.print(s[a]+" ");
        outer: // to iterate through the array
        for (int i = 0; i < size; i++) {
            if (arr[i] != null) { // it has a linked list in it
                if (arr[i].head != null)
                    while (arr[i].head.CCode.equals(s[a]) || arr[i].head.name.equals(s[a])) {
                        arr[i].deleteHead();
                        if (arr[i].lSize == 0)
                            continue outer;
                    }
                if (arr[i].lSize == 0)
                    continue outer;
                Node prev = arr[i].head;
                Node cur = arr[i].head.next;
                inner: //to iterate through the linked list
                while (cur != null) { // size > 2
                    if (cur.CCode.equals(s[a]) || cur.name.equals(s[a])) {
                        cur = cur.next;
                        prev.next = cur;
                        continue inner; // go to the next element in the array
                    }
                    prev = prev.next; // traverse
                    cur = cur.next;   // traverse
                    }
                }
            }
        }
        double end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("total time to remove data: " + ((end - start) * Math.pow(10, -3)) + " seconds");
    }

    public static void removeInt(int[] y) {
        System.out.print("Searching and removing ");
        double start = System.currentTimeMillis();
        for (int a = 0; a < y.length; a++) {
            if(y[a] == 0)
                continue;
            System.out.print(y[a]+" ");
                outer:
                // to iterate through the array
                for (int i = 0; i < size; i++) {
                    if (arr[i] != null) { // it has a linked list in it
                        while (arr[i].head.year == y[a]) { // here we check the head. if it equals the year we delete and then recheck
                            if (arr[i].head.next == arr[i].tail) { // if there is no nodes left we put the node below to avoid NullPointerException
                                arr[i].head = arr[i].head.next;
                                arr[i].head = arr[i].tail = new Node("deleted", "del", 0, 0);
                                continue outer;
                            } else {
                                arr[i].head = arr[i].head.next;

                            }
                        }
                        Node prev = arr[i].head;
                        Node cur = arr[i].head.next;


                        inner:
                        //to iterate through the linked list
                        while (cur != null) { // size > 2
                            if (cur.year == y[a]) {
                                cur = cur.next;
                                prev.next = cur;
                                continue inner; // go to the next element in the array
                            }
                            prev = prev.next; // traverse
                            cur = cur.next;   // traverse
                        }
                    }
                }
            }
        double end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("total time to remove data: " + ((end - start) * Math.pow(10, -3)) + " seconds");
        }


    public void Print() {
        for (int i = 0; i < size; i++) {
            if (arr[i] != null) {
                arr[i].printList();
            }

        }
    }
    public static String isInteger(String[] nums) {
        try {
            int num = Integer.parseInt(nums[0]);
        } catch (NumberFormatException nfe) {
            removeString(nums);
            return " ";
        }
        int[] years = new int[5];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == null)
                continue;
            years[i] = Integer.parseInt(nums[i]);
        }
        removeInt(years);
        return" ";
    }
}