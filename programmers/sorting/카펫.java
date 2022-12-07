package programmers.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Lv. 2
public class 카펫 {
    public static void main(String[] args) {
        System.out.println(solution(24,24));
    }

    static int[] solution(int brown, int yellow) {
        List<int[]> list = new ArrayList<>();
        for(int row=1; row<=yellow; row++){
            if(yellow % row == 0){
                int col = yellow / row;
                if((col *2 + row *2 + 4) == brown){
                    return new int[]{col+2, row+2};
                }
            }
        }
        return null;
    }
}
