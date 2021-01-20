package exams;

import java.util.Arrays;

public class q2oct2017LIS {

    public static int LCSsize(int[] arr, int[] arr1){
        int n = arr.length +1;
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            mat[i][0] = 0;
            mat[0][i] = 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if(arr[i-1] == arr1[j-1]){
                    mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]) +1;
                }
                else
                    mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
        return mat[n-1][n-1];
    }

    public static int LIS(int[] arr) { // O(n^2)
        int[] sortedArr = new int[arr.length];
        sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        return LCSsize(arr, sortedArr);
    }

    public static void main(String[] args) {
        int[] arr = {3, 11, 2, 10, 4, 5, 9, 1};
        System.out.println(LIS(arr));
    }
}
