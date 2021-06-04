package kakao.intern_2020;

import java.util.HashMap;
import java.util.Map;

/**
 * 키패드 누르기
 */
public class test1 {
    public static void main(String[] args) throws Exception {

        int[] numbers = new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};

        String hand = "right";

        System.out.println(new test1().solution(numbers, hand));
    }


    int[] left = new int[]{4, 1};
    int[] right = new int[]{4, 3};

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        Map<Integer, int[]> map = new HashMap<>();

        map.put(1, new int[]{1, 1});
        map.put(2, new int[]{1, 2});
        map.put(3, new int[]{1, 3});
        map.put(4, new int[]{2, 1});
        map.put(5, new int[]{2, 2});
        map.put(6, new int[]{2, 3});
        map.put(7, new int[]{3, 1});
        map.put(8, new int[]{3, 2});
        map.put(9, new int[]{3, 3});
        map.put(0, new int[]{4, 2});

        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];

            if (num == 1 || num == 4 || num == 7) {
                answer.append("L");
                left = map.get(num);
            } else if (num == 3 || num == 6 || num == 9) {
                answer.append("R");
                right = map.get(num);
            } else {
                int leftDiff = distance(left, map.get(num));
                int rightDiff = distance(right, map.get(num));

                if (leftDiff < rightDiff) {
                    answer.append("L");
                    left = map.get(num);
                } else if (rightDiff < leftDiff) {
                    answer.append("R");
                    right = map.get(num);
                } else {
                    if (hand.equals("left")) {
                        answer.append("L");
                        left = map.get(num);
                    } else {
                        answer.append("R");
                        right = map.get(num);
                    }
                }
            }
        }
        return answer.toString();
    }

    private int distance(int[] hand, int[] location) {
        int handRow = hand[0];
        int handCol = hand[1];

        int locationRow = location[0];
        int locationCol = location[1];


        return Math.abs(locationRow - handRow) + Math.abs(locationCol - handCol);
    }
}