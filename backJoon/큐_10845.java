package backJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 실버 4
// 자료구조, 큐
public class 큐_10845 {
    static int[] queue;
    static int front;
    static int back;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        queue = new int[15];
        front = 0;
        back = 0;

        int repeat = Integer.parseInt(br.readLine());

        for(int i=0; i<repeat; i++){
            String[] str = br.readLine().split(" ");
            if(str[0].equals("push")){
                queue[back++] = Integer.valueOf(str[1]);
            }else if(str[0].equals("pop")){
                if(front >= back) sb.append("-1").append("\n");
                else sb.append(queue[front++]).append("\n");
            }else if(str[0].equals("size")){
                sb.append(back-front).append("\n");
            }else if(str[0].equals("empty")){
                if(back-front == 0) sb.append("1").append("\n");
                else sb.append("0").append("\n");
            }else if(str[0].equals("front")){
                if(back == front) sb.append("-1").append("\n");
                else sb.append(queue[front]).append("\n");
            }else{
                if(back == front) sb.append("-1").append("\n");
                else sb.append(queue[back-1]).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
