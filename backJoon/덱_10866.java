package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 실버 4
public class 덱_10866 {
    static int[] deque;
    static int front;
    static int back;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String order;
        int repeat = Integer.parseInt(br.readLine());
        deque = new int[repeat*2];
        front = repeat;
        back = repeat;

        for(int i=0; i<repeat; i++){
            st = new StringTokenizer(br.readLine(), " ");
            order = st.nextToken();
            if(order.equals("push_front")){
                deque[--front] = Integer.parseInt(st.nextToken());
            }else if(order.equals("push_back")){
                deque[back++] = Integer.parseInt(st.nextToken());
            }else if(order.equals("pop_front")){
                if(!isEmpty()) System.out.println(deque[front++]);
                else System.out.println(-1);
            }else if(order.equals("pop_back")){
                if(!isEmpty()) System.out.println(deque[--back]);
                else System.out.println(-1);
            }else if(order.equals("size")){
                System.out.println(back - front);
            }else if(order.equals("empty")){
                if(isEmpty()) System.out.println(1);
                else System.out.println(0);
            }else if(order.equals("front")){
                if(!isEmpty()) System.out.println(deque[front]);
                else System.out.println(-1);
            }else{
                if(!isEmpty()) System.out.println(deque[back-1]);
                else System.out.println(-1);
            }
        }
    }

    static boolean isEmpty(){
        if(back == front){
            return true;
        }
        return false;
    }
}
