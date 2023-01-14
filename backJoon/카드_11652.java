package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 실버 4
// 자료구조, 정렬, 해시, 집합 맵
public class 카드_11652 {
    static TreeMap<Long, Integer> map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new TreeMap<>();
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            long card = Integer.parseInt(br.readLine());
            int count = map.getOrDefault(card, 0)+1;
            map.put(card, count);
            if(count > max){
                max = count;
            }
        }

        for(long key : map.keySet()){
            if(map.get(key) == max){
                System.out.println(key);
                break;
            }
        }
    }
}
