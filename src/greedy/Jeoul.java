package greedy;

import java.util.Arrays;

public class Jeoul {
    public int solution(int[] weight) {
        Arrays.sort(weight);

        int cur = weight[0];
        for (int i = 1; i < weight.length; i++) {
            if (cur + 1 >= weight[i]) {
                cur += weight[i];
            } else {
                break;
            }
        }
        return cur+1;
    }
}
