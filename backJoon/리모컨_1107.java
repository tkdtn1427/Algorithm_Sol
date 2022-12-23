package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 골드5
public class 리모컨_1107 {
    static List<Integer> ban;
    static int result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ban = new ArrayList<>();
        String target = br.readLine();
        String close = "";
        result = Math.abs(100 - Integer.parseInt(target));
        int repeat = Integer.parseInt(br.readLine());

        if(repeat != 0 ){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<repeat; i++){
                ban.add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i=0; i<1_000_000; i++){
            String str = String.valueOf(i);
            boolean flag = false;
            for(int j=0; j<str.length(); j++){
                if(ban.contains(str.charAt(j)-'0')){
                    flag = true;
                    break;
                }
            }
            if(flag) continue;
            result = Math.min(result, Math.abs(Integer.parseInt(str) - Integer.parseInt(target)) + str.length());
        }

        System.out.println(result);
    }
}
