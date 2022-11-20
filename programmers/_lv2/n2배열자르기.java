package programmers._lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class n2배열자르기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4,14,15)));
    }

    static List<Integer> list;
    static int[] solution(int n, long left, long right) {
        list = new ArrayList<>();
        int rowL = (int)(left / (long)n);
        int colL = (int)(left % (long)n);

        int rowR = (int)(right / (long)n);
        int colR = (int)(right % (long)n);

        if(rowL == rowR){
            for(int i=colL; i<=colR; i++) list.add(Math.max(rowL,i));
        }else{
            for(int i=rowL; i<=rowR; i++){
                if(i == rowL){
                    for(int j=colL; j<n; j++){
                        list.add(Math.max(i,j));
                    }
                }else if(i == rowR){
                    for(int j=0; j<=colR; j++){
                        list.add(Math.max(i,j));
                    }
                }else{
                    for(int j=0; j<n; j++){
                        list.add(Math.max(i,j));
                    }
                }
            }
        }
        return list.stream().map(x -> x += 1).mapToInt(Integer::intValue).toArray();
    }
}

/*

123 223 333

3223

 */