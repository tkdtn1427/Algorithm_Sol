package programmers.sorting;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class K번째수 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 5, 2, 6, 3, 7, 4},new int[][]{{2, 5, 3},{4, 4, 1},{1, 7, 3}})));
    }

    static int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        int idx =0;
        for(int[] arr : commands){
            int[] tmp = Arrays.copyOfRange(array,arr[0]-1,arr[1]);
            Arrays.sort(tmp);
            result[idx++] = tmp[arr[2]-1];
        }
        return result;
    }
}
