package programmers.heap;


import java.util.PriorityQueue;

//Lv. 2
public class 더맵게 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{9, 3, 1, 2, 10, 12},7));
    }

    static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int time = 0;
        for(Integer unit : scoville)
            heap.offer(unit);

        while (true){
            if(heap.peek() >= K) break;
            if(heap.isEmpty() || heap.size() == 1){
                time = -1;
                break;
            }
            int prev = heap.poll();
            int next = heap.poll();
            int sum = prev + next*2;
            heap.offer(sum);
            time += 1;
        }
        return time;
    }
}