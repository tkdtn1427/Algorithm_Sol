package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 골드2
public class 가장긴증가부분수열2_12015 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        list.add(0);
        result.add(0);
        int repeat = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<repeat; i++){
            int data = Integer.parseInt(st.nextToken());
            addData(data, list);
            result.add(data);
        }
        System.out.println(list.size()-1);
    }

    static void addData(int data, List<Integer> list){
        if(data > list.get(list.size()-1)){
            list.add(data);
            return;
        }

        int left = 0;
        int right = list.size();
        int mid;

        while (left <= right){
            mid = (left + right) /2;

            if(list.get(mid) < data){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        list.set(left, data);
    }
}
