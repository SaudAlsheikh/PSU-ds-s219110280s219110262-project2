package dsproject2;

public class Node {
    Node next;
    String name;
    String CCode;
    int year;
    double value;
    public Node(String name, String CCode, int year, double value) {
        this.name = name;
        this.CCode = CCode;
        this.year = year;
        this.value = value;
    }


}
