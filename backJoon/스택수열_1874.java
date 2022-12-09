package backJoon;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 실버 2
// 자료구조, 스택
public class 스택수열_1874 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int repeat = Integer.parseInt(br.readLine());
        int idx = 0;

        for(int i=0; i<repeat; i++){
            int num = Integer.parseInt(br.readLine());
            if(!stack.isEmpty() && stack.peek() == num){
                sb.append("-").append("\n");
                stack.pop();
                continue;
            }
            if(num >= idx){
                for(int j=idx; j<num; j++){
                    stack.push(j+1);
                    sb.append("+").append("\n");
                }
                idx = num;
                sb.append("-").append("\n");
                stack.pop();
                continue;
            }
            sb = new StringBuilder("NO");
            break;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
