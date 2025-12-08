import java.util.ArrayList;
import java.util.Arrays;

public class BST {
    public Node root;

    public BST() {
        this.root = null;
    }

    public boolean contains(String key) {
        return contains(key, root);
    }

    public boolean contains(String key, Node node) {
        if (node == null)
            return false;
        if (node.key.equals(key))
            return true;
        return contains(key, node.left) || contains(key, node.right);
    }

    public Node findMin() {
        return findMin(root);
    }

    public Node findMin(Node node) {
        if (node == null)
            return null;
        Node temp = node;
        while (temp.left != null)
            temp = temp.left;
        return temp;
    }

    private String sortedWord(String word){
        word=word.toLowerCase();
        char[] arr = word.toCharArray();
        //do selection sort
        for(int i=0;i<arr.length-1;i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }

            char temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        return new String(arr);
    }

    public void put(String str) {
        root = put(sortedWord(str), str, root);
    }

    public Node put(String key, String val, Node node) {
        if (node == null) {
            return new Node(key, val);
        }
        if (key.compareTo(node.key)<0) { //put on left
            node.left=put(key,val,node.left);
        } else if (key.compareTo(node.key)>0){ //put on right
            node.right=put(key,val,node.right);
        } else {
            node.values.add(val);
        }
        return node;
    }

    public void printAnagrams(String key){
        key=sortedWord(key);
        ArrayList<String> words = getAnagrams(root, key);
        for(int i=0;i<words.size();i++){
            System.out.println(words.get(i));
        }
    }

    private ArrayList<String> getAnagrams(Node current, String key){
        if(current==null){
            return null;
        }

        if(current.key.equals(key)){
            return current.values;
        } if (key.compareTo(current.key)<0) { //put on left
            return getAnagrams(current.left, key);
        } else if (key.compareTo(current.key)>0){ //put on right
            return getAnagrams(current.right, key);
        } else {
            return null;
        }
    }



//
//    public void inOrder(){
//        inOrderRec(root);
//    }
//
//    private void inOrderRec(Node current){
//        if(current==null){
//            return;
//        }
//        inOrderRec(current.left);
//        System.out.print(current.values+" ");
//        inOrderRec(current.right);
//    }
//




}