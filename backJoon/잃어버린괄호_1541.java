package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 실버 2
public class 잃어버린괄호_1541 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int idx = str.indexOf('-');

        int result = 0;

        if(idx == -1){
            StringTokenizer st = new StringTokenizer(str, "+");
            while (st.hasMoreTokens()){
                result += Integer.parseInt(st.nextToken());
            }
        }else{
            String plus = str.substring(0,idx);
            String minus = str.substring(idx+1);

            StringTokenizer st = new StringTokenizer(plus, "+");
            while (st.hasMoreTokens()){
                result += Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(minus, "-|+");
            while (st.hasMoreTokens()){
                result -= Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(result);
    }
}