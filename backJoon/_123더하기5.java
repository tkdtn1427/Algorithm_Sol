package backJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 실버 2
// DP
// 다시풀이
public class _123더하기5 {
    static long[][] count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        count = new long[100001][4];
        count[1][1] = 1;
        count[2][2] = 1;
        count[3][1] = 1;
        count[3][2] = 1;
        count[3][3] = 1;
        for(int j=4; j<=100_000; j++){
            count[j][1] = (count[j-1][2] + count[j-1][3]) % 1_000_000_009;
            count[j][2] = (count[j-2][1] + count[j-2][3]) % 1_000_000_009;
            count[j][3] = (count[j-3][1] + count[j-3][2]) % 1_000_000_009;
        }

        for(int i=0; i<repeat; i++){
            int target = Integer.parseInt(br.readLine());
            sb.append((count[target][1] + count[target][2] + count[target][3]) % 1_000_000_009).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
