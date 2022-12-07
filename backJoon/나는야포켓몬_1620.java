package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

// 실버 4
// 해시를 사용한 집합과 맵
public class 나는야포켓몬_1620 {
    static Map<String, Integer> map;
    static Map<Integer, String> map2;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        map2 = new HashMap<>();

        for(int i=1; i<=N; i++){
            String tmp = br.readLine();
            map.put(tmp, i);
            map2.put(i, tmp);
        }

        for(int i=0; i<M; i++){
            String str = br.readLine();
            if(map.keySet().contains(str)){
                sb.append(map.get(str)).append("\n");
            }else{
                sb.append(map2.get(Integer.parseInt(str))).append("\n");
            }
        }

        System.out.println(sb.toString());


    }
}
