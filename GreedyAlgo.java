import java.util.*;
public class GreedyAlgo {
    //-------------------Activity Selection Problem------------------
    // public static void main(String[] args){
    //     int start[] = {1, 3, 0, 5, 8, 5};
    //     int end[] = {2, 4, 6, 7, 9, 9};

    //     //sorting
    //     int Activity[][] = new int[start.length][3];
    //     for(int i = 0; i<start.length; i++){
    //         Activity[i][0] = i; //original index
    //         Activity[i][1] = start[i]; //start time
    //         Activity[i][2] = end[i]; //end time
    //     }

    //     // Sort by end time
    //     Arrays.sort(Activity, Comparator.comparingDouble(o -> o[2]));//lambda function -> shortform

    //     //end time are sorted in increasing order
    //     int maxAct = 0;
    //     ArrayList<Integer> ans = new ArrayList<>();

    //     //1st activity
    //     maxAct = 1;
    //     ans.add(Activity[0][0]);
    //     int Lastend = Activity[0][2];
    //     for(int i = 1; i<end.length; i++){
    //         if(Activity[i][1] >= Lastend){
    //             //activity selected
    //             maxAct++;
    //             ans.add(Activity[i][0]);
    //             Lastend = Activity[i][2];
    //         }
    //     }

    //     System.out.println("MAX ACTIVITY: "+ maxAct);
    //     for(int i=0; i<ans.size(); i++){
    //         System.out.print("A"+ans.get(i)+" ");
    //     }
    //     System.out.println();
    // }


    //-------------------Fractional KNAPSACK PROBLEM------------------
    public static void main(String[] args){
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int w = 50;

        double ratio[][] = new double[val.length][2];
        //oth column ->index, 1st column ->ratio

        for(int i = 0; i<val.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)wt[i];
        }
        //Ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));


        int capacity = w;
        int finalVal = 0;
        for(int i = ratio.length-1; i >= 0; i--){
            int idx = (int)ratio[i][0];
            if (capacity >= wt[idx]) {// includ full item
                finalVal += val[idx];
                capacity -= wt[idx];
            }else{
                // include fractional item
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("Final Value =" + finalVal);
    }
}
