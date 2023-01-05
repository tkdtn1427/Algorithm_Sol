package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 사탕게임_3085 {
    static String[][] dp;
    static int max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        max = 0;

        int repeat = Integer.parseInt(br.readLine());

        dp = new String[repeat][repeat];

        for (int i = 0; i < repeat; i++) {
            dp[i] = br.readLine().split("");
        }

        search();

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length-1; j++) {
                String temp = dp[i][j];
                dp[i][j] = dp[i][j+1];
                dp[i][j+1] = temp;

                search();

                temp = dp[i][j];
                dp[i][j] = dp[i][j+1];
                dp[i][j+1] = temp;
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length-1; j++) {
                String temp = dp[j][i];
                dp[j][i] = dp[j+1][i];
                dp[j+1][i] = temp;

                search();

                temp = dp[j][i];
                dp[j][i] = dp[j+1][i];
                dp[j+1][i] = temp;
            }
        }

        System.out.println(max);
    }

    static void search(){
        for(int i=0; i<dp.length; i++) {
            int count=1;
            for(int j=0; j<dp[i].length-1; j++){
                if(dp[i][j].equals(dp[i][j+1])){
                    count++;
                }else{
                    count=1;
                }
                max = Math.max(count, max);
            }
        }

        for(int i=0; i<dp.length; i++) {
            int count=1;
            for(int j=0; j<dp[i].length-1; j++){
                if(dp[j][i].equals(dp[j+1][i])){
                    count++;
                }else{
                    count=1;
                }
                max = Math.max(count, max);
            }
        }
    }
}
