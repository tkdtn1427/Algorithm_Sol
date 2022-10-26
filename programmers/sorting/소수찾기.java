package programmers.sorting;

import java.util.*;

//Lv. 2
public class 소수찾기 {
    public static void main(String[] args) {
        System.out.println(solution("9999"));
    }

    static Set<Integer> set;
    static int solution(String numbers) {
        set = new HashSet<>();
        String[] arr = numbers.split("");
        Arrays.sort(arr);
        boolean[] check = new boolean[arr.length];
        for(int i=0; i<arr.length; i++){
            dfs(new StringBuilder(""), arr, check, i+1);
        }
        System.out.println(set);
        return set.size();
    }

    static void dfs(StringBuilder sb, String[] arr, boolean[] check, int len){
        if(sb.length() == len){
            if(isPrime(Integer.parseInt(sb.toString()))){
                set.add(Integer.parseInt(sb.toString()));
                return;
            }
        }else{
            for(int i=0; i<arr.length; i++){
                if(check[i] == false){
                    sb.append(arr[i]);
                    check[i] = true;
                    dfs(sb,arr,check,len);
                    sb.replace(sb.length()-1,sb.length(),"");
                    check[i] = false;
                }
            }
        }
    }

    static boolean isPrime(Integer num){
        if(num == 1 || num == 0) return false;
        for(int i=2; i<=(int)Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }

}
