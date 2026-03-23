import java.util.*;
public class StackA {

    //------- implementation with Arraylist ----------
    // static class stackb {
    //     static ArrayList<Integer> list = new ArrayList<>();
    //     public static boolean isEmpty(){
    //         return list.size() == 0;
    //     }
    //     public static void push(int data){
    //         list.add(data);
    //     }
    //     public static int pop(){
    //         if(isEmpty()){
    //             return -1;
    //         }
    //         int top = list.get(list.size()-1);
    //         list.remove(list.size()-1);
    //         return top;
    //     }
    //     public static int peek(){
    //         if(isEmpty()){
    //             return -1;
    //         }
    //         return list.get(list.size()-1);
    //     }
    // }

    //------- implementation with Linked List --------
    // static class node {
    //     int data;
    //     node next;
    //     node(int data){
    //         this.data = data;
    //         this.next = null;
    //     }
    // }

    // static class stackb {
    //     static node head = null;

    //     public static boolean isEmpty(){
    //         return  head == null;
    //     }

    //     public static void push(int data){
    //         node newnode = new node(data);
    //         if(isEmpty()){
    //             head = newnode;
    //             return;
    //         }
    //         newnode.next = head;
    //         head = newnode;
    //     }

    //     public static int pop(){
    //         if(isEmpty()){
    //             return -1;
    //         }
    //         int top = head.data;
    //         head = head.next;
    //         return top;
    //     }

    //     public static int peek(){
    //         if(isEmpty()){
    //             return -1;
    //         }
    //         return head.data;
    //     }
    // }

    public static void main(String [] args){
        //stackb s = new stackb();
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}