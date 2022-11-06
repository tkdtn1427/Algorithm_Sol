package programmers.sorting;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//Lv. 2
public class 가장큰수 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{12, 1213}));
    }

    static String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        Numbers[] arr = Arrays.stream(numbers).mapToObj(x -> {
            Numbers tmp = new Numbers(String.valueOf(x));
            return tmp;
        }).toArray(Numbers[]::new);

        for(int i=0; i<arr.length; i++){
            int len = 4 - arr[i].origin.length();
            String lastStr = arr[i].origin.charAt(arr[i].origin.length() - 1) + "";
            arr[i].fourStr = (arr[i].origin + arr[i].origin.repeat(3)).substring(0,4);
                            }

        Arrays.sort(arr, Numbers::compareTo);
        for(Numbers tmp : arr){
            sb.append(tmp.origin);
        }

        if(arr[0].origin.equals("0")) return "0";

        return sb.toString();
    }

    static class Numbers implements Comparable<Numbers> {
        String origin ;
        String fourStr;

        public Numbers(String origin) {
            this.origin = origin;
        }

        @Override
        public int compareTo(Numbers o) {
            return o.fourStr.compareTo(fourStr);
        }
    }
}