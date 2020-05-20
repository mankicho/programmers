package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class level3_paperford {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new level3_paperford().solution(21)));


    }

    public int[] solution(int n) {

        String s = "0";
        for (int i = 1; i < n; i++) {
            StringBuilder result = new StringBuilder();
            result.append(s).append("0");

            for (int j = s.length() - 1; j >= 0; j--) {
                char c = s.charAt(j);
                if (c == '0') {
                    result.append(1);
                } else {
                    result.append(0);
                }
            }
            s = result.toString();
        }

        int[] answer = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            answer[i] = c - 48;
        }

        return answer;
    }
}
