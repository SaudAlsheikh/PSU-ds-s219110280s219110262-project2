
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
            HashTable h = new HashTable("C:\\Users\\user\\Desktop\\EXCEL FILES\\B.csv", 3, 100000, 919);


            long start = System.currentTimeMillis();
            h.removeData(2002);
            long end = System.currentTimeMillis();
            System.out.println("total time to remove data: " + ((end - start) * Math.pow(10, -3)) + " s");


            /*h.removeData("Poland");
            h.removeData("Morocco");
            h.removeData("Saudi Arabia");
            h.removeData("Senegal");
            h.removeData("Vietnam");
            h.removeData("Wallis and Futuna");
            h.removeData("WLF");
            h.removeData("JOR");
            h.removeData("CYP");
            h.removeData("BMU");
            h.removeData("ZMB"); */


            start = System.currentTimeMillis();
            h.writeFile("C:\\Users\\user\\Desktop\\EXCEL FILES\\outPut.csv");
            end = System.currentTimeMillis();
            System.out.println("total time to write data: " + ((end - start) * Math.pow(10, -3)) + " s");
        } else {
            LPHashTable h = new LPHashTable("C:\\Users\\user\\Desktop\\EXCEL FILES\\B.csv", 3, 100000, 919);



            long start = System.currentTimeMillis();
            h.removeData(2002);
            long end = System.currentTimeMillis();
            System.out.println("total time to remove data: " + ((end - start) * Math.pow(10, -3)) + " s");


            /*h.removeData("Poland");
            h.removeData("Morocco");
            h.removeData("Saudi Arabia");
            h.removeData("Senegal");
            h.removeData("Vietnam");
            h.removeData("Wallis and Futuna");
            h.removeData("WLF");
            h.removeData("JOR");
            h.removeData("CYP");
            h.removeData("BMU");
            h.removeData("ZMB"); */


            start = System.currentTimeMillis();
            h.writeFile("C:\\Users\\user\\Desktop\\EXCEL FILES\\outPut.csv");
            end = System.currentTimeMillis();
            System.out.println("total time to write data: " + ((end - start) * Math.pow(10, -3)) + " s");
        }
    }
}




