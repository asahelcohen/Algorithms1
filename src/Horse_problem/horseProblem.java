package Horse_problem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * n^2 horses - an array of speed
 * n horses in each race
 * find the 3 fastest horses
 */
public class horseProblem {

    public static int printTop3(int[] horses){
        int n = (int) Math.sqrt(horses.length);
        int[][] ans = new int[n][n];
        int k = 0;
        int counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = horses[k++];
            }
            race(ans[i], n);
            counter++;
        }
        race(ans, n);
        counter++;
        int[] topHorses = {ans[n-1][n-2], ans[n-1][n-3], ans[n-2][n-1], ans[n-2][n-2], ans[n-3][n-1]};
        race(topHorses, n);
        counter++;
        System.out.println("1st: "+ ans[n-1][n-1]);
        System.out.println("2nd: "+ topHorses[n-1]);
        System.out.println("3rd: "+ topHorses[n-2]);
        return counter;
    }

    /**
     * this function returns the arr sorted from fastest to slowest
     * (acts as race)
     * @param horses array of the horses entering the race
     */
    public static void race(int[][] horses, int n){
        if(horses.length == n){
            Arrays.sort(horses, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[n-1] < o2[n-1]) return -1;
                    if(o1[n-1] > o2[n-1]) return 1;
                    return 0;
                }
            });
        }
    }

    /**
     * this function returns the arr sorted from fastest to slowest
     * (acts as race)
     * @param horses array of the horses entering the race
     */
    public static void race(int[] horses, int n){
        if(horses.length == n){
            Arrays.sort(horses);
        }
    }

    public static void main(String[] args) {
        int[] horses ={4,6,8,10,12,14,15,18,19,20,21,22,23,24,25,26,45,28,29,30,31,33,34,36,37};
        printTop3(horses);
    }
}
