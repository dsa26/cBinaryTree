public class BinaryTree {
    //public or private??
    Node root;
    public BinaryTree() {
        root = null;
    }

    public boolean contains(int key){
        return containsRec(root,key);
    }

    private boolean containsRec(Node current, int key){
        if(current == null){
            return false;
        }
        if(current.val == key){
            return true;
        }
        if(current.val > key){
            return containsRec(current.left,key);
        } else {
            return containsRec(current.right,key);
        }
    }

    public void delete(int key) {
        deleteRec(root,key);
    }

    private void deleteRec(Node current, int key) {
        if(current == null){
            return;
        }
        if(current.val == key){
            //if no left or right (no child)
            if(current.left == null && current.right == null){
                current=null;
            }
            //if only left (one child)
            if(current.left != null && current.right == null){
                current=current.left;
            } //if only right (one child)
            if(current.right != null && current.left == null){
                current=current.right;
            } else { //if both child
                //current=current.left;
            }

        }
        if(current.val > key){
            deleteRec(current.left,key);
        } else {
            deleteRec(current.right,key);
        }
    }

    public int findHeight() {
        return findHeight(root);
    }

    private int heightRec(Node current){
        if(current==null){
            return 0;
        }
        int leftHeight = heightRec(current.left);
        int rightHeight = heightRec(current.right);
        return Math.max(leftHeight,rightHeight) +1 ;
    }

    public boolean isEmpty(){
        return root==null;
    }

    public int max(){
        return maxRec(root);
    }

    private int maxRec(Node current){
        if(current==null){
            return -1; //idk what to return, means root is empty
        }
        if (current.right==null){
            return current.val;
        }
        return maxRec(current.right);
    }

    public int min(){
        return minRec(root);
    }

    private int minRec(Node current){
        if(current==null){
            return -1; //idk what to return, means root is empty
        }
        if (current.left==null){
            return current.val;
        }
        return minRec(current.left);
    }

    public void levelOrder(){
        for (int level =1; level<findHeight(); level++){
            currentLevel(level,root);
            System.out.println("\n");
        }
    }

//    public void levelOrderRec(Node current){
//        if(current==null){
//            return;
//        }
//        System.out.println("\n");
//        //case 1: only left
//        if(current.left!=null && current.right==null){
//            System.out.println(current.left.val+" ");
//            levelOrderRec(current.left);
//        }
//        //case 2: only right
//        if(current.right!=null && current.left==null){
//            System.out.println(current.right.val+" ");
//            levelOrderRec(current.right);
//        }
//        //case 3: both exist -> idk
//    }

    public void currentLevel(int level, Node current){
        if (current==null){
            return;
        }
        if(level==1){
            System.out.println(current.val+" ");
            return;
        }
        currentLevel(level-1,current.left);
        currentLevel(level-1,current.right);
    }

    public void inOrder(){
        inOrderRec(root);
    }

    private void inOrderRec(Node current){
        if(current==null){
            return;
        }
        inOrderRec(current.left);
        System.out.print(current.val+" ");
        inOrderRec(current.right);
    }

    public void postOrder(){
        postOrderRec(root);
    }

    private void postOrderRec(Node current){
        if(current==null){
            return;
        }
        postOrderRec(current.left);
        postOrderRec(current.right);
        System.out.print(current.val+" ");
    }

    public void preOrder(){
        preOrderRec(root);
    }

    private void preOrderRec(Node current){
        if(current==null){
            return;
        }
        System.out.print(current.val+" ");
        preOrderRec(current.left);
        preOrderRec(current.right);
    }

    public void put()






    }
