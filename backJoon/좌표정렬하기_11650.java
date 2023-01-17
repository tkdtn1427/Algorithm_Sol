package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

// 실버 5
// 정렬
// Map을 사용해서 느림 -> 배열 이용
public class 좌표정렬하기_11650 {
    static TreeMap<Integer, PriorityQueue<Integer>> map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new TreeMap<>();

        int repeat = Integer.parseInt(br.readLine());

        for(int i=0; i<repeat; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            if(!map.containsKey(left)) map.put(left, new PriorityQueue<>()); // --> 이 부분에서 가장 시간 많이 소요 예상

            map.get(left).add(right);
        }

        for(Integer key : map.keySet()){
            PriorityQueue<Integer> tmp = map.get(key);
            int len = tmp.size();
            for(int i=0; i<len; i++){
                System.out.println(key + " " + tmp.poll());
            }
        }
    }
}


/*

1. 2차원 배열 점 N 개

 */