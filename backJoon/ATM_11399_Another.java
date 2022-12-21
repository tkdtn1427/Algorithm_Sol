package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ATM_11399_Another {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int result = 0 ;

        int repeat = Integer.parseInt(br.readLine());
        int wait = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<repeat; i++){
            addData(Integer.parseInt(st.nextToken()),list);
        }

        for(int i=0; i<list.size(); i++){
            int data = list.get(i);
            result += wait + data;
            wait += data;
        }

        System.out.println(result);
    }

    static void addData(int data, List<Integer> list){
        int left = 0;
        int right = list.size()-1;
        int mid;

        while (left <= right){
            mid = (left + right) /2;

            if(list.get(mid) < data){
                left = mid +1;
            }else{
                right = mid-1;
            }
        }
        list.add(left, data);
    }
}
