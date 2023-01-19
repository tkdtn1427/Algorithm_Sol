package programmers.graph;

import java.util.*;

// Lv. 3
// 다시풀이
public class 순위 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[][]{{1,4},{4,2},{2,5},{5,3}}));
    }
    static int[][] dp;
    static int solution(int n, int[][] results) {
        dp = new int[n+1][n+1];
        int result = 0;

        for(int[] tmp : results){
            int win = tmp[0];
            int loser = tmp[1];

            dp[win][loser] = 1;
        }

        for(int[] tmp : dp){
            System.out.println(Arrays.toString(tmp));
        }

        System.out.println();

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    if(dp[i][j] == 1 && dp[k][i] == 1){
                        dp[k][j] = 1;
                    }
                }
            }
        }

        // i > j, k > i, k > j

        for(int[] tmp : dp){
            System.out.println(Arrays.toString(tmp));
        }

        for (int i = 1; i <= n; i++) {
            int game = 0;
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] == 1 || dp[j][i] == 1)
                    game++;
            }
            if (game == n-1)
                result++;
        }

        return result;
    }
}