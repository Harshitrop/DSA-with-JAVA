//import java.util.*;
public class BST {
        static class Node {
            int data;
            Node left, right;
    
            public Node(int data) {
                this.data = data;
                this.left = null;
                this.right = null;
            }
        }

        public static Node insert(Node root, int val) {
            if (root == null) {
                return new Node(val);
            }
            if (val < root.data) {
                root.left = insert(root.left, val);
            } else {
                root.right = insert(root.right, val);
            }
            return root;
        }

        public static void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        public static boolean Search(Node root, int key){//O(H) where H is the height of the tree
            if(root == null){
                System.out.println("Key NOT found");
                return false;
            }
            if(root.data == key){
                System.out.println("Key found");
                return true;
            }
            if(key < root.data){
                return Search(root.left, key);
            }
            return Search(root.right, key);
        }
        //----Delete Node
        public static Node Delete(Node root, int val){
            if (root == null) {
                return null;
            }
            if(root.data < val){
                root.right = Delete(root.right, val);
            } else if(root.data > val){
                root.left = Delete(root.left, val);
            } else {
                //case 1 - leaf node 
                if (root.left == null && root.right == null) {
                    return null;
                }
                //case 2 - one child (replace with child node)
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }
                //case 3 - two children
                Node IS = FindInorderSuccessor(root.right);
                root.data = IS.data;
                root.right = Delete(root.right, IS.data);
            }
            return root;
        }
        public static Node FindInorderSuccessor(Node root){
            while (root.left != null) {
                root = root.left;
            }return root;
        }

    public static void main(String args[]) {
        int val[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for(int i = 0; i< val.length; i++){
            root = insert(root, val[i]);
        }
        /*  The tree will look like this:
                  5
                /   \
               1     7
                \
                 3
                /  \
               2    4
         */
        // inorder(root);
        // System.out.println();

        // Search(root, 2);

        // System.out.println("Before Delete node");
        // inorder(root);
        // System.out.println();

        // root = Delete(root, 5);
        // System.out.println("After Delete node");

        // inorder(root);


    }
}
