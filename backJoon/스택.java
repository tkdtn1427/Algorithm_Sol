package backJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 실버 4
public class 스택 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<String> stack = new Stack<>();

        int repeat = Integer.parseInt(br.readLine());
        for(int i=0; i<repeat; i++){
            String[] inputs = br.readLine().split(" ");
            if(inputs[0].equals("push")){
                stack.add(inputs[1]);
                continue;
            }
            if(inputs[0].equals("pop")){
                if(stack.isEmpty()) bw.write(-1+"\n");
                else bw.write(stack.pop()+"\n");
                continue;
            }
            if(inputs[0].equals("size")){
                bw.write(stack.size()+"\n");
                continue;
            }
            if(inputs[0].equals("empty")){
                if(stack.empty()) bw.write(1 + "\n");
                else bw.write(0 + "\n");
                continue;
            }

            if(inputs[0].equals("top")){
                if(stack.isEmpty()) bw.write(-1+"\n");
                else bw.write(stack.peek()+"\n");
                continue;
            }
        }
        bw.flush();
        bw.close();
    }
}
