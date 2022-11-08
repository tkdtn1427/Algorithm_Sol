package backJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// 실버 1
// 다시풀이
// DP, (BFS 풀이법)
public class 카드구매하기 {
    static int[] cards;
    static int[] MaxPrice;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        cards = new int[repeat+1];
        MaxPrice = new int[repeat+1];
        Arrays.fill(MaxPrice,0);

        for(int i=1; i<=repeat; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(bfs(repeat)));
        bw.flush();
        bw.close();
    }

    static int bfs(int repeat){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0));
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (MaxPrice[node.count] > node.price){
                continue;
            }
            for(int i=1; i<=repeat; i++){
                if(node.count + i <= repeat && MaxPrice[node.count + i] < node.price + cards[i]){
                    MaxPrice[node.count +i] = node.price + cards[i];
                    queue.add(new Node(node.count +i,node.price+cards[i]));
                }
            }
        }
        return MaxPrice[repeat];
    }

    static class Node{
        int count;
        int price;
        public Node(int count, int price){
            this.count = count;
            this.price = price;
        }
    }
}