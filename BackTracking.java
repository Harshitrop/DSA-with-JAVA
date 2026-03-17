public class BackTracking {
    public static void changearr(int arr[], int i, int val){
        //bace case
        if(i == arr.length){
            printarr(arr);
            return;
        }
        //kaam(recursion)
        arr[i] = val;
        changearr(arr, i+1, val+1);
        arr[i] = arr[i] -2;
    }

    public static void printarr(int arr[]){
        for(int i =0; i<arr.length; i++){
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }
    public static void subset(String str, String ans, int i){
        //base case 
        if(i == str.length()){
            if( ans.length() == 0){
                System.out.println("null");
            }
            else{
            System.out.print(ans+" ");
            }
            return;
        }
        //recursion
        //yes choice
        subset(str, ans+str.charAt(i), i+1);
        // no choice
        subset(str, ans, i+1);
    }
    public static void permutations(String str,String ans){
        //base case
        if(str.length() == 0){
            System.out.print(ans+" ");
            return;
        }
        //recursion
        for(int i =0; i<str.length(); i++){
            char curr = str.charAt(i);
            String newstr = str.substring(0,i) + str.substring(i+1);
            permutations(newstr, ans+curr);
        }
    }
    // N Quneen que
    public static boolean nQueen(char board [][], int row){ // boolen type use for one solution
        // base case
        if(row == board.length){
            count++;
            //printboard(board);
            return true;
        }
        //col
        for(int j =0; j<board.length; j++){
            if(issafe(board, row, j)){
                board[row][j] = 'Q';
                if(nQueen(board, row+1)){ // if use for one solution 
                    return true;
                }
                board[row][j] = 'x';
            }
        }
        return false;
    }
    public static boolean issafe(char board[][], int row, int col){
        //vertical up
        for(int i =row-1; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        // diag left up
        for(int i = row-1 , j=col-1 ; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        // diag right up
        for(int i = row-1, j = col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public static void printboard(char board[][]){
        System.out.println("------ CHASE BOARD ------");
        for(int i =0; i<board.length; i++){
            for(int j =0; j<board.length; j++){
                System.out.print(board[i][j] +" ");
            }
        System.out.println();
        }
    }
    static int count = 0;
    // public static void main(String[] args){
    //    int n = 4;
    //    char board[][] = new char[n][n];
    //    //initialize
    //    for(int i = 0; i<n; i++){ 
    //         for(int j = 0; j<n; j++){
    //             board[i][j] = 'x';
    //         }
    //     }
    //    if(nQueen(board, 0)){
    //     System.out.println("Solution is possible");
    //     printboard(board);
    //    }
    //    else{
    //     System.out.println("Solution is  NOT possible");
    //    }
    //    //System.out.println("Total solution for N queen = " + count);
    // }
    public static int Gridways(int i, int j, int n, int m){
        //base case
        if(i == n-1 && j == m-1){// condition for last coll
            return 1;
        }
        else if( i == n || j == m) { // baoundry  crros condition
            return 0;
        }
        int w1 = Gridways(i+1, j, n, m);
        int w2 = Gridways(i, j+1, n, m);
        return w1+w2;

    }
    public static boolean issafe(int sudoku[][], int row, int col, int digit){
        //col
        for(int i=0; i<=8; i++){
            if(sudoku[i][col] == digit){
                return false;
            }
        }
        //row
        for(int j =0; j<=8; j++){
            if(sudoku[row][j] == digit){
                return false;
            }
        }
        //grid
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        for(int i = sr; i < sr+3; i++){
            for(int j = sc; j < sc+3; j++){
                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean sudokusolver(int sudoku[][], int row, int col){
        //base case
        if(row == 9 && col == 0){
            return true;
        }
        //recursion
        int nextrow = row, nextcol = col+1;
        if(col+1 == 9){
            nextrow = row+1;
            nextcol = 0;
        }
        if(sudoku[row][col] != 0){
            return sudokusolver(sudoku, nextrow, nextcol);
        }
        for(int digit =1; digit<=9; digit++){
            if(issafe(sudoku, row, col, digit)){
                sudoku[row][col] = digit;
                if(sudokusolver(sudoku, nextrow, nextcol)){
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }
    public static void printsudoko(int sudoku[][]){
        for(int i =0; i<9; i++){
            for(int j =0; j<9; j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int sudoku[][] = {
            { 0, 0, 8, 0, 0, 0, 0, 0, 0},
            { 4, 9, 0, 1, 5, 7, 0, 0, 2},
            { 0, 0, 3, 0, 0, 4, 1, 9, 0},
            { 1, 8, 5, 0, 6, 0, 0, 2, 0},
            { 0, 0, 0, 0, 2, 0, 0, 6, 0},
            { 9, 6, 0, 4, 0, 5, 3, 0, 0},
            { 0, 3, 0, 0, 7, 2, 0, 0, 4},
            { 0, 4, 9, 0, 3, 0, 0, 5, 7},
            { 8, 2, 7, 0, 0, 9, 0, 1, 3},
        };

        if(sudokusolver(sudoku, 0, 0)){
            System.out.println("Solution exit");
            printsudoko(sudoku);
        }
        else{
            System.out.println(" Solution NOT exit");
        }
    } 
}