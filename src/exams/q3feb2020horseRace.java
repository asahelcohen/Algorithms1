package exams;

import java.util.Arrays;
import java.util.Comparator;

public class q3feb2020horseRace {

    public static int minNumRaces(int[] horses){
        int num = 0;
        int[][] race = new int[5][5];
        int k = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                race[i][j] = horses[k];
                k++;
            }
        }
        for (int i = 0; i < 5; i++) {
            Arrays.sort(race[i]);
            num++;
        }
        Arrays.sort(race, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[4] < o2[4]) return -1;
                if(o1[4] > o2[4]) return 1;
                return 0;
            }
        });
        num++;
        int[] finalRace = {race[4][3],race[4][2],race[3][4],race[3][3],race[2][4]};
        Arrays.sort(finalRace);
        num++;
        System.out.println("first: "+ race[4][4]);
        System.out.println("second: "+finalRace[4]);
        System.out.println("third: "+finalRace[3]);


        return num;
    }



    public static void main(String[] args) {
        int[] horses ={4,6,8,10,97,14,56,18,19,20,21,22,23,24,25,26,45,28,29,30,31,33,34,36,37};
        System.out.println(minNumRaces(horses));
    }
}
