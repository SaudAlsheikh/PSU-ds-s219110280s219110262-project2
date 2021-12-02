
package dsproject2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
public class DSProject2 {


    public static void main(String[] args) throws FileNotFoundException,IOException  {
        Scanner scan = new Scanner(System.in);
        System.out.println("please enter the method: (1 for LPM) (2 for Chaining)");
        int type = scan.nextInt();
        if(type == 2){
            HashTable h = new HashTable("C:\\Users\\user\\Desktop\\EXCEL FILES\\B.csv", "C:\\Users\\user\\Desktop\\EXCEL FILES\\outout2.txt", 1, 2000, 821,"Yemen");

        }else {
            LPHashTable h = new LPHashTable("C:\\Users\\user\\Desktop\\EXCEL FILES\\B.csv", "C:\\Users\\user\\Desktop\\EXCEL FILES\\outPut.csv", 3, 8961, 11, "Yemen");
            h.Print();
        }

        
    }
}

