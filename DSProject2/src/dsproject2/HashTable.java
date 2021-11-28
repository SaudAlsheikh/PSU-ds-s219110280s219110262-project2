package dsproject2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashTable {
    int n;
   public static LinkedList[] arr;
    
   public HashTable(String path) throws FileNotFoundException {
       LinkedList[] arr = new LinkedList[383];
       readFile(path);
   }

   public static void put(Node n){
       int x = (int) hash(n.name);
       arr[x] = new LinkedList();
       arr[x].insertFirst(n);
   }
   
   public static long hash(String s){
      int n = s.length();
   long sum = 0;
       for (int i = 0; i < n; i++) {       
           sum = sum + (s.charAt(i) * (int)Math.pow(31, n-1-i));
       }
       
   return sum % 383;
   }

    public static void readFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner inFile = new Scanner(file);

        while (inFile.hasNextLine()) {
            String line = inFile.nextLine();
            String[] col = line.split(Character.toString(','));
            Node temp= new Node(col[0],col[1],Integer.parseInt(col[2]),Double.parseDouble(col[2]));
            put(temp);
        }
        inFile.close();
    }

    public void Print(){
       //for (int i =0 ; i < 383 ; i++){
           arr[0].printList();


    }
    }
