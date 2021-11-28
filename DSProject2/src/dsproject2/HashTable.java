package dsproject2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashTable {
    int n;
    LinkedList[] arr;
    
   public HashTable(){
    for(int i=0;i<383;i++)
    {
        arr[i]=new LinkedList();
    }
   }
   
   public long hash(String s){
      int n = s.length();
   long sum = 0;
       for (int i = 0; i < n; i++) {       
           sum = sum + (s.charAt(i) * (int)Math.pow(31, n-1-i));
       }
       
   return sum % 383;
   }
   
    public String readFile(String filePath)throws FileNotFoundException{
        File file = new File(filePath);        
        Scanner scan = new Scanner(file);
    String s="";
    while(scan.hasNextLine()){
        s = scan.nextLine();
        break;
    }
        scan.close();
    return s;
    
    }
}