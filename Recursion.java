public class Recursion {
    public static int factorial(int n){
        if(n==0){
            return 1;
        }
        return (n*factorial(n-1));
        //System.out.print(n + " ");
    }

    public static int calsum(int n){
        if(n==1){
            return 1;
        }
        return (n+calsum(n-1));
    }

    public static int fibonacci(int n){
        if(n == 0 || n == 1){
            return n;
        }
        int fibnm1 = fibonacci(n-1);
        int fibnm2 = fibonacci(n-2);
        int fibN = fibnm1 + fibnm2;
        return fibN;
    }

    public static boolean issorted(int arr[], int i){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i] > arr[i+1]){
            return false;
        }
        return issorted(arr, i+1);
    }

    public static int firstoccurrence(int arr[], int key, int i){
        if(i == arr.length){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
        return firstoccurrence(arr, key, i+1);
    }

    public static int lastoccurrence(int arr[], int key, int i){
        if(i == arr.length){
            return -1;
        }
        int isfound = lastoccurrence(arr, key, i+1);
        if(isfound == -1 && arr[i] == key){
            return i;
        }
        return isfound;
    }

    public static int pow(int x , int n){
        if(n == 1){
            return x;
        }
        return (x * pow(x, n-1));
    }

    public static int optimizedpow(int x , int n){
        if(n == 0){
            return 1;
        }
        // if(n%2 == 0){
        //     return optimizedpow(x, n/2) * optimizedpow(x, n/2);
        // }else{
        //     return x * optimizedpow(x, n/2) * optimizedpow(x, n/2);
        // }
        int halfpower = optimizedpow(x, n/2);
        int halfpowersq = halfpower * halfpower;
        if(n%2 == 0){
            return halfpowersq;
        }else{
            return x * halfpowersq;
        }
    }

    public static int tilingproblem(int n){
        //base case
        if(n == 0 || n == 1){
            return 1;
        }
            //return tilingproblem(n-1) + tilingproblem(n-2);
            //kaam
            //vertical choice
            int fnm1 = tilingproblem(n-1);
            //horizontal choice
            int fnm2 = tilingproblem(n-2);
            int total_ways = fnm1 + fnm2;
            return total_ways;
    }

    public static void removeDuplicates(String str, int idx, StringBuilder newstr, boolean map[]){
        if(idx == str.length()){
            System.out.println(newstr);
            return ;
        }
        char currchar = str.charAt(idx);
        if(map[currchar - 'a'] == true){
            removeDuplicates(str, idx+1, newstr, map);
        }else{
            map[currchar - 'a'] = true;
            removeDuplicates(str, idx+1, newstr.append(currchar), map);
        }
    }
    public static int friendspairing(int n){
        //base case
        if(n == 0 || n == 1 || n == 2){
            return n;
        }
        // choice 1 single
        int fnm1 = friendspairing(n-1);
        // choice 2 pair
        int fnm2 = friendspairing(n-2);
        int pairways = (n-1) * fnm2;
        int totalways = fnm1 + pairways;
        return totalways;
    }
    public static void binarystrings(int n, int lastplace, String str){
        if(n == 0){
            System.out.println(str);
            return;
        }
        binarystrings(n-1, 0, str + "0");
        if(lastplace == 0){
            binarystrings(n-1, 1, str + "1");
        }
    }

    public static void alloccurrence(int arr[], int key, int i){
        if(i == arr.length){
            return;
        }
        if(arr[i] == key){
            System.out.print(i + " ");
        }
        alloccurrence(arr, key, i+1);
    }
    static String digits [] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
    public static void noTOstring(int n){
        if(n==0) return;
        int lastdigit = n%10;
        noTOstring(n/10);
        System.out.print(digits[lastdigit] + " ");

    }
    public static int LengthofaString(String str){
        if(str.length() == 0){
            return 0;
        }
        return 1 + LengthofaString(str.substring(1));
    }
    public static int countSubstrs(String str,int i, int j, int n) {
        if(n==1)return 1;
        if(n<=0)return 0;
        int res = countSubstrs(str,i+1,j,n-1) + countSubstrs(str,i,j-1,n-1) - countSubstrs(str,i+1,j-1,n-2);
        if(str.charAt(i) == str.charAt(j)) {
            res++;
        }
        return res;
    }
    // tower of hanoi
    // public static int towerofhanoi(int n, String src, String helper, String dest){
    //     if(n == 1){
    //         System.out.println("Transfer disk " + n + " from " + src + " to " + dest);
    //         return 1;
    //     }
    //     int step1 = towerofhanoi(n-1, src, dest, helper);
    //     System.out.println("Transfer disk " + n + " from " + src + " to " + dest);
    //     int step2 = towerofhanoi(n-1, helper, src, dest);
    //     return step1 + step2 + 1;
    // }
    public static void main(String[] args) {
        // System.out.println(factorial(5));
        // System.out.println(calsum(5));
        // System.out.println(fibonacci(5));
        // int arr[] = {1,2,3,4,5};
        // System.out.println(issorted(arr, 0));
        // int arr[] = {1,2,3,4,5};
        // System.out.println(firstoccurrence(arr, 3, 0));
        // int arr[] = {1,2,3,4,5};
        // System.out.println(lastoccurrence(arr, 3, 0));
        // System.out.println(pow(2, 10));
        // System.out.println(optimizedpow(2, 10));
        // System.out.println(tilingproblem(4));
        //String str = "appnnacollege";
        // removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
        //System.out.println(friendspairing(3));
        //binarystrings(3, 0, "");
        // int arr[] = {1,2,3,4,5,3,3};
        // alloccurrence(arr, 3, 0);
        // System.out.println();
        // noTOstring(1234);
        String str="aba";
        int n=str.length();
        System.out.print(countSubstrs(str,0,n-1,n));
    }


    
}
