package kakao.intern_2020;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 경주로 건설
 */
public class test4 {
    public static void main(String[] args) {

        new test4().solution(new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}
        });
    }

    public int solution(int[][] board) {
        int answer = 0;

        int[][] direction = {
                {-1, 0}, {0, 1}, {1, 0}, {0, -1}
        };
        int[][][] dp = new int[board.length][board.length][4];

        for (int[][] arr : dp) {
            for (int[] tmpArr : arr) {
                Arrays.fill(tmpArr, 987654321);
            }
        }

        dp[0][0][0] = 0;
        dp[0][0][1] = 0;
        dp[0][0][2] = 0;
        dp[0][0][3] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(0, 0, 0, 0));
        pq.add(new Node(0, 0, 0, 1));
        pq.add(new Node(0, 0, 0, 2));
        pq.add(new Node(0, 0, 0, 3));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int row = node.row;
            int col = node.col;
            int cost = node.cost;
            int dir = node.fromDirection;

            for (int i = 0; i < direction.length; i++) {

                if (Math.abs(dir - i) == 2) {
                    continue; // 방향이 직전에서 왔다.
                }

                int[] arr = direction[i];

                if (row + arr[0] >= board.length || row + arr[0] < 0 ||
                        col + arr[1] >= board.length || col + arr[1] < 0 || board[row + arr[0]][col + arr[1]] == 1) {
                    continue; // 범위를 벗어남 혹은 벽으로 막혀있음.
                }
                int tmpCost = 0;
                if (dir == i) {
                    tmpCost = 100;
                } else {
                    tmpCost = 600;
                }

                if (dp[row + arr[0]][col + arr[1]][i] > cost + tmpCost) {
                    dp[row + arr[0]][col + arr[1]][i] = cost + tmpCost;
                    pq.add(new Node(row + arr[0], col + arr[1], cost + tmpCost, i));
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            if (min > dp[board.length - 1][board.length - 1][i]) {
                min = dp[board.length - 1][board.length - 1][i];
            }
        }
        return min;
    }


    class Node implements Comparable<Node> {
        int row;
        int col;
        int cost;
        int fromDirection;

        public Node(int row, int col, int cost, int fromDirection) {
            this.row = row;
            this.col = col;
            this.cost = cost;
            this.fromDirection = fromDirection;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
