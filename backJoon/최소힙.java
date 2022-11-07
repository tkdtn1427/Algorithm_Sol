package backJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

//실버 2
public class 최소힙 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int repeat = Integer.parseInt(br.readLine());
        for(int i=0; i<repeat; i++){
            String input = br.readLine();
            if(input.equals("0")){
                if(queue.isEmpty()) bw.write("0\n");
                else{
                    Integer tmp = queue.poll();
                    bw.write(tmp+"\n");
                }
            }else{
                queue.add(Integer.parseInt(input));
            }
        }
        bw.flush();
        bw.close();
    }
}
