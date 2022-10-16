package programmers.stackQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 같은숫자 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,1,3,3,0,1,1})));
    }

    static int[] solution(int []arr) {
        List<Integer> tmpList = new ArrayList<>();
        int prev = -1;
        for(int tmp : arr){
            if(tmp != prev){
                prev = tmp;
                tmpList.add(tmp);
            }
        }

        return tmpList.stream().mapToInt(Integer::valueOf).toArray();
    }
}
