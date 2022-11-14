package programmers.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

//Lv. 2
public class 네트워크 {
    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0},{1, 1, 0},{0, 0, 1}}));
    }

    static int solution(int n, int[][] computers) {
        boolean[] check = new boolean[n];
        int network = 0;
        for(int i=0; i<computers.length; i++){
            if(check[i] == true) continue;
            check[i] = true;
            bfs(i,computers,check);
            network++;
        }

        return network;
    }

    static void bfs(int start, int[][] computers, boolean[] check){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()){
            Integer node = queue.poll();
            for(int i=0; i<computers.length; i++){
                if(i == node || check[i] == true || computers[node][i] == 0) continue;
                check[i] = true;
                queue.add(i);
            }
        }
    }
}
