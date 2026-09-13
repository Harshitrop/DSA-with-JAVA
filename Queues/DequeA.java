import java.util.*;
public class DequeA {
    static class Stack {
        //implementing stack using Deque
    Deque<Integer> Deque = new LinkedList<>();
    public void push(int data){
        Deque.addLast(data);
    }
    public int pop(){
        return Deque.removeLast();
    }
    public int peek(){
        return Deque.getLast();
    }
    }

    //implementing queue using Deque
    static class Queue {
        Deque<Integer> Deque = new LinkedList<>();

        public void add(int data){
            Deque.addLast(data);
        }
        public int remove(){
            return Deque.removeFirst();
        }
        public int peek(){
            return Deque.getFirst();
        }
    }
    public static void main(String[] args) {
        // Deque<Integer> dq = new LinkedList<>();//Deque is an interface and LinkedList is a class that implements the Deque interface
        // dq.addFirst(1);
        // dq.addFirst(2);
        // System.out.println(dq);

        // Stack s = new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // System.out.println("Peek: " + s.peek());
        // System.out.println(s.pop());
        // System.out.println(s.pop());
        // System.out.println(s.pop());

        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println("Peek: " + q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}
