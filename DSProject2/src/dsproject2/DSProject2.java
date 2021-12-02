
package dsproject2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class DSProject2<T> {


    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("please enter the method: (1 for LPM) (2 for Chaining)");
        int type = scan.nextInt();
        if (type == 2) {
            HashTable h = new HashTable("C:\\Users\\user\\Desktop\\EXCEL FILES\\C.csv", 2, 24000, 313);
            // maybe remove
           // h.removeData(2002);
            h.removeData("WLF");
            h.removeData("JOR");
            h.removeData("CYP");
            h.removeData("BMU");
            h.removeData("ZMB");









           /* h.removeData("Poland");
            h.removeData("Morocco");
            h.removeData("Saudi Arabia");
            h.removeData("Senegal");
            h.removeData("Vietnam");
            h.removeData("Wallis and Futuna"); */
            h.writeFile("C:\\Users\\user\\Desktop\\EXCEL FILES\\outPut.csv");
        } else {
            LPHashTable h = new LPHashTable("C:\\Users\\user\\Desktop\\EXCEL FILES\\D.csv", 1, 100000, 1913);
            //h.Print();
            h.removeData("Poland");
            h.removeData("Morocco");
            h.removeData("Saudi Arabia");
            h.removeData("Senegal");
            h.removeData("Vietnam");
            h.removeData("Wallis and Futuna");
            h.writeFile("C:\\Users\\user\\Desktop\\EXCEL FILES\\outPut.csv");
        }
    }
}




