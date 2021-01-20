package exams;

public class q1feb2020subString {
    public static String longestCommonSubString(String x, String y){
        String ans ="";
        int i = x.length() -1;
        int j = y.length() -1;
        String compare = longestSubString(x, y);
        int k = compare.length() -1;
        while(i >= 0 && j >= 0 && k >= 0){
            if(x.charAt(i) == compare.charAt(k) && y.charAt(j) == compare.charAt(k)){
                ans = x.charAt(i) + ans;
                i--; j--; k--;
            }
            else if(x.charAt(i) == compare.charAt(k) && y.charAt(j) != compare.charAt(k)){
                ans = y.charAt(j) + ans;
                j--;
            }
            else if(x.charAt(i) != compare.charAt(k) && y.charAt(j) == compare.charAt(k)){
                ans = x.charAt(i) + ans;
                i--;
            }
            else{
                ans = x.charAt(i) + ans;
                i--;
            }
        }
        if(i == -1){
            while(j >= 0){
                ans = y.charAt(j) + ans;
                j--;
            }
        }
        else
            while(i >= 0){
                ans = x.charAt(i) + ans;
                i--;
            }

        return ans;
    }

    public static String longestSubString(String x, String y){
        String s = "";
        int[][] mat = matrix(x, y);
        int i = x.length();
        int j = y.length();
        while(i > 0 && j > 0){
            if(x.charAt(i -1) == y.charAt(j -1)){
                s = x.charAt(i -1) + s;
                j--; i--;
            }
            else{
                if(mat[i][j-1] > mat[i-1][j])
                    j--;
                else
                    i--;
            }

        }


        return s;
    }

    public static int longestSubSize(String x, String y){
        int[][] mat = matrix(x, y);

        return mat[x.length()][y.length()];
    }

    public static int[][] matrix(String x, String y){
        int[][] mat = new int[x.length() +1][y.length() +1];
        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                if(x.charAt(i -1) == y.charAt(j -1)){
                    mat[i][j] = 1 + mat[i-1][j-1];
                }
                else{
                    mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
                }
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        String x = "abcbdab";
        String y = "bdcaba";
        int[][] mat = matrix(x, y);
        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if(j == y.length()-1)
                    System.out.println(mat[i][j]+ " ");
                else
                    System.out.print(mat[i][j]+ " ");
            }
        }

        System.out.println("longest substring Size: " + longestSubSize(x, y));
        System.out.println("longest susbstring example: "+ longestSubString(x, y));
        System.out.println("longest combained susbstring example: "+ longestCommonSubString(x, y));

    }

}
