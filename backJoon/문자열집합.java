package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 실버 3
// hash , brute force
// 해시 , 트리 , 문자열, 자료구조
public class 문자열집합 {
    static Map<Integer, List<String>> map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new HashMap<>();
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0 ;i<N; i++){
            String str = br.readLine();

            if(!map.keySet().contains(str.length()))
                map.put(str.length(), new ArrayList<>());
            map.get(str.length()).add(str);
        }

//        System.out.println(map);

        for(int i=0; i<M; i++){
            String target = br.readLine();
            int len = target.length();

            if(map.keySet().contains(len)){
                List<String> list = map.get(len);
                for(String tmp : list){
                    if(tmp.equals(target)){
                        result++;
                        break;
                    }
                }
            }
        }

        System.out.println(result);
    }
}


//=============================================



//public class 문자열집합 {
//    static Map<String, Integer> map;
//    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        map = new HashMap<>();
//        int result = 0;
//
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//
//        for(int i=0 ;i<N; i++){
//            String str = br.readLine();
//            map.put(str,0);
//        }
//
////        System.out.println(map);
//
//        for(int i=0; i<M; i++){
//            String target = br.readLine();
//            if(map.keySet().contains(target))
//                result++;
//            }
//
//        System.out.println(result);
//    }
//}
//
