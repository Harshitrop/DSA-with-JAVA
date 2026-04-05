import java.util.*;

public class BinaryTreeB {
    static class  node {
        int data; 
        node left;
        node right;

        node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

        static class BinaryTree {
            static int idx = -1;
            public static node buildTree(int nodes[]){//O(n)
                idx++;
                if(nodes[idx] == -1){
                    return null;
                }
                node newnode = new node(nodes[idx]);
                newnode.left = buildTree(nodes);
                newnode.right = buildTree(nodes);
                return newnode;
            }
            
            public static void Preorder(node root){//O(n)
                if(root == null){
                    System.out.print("-1 ");
                    return;
                }
                System.out.print(root.data + " ");
                Preorder(root.left);
                Preorder(root.right);
            }

            public static void Inorder(node root){//O(n)
                if(root == null){
                    //System.out.print("-1 ");
                    return;
                }
                Inorder(root.left);
                System.out.print(root.data + " ");
                Inorder(root.right);
            }

            public static void Postorder(node root){
                if(root == null){
                    //System.out.print("-1 ");
                    return;
                }
                Postorder(root.left);
                Postorder(root.right);
                System.out.print(root.data + " ");
            }

            public static void Levelorder(node root){//O(n)
                if(root == null){
                    return;
                }
                Queue<node> q = new LinkedList<>();
                q.add(root);
                q.add(null);

                while(!q.isEmpty()){
                    node currNode = q.remove();
                    if(currNode == null){
                        System.out.println();
                        if(q.isEmpty()){
                            break;
                        }else{
                            q.add(null);
                        }
                    }else{
                        System.out.print(currNode.data + " ");
                        if(currNode.left != null){
                            q.add(currNode.left);
                        }
                        if(currNode.right != null){
                            q.add(currNode.right);
                        }
                    }
                }    
            }
        }
        // public static void main(String[] args) {
        //     int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        //     BinaryTree Tree = new BinaryTree();
        //     node root = Tree.buildTree(nodes);
            
        //     System.out.println("Levelorder Traversal: ");
        //     Tree.Levelorder(root);
        // }
    }
    public static int Height(node root){
        if(root == null){
            return 0;
        }
        int LH = Height(root.left);
        int RH = Height(root.right);
        return Math.max(LH, RH) +1;
    }
    public static int countnodes(node root){
        if(root == null){
            return 0;
        }
        int LC = countnodes(root.left);
        int RC = countnodes(root.right);
        return LC + RC + 1;
    }
    public static int sumofnodes(node root){
        if(root == null){
            return 0;
        }
        int LSum = sumofnodes(root.left);
        int RSum = sumofnodes(root.right);
        return LSum + RSum + root.data;
    }
    public static int Diameter(node root){//O(n^2)
        if(root == null){
            return 0;
        }
        int LDiameter = Diameter(root.left);
        int LHeight = Height(root.left);
        int RDiameter = Diameter(root.right);
        int RHeight = Height(root.right);

        int TreDiameter = LHeight + RHeight + 1;

        return Math.max(TreDiameter, Math.max(LDiameter, RDiameter));
    }
    static class Info{
        int diam;
        int ht;

        public Info(int diam, int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }
    public static Info Diameter2(node root){//O(n)
        if(root == null){
            return new Info(0, 0);
        }
        Info LInfo = Diameter2(root.left);
        Info RInfo = Diameter2(root.right);

        int Diameter = Math.max(Math.max(LInfo.diam, RInfo.diam), LInfo.ht + RInfo.ht + 1);
        int Height = Math.max(LInfo.ht, RInfo.ht) + 1;

        return new Info(Diameter, Height);
    }

    public static boolean isSubTree(node root, node subRoot){
        if(root == null){
            return false;
        }
        if(root.data == subRoot.data){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }
        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }
    public static boolean isIdentical(node node, node subRoot){
        if( node == null && subRoot == null){
            return true;
        }else if( node == null || subRoot == null || node.data != subRoot.data){
            return false;
        }
        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }
        return true;

    }

    //--------Top View of Tree problem--------
    static class INFO {
        node node;
        int hd;

        public INFO(node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public static void TopView(node root){
        //Level order traversal + HashMap
        Queue<INFO> q = new LinkedList<>();
        HashMap<Integer, node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new INFO(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            INFO curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }
            else{
                    if(!map.containsKey(curr.hd)){//If the horizontal distance is not present in the map, add it
                    map.put(curr.hd, curr.node);
                }
                if(curr.node.left != null){
                    q.add(new INFO(curr.node.left, curr.hd -1));
                    min = Math.min(min, curr.hd -1);
                }
                if(curr.node.right != null){
                    q.add(new INFO(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }
        //Print the top view
        for(int i = min; i <= max; i++){
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        /*
                1
               / \
              2   3
             / \   \
            4   5   6
        */
       node root = new node(1);
       root.left = new node(2);
       root.right = new node(3);
       root.left.left = new node(4);
       root.left.right = new node(5);
       root.right.right = new node(6);

       /*
             2
            / \
           4   6
       */
    //   node subRoot = new node(2);
    //   subRoot.left = new node(4);
    //   subRoot.right = new node(6);

       System.out.println("Top View of Tree: ");
       TopView(root);
    }
}
