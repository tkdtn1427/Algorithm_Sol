package programmers._lv2;

import java.util.*;
import java.util.stream.Collectors;

public class 두큐합 {
    public static void main(String[] args) {
        int sol = solution(new int[]{1,1},new int[]{1,5});
        System.out.println(sol);
    }

    static int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();

        if((sum1+sum2) % 2 != 0) return -1;
        if(sum1 == sum2) return 0;

        Queue<Long> q1 = new LinkedList<>(Arrays.stream(queue1).mapToLong(Long::valueOf).boxed().collect(Collectors.toList()));
        Queue<Long> q2 = new LinkedList<>(Arrays.stream(queue2).mapToLong(Long::valueOf).boxed().collect(Collectors.toList()));

        int idx = 0;
        while (idx < (queue1.length + queue2.length)*3 && (q1.size() != 0 || q2.size() != 0)){
            if(sum1 > sum2){
                long num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.add(num);
            }else{
                long num = q2.poll();
                sum2 -= num;
                sum1 += num;
                q1.add(num);
            }
            idx++;
            if(sum1 == sum2){
                return idx;
            }
        }
        return -1;
    }
}
