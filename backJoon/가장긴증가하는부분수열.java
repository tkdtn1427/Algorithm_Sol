package backJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 실버2
//
public class 가장긴증가하는부분수열 {
    static int[][] count;
    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int repeat = Integer.parseInt(br.readLine());
//        int result = 0;
//        String str = br.readLine();
//        StringTokenizer st = new StringTokenizer(str, " ");
//        count = new int[repeat][2];
//
//        for(int i=0; i<repeat; i++) {
//            int num = Integer.parseInt(st.nextToken());
//            count[i][0] = num;
//            int max = 0;
//            for(int j=0; j<i; j++){
//                if(count[j][0] < num && count[j][1] > max){
//                    max = count[j][1];
//                }
//            }
//            count[i][1] = max+1;
//            if(result < count[i][1]){
//                result = count[i][1];
//            }
//            for(int[] tmp : count){
//                System.out.println(Arrays.toString(tmp));
//            }
//            System.out.println();
//        }
//
//        bw.write(String.valueOf(result));
//        bw.flush();
//        bw.close();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(0);
        for (int i = 0 ; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if (num>dp.get(dp.size()-1)){
                dp.add(num);
            }else{
                int idx = Collections.binarySearch(dp,num);
                System.out.println(idx);
                if (idx<0){
                    idx = -(idx+1);
                    System.out.println();
                    System.out.println(idx);
                }
                dp.set(idx,num);
            }
            System.out.println(dp);
        }
        System.out.println(dp.size()-1);
    }
}