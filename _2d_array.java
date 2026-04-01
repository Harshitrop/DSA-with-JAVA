//import java.util.Scanner;

public class _2d_array {
    
    public static void _2darray(int matrix[][]){
        int n = matrix.length; int m = matrix[0].length;
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        //Scanner sc = new Scanner(System.in);
        
        for(int i =0; i<n; i++){
            for(int j=0; j<m; j++){
                //matrix[i][j] = sc.nextInt();
                //find the largest and smallest element in the matrix
                if(matrix[i][j] > largest){
                    largest = matrix[i][j];
                }
                if(matrix[i][j] < smallest){
                    smallest = matrix[i][j];
                }
            }
        }
        //print the matrix
        for(int i =0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Largest element: " + largest);
        System.out.println("Smallest element: " + smallest);
    }

    public static boolean search(int matrix[][], int key){
        for(int i =0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == key){
                    System.out.println("key found at index: (" + i + ", " + j + ")");
                    return true;
                }
            }
        }
        System.out.println("key not found");
        return false;
    }

    public static void spiral_matrix(int matrix[][]){
        int start_row = 0;
        int start_col = 0;
        int end_row = matrix.length-1;
        int end_col = matrix.length-1;

        while (start_row <= end_row && start_col <= end_col) {
            //top
            for(int j =start_col; j <= end_col; j++){
                System.out.print(matrix[start_row][j] + " ");
            }
            //rigt
            for(int i =start_row+1; i <= end_row; i++){
                System.out.print(matrix[i][end_col]+ " ");
            }
            //bootom
            for(int j =end_col-1; j>= start_col; j--){
                if(start_row == end_row){
                    break;
                }
                System.out.print(matrix[end_row][j]+ " ");
            }
            //left
            for(int i =end_row-1; i>= start_row+1; i--){
                if(start_col == end_col){
                    break;
                }
                System.out.print(matrix[i][start_col]+ " ");
            }
            start_row ++;
            start_col ++;
            end_row --;
            end_col--;
        }
        System.out.println();
    }

    public static int diagonal_sum(int matrix[][]){
        int sum = 0;
        // for(int i = 0; i<matrix.length; i++){//O(n^2)
        //     for(int j = 0; j<matrix.length; j++){
        //         if(i == j){
        //             sum += matrix[i][j];
        //         }
        //         else if(i+j == matrix.length-1){
        //             sum +=matrix[i][j];
        //         }
        //     }
        // }

        for(int i=0; i<matrix.length; i++){//O(n)
            //primarySUM
            sum += matrix[i][i];
            //SecondrySUM
            if(i!= matrix.length-1-i)
                sum += matrix[i][matrix.length-i-1];
        }
        return sum;
    }

    public static boolean  searchIN_sortArray(int matrix[][], int key ){
        int row =0; int col = matrix[0].length;
        while (row < matrix.length && col >= 0) {
            if(matrix[row][col] == key){
                System.out.println("FOUND at index = (" + row + "," + col + ")" );
                return true;
            }
            else if (key < matrix[row][col]){
                col--;
            }
            else{
                row++;
            }
        }
        System.out.println("NOT FOUND");
        return false;
    }

    //practice 
    //Q1.Print the number of 7’s that are in the 2d Array.
    public static int count7(int matrix[][]){
        int count = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 7){
                    count ++;
                }
            }
        }
        return count;
    }
    //Q2 print out the sum of the numbers in the second row of the “nums” array
    public static int sum(int matrix[][]){
        int sum =0;
        for(int j=0; j<matrix[0].length; j++){
            sum += matrix[1][j];
        }
        return sum;
    }

    // Q3 Write a program to FindTransposeofa Matrix
    public static void transmatrix(int matrix[][]){
        int col = 3;
        int row = 2;
        int[][]transpose = new int [col][row];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
            transpose[j][i] =matrix[i][j];
            }
        }
    }

    public static void printMatrix(int[][]matrix){
        System.out.println("The matrix is: ");
        for(int i = 0; i<matrix.length; i++) {
            for(int j = 0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
    }
    public static void main(Strings[] args){
        int[][]matrix= { {2,3,7}, {5,6,7} };
        printMatrix(matrix);// original
        int col = 3;
        int row = 2;
        int[][]transpose = new int [col][row];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
            transpose[j][i] = matrix[i][j];
            }
        }
        printMatrix(transpose);
    }
}
