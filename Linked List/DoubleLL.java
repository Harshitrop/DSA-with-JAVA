public class DoubleLL {
    public class node {
        int data;
        node next;
        node prev;
        public node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static node head;
    public static node tail;
    public static int size;

    //add
    public void addfirst(int data){
        // step 1 create new node
        node newnode = new node(data);
        size ++;
        if(head == null){
            head = tail = newnode;
            return;
        }
        //ste 2- newnode next = head
        newnode.next = head;//link
        head.prev = newnode;
        //step 3 - head = new node
        head = newnode;
    }

    //remove
    public int removefirst(){
        if(size == 0){
            System.out.println("Doubly Linked List is ampty");
            return Integer.MIN_VALUE;
        }else if (size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }
    public void printll(){
        if(head == null){
            System.out.println("LinkList is empty");
            return;
        }
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data+"<-->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void reverseLL(){
        node prev = null;
        node curr = tail = head;
        node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String [] args){
        DoubleLL DLL = new DoubleLL();
        DLL.addfirst(3);
        DLL.addfirst(2);
        DLL.addfirst(1);
        DLL.addfirst(5);
        DLL.addfirst(0);
        
    }
}
