package programmers._lv1;

import java.util.*;
import java.util.stream.Collectors;

public class 신고결과받기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"muzi", "frodo", "apeach", "neo"},new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},2)));
    }

    static int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String str : id_list){
            map.put(str,0);
        }
        List<String>[] list = new ArrayList[id_list.length];
        for(int i=0; i<list.length; i++){
            list[i] = new ArrayList<>();
        }

        List<String> invoter = Arrays.stream(id_list).collect(Collectors.toList());

        Set<String> reportSet = new HashSet();
        for(String arr : report) reportSet.add(arr);

        for(String str : reportSet){
            StringTokenizer st = new StringTokenizer(str," ");
            String voter = st.nextToken();
            String voted = st.nextToken();
            list[invoter.indexOf(voter)].add(voted);
            map.replace(voted,map.get(voted)+1);
        }

        int[] answer = new int[id_list.length];

        for(String str : reportSet){
            StringTokenizer st = new StringTokenizer(str, " ");
            int idx = invoter.indexOf(st.nextToken());
            if(map.get(st.nextToken()) >= k) answer[idx] += 1;
        }

        return answer;
    }
}
