package programmers.stackQueue;

import java.util.*;

//Lv. 2
public class 다리를지나는트럭 {
    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
    }
    static int solution(int bridge_length, int weight, int[] truck_weights) {
        int arrived = 0;
        int time = 0;
        int index = 0;
        List<Integer> passed = new ArrayList<>();
        Integer[] location = new Integer[truck_weights.length];
        Arrays.fill(location, bridge_length);
        while (arrived != truck_weights.length){
            for(Integer tmp : passed){
                location[tmp] -= 1;
            }

            if(passed.size() != 0 && location[passed.get(0)] == 0){
                weight += truck_weights[passed.get(0)];
                passed.remove(0);
                arrived += 1;
            }

            if(index != truck_weights.length && weight - truck_weights[index] >= 0){
                weight -= truck_weights[index];
                passed.add(index);
                index += 1;
            }
            time += 1;
        }
        return time;

//        Stack<Integer> truckStack = new Stack<>();
//        Map<Integer, Integer> bridgeMap = new HashMap<>();
//
//        for (int i = truck_weights.length-1; i >= 0; i--)
//            truckStack.push(truck_weights[i]);
//
//        int answer = 0;
//        int sum = 0;
//        while(true) {
//            answer++;
//
//            if (bridgeMap.containsKey(answer))
//                bridgeMap.remove(answer);
//
//            sum = bridgeMap.values().stream().mapToInt(Number::intValue).sum();
//
//            if (!truckStack.isEmpty())
//                if (sum + truckStack.peek() <= weight)
//                    bridgeMap.put(answer + bridge_length, truckStack.pop());
//
//            if (bridgeMap.isEmpty() && truckStack.isEmpty())
//                break;
//
//        }
//        return answer;
    }
}
