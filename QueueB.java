import java.util.*;

import javax.print.DocFlavor.STRING;
public class QueueB {
    //-------- implementing queue using linked list -------------
    // static class Node {
    //     int data;
    //     Node next;

    //     Node(int data) {
    //         this.data = data;
    //         this.next = null;
    //     }
    // }
    //static class Queue {
        //-------- implementing queue using array && circular queue---------- 
        // static int arr[];
        // static int size;
        // static int rear;
        // static int front;//because of circular queue we need front and rear both

        // Queue(int n) {
        //     arr = new int[n];
        //     size = n;
        //     rear = -1;
        //     front = -1;
        // }
        // public static boolean isEmpty() {
        //     return rear == -1 && front == -1;
        // }
        // public static boolean isFull() {
        //     return (rear + 1) % size == front;
        // }

        // //add
        // public static void add(int data) {
        //     if (isFull()) {
        //         System.out.println("Queue is full");
        //         return;
        //     }
        //     //add first element
        //     if (front == -1) {
        //         front = 0;
        //     }
        //     rear = (rear + 1) % size;
        //     arr[rear] = data;
        //     // size++;
        // }

        // //remove
        // public static int remove() {
        //     if (isEmpty()) {
        //         System.out.println("Queue is empty");
        //         return -1;
        //     }
        //     int result = arr[front];
        //     //last element
        //     if(rear == front){
        //         rear = front = -1;
        //     }else{
        //         front = (front +1) % size;
        //     }
        //     return result;
        // }

        // //peek
        // public static int peek() {
        //     if (isEmpty()) {
        //         System.out.println("Queue is empty");
        //         return -1;
        //     }
        //     return arr[front];
        // }

        //-------- implementing queue using linked list -------------
        // static Node head = null;
        // static Node tail = null;
        // public static boolean isEmpty() {
        //     return head == null && tail == null;
        // }
        // //add
        // public static void add(int data) {
        //     Node newNode = new Node(data);
        //     if (head == null) {
        //         head = tail = newNode;
        //         return;
        //     }
        //     tail.next = newNode;
        //     tail = newNode;
        // }

        // //remove
        // public static int remove() {
        //     if (isEmpty()) {
        //         System.out.println("Queue is empty");
        //         return -1;
        //     }
        //     int result = head.data;
        //     //last element
        //     if (head == tail) {
        //         head = tail = null;
        //     } else {
        //         head = head.next;
        //     }
        //     return result;
        // }

        // //peek
        // public static int peek() {
        //     if (isEmpty()) {
        //         System.out.println("Queue is empty");
        //         return -1;
        //     }
        //     return head.data;
        // }
    //}

    // public static void main(String[] args) {
    //     Queue q = new Queue();
    //     q.add(1);
    //     q.add(2);
    //     q.add(3);
    //     q.add(4);
    //     q.add(5);
    //     System.out.println(q.remove());
    //     q.add(6);
    //     System.out.println(q.remove());
    //     q.add(7);
    //     while (!q.isEmpty()) {
    //         System.out.println(q.peek());
    //         q.remove();
    //     }
    // }


    //-------Queue using 2 stacks------
    //static class Queue {
        // static Stack<Integer> s1 = new Stack<>();
        // static Stack<Integer> s2 = new Stack<>();

        // public static boolean isEmpty(){
        //     return s1.isEmpty();
        // }
        // //add
        // public static void add(int data){
        //     while (!s1.isEmpty()) {
        //         s2.push(s1.pop());
        //     }
        //     s1.push(data);
        //     while (!s2.isEmpty()) {
        //         s1.push(s2.pop());
        //     }
        // }
        // //remove
        // public static int remove(){
        //     if(isEmpty()){
        //         System.out.println("Queue is Empty");
        //         return -1;
        //     }
        //     return s1.pop();
        // }
        // //peek
        // public static int peek(){
        //     if(isEmpty()){
        //         System.out.println("Queue is Empty");
        //         return -1;
        //     }
        //     return s1.peek();
        // }
    //}

        //-------Stack using 2 queues------
        static class Stack<T> {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty(){
           return q1.isEmpty() && q2.isEmpty();
        }
        public static void push(int data){
            if(!q1.isEmpty()){
                q1.add(data);
            }else{
                q2.add(data);
            }
        }
        public static int pop(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            int top = -1;

            //case 1
            if(!q1.isEmpty()){
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }
            }else{//case 2
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            int top = -1;

            //case 1
            if(!q1.isEmpty()){
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            }else{//case 2
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }

    //reverse the Queue
    public static void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<Integer>();

        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }

    //First non repeating character in a stream of characters
    public static void FristNonRepeating(String str){
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;

            while (!q.isEmpty() && freq[q.peek()-'a'] >1) {
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
    }
    //interleave two halves of a queue
    public static void interleave(Queue<Integer> q){
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();

        for(int i = 0; i<size/2; i++){
            firstHalf.add(q.remove());
        }
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }

    }
    
    public static void main(String[] args){//java collection framework
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        reverse(q);
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }
}