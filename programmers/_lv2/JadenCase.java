package programmers._lv2;

import java.util.StringTokenizer;

public class JadenCase {
    public static void main(String[] args) {
        System.out.println(solution(" adgagd 3eagdag "));
    }

    static String solution(String s) {
        String[] arr = s.split("");
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<arr.length; i++){
            if(arr[i].equals(" ")){
                sb.append(arr[i]);
            }else if(i !=0 && !arr[i-1].equals(" ")){
                sb.append(arr[i].toLowerCase());
            }else{
                sb.append(arr[i].toUpperCase());
            }
        }
        return sb.toString();
    }
}
