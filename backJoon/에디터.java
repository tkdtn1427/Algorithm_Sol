package backJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// 실버 2
// 자료구조, 스택, 연결리스트
// 다시 풀이
public class 에디터 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int repeat = Integer.valueOf(br.readLine());
        Node left = new Node(new Character[15],-1);
        Node right = new Node(new Character[15], -1);

        for(int i=0; i<str.length(); i++){
            left.arr[++left.pointer] = str.charAt(i);
        }

        for(int i=0; i<repeat; i++){
            String order = br.readLine();
            if(order.charAt(0) == 'P'){
                if(left.pointer == 600000) continue;
                left.arr[++left.pointer] = order.charAt(2);
            }else if(order.charAt(0) == 'B'){
                if(left.pointer == -1) continue;
                left.pointer--;
            }else if(order.charAt(0) == 'L'){
                if(left.pointer == -1) continue;
                right.arr[++right.pointer] = left.arr[left.pointer--];
            }else{
                if(right.pointer == -1) continue;
                left.arr[++left.pointer] = right.arr[right.pointer--];
            }
        }

        for(int i=0; i<=left.pointer; i++){
            bw.write(left.arr[i]);
        }
        for(int i=right.pointer; i>=0; i--){
            bw.write(right.arr[i]);
        }

        bw.flush();
        bw.close();
    }

    static class Node{
        Character[] arr;
        int pointer;
        public Node(Character[] arr, int pointer){
            this.pointer = pointer;
            this.arr = arr;
        }
    }
}

// 입력 : 소문자 영어 , 6만자
//