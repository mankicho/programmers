package level3;

import java.util.Arrays;
import java.util.LinkedList;

public class level3_doublePriorityQ {
    public static void main(String[] args) {
        new level3_doublePriorityQ().solution(new String[]{"l 16", "D 1"});
        new level3_doublePriorityQ().solution(new String[]{"l 7", "l 5", "l -5", "D -1"});
    }

    public int[] solution(String[] operations) {
        int[] answer = {};

        LinkedList<Integer> queue = new LinkedList<>();

        Arrays.stream(operations).forEach(s -> {
            if (s.startsWith("l")) {
                queue.add(Integer.parseInt(s.split(" ")[1]));
            } else if (!queue.isEmpty() && s.startsWith("D")) {
                if (Integer.parseInt(s.split(" ")[1]) > 0) {
                    int max = 0;
                    int index = 0;
                    for (int i = 0; i < queue.size(); i++) {
                        if (queue.get(i) > max) {
                            max = queue.get(i);
                            index = i;
                        }
                    }
                    queue.remove(index);
                } else {
                    int min = Integer.MAX_VALUE;
                    int index = 0;
                    for (int i = 0; i < queue.size(); i++) {
                        if (queue.get(i) < min) {
                            min = queue.get(i);
                            index = i;
                        }
                    }
                    queue.remove(index);
                }
            }
        });
        if (queue.isEmpty()) {
            answer = new int[]{0, 0};
        } else {
            int max = 0;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < queue.size(); i++) {
                if (queue.get(i) > max) {
                    max = queue.get(i);
                }

                if (queue.get(i) < min) {
                    min = queue.get(i);
                }
            }
            answer = new int[]{max, min};
        }

        return answer;
    }


}
