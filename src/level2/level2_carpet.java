package level2;

import java.util.Arrays;

public class level2_carpet {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new level2_carpet().solution(10, 2)));
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        int start = brown / 4 + 1;
        int col = 0;
        while (start <= (brown - 2) / 2) {
            col = (brown - (start * 2)) / 2;
            if (col + 2 > start) {
                start++;
                continue;
            }
            if (col * (start - 2) == yellow) {
                break;
            }
            start++;

        }

        answer = new int[]{start, col + 2};
        return answer;
    }
}
