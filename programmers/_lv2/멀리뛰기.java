package programmers._lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 멀리뛰기 {
    public static void main(String[] args) {
        System.out.println(solution(3));
    }

    static long[] dp;
    static List<Integer> list;
    static long solution(int n) {
        dp = new long[2001];
        list = new ArrayList<>(List.of(1,2));
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 1234567L;
        }

        System.out.println(Arrays.toString(dp));

        return dp[n];
    }
}
