
package dsproject2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class DSProject2<T> {


    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scan = new Scanner(System.in);

        System.out.println("please enter the method: (1 for LPM) (2 for Chaining)");
        int type = scan.nextInt();
        if (type == 2) {
            HashTable h = new HashTable("C:\\Users\\HP\\Downloads\\D.csv", 1, 8000, 313);
          //  h.Print();
            // maybe remove
            h.removeData("Poland");
            h.removeData("Morocco");
            h.removeData("Saudi Arabia");
            h.removeData("Senegal");
            h.removeData("Vietnam");
            h.removeData("Wallis and Futuna");
            h.writeFile("C:\\Users\\HP\\Downloads\\OutputOfDDD.csv");
        } else {
            LPHashTable h = new LPHashTable("C:\\Users\\user\\Desktop\\EXCEL FILES\\B.csv", 3, 8961, 11);
            h.Print();
            // maybe remove
            h.writeFile("C:\\Users\\user\\Desktop\\EXCEL FILES\\outPut.csv");
        }
    }
}




