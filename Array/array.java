//import java.util.*;

public class array {

    public static void update(int marsks[]){
        for(int i=0; i<marsks.length; i++){
            marsks[i] = marsks[i] + 1;
        }
    }

    public static int liner_Search(Strings array[], Strings key){

        for(int i = 0; i<array.length; i++){
            if(array[i] == key){
                return i;
            }
        }
        return -1;
    }

    public static int largest(int aar[]){
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for(int i=0; i< aar.length; i++){
            if(largest<aar[i]){
                largest = aar[i];
            }
            if(smallest>aar[i]){
                smallest=aar[i];
            }
        }
        System.out.println("smallest Number is ="+smallest);
        return largest;
    }

    public static int Binary_search( int arr[], int key){
        int start = 0; int end = arr.length-1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if(arr[mid] == key){ // FOUND
                return mid;
            }
            if(arr[mid] > key ){ //left 
                end = mid - 1;
            }
            else{ // right
                start = mid +1;
            }
        }
        return -1;
    }

    public static void reverse(int array[]){
        int first =0; int last = array.length-1;

        while (first<last) {
            int temp = array[first];
            array[first] = array[last];
            array[last] = temp;
            first++;
            last--;
        }
    }

    public static void printPairs(int arr[]){
        for(int i=0; i<arr.length; i++){
            int current = arr[i];
            for(int j=i+1; j<arr.length; j++){
                System.out.print("(" + current + "," + arr[j] +")");
            }
            System.out.println();
        }
    }

    public static void subarray( int arr[]){
        int total_Subarray =0;
        int MIM_SUM = Integer.MAX_VALUE;
        int MAX_SUM = Integer.MIN_VALUE;
        for(int i =0; i<arr.length; i++){
            for(int j =i; j<arr.length; j++){
                int currentSubarraySUM = 0;
                for(int k = i; k <= j; k++ ){
                    System.out.print(arr[k] + " ");//subarray
                    currentSubarraySUM+=arr[k];
                }
                total_Subarray ++;
                System.out.print("sum = "+currentSubarraySUM);
                System.out.println();
                if(currentSubarraySUM < MIM_SUM){
                    MIM_SUM = currentSubarraySUM;
                }
                if(currentSubarraySUM > MAX_SUM){
                    MAX_SUM = currentSubarraySUM;
                }
            }
            System.out.println();
        }
        System.out.println("Total SubArray =" + total_Subarray);
        System.out.println("MINMUM SUM = " + MIM_SUM);
        System.out.println("MAXIMUM SUM = " + MAX_SUM);
    }

    public static void prefixArray(int arr[]){
        int currSum = 0;
        int MAX_SUM =Integer.MIN_VALUE;
        int prefix[] = new int [arr.length];

        prefix[0] = arr[0];
        //calculate prefix
        for(int i=1; i<arr.length; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }

        for(int i=0; i<arr.length; i++){
            int start =i;
            for(int j =i; j<arr.length; j++){
                int end =j;
                currSum = start==0 ? prefix[end] :prefix[end] - prefix[start-1];

                if(MAX_SUM < currSum){
                    MAX_SUM = currSum ;
                }
            }
        }
        System.out.println("MAX SUM = "+ MAX_SUM);
    }

    public static void kadansAlgo(int arr[]){
        int currSum = 0;
        int MAX_SUM = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            currSum = currSum + arr[i];
            MAX_SUM = Math.max(currSum, MAX_SUM);
            
            if(currSum < 0){
                currSum = 0;
            }
        }
        System.out.println("MAX SUM = "+ MAX_SUM);
    }

    public static int trappedRainWater(int height[]){
        int n = height.length;
        // calculate left max boundary- array
        int LeftMax[] = new int [n];
        LeftMax[0] = height[0];
        for(int i =1; i<n; i++){
            LeftMax[i] = Math.max(height[i], LeftMax[i-1]);
        }
        // calculate right max boundary- array
        int RightMax[] = new int [n];
        RightMax[n-1] = height[n-1];
        for(int i = n-2; i>=0; i--){
            RightMax[i] = Math.max(height[i], RightMax[i+1]);
        }
        // calculate trapped water
        int trappedWater = 0;
        for(int i = 0; i < n; i++){
            int waterLevel = Math.min(LeftMax[i], RightMax[i]);
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }

    public static void Buy_Sell_Stock(int price[]){
        int Buying_price = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i =0; i < price.length; i++){
            if( Buying_price < price[i]){
                int profit = price[i] - Buying_price;
                maxProfit = Math.max(profit, maxProfit);

            }
            else{
                Buying_price = price[i];
            }
        }
        System.out.println(" maxProfit = "+ maxProfit);
    }
    //practice question
    // Q1 check if the array has duplicate element or not = Brute Force (O(n^2))
    public static boolean distinctORnot(int number[]){
        for(int i=0; i<number.length; i++){
            for(int j = i+1; j<number.length; j++){
                if(number[i] == number[j]){
                    return true;
                }
            }
        }
        return false;
    }
    //Q2 Given the array nums after the possible rotation and an integer target, 
    // return the index of target if it is in nums, or -1   if it is not in nums.
    // public static int Rotate_target(int nums[], int target){
    //     int n = nums.length;
    //     int start = 0; 
    //     int end = n-1;
    //     while (start <= end) {
    //         int mid = (start + end) / 2;
    //         if(nums[mid] == target){ // FOUND
    //             return mid;
    //         }
    //         if(nums[start] > nums[end]){// rotated
    //         }
    //     }
    //     return 0;
    // }


    public static void main(Strings[] args){
        int  height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappedRainWater(height));
    }
}
