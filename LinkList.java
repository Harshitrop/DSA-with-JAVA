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
    //  public static void main(String[] args){
    //     LinkList ll = new LinkList();
    //     ll.addfirst(2);
    //     ll.addfirst(1);
    //     ll.addlast(4);
    //     ll.addlast(5);
    //     ll.addATindex(2, 3);

    //     System.out.println(ll.itrsearch(3));
    // }
    public int helper(node head, int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }
        return idx+1;
    }
    public int recursiveSearch( int key){
        return helper(head, key);
    }
    public void reverseLL(){
        node prev = null;
        node curr = tail = head;
        node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public void removeNthfromEnd(int n){
        // calculate size
        int sz = 0;
        node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        if(n == sz){
            head = head.next;
            return;
        }
        //sz-1
        int i = 1;
        node prev = head;
        int itofind = sz-n;
        while (i < itofind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }
    public node findmid(node head){
        node slow = head;
        node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // slow is my mid node
    }
    public boolean ispalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        //step 1 find mid
        node midNode = findmid(head);

        //step 2 2nd half reverse
        node prev = null;
        node curr = midNode;
        node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        node right = prev;
        node left = head;

        //step 3 check left & right part
        while (right != null) {
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    public boolean iscycle(){
        node fast = head;
        node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
    public static void removecycle(){
        //detect cycle
        node fast = head;
        node slow = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                cycle =  true;
                break;
            }
        }
        if(cycle == false){
            return;
        }

        //find metting point
        slow = head;
        node prev = head;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        //remove cycle
        prev.next = null;
    }

    private node merge(node head1, node head2){
        node mergell = new node(-1);
        node temp = mergell;

        while (head1 != null && head2 != null) {
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergell.next;
    }
    public node mergesort(node head){
        if(head == null || head.next == null){
            return head;
        }
        //find mid
        node mid = findmid(head);
        // left & right MS
        node rightHaed = mid.next;
        mid.next = null;
        node newleft = mergesort(head);
        node newright = mergesort(rightHaed);

        //merge
        return merge(newleft, newright);
    }
    public static void main(String[] args){
        LinkList ll = new LinkList();
        ll.addfirst(1);
        ll.addfirst(2);
        ll.addlast(3);
        ll.addlast(4);
        ll.addlast(5);
        ll.printll();
        //System.out.println(ll.ispalindrome());
        ll.head = ll.mergesort(head);
        ll.printll();
    }
}