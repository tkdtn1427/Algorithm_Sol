package backJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//실버 2
public class 최대힙 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int repeat = Integer.parseInt(br.readLine());
//        Heap heap = new Heap(repeat);
//
//        for(int i=0; i<repeat; i++){
//            String str = br.readLine();
//            if(str.equals("0")){
//                sb.append(heap.poll()).append("\n");
//            }else{
//                heap.push(Integer.parseInt(str));
//            }
//        }


        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for(int i=0; i<repeat; i++){
            String str = br.readLine();
            if(str.equals("0")){
                if(queue.isEmpty()) sb.append("0").append("\n");
                else sb.append(queue.poll()).append("\n");
            }else{
                queue.add(Integer.parseInt(str));
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

class Heap{
    int[] heap;
    int index;
    public Heap(int len){
        heap = new int[len+1];
        index = 0;
    }

    public void push(int data){
        if(index >= heap.length) return ;
        int i = ++index;
        while ( i /2 >= 1 && heap[i/2] < data){
            heap[i] = heap[i/2];
            i /= 2;
        }
        heap[i] = data;
    }

    public int poll(){
        if(index == 0) return 0;
        int data = heap[1];

        heap[1] = heap[index--];
        int i = 1;
        while (true){
            if(i*2+1 <= index && (heap[i*2] >= heap[i] || heap[i*2+1] >= heap[i])){
                int up = heap[i*2] > heap[i*2+1] ? i*2 : i*2+1;
                int prev = heap[i];
                heap[i] = heap[up];
                heap[up] = prev;
                i = up;
                continue;
            }else if(i*2 <= index && heap[i*2] >= heap[i]){
                int prev = heap[i];
                heap[i] = heap[i*2];
                heap[i*2] = prev;
                i = i*2;
                continue;
            }
            break;
        }

        return data;
    }

}