package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 실버2
public class 알고리즘_깊이우선1_24479 {
    static Map<Integer, List<Integer>> map;
    static boolean[] flag;
    static int[] result;
    static int cnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        result = new int[N+1];
        flag = new boolean[N+1];
        cnt = 1;
        int edge1;
        int edge2;

        int start = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            map.put(i+1, new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            edge1 = Integer.parseInt(st.nextToken());
            edge2 = Integer.parseInt(st.nextToken());

            map.get(edge1).add(edge2);
            map.get(edge2).add(edge1);
        }

        for(int key : map.keySet())
            Collections.sort(map.get(key));

        dfs(start);

        for(int i=1; i<=N; i++){
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb.replace(sb.length()-1, sb.length(), "").toString());
    }

    static void dfs(int edge){
        flag[edge] = true;
        result[edge] = cnt++;
        List<Integer> list = map.get(edge);
        for(int e : list){
            if(!flag[e]){
                dfs(e);
            }
        }
    }
}
