package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class level3_bridge {
    public static void main(String[] args) {
        System.out.println(new level3_bridge().solution(25, new int[]{2, 14, 11, 21, 17}, 2));
    }

    public int solution(int distance, int[] rocks, int n) {
        int start = 1;
        int end = distance;
        int mid;
        Arrays.sort(rocks);
        while (start < end) {
            mid = (start + end) / 2;
//            System.out.println("start = " + start +" : end " + end );
//            System.out.println(" mid = " + mid);
            int cur = 0;
            int remove = 0;
            System.out.println(Arrays.toString(rocks));
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - cur > mid) {
                    cur = rocks[i];
                } else {
                    remove++;
//                    System.out.println("cur = " + cur + "," + "remove = " + remove);
                }
            }

//            System.out.println("remove = " + remove);
            if (remove > n) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }
}
