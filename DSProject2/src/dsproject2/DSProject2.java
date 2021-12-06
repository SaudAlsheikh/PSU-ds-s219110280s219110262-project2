
package dsproject2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class DSProject2<T> {

// chaange the input so that the user put the input file and output
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);


        System.out.println("please enter the method: (1 for LPM) (2 for Chaining)");
        int type = scan.nextInt();
        if (type == 2) {
            System.out.println("num of keys");
            int number= scan.nextInt();
            System.out.println("please enter the keys");
            String[] keys= new String[6];
            int i=0;
            keys[i]=scan.nextLine();
            while(i != number ){
                keys[i]= scan.nextLine();
                i++;
            }
            for(int j =0;j< keys.length;j++)
                System.out.println(keys[j]);

            HashTable h = new HashTable("C:\\Users\\user\\Desktop\\EXCEL FILES\\C.csv","C:\\Users\\user\\Desktop\\EXCEL FILES\\outPut.csv", 2, 24000, 313,keys);


           /* long start = System.currentTimeMillis();

            long end = System.currentTimeMillis();
            System.out.println("total time to remove data: " + ((end - start) * Math.pow(10, -3)) + " s"); */


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

        /*
            start = System.currentTimeMillis();
            h.writeFile("C:\\Users\\user\\Desktop\\EXCEL FILES\\outPut.csv");
            end = System.currentTimeMillis();
            System.out.println("total time to write data: " + ((end - start) * Math.pow(10, -3)) + " s"); */
        } else {
            System.out.println("num of keys");
            int number= scan.nextInt();
            System.out.println("please enter the keys");
            String[] keys= new String[6];
            int i=0;
            keys[i]=scan.nextLine();
            while(i != number ){
                keys[i]= scan.nextLine();
                i++;
            }
            for(int j =0;j< keys.length;j++)
                System.out.println(keys[j]);

            LPHashTable h = new LPHashTable("C:\\Users\\user\\Desktop\\EXCEL FILES\\D.csv","C:\\Users\\user\\Desktop\\EXCEL FILES\\outPut.csv", 1, 100000, 313,keys);


           // long start = System.currentTimeMillis();
           // h.removeData(2002);
           // long end = System.currentTimeMillis();
           // System.out.println("total time to remove data: " + ((end - start) * Math.pow(10, -3)) + " s");


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


          /*  start = System.currentTimeMillis();
            h.writeFile("C:\\Users\\user\\Desktop\\EXCEL FILES\\outPut.csv");
            end = System.currentTimeMillis();
            System.out.println("total time to write data: " + ((end - start) * Math.pow(10, -3)) + " s"); */
        }
    }
}




