package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 실버 2
public class DFS와BFS_1260 {
    static Map<Integer, List<Integer>> map;
    static List<Integer> bfs;
    static List<Integer> dfs;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new HashMap<>();
        bfs = new ArrayList<>();
        dfs = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++){
            map.put(i,new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            map.get(left).add(right);
            map.get(right).add(left);
        }

        for(Integer key : map.keySet()){
            Collections.sort(map.get(key));
        }

        bfs(V);
        dfs(V);

        StringBuilder sb = new StringBuilder();
        for(Integer data : dfs){
            sb.append(data).append(" ");
        }
        System.out.println(sb.replace(sb.length()-1,sb.length(),"").toString());

        sb = new StringBuilder();
        for(Integer data : bfs) {
            sb.append(data).append(" ");
        }
        System.out.println(sb.replace(sb.length()-1,sb.length(),"").toString());
    }

    static void bfs(int V){
        Queue<Integer> queue = new LinkedList<>();
        bfs.add(V);
        queue.add(V);
        while (!queue.isEmpty()){
            int v = queue.poll();
            for(Integer num : map.get(v)){
                if(bfs.contains(num)) continue;
                queue.add(num);
                bfs.add(num);
            }
        }
    }

    static void dfs(int V){
        dfs.add(V);
        for(Integer num : map.get(V)){
            if(dfs.contains(num)) continue;
            dfs(num);
        }
    }
}

/*
1. DFS / BFS 탐색 결과를 출력
2. 정점 번호가 작은거 먼저 방문
*/