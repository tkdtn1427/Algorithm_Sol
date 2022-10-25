package backJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// 실버 3
public class 바이러스 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = 0;

        int computer = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=1; i<=computer; i++){
            map.put(i, new ArrayList<>());
        }

        boolean[] check = new boolean[map.size()+1];

        int repeat = Integer.parseInt(br.readLine());
        for(int i=0; i<repeat; i++){
            String[] arr = br.readLine().split(" ");
            int prev = Integer.parseInt(arr[0]);
            int next = Integer.parseInt(arr[1]);
            map.get(prev).add(next);
            map.get(next).add(prev);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        check[1] = true;

        while (!queue.isEmpty()){
            List<Integer> list = map.get(queue.poll());
            for(int i=0; i<list.size(); i++){
                if(check[list.get(i)] == false){
                    queue.add(list.get(i));
                    check[list.get(i)] = true;
                    total++;
                }
            }
        }

        bw.write(String.valueOf(total));
        bw.flush();
        bw.close();
    }
}
