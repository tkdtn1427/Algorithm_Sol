package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 실버3
// 그리디
public class 주유소_13305 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int repeat = Integer.parseInt(br.readLine());

        long[] roads = new long[repeat-1];
        long[] weight = new long[repeat];

        long total = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<repeat-1; i++){
            roads[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<repeat; i++){
            weight[i] = Integer.parseInt(st.nextToken());
        }

        long min = weight[0];
        for(int i=0; i<repeat-1; i++){
            min = Math.min(weight[i], min);
            total += min*roads[i];
        }

        System.out.println(total);
    }
}
