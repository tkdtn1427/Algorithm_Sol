package programmers.DP;

import java.util.Arrays;

// Lv. 3
public class 등굣길 {
    public static void main(String[] args) {
        System.out.println(solution(4,3,new int[][]{{2,2}}));
    }
    static int[][] loadMap;
    static int solution(int m, int n, int[][] puddles) {
        loadMap = new int[n+1][m+1];
        loadMap[0][1] = 1;
        for(int[] pool : puddles){
            loadMap[pool[1]][pool[0]] = -1;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(loadMap[i][j] == -1 ) continue;
                if(loadMap[i-1][j] == -1) loadMap[i][j] = loadMap[i][j-1];
                else if(loadMap[i][j-1] == -1) loadMap[i][j] = loadMap[i-1][j];
                else loadMap[i][j] = (loadMap[i][j-1] + loadMap[i-1][j]) % 1_000_000_007;
            }
        }

        for(int[] tmp : loadMap){
            System.out.println(Arrays.toString(tmp));
        }

        return loadMap[n][m];
    }
}
