
//----------Implimantation with JCF------------
// import java.util.Comparator;
// import java.util.PriorityQueue; // Java collection Fremwork
// public class Heap {
    
//     static class Student implements Comparable<Student> { //Overriding
//         String name;
//         int rank;

//         public Student(String name, int rank){
//             this.name = name;
//             this.rank = rank;
//         }
        
//         @Override
//         public int compareTo(Student s2){
//             return this.rank - s2.rank;
//         }
//     }

//     public static void main(String args[]){

//         PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());

//         pq.add(new Student("A", 4)); //O(logn)
//         pq.add(new Student("B", 8));
//         pq.add(new Student("C", 2));
//         pq.add(new Student("D", 6));

//         while (!pq.isEmpty()) {
//             System.out.println(pq.peek().name +" -->"+ pq.peek().rank);//O(1)
//             pq.remove(); //O(logn)
//         }
//     }
// }


// --------------------- Implimantation of min Heap -------------------------
// import java.util.*;
// public class Heap {

//     static class InnerHeap {
    
//         ArrayList<Integer> arr = new ArrayList<>();

//         public void add(int data){
//             //add at last index
//             arr.add(data);

//             int x = arr.size()-1; //x is child index
//             int parent = (x-1)/2;//parent index

//             while (arr.get(x) < arr.get(parent)) { //for max Heap we change "<" to ">" 
//                 //swap
//                 int temp = arr.get(x);
//                 arr.set(x, arr.get(parent));
//                 arr.set(parent, temp);

//                 x = parent;
//                 parent = (x-1)/2;
//             }
//         }
//         public int peek(){
//             return arr.get(0);
//         }

//         private void Heapify(int i){
//             int left = 2*i+1;
//             int right = 2*i+2;
//             int minIdx = i;

//             if (left < arr.size() && arr.get(minIdx) > arr.get(left)) { //for max Heap we change ">" to "<" 
//                 minIdx = left;
//             }

//             if (right < arr.size() && arr.get(minIdx) > arr.get(right)) { //for max Heap we change ">" to "<" 
//                 minIdx = right;
//             }

//             if (minIdx != i) {
//                 //swap
//                 int temp = arr.get(i);
//                 arr.set(i, arr.get(minIdx));
//                 arr.set(minIdx, temp);
                
//                 Heapify(minIdx);
//             }
//         }
//         public int Remove(){
//             int data = arr.get(0);

//             // Step 1- swap first & last
//             int temp = arr.get(0);
//             arr.set(0, arr.get(arr.size()-1));
//             arr.set(arr.size()-1, temp);

//             // Step 2- delete last
//             arr.remove(arr.size()-1);

//             // Step 3- heapify
//             Heapify(0);
//             return data;
//         }

//         public boolean isEmpty(){
//             return arr.size() == 0;
//         }
//     }
//     public static void main(String args[]){
//         InnerHeap h = new InnerHeap();
//         h.add(3);
//         h.add(4);
//         h.add(1);
//         h.add(5);

//         while (!h.isEmpty()) {
//             System.out.println(h.peek());
//             h.Remove();
//         }
//     }
// }

//----------------- HeapSort-----------
public class Heap{

    static class InnerHeap {

        public static void Heapify(int arr[], int i, int size){
            int left = 2*i+1;
            int right = 2*i+2;
            int maxIdx = i;

            if (left < size && arr[left] > arr[maxIdx]) {// for min Heap change ">" to "<"
                maxIdx = left;
            }

            if (right < size && arr[right] > arr[maxIdx]) {// for min Heap change ">" to "<"
                maxIdx = right;
            }

            if (maxIdx != i) {
                //swap
                int temp = arr[i];
                arr[i] = arr[maxIdx];
                arr[maxIdx] = temp;
                
                Heapify(arr, maxIdx, size);
            }
        }

        public static void Heapsort(int arr[]){
            //step 1 build maxHeap
            int n = arr.length;
            for(int i = n/2; i >= 0; i--){
                Heapify(arr, i, n);
            }
            //Step 2 push largest at end
            for(int i = n-1; i>0; i--){
                //swap 
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                Heapify(arr, 0, i);
            }
        }
    }

    public static void main(String args[]){
        int arr[] = { 1,2,4,5,3};
        InnerHeap.Heapsort(arr);

        //print
        for(int i =0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

}