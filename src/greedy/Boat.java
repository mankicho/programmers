package greedy;

import java.util.Arrays;

public class Boat {
    public static void main(String[] args) {
        System.out.println(new Boat().solution(new int[]{70, 60, 30, 20, 50, 50, 50, 50, 50, 100, 100}, 240));

    }

    public int solution(int[] people, int limit) {
        int startIdx = -1;
        int endIdx = people.length - 1;
        Arrays.sort(people);
        System.out.println(Arrays.toString(people));
        int count = 0;
        while (startIdx < endIdx) {
            int endSumWeight = 0;
//            System.out.println("pre : endIdx = " + endIdx);

            for (int i = endIdx; i >= 0; i--) {
                endSumWeight += people[i];
                if (endSumWeight > limit) {
                    endSumWeight -= people[i];
                    break;
                }
                endIdx--;
            }
//            System.out.println("after  : endIdx = " + endIdx);

            for (int i = startIdx + 1; i <= endIdx; i++) {
                endSumWeight += people[i];
                if (endSumWeight > limit) {
                    break;
                }
                startIdx++;
            }

            count++;
        }

//        System.out.println("start = " + startIdx + " : end = " + endIdx);
        return count;
    }
}
