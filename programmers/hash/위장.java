package programmers.hash;

import java.util.*;

public class 위장 {
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}}));
    }

    static int solution(String[][] clothes) {
        Map<String, Set<String>> map = new HashMap<>();
        int result =1;
        for(int i=0; i<clothes.length; i++){
            if(!map.containsKey(clothes[i][1])){
                map.put(clothes[i][1], new HashSet<>(List.of(clothes[i][0])));
            }else{
                map.get(clothes[i][1]).add(clothes[i][0]);
            }
        }

        for(String str : map.keySet()){
            result *= map.get(str).size()+1;
        }

        return result-1;
    }
}
