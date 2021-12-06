package dsproject2;

public class Node {
    Node next = null;
    String name= null;
    String CCode= null;
    int year =0;
    double[]values = new double[6]; // An array of double values to store File D values.
    double value=0.0;
   

    public Node(String name, String CCode, int year, double value) {
        this.name = name;
        this.CCode = CCode;
        this.year = year;
        this.value = value;
        values[0]= -1; // A marker to distinguish both nodes that this is the node with 1 value. ( File A, B, C).
    }
    public Node(String name, String CCode, int year, double value1, double value2, double value3, double value4, double value5, double value6) {
        this.name = name;
        this.CCode = CCode;
        this.year = year;
        values[0] = value1; // All the values in File D in the []values array.
        values[1] = value2;
        values[2] = value3;
        values[3] = value4;
        values[4] = value5;
        values[5] = value6;
    }
  @Override
 public String toString(){
        return (this.name+" " + this.CCode+" "+this.year+" "+this.value);
  }
}
