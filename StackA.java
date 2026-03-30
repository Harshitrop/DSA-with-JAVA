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

    // public static void main(String [] args){
    //     //stackb s = new stackb();
    //     Stack<Integer> s = new Stack<>();//java collection framework(JCF)
    //     s.push(1);
    //     s.push(2);
    //     s.push(3);

    //     while (!s.isEmpty()) {
    //         System.out.println(s.peek());
    //         s.pop();
    //     }
    // }

    public static void puchAtBottom(Stack<Integer> s , int data){
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        puchAtBottom(s, data);
        s.push(top);
    }
    public static String reverseString( String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx ++;
        }
        StringBuilder result = new StringBuilder("");
        while (!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();
    }
    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        puchAtBottom(s, top);
    }
    public static void printStack(Stack<Integer> s){
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    //stack span problem
    public static void StockSpan(int stock[], int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i = 1; i < stock.length; i++){
            int currprice = stock[i];
            while (!s.isEmpty() && currprice> stock[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }else{
                int prevHight = s.peek();
                span[i]  = i - prevHight;
            }
            s.push(i);
        }
    }
    // public static void main(String[] args){
    //     int stock[] = {100, 80, 60, 70, 60, 85, 100};
    //     int span[] = new int[stock.length];
    //     StockSpan(stock, span);

    //     for(int i = 0; i< stock.length; i++){
    //         System.out.println(span[i]+" ");
    //     }
    // }

    //Next Greater Element
    // public static void main(String[] args){
    //     int arr[] = {6, 8, 0, 1, 3};
    //     Stack<Integer> s = new Stack<>();
    //     int nextGreater[] = new int[arr.length];
    //     int n = arr.length;

    //     for(int i = n-1; i>= 0; i--){
    //         //1. pop smaller element
    //         while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
    //             s.pop();
    //         }
    //         //2. store the next greater element
    //         if(s.isEmpty()){
    //             nextGreater[i] = -1;
    //         }else{
    //             nextGreater[i] = arr[s.peek()];
    //         }
    //         //3. push the current element index
    //         s.push(i);
    //     }
    //     for(int i = 0; i< arr.length; i++){
    //         System.out.print(nextGreater[i]+" ");
    //     }
    //     System.out.println();
        // next greater right
        //next greater left change the loop from i = 0 to n-1  
        //next smaller right = change the condition from <= to >= in while loop
        //next smaller left = change the condition from <= to >= in while loop and change the loop from i = 0 to n-1
    //}
    //valid parenthesis
    public static boolean isValidparenthesis(String str){
        Stack<Character> s = new Stack<>();

        for(int i = 0; i< str.length(); i++){
            char curr = str.charAt(i);
            if(curr == '(' || curr == '{' || curr == '['){ //opening bracket
                s.push(curr);
            }
            else{
                if(s.isEmpty()){//closing bracket without opening bracket
                    return false;
                }
                if((curr == ')' && s.peek() == '(')
                     || (curr == '}' && s.peek() == '{')
                     || (curr == ']' && s.peek() == '[')){
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }
        else{
        return false;
        }
    }
    //duplicate parenthesis
    public static boolean duplicateParenthesis(String str){
        Stack<Character> s = new Stack<>();

        for(int i = 0; i< str.length(); i++){
            char curr = str.charAt(i);
            //closing bracket
            if(curr == ')'){
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if(count < 1){//duplicate parenthesis
                    return true;
                }else{//valid parenthesis
                    s.pop();
                }
            }
            else{//opening bracket or operand
                s.push(curr);
            }
        }
        return false;
    }
    // Max Area in Histogram
    public static void maxAreaHistogram(int arr[]){
        int maxArea = 0;
        int nsl[] = new int[arr.length];
        int nsr[] = new int[arr.length];

        //next smaller right
        Stack<Integer> s = new Stack<>();
        for(int i = arr.length-1; i >= 0; i--){
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = arr.length;
            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        //next smaller left
         s = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        //current area = height * width(nsr[i] - nsl[i] - 1)
        for(int i = 0; i < arr.length; i++){
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }
        System.out.println("Maximum area in histogram: " + maxArea);

    }
    public static void main(String[] args){
        int arr[] = {2, 4};
        maxAreaHistogram(arr);
    }
}