package dsproject2;

public class Node {
    Node next = null;
 //   Node prev = null;
    String name= null;
    String CCode= null;
    int year =0;
    double value=0.0;
    public Node(){}
    public Node(String name, String CCode, int year, double value) {
        this.name = name;
        this.CCode = CCode;
        this.year = year;
        this.value = value;
    }
  @Override
 public String toString(){
        return (this.name+" " + this.CCode+" "+this.year+" "+this.value);
  }
}
