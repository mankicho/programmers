package level3;

import java.util.Arrays;

public class level3_Immigration {
    public static void main(String[] args) {
        new level3_Immigration().solution(1000000000, new int[]{7, 3, 1000000000});
    }

    public long solution(int n, int[] times) {
        long answer = 0;

        long max = Arrays.stream(times).max().getAsInt() * (long) n;
        long start = 1;

        while (start < max) {
            long middle = (start + max) / 2;

            long person = 0;
            for (int i = 0; i < times.length; i++) {
                person += (middle / (long) times[i]);
            }

            if (person >= n) {
                max = middle;
            } else {
                start = middle + 1;
            }
        }
        answer =  start;
        return answer;
    }
}

