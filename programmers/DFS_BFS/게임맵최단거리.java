package programmers.DFS_BFS;

import java.util.*;

//Lv 2
//
public class 게임맵최단거리 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));

    }

    static int solution(int[][] maps) {
        return bfs(maps);
    }

    static int bfs(int[][] maps){
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visit = new boolean[maps.length][maps[0].length];
        queue.add(new Node(0,0,1));
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if(node.row < 0 || node.row > maps.length-1 || node.col < 0 || node.col > maps[0].length-1) continue;
            if(maps[node.row][node.col] == 0 || visit[node.row][node.col] == true) continue;

            maps[node.row][node.col] = node.move;
            visit[node.row][node.col] = true;
            queue.add(new Node(node.row-1, node.col, node.move+1));
            queue.add(new Node(node.row+1, node.col, node.move+1));
            queue.add(new Node(node.row, node.col+1, node.move+1));
            queue.add(new Node(node.row, node.col-1, node.move+1));

            for(int i=0; i<maps.length; i++){
                System.out.println(Arrays.toString(maps[i]));
            }
            System.out.println();
        }

        if(maps[maps.length-1][maps[0].length-1] == 1) return -1;
        else return maps[maps.length-1][maps[0].length-1];
    }

    static class Node{
        int row;
        int col;
        int move;
        public Node(int row, int col, int move){
            this.row = row;
            this.col = col;
            this.move = move;
        }
    }
}
