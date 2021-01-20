package exams;

import java.util.Arrays;

public class q1oct2017oneMatrix {

    public static int findTwoTwoSquare(int[][] mat){
        int[][] arr = new int[mat.length][mat[0].length];
        int ans = 0;
        for (int i = 0; i < mat.length; i++) {
            arr[i][0] = mat[i][0];
        }
        for (int i = 0; i < mat[0].length; i++) {
            arr[0][i] = mat[0][i];
        }
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                if(mat[i][j] == 1){
                    if((arr[i-1][j] == 2 || arr[i-1][j] == 1) &&
                            (arr[i][j-1] == 2 || arr[i][j-1] == 1) && (arr[i-1][j-1] == 2 || arr[i-1][j-1] == 1)){
                        arr[i][j] = 2;
                    }
                    else
                        arr[i][j] = 1;
                }
                else
                    arr[i][j] = 0;
            }

        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 2){
                    ans++;
                }
            }

        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }


        return ans;
    }

    public static int findLargestSquare(int[][] mat){
        int[][] ans = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            ans[i][0] = mat[i][0];
        }
        for (int i = 0; i < mat[0].length; i++) {
            ans[0][i] = mat[0][i];
        }
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                if(mat[i][j] == 1){
                    if(ans[i-1][j] == ans[i-1][j-1] && ans[i][j-1] == ans[i-1][j-1]){
                        ans[i][j] = 1+ ans[i-1][j-1];
                    }
                    else
                        ans[i][j] = Math.max(ans[i-1][j], ans[i][j-1]);
                }
                else
                    ans[i][j] = 0;
            }

        }
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }


        return ans[ans.length-1][ans[0].length-1];
    }

    public static void main(String[] args) {
        int[][] mat = { {0,0,1,0,1},
                {0,1,1,1,1},
                {1,1,1,1,0},
                {0,1,1,1,1},
                {0,0,1,1,1}};
        int x = findLargestSquare(mat);
        System.out.println("largest square of ones is built of: " + x*x + " ones.");
        System.out.println("amount of squares sized 2x2 is: " + findTwoTwoSquare(mat));
    }
}
