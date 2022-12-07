package backJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// 실버 4
public class 괄호 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int repeat = Integer.parseInt(br.readLine());
        for(int i=0; i<repeat; i++){
            String str = checkVPS(br.readLine());
            sb.append(str+"\n");
        }
        bw.write(sb.substring(0,sb.length()-1));
        bw.flush();
        bw.close();
    }

    static String checkVPS(String str){
        List<Character> stack = new ArrayList<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                stack.add(str.charAt(i));
            }else{
                if(stack.isEmpty()) return "NO";
                stack.remove(0);
            }
        }
        if(!stack.isEmpty()) return "NO";
        return "YES";
    }
}
