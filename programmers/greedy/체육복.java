package programmers.greedy;

import java.util.Arrays;

public class 체육복 {
    public static void main(String[] args) {
        System.out.println(solution(3,new int[]{3},new int[]{1}));
    }

    static int solution(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n+1];
        Arrays.fill(arr,1);
        int result = 0;
        for(int val : reserve) arr[val] += 1;
        for(int los : lost) arr[los] -= 1;
        System.out.println(Arrays.toString(arr));
        int empty = -1;
        int value = -1;

        for(int i=1; i<arr.length; i++){
            if(arr[i] == 0){
                if(value == 1) {
                    result += 1;
                    empty = -1;
                }else{
                    empty = 1;
                }
                value = -1;
            }else if(arr[i] == 1){
                result += 1;
                empty = -1;
                value = -1;
            }else{
                if(empty == 1){
                    result += 2;
                    value = -1;
                }else{
                    value = 1;
                    result += 1;
                }
                empty = -1;
            }
        }

        return result;
    }
}
