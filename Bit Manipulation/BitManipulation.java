public class BitManipulation {
    
    public static void EvenOdd(int n) {
        if ((n & 1) == 0) {
            System.out.println(n + " is even.");
        } else {
            System.out.println(n + " is odd.");
        }
    }
    public static int GetIthBit(int n, int i) {
        int bitmask = 1 << i; 
        if((n & bitmask) == 0){
            return 0;
        }else{
            return 1;
        }
    }
    public static int SetIthbit(int n, int i){
        int bitmask = 1<<i;
        return n | bitmask;
    }
    public static int clearIthbit(int n, int i){
        int bitmask = ~(1<<i);
        return n & bitmask;
    }
    public static int UpdateIthbit(int n , int i, int newbit){
        // if(newbit == 0){
        //     return clearIthbit(n, i);
        // }
        // else{
        //     return SetIthbit(n, i);
        // }
        n= clearIthbit(n, i);
        int bitmask = newbit<<i;
        return n| bitmask;
    }
    public static int clearlastIbit(int n, int i){
        int bitmask = -1<<i;
        return n & bitmask;
    }
    public static int clearrangeITOJbit(int n, int i, int j){
        int a = (~0)<<(j+1);
        int b = (1<<i)-1;
        int bitmask = a | b;
        return n & bitmask;
    }
    public static boolean isnumberpowerof2(int n){
        return (n & (n-1) ) == 0 ;
    }
    public static int countsetbit(int n){
        int count = 0;
        while (n>0) {
            if((n&1)!= 0){
                count++;
            }
            n = n>>1;
        }
        return count;
    }
    public static void main(String[] args) {
       // Convert uppercase character to lowercase
       for(char ch = 'A'; ch <= 'Z'; ch++) {
        System.out.print((char)(ch|' '));// prints abcdefghijklmnopqrstuvwxyz
        }
    }
}
