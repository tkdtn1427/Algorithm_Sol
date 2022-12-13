package backJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 실버3
public class _2xn타일링 {
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        if(n == 1 || n == 2){
            bw.write(String.valueOf(n));
        }else{
            for(int i=3; i<=n; i++){
                arr[i] = arr[i-1] + arr[i-2];
                arr[i] %= 10_007;
            }
            bw.write(String.valueOf(arr[n]));
        }
        bw.flush();
        bw.close();
    }
}
