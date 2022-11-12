package backJoon;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 실버3
// DO : 케이스 별로 다 구함
// Sol : 구현, 그리디, 많은 조건분기
public class 병든나이트 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int move;

        if(row == 1){
           move = 1;
        }else if(row == 2){
            move = Math.min(4, (col+1)/2);
        }else if(col < 7){
            move = Math.min(4, col);
        }else {
            move = col - 2;
        }
        bw.write(String.valueOf(move));
        bw.flush();
        bw.close();
    }
}
