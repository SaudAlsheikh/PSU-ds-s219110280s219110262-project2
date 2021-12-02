package dsproject2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LPHashTable<T> {
    public static int size = 0;
    public static Node[] arr;
    public static int p = 0;
    public static int col = 0;
    public static int capacity = 0;
    public LPHashTable(String inPath,int c, int s, int prime) throws Exception {

        col = c;
        size = s;
        p = prime;
        arr = new Node[size];
        readFile(inPath);
        //  writeFile(outPath);
    }

    public static void put(Node n) throws Exception {
        if(capacity == size)
            throw new Exception("hashmap is full");
        int x = 0;
        switch (col){

            case 1:
                x = (int) hash(n.name);
            case 2:
                x = (int) hash(n.CCode);
            case 3:
                x = (int) hash(n.year);
        }
        if(arr[x] == null){
            arr[x] = n;
            return;
        }
        Node temp = arr[x];
        int i=1;
        while(temp!=null){
            temp = arr[x+i % size];
            if(temp == null)
                arr[x+i % size] = n;
            else
                i++;
        }
    capacity++;
    }

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

    public static void readFile(String path) throws Exception {

        File file = new File(path);
        Scanner inFile = new Scanner(file);

        while (inFile.hasNextLine()) {
            String line = inFile.nextLine();
            String[] col = line.split(Character.toString(','));
            Node temp= new Node(col[0],col[1],Integer.parseInt(col[2]),Double.parseDouble(col[3]));
            put(temp);
        }
        inFile.close();
    }
    public static void writeFile(String outPath) throws IOException {
        FileWriter myWriter = new FileWriter(outPath);
        for (int i = 0; i < size; i++) {
            if (arr[i]!= null) {

                Node cur = arr[i];
                while(cur!=null){
                    myWriter.write(cur.name + ", ");
                    myWriter.write(cur.CCode + ", ");
                    myWriter.write(cur.year + ", ");
                    myWriter.write(String.valueOf(cur.value));
                    myWriter.write("\n");
                    cur = cur.next;
                }
            }

        }

    }


    public void removeData(int year) {
        if (year < 0)
            throw new IllegalArgumentException("Year cannot be negative!");
        int i = 0;
        Node empty = new Node("deleted", "del", 0, 0.0);
        while (i < size) {
            if (arr[i].year == year)
                arr[i] = empty;
            i++;
        }
    }

    public void removeData(String s){
        if(s.equals(null))
            throw new IllegalArgumentException("name cannot be null!");
        int i =0;
        Node empty= new Node("deleted","del",0,0.0);
        while(i < size){
            if(arr[i].name.equals(s)  || arr[i].CCode.equals(s))
                arr[i] = empty;
            i++;
        }          }

    public void Print(){
        for (int i =0 ; i < size ; i++){
            if (arr[i] != null) {
                System.out.println("("+i+") = " + arr[i]);
            }

        }

    }
}
