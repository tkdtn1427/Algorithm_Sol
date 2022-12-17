package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 실버 4
// 완전탐색
public class 체스판다시칠하기_1018 {
    static String[][] dp;
    static int result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;
        dp = new String[row][col];

        for(int i=0; i<row; i++){
            dp[i] = br.readLine().split("");
        }

        for(int i=0; i<=dp.length-8; i++){
            for(int j=0; j<=dp[0].length-8; j++){
                result = Math.min(result, search(i,j));
            }
        }

        System.out.println(result);
    }

    static int search(int row, int col){
        int W_count = 0;
        int B_count = 0;

        List<String> W_ = new ArrayList<>(List.of("W","B"));
        List<String> B_ = new ArrayList<>(List.of("B","W"));

        for(int i=row; i<row+8; i++){
            for(int j=col; j<col+8; j++){
                if(!dp[i][j].equals(W_.get((i+j)%2))){
                    W_count++;
                }
                if(!dp[i][j].equals(B_.get((i+j)%2)))
                    B_count++;
            }
        }
        return Math.min(W_count, B_count);
    }
}
