package programmers.sorting;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//Lv. 2
public class HIndex {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 2, 2, 2, 2}));
    }

    static int solution(int[] citations) {
        Arrays.sort(citations);
        int[] arr = new int[citations.length+1];
        System.out.println(Arrays.toString(citations));

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<citations.length; j++){
                if(citations[j] >= i){
                    arr[i] = citations.length - j;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

        for(int i=0; i<arr.length; i++){
            if(arr[i] < i){
                return i-1;
            }
        }

        return arr.length-1;
    }
}
