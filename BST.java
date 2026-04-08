import java.util.*;
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

        //Inser
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

        //Inorder
        public static void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        //Search
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

        //Delete
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
    public static Node FindInorderSuccessor(Node root){//Helper fun
        while (root.left != null) {
            root = root.left;
        }return root;
    }

    //-----Print in range
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

    //---print Root to Leaf
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
    public static void PrintPath(ArrayList<Integer> path){//helper fun
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

    //PreOrder
    public static void PreOder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        PreOder(root.left);
        PreOder(root.right);
    } 


    //----- sorted array to balanced BST
    public static Node CreatrB_BST(int arr[], int St, int End){
        if(St > End){
            return null;
        }

        int mid = (St + End)/2;
        Node root = new Node(arr[mid]);
        root.left = CreatrB_BST(arr, St,mid-1);
        root.right = CreatrB_BST(arr, mid+1, End);
        return root;
    }


    //helper Funtion
    public static void GetInoder(Node root, ArrayList<Integer> inorder){
        if(root == null){
            return;
        }
        GetInoder(root.left, inorder);
        inorder.add(root.data);
        GetInoder(root.right, inorder);
    }
    //helper Funtion
    public static Node CreatrB_BST1(ArrayList<Integer> inorder, int St, int End){
        if(St > End){
            return null;
        }
        int mid = (St + End)/2;
        Node root = new Node(inorder.get(mid));
        root.left = CreatrB_BST1(inorder, St, mid-1);
        root.right = CreatrB_BST1(inorder, mid+1, End);
        return root;
    }
    //------ Convert BST to Balance BST
    public static Node B_BST(Node root){//O(n)
        //Inorder Sequence
        ArrayList<Integer> inorder = new ArrayList<>();
        GetInoder(root, inorder);

        //Sorted Inorder -> Balance BST
        root = CreatrB_BST1(inorder, 0, inorder.size()-1);
        return root;
    }


    //Size of largest BST in BT
    public static class Info {
        boolean IsBST;
        int size;
        int min;
        int max;

        public Info(boolean IsBST, int size, int min, int max){
            this.IsBST = IsBST;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }
    public static int maxBST = 0;

    public static Info largestBST(Node root){
        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info LeftInfo = largestBST(root.left);
        Info RightInfo = largestBST(root.right);
        int Size = LeftInfo.size + RightInfo.size + 1;
        int min = Math.min(root.data, Math.min(LeftInfo.min , RightInfo.min));
        int max = Math.max(root.data, Math.max(LeftInfo.max, RightInfo.max));

        if(root.data <= LeftInfo.max || root.data >= RightInfo.min){
            return new Info(false, Size, min, max);
        }
        if(LeftInfo.IsBST && RightInfo.IsBST){
            maxBST = Math.max(maxBST, Size);
            return new Info(true, Size, min, max);
        }
        return new Info(false, Size, min, max);
    }
    public static void main(String args[]) {
        // int val[] = {2,3,4,5,6};
        // Node root = null;

        // for(int i = 0; i< val.length; i++){
        //     root = insert(root, val[i]);
        // }
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
        // System.out.println();
        // PrintInRange(root, 5, 10);

        // PrintRoot2leaf(root, new ArrayList<>());
        // PrintPath(new ArrayList<>());

        // System.out.println(IsValidBST(root, null, null));

        // Mirror(root);
        // inorder(root);
        // System.out.println();
        
        // int arr[] = {3,5,6,8,10,11,12};
        // Node root = CreatrB_BST(arr, 0, arr.length-1);
        // PreOder(root);


        //BST to Balance BST
        /*
                  8
                /   \
               6     10
              /       \
             5         11
            /           \
           3             12
           given BSt 
        */
    //    Node root = new Node(8);
    //    root.left = new Node(6);
    //    root.left.left = new Node(5);
    //    root.left.left.left = new Node(3);

    //    root.right = new Node(10);
    //    root.right.right = new Node(11);
    //    root.right.right.right = new Node(12);

       /*
                 8
               /   \
              5     11
             / \    / \
            3   6  10  12
            Expected BST
       */
        // root = B_BST(root);
        // PreOder(root);


        //Size of largest BST in BT
        /*
                       50
                    /      \
                  30        60
                 /  \      /   \
                5    20   45    70
                               /   \
                              65    80 
        */
    //     Node root = new Node(50);
    //    root.left = new Node(30);
    //    root.left.left = new Node(5);
    //    root.left.right = new Node(20);

    //    root.right = new Node(60);
    //    root.right.left = new Node(45);
    //    root.right.right = new Node(70);
    //    root.right.right.left = new Node(65);
    //    root.right.right.right = new Node(80);
        /*
        Expected output
                    60
                  /    \
                 45    70
                      /   \
                    65    80 
                    size = 5
        */
        // Info info = largestBST(root);
        // System.out.println("Largest BST Size = " + maxBST);
    }
}
