package level2;

import java.util.LinkedList;
import java.util.Queue;

public class level2_printer {
    public static void main(String[] args) {
        System.out.println(new level2_printer().solution(new int[]{1, 1, 1, 2, 2, 1, 1, 3, 3, 3, 1, 1, 2, 1, 2}, 0));
//        System.out.println(new level2_printer().solution(new int[]{1,1,1,1,2,2,2,2,2,2,2,2,2}, 0));
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            ((LinkedList<Node>) queue).add(new Node(i, priorities[i]));
        }

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            int size = queue.size();
            boolean more = false;
            for (int i = 0; i < size; i++) {
                Node get = ((LinkedList<Node>) queue).get(i);

                if (get.value > poll.value) {
                    more = true;
                    break;
                }
            }

            if (more) {
                ((LinkedList<Node>) queue).add(poll);
            } else {
                answer++;
                if (poll.location == location) {
                    break;
                }
            }

        }
        return answer;
    }

    class Node {

        int location;
        int value;

        public Node(int location, int value) {
            this.location = location;
            this.value = value;
        }

    }
}
