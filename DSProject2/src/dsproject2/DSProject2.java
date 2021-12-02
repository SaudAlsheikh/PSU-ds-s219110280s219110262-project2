
package dsproject2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
public class DSProject2<T> {


    public static void main(String[] args) throws FileNotFoundException,IOException  {
        Scanner scan = new Scanner(System.in); 
        System.out.println("please enter the method: (1 for LPM) (2 for Chaining)");
        int type = scan.nextInt();
        System.out.println("Please enter what u wanna delete: (1 for Name or Country Code) (2 for years)");
        int delType = scan.nextInt();
        String data;
        if(type == 2){
           HashTable h = new HashTable("C:\\Users\\user\\Desktop\\EXCEL FILES\\B.csv", 1, 2000, 821);
           System.out.println("Enter countries you want to delete: (Press Enter to finish) ");
           
            if (delType == 1) {
                
            
           do {                    
                    data = scan.nextLine();
                    h.removeData(data);
                } while (!data.equals(null)); 
           
           h.writeFile("C:\\Users\\user\\Desktop\\EXCEL FILES\\outout2.txt");
            
            }
        }else {
            LPHashTable h = new LPHashTable("C:\\Users\\user\\Desktop\\EXCEL FILES\\B.csv", "C:\\Users\\user\\Desktop\\EXCEL FILES\\outPut.csv", 3, 8961, 11, "Yemen");
            h.Print();
        }
        
        
        
        /*
        String data;
        HashTable h;
        System.out.println("please enter the method: (1 for LPM) (2 for Chaining)");
        int type = scan.nextInt();
        if(type == 2){
             h = new HashTable("C:\\Users\\user\\Desktop\\EXCEL FILES\\B.csv", "C:\\Users\\user\\Desktop\\EXCEL FILES\\outout2.txt", 1, 2000, 821,"Yemen");

        }else {
            LPHashTable h = new LPHashTable("C:\\Users\\user\\Desktop\\EXCEL FILES\\B.csv", "C:\\Users\\user\\Desktop\\EXCEL FILES\\outPut.csv", 3, 8961, 11, "Yemen");
            h.Print();
        }
        
        HashTable.col = scan.nextInt();
        
        switch (HashTable.col){
            case 1: System.out.println("Enter the HashTable size:");
                HashTable.size = scan.nextInt();
                do { 
                    System.out.println("Enter countries you want to delete: ");
                    data = scan.nextLine();
                    h.removeData(data);
                } while (!data.equals(null));
            
        
        }
                */
        
    }
}

