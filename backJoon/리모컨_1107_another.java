package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 골드5
// 완전탐색
// ReSolve
public class 리모컨_1107_another {
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

        int i=0;
        int numCnt = 500_000;
        while (result > i){
            int t1 = Integer.parseInt(target) - i;
            int t2 = Integer.parseInt(target) + i;
            if(t1 >= 0 && available(String.valueOf(t1))){
                numCnt = count(t1);
                break;
            }else if(t2 <= 999_999 && available(String.valueOf(t2))){
                numCnt = count(t2);
                break;
            }
            i++;
        }

        System.out.println(Math.min(result, i+numCnt));
    }

    static boolean available(String data){
        for(int i=0; i<data.length(); i++){
            if(ban.contains(data.charAt(i)-'0'))
                return false;
        }
        return true;
    }

    static int count(int data){
        return String.valueOf(data).length();
    }
}
