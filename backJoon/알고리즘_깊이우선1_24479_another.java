package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 실버2
public class 알고리즘_깊이우선1_24479_another {
    static List<Integer>[] map;
    static boolean[] flag;
    static int[] result;
    static int cnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new ArrayList[N+1];
        result = new int[N+1];
        flag = new boolean[N+1];
        cnt = 1;
        int edge1;
        int edge2;

        int start = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            map[i+1] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            edge1 = Integer.parseInt(st.nextToken());
            edge2 = Integer.parseInt(st.nextToken());

            map[edge1].add(edge2);
            map[edge2].add(edge1);
        }

        for(int i=1; i<=N; i++){
            Collections.sort(map[i]);
        }

        dfs(start);

        for(int i=1; i<=N; i++){
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb.replace(sb.length()-1, sb.length(), "").toString());
    }

    static void dfs(int edge){
        flag[edge] = true;
        result[edge] = cnt++;
        List<Integer> list = map[edge];
        for(int e : list){
            if(!flag[e]){
                dfs(e);
            }
        }
    }
}
