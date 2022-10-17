package programmers.stackQueue;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Lv. 2
public class 기능개발 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{93, 30, 55},new int[]{1, 30, 5})));
    }

    static int[] solution(int[] progresses, int[] speeds) {
        int[] day = new int[progresses.length];
        for(int i=0; i<progresses.length; i++){
            day[i] = (int)Math.ceil((double) (100 - progresses[i]) / (double) speeds[i]);
        }
        List<Integer> days = new ArrayList<>();
        int prev = day[0];
        int count =0;
        for(int i=0; i<day.length; i++){
            if(day[i] <= prev){
                count += 1;
            }else{
                days.add(count);
                prev = day[i];
                count = 1;
            }
        }
        days.add(count);

        return days.stream().mapToInt(Integer::valueOf).toArray();
    }
}
