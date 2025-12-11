public class BST {

    //standard binary search tree class with insert delete and find methods to test for time efficiency

    Node root;
    public BST() {
        root = null;
    }

    public boolean contains(int key){
        return contains(root,key);
    }

    private boolean contains(Node current, int key){
        if(current == null){
            return false;
        }
        if(current.val == key){
            return true;
        }
        if(current.val > key){
            return contains(current.left,key);
        } else {
            return contains(current.right,key);
        }
    }

    public void delete(int key) {
        root = delete(root,key);
    }

    private Node delete(Node current, int key) {
        if(current == null){
            return current;
        }
        if(current.val > key){
            current.left=delete(current.left,key);
        } else if (current.val < key){
            current.right=delete(current.right,key);
        } else{
            if(current.left==null){
                return current.right;
            }
            if(current.right==null){
                return current.left;
            }
            Node replace=current.right;
            while(replace!=null && replace.left!=null){
                replace=replace.left;
            }
            current.val=replace.val;
            current.right=delete(current.right,replace.val);
        }
        return current;
    }

    public void insert(int key) {
        root=insert(root,key);
    }

    public Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.val) {
            root.left = insert(root.left, key);
        } else if (key > root.val) {
            root.right = insert(root.right, key);
        }
        return root;
    }



}
