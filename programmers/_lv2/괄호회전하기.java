package programmers._lv2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 괄호회전하기 {
    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
    }
    static Map<Character, Character> map;
    static Stack<Character> stack;
    static int result;
    static int solution(String s) {
        result = 0;
        map = new HashMap<>(Map.of('{','}','[',']','(',')'));
        StringBuilder sb = new StringBuilder(s);

        for(int i=0; i<s.length(); i++){
            if(isRight(sb.toString())) result++;
            sb = new StringBuilder(sb.subSequence(1,sb.length())).append(sb.charAt(0));
        }

        return result;
    }

    static boolean isRight(String s){
        stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            Character data = s.charAt(i);
            if(map.keySet().contains(data)){
                stack.add(data);
            }else{
                if(stack.isEmpty()) return false;
                Character prev = stack.pop();
                if(data != map.get(prev)){
                    return false;
                }
            }
        }

        if(stack.isEmpty()) return true;
        else return false;
    }
}
