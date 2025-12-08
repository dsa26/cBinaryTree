import java.util.ArrayList;
import java.util.LinkedList;

public class Node {
    public Node left;
    public Node right;
    public String key;
    public ArrayList<String> values;

    public Node(String key, String val) {
        this.key = key;
        values = new ArrayList<>();
        values.add(val);
        this.left = null;
        this.right = null;
    }

}