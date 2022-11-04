package programmers.hash;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 완주하지못한선수 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"},new String[]{"stanko", "ana", "mislav"}));
    }

    static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i=0; i< completion.length; i++){
            if(!participant[i].equals(completion[i])) return participant[i];
        }
        return participant[participant.length-1];
    }

}
