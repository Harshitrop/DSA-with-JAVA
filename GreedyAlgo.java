//import java.util.*;
public class GreedyAlgo {
    //------------------- Activity Selection Problem ------------------
    // public static void main(String[] args){ // O(nlogn)
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
    // public static void main(String[] args){// O(nlogn)
    //     int val[] = {60, 100, 120};
    //     int wt[] = {10, 20, 30};
    //     int w = 50;

    //     double ratio[][] = new double[val.length][2];
    //     //oth column ->index, 1st column ->ratio

    //     for(int i = 0; i<val.length; i++){
    //         ratio[i][0] = i;
    //         ratio[i][1] = val[i]/(double)wt[i];
    //     }
    //     //Ascending order
    //     Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));


    //     int capacity = w;
    //     int finalVal = 0;
    //     for(int i = ratio.length-1; i >= 0; i--){
    //         int idx = (int)ratio[i][0];
    //         if (capacity >= wt[idx]) {// includ full item
    //             finalVal += val[idx];
    //             capacity -= wt[idx];
    //         }else{
    //             // include fractional item
    //             finalVal += (ratio[i][1] * capacity);
    //             capacity = 0;
    //             break;
    //         }
    //     }
    //     System.out.println("Final Value =" + finalVal);
    // }

    //----------------MIN Absolute Difference------------------
    // public static void main(String[] args){// O(nlogn)
    //     int A[] = {4,1,8,7};
    //     int B[] = {2,3,6,5};

    //     Arrays.sort(A);
    //     Arrays.sort(B);

    //     int mindiff = 0;
    //     for(int i=0; i<A.length; i++){
    //         mindiff += Math.abs(A[i] - B[i]);
    //     }
    //     System.out.println("Minimum Absolute Difference: "+ mindiff);
    // }


    //----------------MAX LENGTH CHAIN OF PAIRS------------------
    // public static void main(String[] args){// O(nlogn)
    //     int pair[][] = {{5, 24}, {39, 60}, {5,28}, {27, 40}, {50, 90}};

    //     Arrays.sort(pair, Comparator.comparingDouble(o -> o[1]));
    //      int chainlen = 1;
    //      int chainend = pair[0][1];

    //      for(int i =1; i<pair.length; i++){
    //         if(pair[i][0] > chainend){
    //             chainlen++;
    //             chainend = pair[i][1];
    //         }
    //      }
    //      System.out.println("Maximum chain length: " + chainlen);
    // }


    //------------Indian Coin Change Problem------------------
    // public static void main(String[] args){
    //     Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};

    //     Arrays.sort(coins, Comparator.reverseOrder());
    //     int amount = 590;
    //     int countOfCoins = 0;
    //     ArrayList<Integer> ans = new ArrayList<>(); 

    //     for(int i = 0; i<coins.length; i++){
    //         if(coins[i] <= amount){
    //             while (coins[i] <= amount){ {
    //                     countOfCoins++;
    //                     ans.add(coins[i]);
    //                     amount -= coins[i]; // check same coin again
    //                 }
    //             }
    //         }
    //     }
    //     System.out.println("Total coins used: " + countOfCoins);
    //     for(int i = 0; i<ans.size(); i++){
    //         System.out.print(ans.get(i) + " " +"="+ amount);
    //     }
    //     System.out.println();

    // }


    //---------------JOB SEQUENCING PROBLEM------------------
    // static class Job{
    //     int id;
    //     int deadline;
    //     int profit;

    //     public Job(int id, int deadline, int profit){
    //         this.id = id;
    //         this.deadline = deadline;
    //         this.profit = profit;
    //     }
    // }
    // public static void main(String[] args){
    //     int jobsinfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

    //     ArrayList<Job> jobs = new ArrayList<>();
    //     for(int i = 0; i<jobsinfo.length; i++){
    //         jobs.add(new Job(i, jobsinfo[i][0], jobsinfo[i][1]));
    //     }
    //     //sort by profit
    //     Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);//descending order

    //     ArrayList<Integer> jobseq = new ArrayList<>();
    //     int time = 0;
    //     for(int i = 0; i<jobs.size(); i++){
    //         Job currjob = jobs.get(i);
    //         if(currjob.deadline > time){
    //             jobseq.add(currjob.id);
    //             time++;
    //         }
    //     }
    //     //print job sequence
    //     System.out.println("Maximum Job sequence: " + jobseq.size());
    //     for(int i = 0; i<jobseq.size(); i++){
    //         System.out.print("JOB = "+jobseq.get(i)+" ");
    //     }
    //     System.out.println();
    // }


    //------------CHOCOLA(Chocolate) PROBLEM------------------
    // public static void main(String[] args){
    //     int n = 4; int m = 6;
    //     Integer costVer[] = {2, 1, 3, 1, 4}; // n-1 vertical cuts
    //     Integer costHor[] = {4, 1, 2}; // m-1 horizontal cuts

    //     Arrays.sort(costVer, Collections.reverseOrder());
    //     Arrays.sort(costHor, Collections.reverseOrder());
        
    //     int h = 0; int v = 0;
    //     int hp = 1; int vp = 1;
    //     int mincost = 0; 

    //     while(h < costHor.length && v < costVer.length){
    //         if(costHor[h] > costVer[v]){// horizontal cut
    //             mincost += costHor[h] * vp;
    //             hp++;
    //             h++;
    //         }else{// vertical cut
    //             mincost += costVer[v] * hp;
    //             vp++;
    //             v++;
    //         }
    //     }
    //     //remaining horizontal cuts
    //     while(h < costHor.length){
    //         mincost += costHor[h] * vp;
    //         hp++;
    //         h++;
    //     }
    //     //remaining vertical cuts
    //     while(v < costVer.length){
    //         mincost += costVer[v] * hp;
    //         vp++;
    //         v++;
    //     }
    //     System.out.println("Minimum cost: " + mincost);
    // }

    //Practice Question
    //Q1
}