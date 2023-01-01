package backJoon;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 실버1
// 수학, 나머지정리
public class 카잉달력 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int last = (N*M) / GCD(N,M);

            while(true) {
                if(x > last) {
                    System.out.println(-1);
                    break;
                }
                else if(((x % N) == 0 ? N : x % N) == y){
                    System.out.println(x);
                    break;
                }
                x += M;
            }
        }
    }
    public static int GCD(int A, int B) {
        int temp = 0;
        while(B > 0) {
            temp = A % B;
            A = B;
            B = temp;
            System.out.println(temp);
            System.out.println(A);
            System.out.println(B);
        }
        return A;
    }
}


/*

y = 10x+3

 */