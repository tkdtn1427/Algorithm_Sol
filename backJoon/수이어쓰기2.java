package backJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 실버 1
// 수학 구현
// 시간초과
public class 수이어쓰기2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int idx = 0;
        int total = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int prev = 0;

        for(int i=1; i<=total; i++){
            if(idx >= target) break;
            prev = i;
            idx += getIdx(i);
        }

        if(target > idx)
            bw.write(String.valueOf(-1));
        else{
            int len = getIdx(prev);
            idx -= len;
            bw.write(String.valueOf(prev).charAt(target-idx-1));
        }

        bw.flush();
        bw.close();
    }

    static int getIdx(int i){
        int ans = 0;
        while (i > 0){
            i /= 10;
            ans++;
        }
        return ans;
    }
}
