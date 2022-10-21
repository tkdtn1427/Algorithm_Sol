package programmers.stackQueue;

// Lv. 2
public class 올바른괄호 {
    public static void main(String[] args) {
        System.out.println(solution(new String("(()(")));
    }

    static boolean solution(String s) {
        int s_count = 0;

        for(int i=0; i<s.length(); i++){
            if(String.valueOf(s.charAt(i)).equals("(")){
                s_count += 1;
            }else{
                if(s_count == 0) return false;
                s_count -= 1;
            }
        }

        if(s_count != 0) return false;
        else return true;
    }
}
