package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 실버 4
// 그리디, 정렬

public class ATM_11399{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int result = 0 ;

        int repeat = Integer.parseInt(br.readLine());
        int wait = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<repeat; i++){
            queue.add(Integer.parseInt(st.nextToken()));
        }

        while (!queue.isEmpty()){
            int data = queue.poll();
            result += wait + data;
            wait += data;
        }

        System.out.println(result);
    }
}

/*
1. 줄서기
2. 기다리는 사람 최소로
3. ** 기다리는 시간의 합을 최소로 구하는 프로그램 **
*/