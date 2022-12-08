package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 실버 1
// 그래프 이론
// 너비우선 탐색
// 다시풀기
public class 숨바꼭질_1697 {
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[100_001];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int pointS = Integer.parseInt(st.nextToken());
        int pointT = Integer.parseInt(st.nextToken());

        bfs(pointS,pointT);

        System.out.println(Arrays.toString(dp));
    }

    static void bfs(int start, int pointT){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()){
            int number = queue.poll();
            for(int i=0; i<3; i++){
                int next;

                if(i==0){
                    next = number-1;
                }else if(i==1){
                    next = number+1;
                }else{
                    next = number*2;
                }

                if(next == pointT){
                    System.out.println(dp[number]+1);
                    return ;
                }

                if(dp[next] == 0 && next<dp.length && next > 0){
                    queue.add(next);
                    dp[next] = dp[number]+1;
                }
            }
        }
    }
}
