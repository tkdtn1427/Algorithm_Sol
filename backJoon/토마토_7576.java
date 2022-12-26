package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

// 골드 5
public class 토마토_7576 {
    static int[][] dp;
    static Queue<Node> queue;
    static boolean[][] check;
    static int result ;
    static int good;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        queue = new LinkedList<>();
        dp = new int[row][col];
        check = new boolean[row][col];
        result = 0;
        good = 0;
        int tomato = 0;

        for(int i=0; i<row; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<col; j++){
                int num = Integer.parseInt(st.nextToken());
                dp[i][j] = num;
                if(num == 1){
                    check[i][j] = true;
                    queue.add(new Node(i,j));
                }
                if(num != -1) tomato++;
            }
        }

        bfs(row,col);
        if(tomato == good) System.out.println(result-1);
        else System.out.println(-1);
    }

    static void bfs(int rowlen, int collen){
        List<int[]> move = new ArrayList<>(List.of(
                new int[]{1,0},new int[]{-1,0},
                new int[]{0,1},new int[]{0,-1}
        ));
        while (!queue.isEmpty()){
            List<Node> list = new ArrayList<>();
            int len = queue.size();
            for(int i=0; i<len; i++){
                Node node = queue.poll();
                if(dp[node.row][node.col] == 1){
                    good++;
                    for(int[] tmp : move){
                        int x = node.row + tmp[0];
                        int y = node.col + tmp[1];
                        if(x < 0 || y < 0 || x >= rowlen || y >= collen) continue;
                        if(dp[x][y] == 1 || dp[x][y] == -1 || check[x][y] == true) continue;
                        list.add(new Node(x,y));
                        dp[x][y] += 1;
                        check[x][y] = true;
                    }
                }else{
                    dp[node.row][node.col] += 1;
                    list.add(node);
                }
            }
            queue.addAll(list);
            result++;
        }
    }

    static class Node{
        int row;
        int col;
        public Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}
