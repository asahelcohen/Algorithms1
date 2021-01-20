package exams;

public class q4feb2020numGame {

    public static int multiGame(int[] arr){
        int n = arr.length;
        int[] temp = new int[n];
        int[][] play = new int[2][n];
        int ans = 0;
        int maxWin = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[(j+i)%n] = arr[j];
            }
            int[][] temp2 = matrixBuilder(temp);
            if(temp2[0][n-1] > maxWin) {
                maxWin = temp2[0][n-1];
                play = playGame(temp);
//                ans = play[0][0];
                ans = i;
            }
        }
        return ans;
    }

    public static int[][] playGame(int[] arr) {
        int[][] ans = new int[2][arr.length/2];
        int[][] game = matrixBuilder(arr);
        int player = 0;
        int k = 0;
        int i = 0;
        int j = arr.length -1;
        while(i != j){
            if(game[i][i] - game[i+1][j] > game[j][j] - game[i][j-1]){
                ans[player][k] = game[i][i];
                i++;
            }
            else{
                ans[player][k] = game[j][j];
                j--;
            }

            if(player == 0) player =1;
            else {
                player = 0;
                k++;
            }
        }
        ans[1][arr.length/2 -1] = game[i][i];

        return ans;
    }

    public static int[][] matrixBuilder(int[] arr) {
        int n = arr.length;
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            ans[i][i] = arr[i];
        }
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n) {
                ans[i][j] = Math.max(ans[i][i] - ans[i + 1][j], ans[j][j] - ans[i][j - 1]);
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] numGame = {1, 4, 5, 8, 3, 9, 5, 3, 4, 2, 5, 2, 1, 1};
        int[] numGame = {1, 2, 11, 3, 6, 11, 4, 2, 8, 10};
        int[][] arr = matrixBuilder(numGame);
        for (int i = 0; i < numGame.length; i++) {
            for (int j = 0; j < numGame.length; j++) {
                if (j == numGame.length - 1)
                    System.out.println(arr[i][j]);
                else
                    System.out.print(arr[i][j] + " ");
            }
        }
        int[][] moves = playGame(numGame);
        int player1 = 0;
        int player2 = 0;
        for (int i = 0; i < moves[0].length; i++) {
            System.out.print(moves[0][i]+ "-->");
            player1 += moves[0][i];
        }
        System.out.println();
        for (int i = 0; i < moves[0].length; i++) {
            System.out.print(moves[1][i]+ "-->");
            player2 += moves[1][i];
        }
        System.out.println();
        System.out.println("difference: "+ (player1 - player2));
        System.out.println("best first pick: numGame at index "+multiGame(numGame));

    }
}
