public class Divide_Conquer {
    
    public static void printarr(int [] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void mergesort(int [] arr, int start, int end){
        if(start >= end){
            return;
        }
        //kaam
        int mid = start + (end - start)/2;//(start + end)/2;
        mergesort(arr, start, mid);//left part
        mergesort(arr, mid+1, end);//right part
        merge(arr, start, mid, end);//merge
    }
    public static void merge(int [] arr, int start, int mid, int end){
        int temp [] = new int[end - start + 1];//temp array //+1 because arrays start from index 0
        int i = start;//itretor for left part
        int j = mid + 1;//iterator for right part
        int k = 0;//iterator for temp array

        while (i <= mid && j <= end) {
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        //left part
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        //right part
        while (j <= end) {
            temp[k++] = arr[j++];
        }
        //copy temp to original array
        for (k = 0, i = start; k < temp.length; i++, k++) {
            arr[i] = temp[k];
        }
    }
    public static void quicksort(int [] arr, int si, int ei){
        if(si >= ei){
            return;
        }
        //kaam
        int pidx = partition(arr, si, ei);
        quicksort(arr, si, pidx-1);//left part
        quicksort(arr, pidx+1, ei);//right part
    }
    public static int partition(int arr [], int si, int ei){
        int pivot = arr[ei];
        int i = si -1;// to make pace for element smaller then pivot

        for(int j=si; j<ei; j++){
            if(arr[j] <= pivot){
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp; 
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }
    public static int searchINrotatedsorted(int arr [], int tar, int si, int ei){
        //base case
        if(si > ei){
            return -1;
        }
        //kaam
        int mid = si + (ei - si )/2;
        if(arr[mid] == tar){
            return mid;
        }
        // mid on line 1
        if(arr[si] <= arr[mid]){
            //case a
            if(arr[si] <= tar && tar <= arr[mid]){
                return searchINrotatedsorted(arr, tar, si, mid-1);
            }
            //case b
            else{
                return searchINrotatedsorted(arr, tar, mid+1, ei);
            }
         // mid on line 2
        }else{
            //case c right
            if(arr[mid] <= tar && tar <= arr[ei]){
                return searchINrotatedsorted(arr, tar, mid+1, ei);
            }
            //case d left
            else{
                return searchINrotatedsorted(arr, tar, si, mid-1);
            }
        }
    }
    //Apply Merge sort to sort an array of Strings.
    //(Assume that all the characters in all the Strings are in lowercase)
    public static void sortstring(String std [], int si, int ei){
        // base case
        if(si >= ei){
            return;
        }
        int mid = si + ( ei - si )/2;
        

    }
    public static void main(String[] args){
        String str [] = {"sun", "earth", "mars", "mercury"};
    }
}
