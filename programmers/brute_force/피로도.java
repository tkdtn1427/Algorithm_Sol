package programmers.brute_force;

import java.util.*;

//Lv. 2
public class 피로도 {
    public static void main(String[] args) {
        System.out.println(solution(80, new int[][]{{80,20},{50,40},{30,10},{10,10}}));
    }
    static List<Integer> list;

    static int solution(int k, int[][] dungeons) {
            list = new ArrayList<>();
            for(int i=0; i<dungeons.length; i++){
                if(k >= dungeons[i][0])
                    dfs(k,i, dungeons, new boolean[dungeons.length],0);
            }

            return Collections.max(list);
        }

        static void dfs(int k, int index, int[][] dungeons, boolean[] check, int count) {
            count += 1;
            check[index] = true;
            k -= dungeons[index][1];
            for(int i=0; i<dungeons.length; i++){
                if(check[i] == false && dungeons[i][0] <= k){
                    dfs(k, i, dungeons, check, count);
                    check[i] = false;
                }
            }
            list.add(count);
        }
}
