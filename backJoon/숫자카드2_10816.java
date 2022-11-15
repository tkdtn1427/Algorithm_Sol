package backJoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

// 실버 4
// 해시
// 이분 탐색
// 정렬
public class 숫자카드2_10816 {
    static int[] dp;
    static int[] dp2;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[10_000_001];
        dp2 = new int[10_000_001];
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<M; i++){
            int number = Integer.parseInt(st.nextToken());
            if(number >= 0){
                dp[number] += 1;
            }else{
                dp2[-number] += 1;
            }
        }

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int target = Integer.parseInt(st.nextToken());
            if(target > 0)
                sb.append(dp[target]).append(" ");
            else
                sb.append(dp2[-target]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
