package programmers._lv2;

import java.util.*;

public class 뉴스클러스터링 {
    public static void main(String[] args) {
        System.out.println(solution("E=M*C^2","e=m*c^2"));
    }
    static List<String> left;
    static List<String> right;
    static List<String> union;
    static int solution(String str1, String str2) {
        left = new ArrayList<>();
        right = new ArrayList<>();
        union = new ArrayList<>();

        makeSubString(left,str1);
        makeSubString(right,str2);

        int size = left.size();

        for(int i=0; i<size; i++){
            String str = left.remove(0);
            if(right.indexOf(str) != -1){
                union.add(str);
                right.remove(str);
            }else{
                left.add(str);
            }
        }

        double G = union.size();
        double H = G + left.size() + right.size();

        if(G == 0 && H == 0){
            return 65536;
        }

        double result = G / H * 65536;

        return (int)result;
    }

    static void makeSubString(List<String> list , String str){
        str = str.toUpperCase();
        for(int i=0; i<str.length()-1; i++){
            if(str.charAt(i) >= 'A' && str.charAt(i) <='Z' && str.charAt(i+1) >= 'A' && str.charAt(i+1) <= 'Z'){
                list.add(str.substring(i,i+2));
            }
        }
    }
}
