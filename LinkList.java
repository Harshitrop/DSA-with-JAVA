public class LinkList {
    
    public static class node {
        int data;
        node next;
        
        public node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static node head;
    public static node tail;
    public static int size;

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

        //step 3 - head = new node
        head = newnode;
    }
    public void addlast( int data){
        node newnode = new node(data);
        size++;
        if(head == null){
            head = tail = newnode;
            return;
        }
        tail.next = newnode;
        tail = newnode;
    }
    public void printll(){
        if(head == null){
            System.out.println("LinkList is empty");
            return;
        }
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data+" -->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void addATindex(int index, int data){
        if(index == 0){
            addfirst(data);
            return;
        }
        node newnode = new node(data);
        size++;
        node temp = head;
        int i =0;
        while (i<index-1) {
            temp = temp.next;
            i++;
        }
        // i = index-1; temp -> prev
        newnode.next = temp.next;
        temp.next = newnode;
    }
    public int removefirst(){
        if(size == 0){
            System.out.println("Linked List is ampty");
            return Integer.MIN_VALUE;
        }else if (size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }
    public int removelast(){
        if(size == 0){
            System.out.println("Linked List is ampty");
            return Integer.MIN_VALUE;
        }else if (size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        node prev = head;
        for(int i=0; i<size-2; i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }
    public int itrsearch(int key){
        node temp = head;
        int i = 0;
        while (temp != null) {
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
    public static void main(String[] args){
        LinkList ll = new LinkList();
        ll.addfirst(2);
        ll.addfirst(1);
        ll.addlast(4);
        ll.addlast(5);
        ll.addATindex(2, 3);

        System.out.println(ll.itrsearch(3));
    }
}