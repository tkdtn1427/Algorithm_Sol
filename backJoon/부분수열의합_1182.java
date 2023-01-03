package backJoon;

// 실버 2
// 완탐, 백드래킹
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부분수열의합_1182 {
    static int[] data;
    static int result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        result = 0;

        data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(data);

        dfs(0, 0, T);

        if(T == 0){
            System.out.println(result-1);
        }else{
            System.out.println(result);
        }
    }

    static void dfs(int idx, int value, int T){
        if(idx == data.length){
            if(value == T){
                result++;
            }
            return;
        }

        dfs(idx+1, value+data[idx],T);
        dfs(idx+1, value, T);
    }
}
