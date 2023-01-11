package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 한줄로서기_1138 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());

        int[] array = new int[number+1];
        Arrays.fill(array, 0);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=number; i++){
            int jump = Integer.parseInt(st.nextToken());
            int index = 0;

            while (!(array[index] == 0 && jump == 0)){
                if(array[index] == 0)
                    jump--;
                index++;
            }


            array[index] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<array.length-1; i++)
            sb.append(array[i]).append(" ");

        System.out.println(sb.toString());
    }
}
