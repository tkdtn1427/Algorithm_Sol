package programmers.brute_force;

import java.util.*;

// Lv. 2
public class 모음사전 {
    public static void main(String[] args) {
        System.out.println(solution("EIO"));
    }

    static int solution(String word) {
        int index = 0;
        List<String> tmp = new ArrayList<>(List.of("A","E","I","O","U"));

        StringBuilder sb = new StringBuilder();
        while (!sb.toString().equals(word)){
            if(sb.length() < 5){
                sb.append("A");
            }else{
                setString(sb, tmp);
            }
            index++;
        }

        return index;
    }

    static void setString(StringBuilder sb, List<String> tmp){
        int index = sb.length()-1;
        if(String.valueOf(sb.charAt(index)).equals("U")){
            sb.replace(index,index+1,"");
            setString(sb, tmp);
        }else{
            String str = String.valueOf(sb.charAt(index));
            int next = tmp.indexOf(str)+1;
            sb.replace(index,index+1,tmp.get(next));
        }
    }
}
