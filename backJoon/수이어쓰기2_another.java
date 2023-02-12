package backJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 실버1
public class 수이어쓰기2_another {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int total = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int target_s = target;
        int res = 0;
        int len = 1;
        int numCnt = 9;

        while (target_s >= numCnt * len){
            target_s -= numCnt*len;
            res += numCnt;
            numCnt *= 10;
            len++;
        }

//        System.out.println(res);
//        System.out.println(target_s);

        res = res+1 + (target_s-1)/len;
        // res를 다음수의 첫번쨰 자리에 맞추고, 이동가능한 수만큼 증가

        if(res > total)
            bw.write(String.valueOf(-1));
        else{
            // 만약 이동하고 뒤에 남은 수가 있으면 해당 수인덱스 타겟
            int idx = (int)((target_s-1)%len);
            bw.write(String.valueOf(res).charAt(idx));
        }

        bw.flush();
        bw.close();
    }
}
