package kakao.intern_2020;

import java.util.*;

public class test3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new test3().solution(new String[]{
                "A", "B", "B", "B", "B", "B", "C", "A"
        })));
    }

    public int[] solution(String[] gems) {
        int[] answer = {};

        int[] has = new int[gems.length + 1];

        Map<String, Integer> map = new HashMap<>();

        Set<String> set = new HashSet<>(Arrays.asList(gems));

        int idx = 1;
        for (int i = 0; i < gems.length; i++) {
            map.putIfAbsent(gems[i], idx++);
        }

        int front = 0;
        int back = 0;

        int num = 0;

        int x = 0;
        int y = gems.length;
        while (back <= front) {
            if (front == gems.length) {
                break;
            }
            String gem = gems[front];

            if (has[map.get(gem)] == 0) {
                num++;
            }
            has[map.get(gem)]++;

            if (num == set.size()) {
                while (back <= front) {
                    String gem2 = gems[back];
                    has[map.get(gem2)]--;

                    if (has[map.get(gem2)] == 0) {
                        num--;
                    }

                    if (num < set.size()) {
                        int tmpX = back + 1;
                        int tmpY = front + 1;

                        if (y - x > tmpY - tmpX) {
                            x = tmpX;
                            y = tmpY;
                        } else if (y - x == tmpY - tmpX) {
                            if (tmpX < x) {
                                x = tmpX;
                                y = tmpY;
                            }
                        }
                        back++;
                        break;
                    }
                    back++;

                }
            }

            front++;
        }
        return new int[]{x, y};
    }
}
