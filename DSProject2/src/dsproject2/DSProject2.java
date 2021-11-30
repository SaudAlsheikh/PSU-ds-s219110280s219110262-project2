
package dsproject2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
public class DSProject2 {


    public static void main(String[] args) throws FileNotFoundException,IOException  {
        Scanner scan = new Scanner(System.in);
        HashTable h = new HashTable("C:\\Users\\HP\\Downloads\\B.csv", "C:\\Users\\HP\\Downloads\\ourFile.csv", 1, 8000, 11);
      //  h.removeData(2012);
        h.Print();
        
    }
}

