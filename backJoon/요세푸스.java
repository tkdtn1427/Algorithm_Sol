package backJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class 요세푸스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");
        String result = solution(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        System.out.println(result);
    }

    static String solution(int N, int K){
        StringBuilder sb = new StringBuilder("<");
        List<People> people = new ArrayList<>();
        int count = 0;
        for(int i=1; i<=N; i++){
            people.add(new People(i,i));
        }


        while (people.size() != 0){
            count += 1;
            People tmp = people.remove(0);
            if(count % K == 0){
                sb.append(tmp.per + ", ");
            }else{
                people.add(tmp);
            }
        }

        return sb.replace(sb.length()-2,sb.length(),">").toString();
    }

    static class People{
        int count;
        int per;

        public People(int per, int count){
            this.per = per;
            this.count = count;
        }
    }
}
