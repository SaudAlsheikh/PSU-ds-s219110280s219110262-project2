
package dsproject2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class DSProject2 {

   
    public static void main(String[] args) throws FileNotFoundException {

    HashTable h = new HashTable("C:\\Users\\HP\\Downloads\\A.csv");
        h.Print();


    }
    public static void readFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner inFile = new Scanner(file);

        while (inFile.hasNextLine()) {
            String line = inFile.nextLine();
            String[] col = line.split(Character.toString(','));
            Node temp= new Node(col[0],col[1],Integer.parseInt(col[2]),Double.parseDouble(col[2]));

        }
        inFile.close();
    }

    }

