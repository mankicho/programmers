package level3;

import java.util.Arrays;
import java.util.Random;

public class level3_yesan {
    public static void main(String[] args) {

        int[] arr = new int[100000];

        Random random = new Random();

        for(int i=0;i<arr.length;i++){
            arr[i] = random.nextInt(100000)+1;
        }
        int M = 100000000;

        System.out.println(new level3_yesan().solution(arr, M));
    }

    public int solution(int[] budgets, int M) {

        Arrays.sort(budgets);

        int start = budgets[0];
        int end = budgets[budgets.length - 1];
        int mid;

        while (start < end) {
            System.out.println();
            mid = (start + end) / 2;
            long sum = 0;

            for (int i = 0; i < budgets.length; i++) {
                if (budgets[i] > mid) {
                    sum += mid;
                    continue;
                }
                sum += budgets[i];
            }

            if (sum > M) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < budgets.length; i++) {
            if (budgets[i] > start) {
                sum += start;
                continue;
            }
            sum += budgets[i];
        }

        if (sum > M) {
            start = start - 1;
        }
        return start;
    }
}
