package programmers._lv3;

import java.util.*;
import java.util.stream.Collectors;

public class 등산코드 {
    static int[] result;
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(7,new int[][]{{1,2,5},{1,4,1},
                {2,3,1},{2,6,7},{4,5,1},{5,6,1},{6,7,1}},new int[]{3,7},new int[]{1,5})));
    }

    static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        Queue<Node> nodes = new LinkedList<>();
        int[] result = new int[]{0, Integer.MAX_VALUE};
        List<Integer> starts = Arrays.stream(gates).boxed().collect(Collectors.toList());
        List<Integer> ends = Arrays.stream(summits).boxed().collect(Collectors.toList());
        int[] intensity = new int[n+1];
        Arrays.fill(intensity,Integer.MAX_VALUE);

        for(int gate : gates){
            Node node = new Node(gate,0);
            intensity[gate] = 0;
            nodes.add(node);
        }

        List<Node>[] map = new ArrayList[n+1];

        for(int i=0; i<=n; i++)
            map[i] = new ArrayList<>();

        for(int i=0; i< paths.length; i++){
            int s = paths[i][0];
            int e = paths[i][1];
            int d = paths[i][2];

            if(starts.contains(s) || ends.contains(e)){
                map[s].add(new Node(e,d));
            }else if(starts.contains(e) || ends.contains(s)){
                map[e].add(new Node(s,d));
            }else{
                map[e].add(new Node(s,d));
                map[s].add(new Node(e,d));
            }
        }

        while(!nodes.isEmpty()){
            Node now = nodes.poll();

            if(now.w > intensity[now.s]) continue;

            for(Node node : map[now.s]){
                int tmp = Math.max(node.w, intensity[now.s]);
                if(intensity[node.s] > tmp){
                    intensity[node.s] = tmp;
                    nodes.add(node);
                }
            }
        }

        Arrays.sort(summits);
        for(int end : summits){
            if(result[1] == intensity[end]){
                result[0] = Math.min(result[0],end);
            }else if(result[1] > intensity[end]){
                result[0] = end;
                result[1] = intensity[end];
            }
        }
        return result;
    }

    static class Node{
        int s;
        int w;
        public Node(int s,int w){
            this.s = s;
            this.w = w;
        }
    }
}
