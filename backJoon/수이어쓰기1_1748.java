package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 수이어쓰기1_1748 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        String data = br.readLine();
        int len = data.length();

        for(int i=1; i<len; i++){
            result += 9*Math.pow(10,i-1)*i;
        }

        int number = Integer.parseInt(data);
        result += (number - 1*Math.pow(10,len-1) +1) * len;

        System.out.println(result);
    }
}
