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

    public LPHashTable(String inPath,String outPath, int c, int s,int prime,String[] keys) throws Exception {

        System.out.println("Reading data...");
        this.col = c;
        size = s;
        p = prime;
        arr = new Node[size];
        long start = System.currentTimeMillis();
        readFile(inPath);
        long end = System.currentTimeMillis();
        System.out.println("total time to read data: " + ((end - start) * Math.pow(10, -3)) + " s");
        isInteger(keys);
        writeFile(outPath);


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
            if (col.length == 4) { // File A, B, C
                temp = new Node(col[0], col[1], Integer.parseInt(col[2]), Double.parseDouble(col[3]));
                    put(temp);
                                 }
            else if(col.length ==9) { // File D
                temp = new Node(col[0], col[1], Integer.parseInt(col[2]), Double.parseDouble(col[3]), Double.parseDouble(col[4])
                , Double.parseDouble(col[5]), Double.parseDouble(col[6]),Double.parseDouble(col[7]),Double.parseDouble(col[8]));
                    put(temp);
                 }
                                     }
        inFile.close();
    }

    public static void writeFile(String outPath) throws IOException {
        System.out.println("Writing data to output file");
        double start = System.currentTimeMillis();
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
        double end = System.currentTimeMillis();
        System.out.println("total time to write data: " + ((end - start) * Math.pow(10, -3)) + " seconds.");

    }


    public static void removeInt(int[] y) {
        System.out.print("Searching and removing ");
        double start = System.currentTimeMillis();
        for (int a = 0; a < y.length; a++) {
            if (y[a] < 0)
                throw new IllegalArgumentException("Year cannot be negative!");
            if (y[a] == 0)
                continue;
            System.out.print(y[a]+" ");
                int i = 0;
                Node empty = new Node("deleted", "del", 0, 0.0);
                while (i < size) {
                    if (arr[i] != null)
                        if (arr[i].year == y[a])
                            arr[i] = empty;
                    i++;
                }
            }
        double end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("total time to remove data: " + ((end - start) * Math.pow(10, -3)) + " seconds");
        }

    public static void removeString(String[] s){
        System.out.print("Searching and removing ");
        double start = System.currentTimeMillis();
            for (int a = 0; a < s.length; a++) {
                if(s.equals(null))
                    throw new IllegalArgumentException("name OR code cannot be null!");
                if (s[a] == null)
                    continue;
                System.out.print(s[a]+" ");
                    int i = 0;
                    Node empty = new Node("deleted", "del", 0, 0.0);
                    while (i < size) {
                        if (arr[i] != null)
                            if (arr[i].name.equals(s[a]) || arr[i].CCode.equals(s[a]))
                                arr[i] = empty;
                        i++;
                    }
                }
        double end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("total time to remove data: " + ((end - start) * Math.pow(10, -3)) + " seconds");
            }

    public void Print() { // A method to print the HashTable with its indecies.
        for (int i = 0; i < size; i++) {
            if (arr[i] != null) {
                System.out.println("(" + i + ") = " + arr[i]);
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

