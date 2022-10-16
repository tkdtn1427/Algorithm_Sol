package programmers._lv1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class check {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"},new int[]{5, 3, 2, 7, 5}));
    }

    public static String solution(String[] survey, int[] choices) {
        String[] char_ = new String[]{"R","T","C","F","J","M","A","N"};
        String list = String.join("",char_);
        int[][] count = new int[4][2];

        for(int i=0; i<survey.length; i++){
            String str = survey[i];
            int num = choices[i] - 4;
            int idx = list.indexOf(str.charAt(0));

            int M = idx / 2;
            int N = idx % 2;

            if(N != 0) num *= -1;

            if(num <= 0) count[M][0] += Math.abs(num);
            else count[M][1] += Math.abs(num);
        }

        for(int[] test : count)
            System.out.println(Arrays.toString(test));

        StringBuilder br = new StringBuilder("");
        for(int i=0; i<4; i++){
            String str = count[i][0] >= count[i][1] ? char_[i*2] : char_[i*2+1];
            br.append(str);
        }

        String answer = br.toString();
        return answer;
    }
}
