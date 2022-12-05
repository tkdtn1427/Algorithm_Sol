package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 실버 4
public class 동전0_11047 {
    static int[] wallet;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int total = 0;
        int type = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        wallet = new int[type];

        for(int i=0; i<type; i++){
            wallet[i] = Integer.parseInt(br.readLine());
        }

        for(int i=wallet.length-1; i>=0 ;i--){
            if(target == 0) break;
            int count = target / wallet[i];
            target -= wallet[i]*count;
            total += count;
        }

        System.out.println(total);
    }
}
