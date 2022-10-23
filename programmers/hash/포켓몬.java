package programmers.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class 포켓몬 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,3,3,2,2,4}));
    }

    static int solution(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int choice = nums.length / 2;
        return Math.min(choice, set.size());
    }
}