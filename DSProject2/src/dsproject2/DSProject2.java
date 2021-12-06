
package dsproject2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class DSProject2<T> {

    // chaange the input so that the user put the input file and output
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int type = Integer.parseInt(args[4]);
        if (type == 2) {
            String[] keys = new String[6];
            int g = 6;
            int s = 0;
            while (args[g] != null) {
                keys[s] = args[g];
                s++;
                g++;
                if (g == args.length)
                    break;
            }
            HashTable h = new HashTable(args[0], args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[5]), keys);

        } else {
            String[] keys = new String[6];
            int g = 6;
            int s = 0;
            while (args[g] != null) {
                keys[s] = args[g];
                s++;
                g++;
                if (g == args.length)
                    break;
            }
            LPHashTable h = new LPHashTable(args[0], args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[5]), keys);
        }
    }
}




