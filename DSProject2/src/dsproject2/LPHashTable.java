package dsproject2;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LPHashTable<T> {
    public static int size = 0;
    public static Node[] arr; // Array of nodes
    public static int p = 0; // Prime number
    public static int col = 0;
    public static int capacity = 0; // a counter to count the # of elements in the array.

    public LPHashTable(String inPath, int c, int s, int prime) throws Exception {

        col = c;
        size = s;
        p = prime;
        arr = new Node[size];
        long start = System.currentTimeMillis();
        readFile(inPath);
        long end = System.currentTimeMillis();
        System.out.println("total time to read data: "+((end-start)* Math.pow(10,-3))+" s");
        System.out.println("Capacity is: " + capacity +  " & size is: " + size + "\n" + "Load Factor is: " + (double)capacity/size);
    }

    public static void put(Node n) throws Exception {
        if (capacity == size)
            throw new Exception("Hashmap is full");
        int x = 0; 
        switch (col) { // Switch statement to determine which column to hash.

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
        if (arr[x] == null) { // if no node already exists in the array, put the node here.
            arr[x] = n;
            return;
        }
        Node temp = arr[x]; // arr[x] is occupied, then do the formula to find the next empty spot.
        int i = 1;
        while (temp != null) { // while loop to keep iterating while temp is not null
                temp = arr[x + i % size]; // LP formula to find the next empty spot.
            if (temp == null) // found the empty spot
                arr[x + i % size] = n; // put the node into the empty spot
            else
                i++;
        }
        capacity++;
    }

    public static int hash(String s) { // Hashing function (String)
        int n = s.length();
        double sum = 0; // we made it double because double can afford more digits than INT.
        for (int i = 0; i < n; i++) {
            sum = sum + s.charAt(i) * Math.pow(31, s.length() - 1 - i);
        }
            sum = sum % p;
        return (int) sum; 
    }

    public static long hash(int d) { // Hashing Function (Integer)
        return d % p;
    }

    public static void readFile(String path) throws Exception {

        File file = new File(path);
        Scanner inFile = new Scanner(file);

        while (inFile.hasNextLine()) {
            String line = inFile.nextLine();
            String[] col = line.split(Character.toString(',')); // arr col to store the data of each row based on splitting whenever finds a comma
            Node temp;
            if (col.length <= 4) { // File A, B, C
                temp = new Node(col[0], col[1], Integer.parseInt(col[2]), Double.parseDouble(col[3]));
                    put(temp);
                                 }
            else { // File D
                temp = new Node(col[0], col[1], Integer.parseInt(col[2]), Double.parseDouble(col[3]), Double.parseDouble(col[4])
                , Double.parseDouble(col[5]), Double.parseDouble(col[6]),Double.parseDouble(col[7]),Double.parseDouble(col[8]));
                    put(temp);
                 }
                                     }
        inFile.close();
    }

    public static void writeFile(String outPath) throws IOException {
        FileWriter myWriter = new FileWriter(outPath);
        for (int i = 0; i < size; i++) {
            if (arr[i] != null)
                if (arr[i].values[0]== -1) { // Our marker in class Node is true? then write based on the structure of Files A, B, C
                    myWriter.write(arr[i].name + ", " + arr[i].CCode + ", " + arr[i].year + ", " + arr[i].value + "\n");
                }
                else { // Marker is false? Write based on structure of File D.
                    myWriter.write(arr[i].name + ", " + arr[i].CCode + ", " + arr[i].year + ", " + arr[i].values[0] + ", " + arr[i].values[1] + ", " +
                            arr[i].values[2] + ", " + arr[i].values[3] + ", " + arr[i].values[4] + ", " + arr[i].values[5] + "\n");
                }
        }

    }


    public void removeData(int year) {
        if (year < 0)
            throw new IllegalArgumentException("Year cannot be negative!");
        int i = 0;
        Node empty = new Node("deleted", "del", 0, 0.0);
        while (i < size) {
            if (arr[i] != null)
                if (arr[i].year == year)
                    arr[i] = empty;
            i++;
        }
    }

    public void removeData(String s) {
        if (s.equals(null))
            throw new IllegalArgumentException("name OR code cannot be null!");
        int i = 0;
        Node empty = new Node("deleted", "del", 0, 0.0);
        while (i < size) {
            if(arr[i] != null)
            if (arr[i].name.equals(s) || arr[i].CCode.equals(s))
                arr[i] = empty;
            i++;
        }
    }

    public void Print() { // A method to print the HashTable with its indecies.
        for (int i = 0; i < size; i++) {
            if (arr[i] != null) {
                System.out.println("(" + i + ") = " + arr[i]);
            }

        }

    }
}
