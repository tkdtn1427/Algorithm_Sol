package backJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;

//실버 5
public class 회사에있는 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<String> set = new HashSet<>();

        int repeat = Integer.parseInt(br.readLine());
        for(int i=0; i<repeat; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String type = st.nextToken();

            if(type.equals("enter")) set.add(name);
            if(type.equals("leave")) set.remove(name);
        }

        List<String> list = new ArrayList<>();
        list.addAll(set);
        Collections.sort(list, Collections.reverseOrder());
        for(String tmp : list){
            bw.write(tmp + "\n");
        }
        bw.flush();
        bw.close();
    }
}
