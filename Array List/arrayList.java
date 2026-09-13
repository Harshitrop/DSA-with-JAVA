import java.util.*;

public class arrayList {

    //container with most water
    //brute force (O(n^2))
    public static int CwithMWater(ArrayList<Integer> height){
        int maxwater =0;
        for(int i =0; i<height.size(); i++){
            for(int j=i+1; j<height.size(); j++){
                int ht = Math.min(height.get(i), height.get(j));
                int width = j - i;
                int currwater = ht*width;
                maxwater = Math.max(maxwater, currwater);
            }
        }
        return maxwater;
    }

    //Optimize solution - O(n) for container with most water
    // 2 pointer approach
    public static int CwithMwater2(ArrayList<Integer> height){
        int maxwater = 0;
        int LP = 0;
        int RP = height.size()-1;

        while (LP < RP) {
            // calculate water area
            int ht = Math.min(height.get(LP), height.get(RP));
            int width = RP - LP;
            int currwater = ht * width;
            maxwater = Math.max(maxwater, currwater);

            //update pointer
            if(height.get(LP) < height.get(RP)){
                LP++;
            }else{
                RP--;
            }
        }
        return maxwater;
    }
    //   public static void main1(String[] args){
    //     ArrayList<Integer> height = new ArrayList<>();
    //     height.add(1);
    //     height.add(8);
    //     height.add(6);
    //     height.add(2);
    //     height.add(5);
    //     height.add(4);
    //     height.add(8);
    //     height.add(3);
    //     height.add(7);

    //     System.out.println(CwithMwater2(height));
    // }
    public static boolean pairsum(ArrayList<Integer> list, int tar){
        int LP = 0;
        int RP = list.size()-1;
        while (LP<RP) {
            if(list.get(LP)+list.get(RP) == tar){
                return true;
            }
            else if(list.get(LP)+list.get(RP)  < tar){
                LP++;
            }
            else{
                RP--;
            }
        }
        return false;
    }
     public static boolean pairsum2(ArrayList<Integer> list, int tar){
        int bp = -1;
        int n = list.size();
        for(int i = 0; i<list.size(); i++){
            if(list.get(i) > list.get(i+1)){
                bp = i;
                break;
            }
        }
        int LP = bp+1;
        int RP = bp;
        while (LP != RP) {
            if(list.get(LP)+list.get(RP) == tar){
                return true;
            }
            if(list.get(LP)+list.get(RP)  < tar){
                LP = (LP + 1)%n;
            }
            else{
                RP = (n + RP-1)%n;
            }
        }
        return false;
    }
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        System.out.println(pairsum2(list, 16));
    }
}