package backJoon;

import java.io.*;
import java.util.*;

// 실버 4
public class 듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Integer[] numbers = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        for(int i=0; i<numbers[0]+numbers[1]; i++){
            String str = br.readLine();
            if(map.get(str) == null){
                map.put(str, 1);
            }else{
                list.add(str);
            }
        }

        bw.write(list.size() + "\n");
        Collections.sort(list);
        for(int i=0; i<list.size(); i++) bw.write(list.get(i) + "\n");
        bw.flush();
        bw.close();
    }
}
