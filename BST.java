//import java.util.*;

import java.util.ArrayList;

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
    public static void PrintInRange(Node root, int x, int y){
        if(root == null){
            return;
        }
        if(root.data >= x && root.data <= y){//Case 1 - if the root is in the range
            PrintInRange(root.left, x, y);
            System.out.print(root.data + " ");
            PrintInRange(root.right, x, y);
        }
        else if(root.data < x){//Case 2 - if the root is less than x, then we can ignore the left subtree
            PrintInRange(root.right, x, y);
        }
        else {//Case 3 - if the root is greater than y, then we can ignore the right subtree
            PrintInRange(root.left, x, y);
        }
    }
    public static void PrintRoot2leaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            PrintPath(path);
        }
        PrintRoot2leaf(root.left, path);
        PrintRoot2leaf(root.right, path);
        path.remove(path.size() - 1);
    }
    public static void PrintPath(ArrayList<Integer> path){
        for(int i = 0; i < path.size(); i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println("null");
    }

    //--------Validate BST------
    public static boolean IsValidBST(Node root, Node min, Node max){
        if(root == null){
            return true;
        }
        if(min != null && root.data <= min.data){
            return false;
        }
        if(max != null && root.data >= max.data){
            return false;
        }
        return IsValidBST(root.left, min, root) && IsValidBST(root.right, root, max);
    }
    //---------Mirror of a BST------
    public static Node Mirror(Node root){
        if(root == null){
            return null;
        }
        Node LeftST = Mirror(root.left);
        Node RightST = Mirror(root.right);

        root.left = RightST;
        root.right = LeftST;
        return root;
    }

    public static void main(String args[]) {
        int val[] = {8,5,3,6,10,11,14};
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

        inorder(root);
        System.out.println();
        // PrintInRange(root, 5, 10);

        // PrintRoot2leaf(root, new ArrayList<>());
        // PrintPath(new ArrayList<>());

        // System.out.println(IsValidBST(root, null, null));

        Mirror(root);
        inorder(root);
        System.out.println();
    }
}
